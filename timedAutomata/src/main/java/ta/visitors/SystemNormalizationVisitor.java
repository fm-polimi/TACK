package ta.visitors;

import ta.*;
import ta.declarations.BoundedVariableDecl;
import ta.declarations.ClockDecl;
import ta.declarations.VariableDecl;
import ta.expressions.Identifier;
import ta.state.ExpInvariant;
import ta.state.Invariant;
import ta.state.State;
import ta.transition.Assign;
import ta.transition.Guard;
import ta.transition.Transition;
import ta.transition.assignments.ClockAssignement;
import ta.transition.assignments.VariableAssignement;
import ta.transition.guard.ClockConstraintAtom;
import ta.transition.guard.VariableConstraintAtom;

import java.util.*;
import java.util.stream.Collectors;

public class SystemNormalizationVisitor {

    public static class SystemContainer {
        public SystemDecl system;
        public Set<StateAP> stateAPs;
        public Set<VariableAssignementAP> variableAssignementAPs;

        public SystemContainer(SystemDecl system, Set<StateAP> stateAPs, Set<VariableAssignementAP> variableAssignementAPs) {
            this.system = system;
            this.stateAPs = stateAPs;
            this.variableAssignementAPs = variableAssignementAPs;
        }
    }


    // Every state, clock & variable should have a name that is unique across the entire system
    // Also, normalize transitions to point to the *real* State objects instead of 'dummy' instances
    // with incorrect Invariant information
    // If you just want a normalized system (without the APs), set them to null
    public static SystemContainer normalize(SystemContainer container) {
        SystemDecl system = container.system;
        Set<StateAP> stateAPs = container.stateAPs;
        Set<VariableAssignementAP> variableAssignementAPs = container.variableAssignementAPs;

        Map<TA, Map<String, State>> mapStringState = new HashMap<>();
        // Sets of Global & local clocks, modified to have a unique naming scheme
        // 'c_' is prepended to the names of global clocks
        // 'cl_[TA-id]_' is prepended to the names of local clocks
        Map<String,ClockDecl> globalClockMap = new HashMap<>();
        Map<TA,Map<String,ClockDecl>> localClockMap = new HashMap<>();
        Map<String, VariableDecl> globalVariableMap = new HashMap<>();
        Map<TA, Map<String, VariableDecl>> localVariableMap = new HashMap<>();

        for (ClockDecl c : system.getClockDeclarations()) {
            globalClockMap.put(c.getId(), new ClockDecl(c.getType(), "c_" + c.getId(), c.getValue()));
        }

        for (VariableDecl v: system.getVariableDeclaration()) {
            if (v instanceof BoundedVariableDecl) {
                BoundedVariableDecl  bv = (BoundedVariableDecl) v;
                globalVariableMap.put(bv.getId(), new BoundedVariableDecl(bv.getType(), "v_" + bv.getId(),
                        bv.getExp(), bv.getValues()));
            } else {
                globalVariableMap.put(v.getId(), new VariableDecl(v.getType(), "v_" + v.getId(), v.getExp()));
            }
        }
        // Rewrite variables in declaration expressions
        ExpressionVariableRenamingVisitor globalRenaming = new ExpressionVariableRenamingVisitor(globalVariableMap);
        globalVariableMap = globalVariableMap.entrySet().stream().map(e -> new AbstractMap.SimpleEntry<>(e.getKey(),
                        rewriteVariableDeclExpression(e.getValue(),globalRenaming)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> a));

        Set<ClockDecl> newClockDecl = new HashSet<>(globalClockMap.values());
        Set<VariableDecl> newVariableDecl = new HashSet<>(globalVariableMap.values());
        Set<TA> newTA = new HashSet<>();


        for (TA ta : system.getTimedAutomata()) {
            localClockMap.put(ta, new HashMap<>());
            localVariableMap.put(ta, new HashMap<>());
            mapStringState.put(ta, new HashMap<>());
            Set<VariableDecl> localVarsOnly = new HashSet<>();
            Set<ClockDecl> localClocksOnly = new HashSet<>();
            for (ClockDecl c : ta.getClockDeclarations()) {
                localClockMap.get(ta).put(c.getId(), new ClockDecl(c.getType(), "cl_" + ta.getIdentifier() + "_" +
                        c.getId(), c.getValue()));
            }
            // localClocksOnly is used to create new normalized TA
            localClocksOnly.addAll(localClockMap.get(ta).values());
            // localClocksMap can now be used to resolve any clock name (local or global) in original TA
            localClockMap.get(ta).putAll(globalClockMap);

            for (VariableDecl v: ta.getDeclarations()) {
                if (v instanceof BoundedVariableDecl) {
                    BoundedVariableDecl  bv = (BoundedVariableDecl) v;
                    localVariableMap.get(ta).put(bv.getId(), new BoundedVariableDecl(bv.getType(), "vl_" +
                            ta.getIdentifier() + "_" + bv.getId(), bv.getExp(), bv.getValues()));
                } else {
                    localVariableMap.get(ta).put(v.getId(), new VariableDecl(v.getType(), "vl_" + ta.getIdentifier() + "_" +
                            v.getId(), v.getExp()));
                }
            }
            // Rewrite variables in declaration expressions, same as in global map above
            ExpressionVariableRenamingVisitor localRenaming = new ExpressionVariableRenamingVisitor(localVariableMap.get(ta));
            localVariableMap.put(ta, localVariableMap.get(ta).entrySet().stream().map(e -> new AbstractMap.SimpleEntry<>(e.getKey(),
                    rewriteVariableDeclExpression(e.getValue(),localRenaming)))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> a)));
            // localVarsOnly is used to create new TA class, localVariableMap.get(ta) is used to rewrite expressions
            localVarsOnly.addAll(localVariableMap.get(ta).values());
            localVariableMap.get(ta).putAll(globalVariableMap);

            Set<State> newStates = ta.getStates().stream().map(s -> {
                Invariant inv = s.getInvariant();
                if (inv instanceof ExpInvariant) {
                    ExpInvariant eInv = (ExpInvariant) inv;
                    // currently Inv.exp is assumed to be a constant value
                    inv = new ExpInvariant(new Identifier(localClockMap.get(ta).get(eInv.getId().getId()).getId()),
                            eInv.getOperator(), eInv.getExp());
                }
                State newState = new State("state_" + ta.getIdentifier() + "_" + s.getStringId(), inv);
                mapStringState.get(ta).put(s.getStringId(), newState);
                return newState;
            }).collect(Collectors.toSet());

            Set<Transition> newTrans = ta.getTransitions().stream().map(t -> {
                State source = mapStringState.get(ta).get(t.getSource().getStringId());
                State dest = mapStringState.get(ta).get(t.getDestination().getStringId());
                Guard guard = normalizeGuard(t.getGuard(),localClockMap.get(ta),localVariableMap.get(ta));
                Assign assign = normalizeAssign(t.getAssignement(),localClockMap.get(ta), localVariableMap.get(ta));
                return new Transition(source,dest,guard,t.getSync(),assign);
            }).collect(Collectors.toSet());

            Set<Clock> newClocks = ta.getClocks().stream().map(c -> new Clock(localClockMap.get(ta).get(c.getName()).getId()))
                    .collect(Collectors.toSet());

            Set<Variable> newVariables = ta.getVariables().stream().map(v ->
                    new Variable(localVariableMap.get(ta).get(v.getName()).getId())).collect(Collectors.toSet());

            State newInitialState = mapStringState.get(ta).get(ta.getInitialState().getStringId());

            newTA.add(new TA(ta.getIdentifier(), ta.getAtomicPropositions(), newStates, newTrans, newInitialState,
                    newClocks, newVariables, localVarsOnly, localClocksOnly));
        }

        SystemDecl newSystem = new SystemDecl(newTA, newClockDecl, newVariableDecl);

        if (stateAPs != null) {
            stateAPs = stateAPs.stream().map(s -> {
                String taName = s.getAutomata();
                String stateName = s.getState();
                TA ta = system.getTimedAutomata().stream().filter(t -> t.getIdentifier().equals(taName)).collect(Collectors.toList()).get(0);
                State state = mapStringState.get(ta).get(stateName);
                return new StateAP(s.getEncodingSymbol(),taName,state.getStringId());
            }).collect(Collectors.toSet());
        }
        if (variableAssignementAPs != null) {
            Map<String, VariableDecl> finalGlobalVariableMap = globalVariableMap;
            variableAssignementAPs = variableAssignementAPs.stream().map(v -> {
                if (v.getAutomaton().equals("")) {
                    //Global Var
                    Variable var = new Variable(finalGlobalVariableMap.get(v.getVariable().getName()).getId());
                    return new VariableAssignementAP("", v.getEncodingSymbol(), var, v.getValue());
                } else {
                    //Local Var
                    String taName = v.getAutomaton();
                    TA ta = system.getTimedAutomata().stream().filter(t -> t.getIdentifier().equals(taName)).collect(Collectors.toList()).get(0);
                    Variable var = new Variable(localVariableMap.get(ta).get(v.getVariable().getName()).getId());
                    return new VariableAssignementAP(taName, v.getEncodingSymbol(), var, v.getValue());
                }
            }).collect(Collectors.toSet());
        }
        return new SystemContainer(newSystem, stateAPs, variableAssignementAPs);
    }


    private static Guard normalizeGuard(Guard guard, Map<String, ClockDecl> clockMap, Map<String, VariableDecl> variableMap) {
        Set<ClockConstraintAtom> cc = guard.getClockConstraints().stream().map(c ->
                new ClockConstraintAtom(new Clock(clockMap.get(c.getClock().getName()).getId()),
                        c.getOperator(),c.getValue())).collect(Collectors.toSet());
        Set<VariableConstraintAtom> vc = guard.getConditions().stream().map(v ->
                new VariableConstraintAtom(new Variable(variableMap.get(v.getVariable().getName()).getId()),
                        v.getOperator(),v.getValue())).collect(Collectors.toSet());
        return new Guard(vc,cc);
    }

    private static VariableDecl rewriteVariableDeclExpression(VariableDecl v, ExpressionVariableRenamingVisitor renamingVisitor) {
        if (v instanceof BoundedVariableDecl) {
            BoundedVariableDecl bv = (BoundedVariableDecl) v;
            return new BoundedVariableDecl(v.getType(), v.getId(), renamingVisitor.visit(v.getExp()), bv.getValues());
        } else {
            return new VariableDecl(v.getType(), v.getId(), renamingVisitor.visit(v.getExp()));
        }
    }

    private static Assign normalizeAssign(Assign assign, Map<String, ClockDecl> clockMap, Map<String, VariableDecl> variableMap) {
        ExpressionVariableRenamingVisitor variableRenamingVisitor = new ExpressionVariableRenamingVisitor(variableMap);
        Set<ClockAssignement> ca = assign.getClockassigments().stream().map(c ->
                new ClockAssignement(new Clock(clockMap.get(c.getClock().getName()).getId()),c.getValue())).collect(Collectors.toSet());
        Set<VariableAssignement> va = assign.getVariableassigments().stream().map(v ->
                new VariableAssignement(new Variable(variableMap.get(v.getVariable().getName()).getId()),
                        variableRenamingVisitor.visit(v.getValue()))).collect(Collectors.toSet());
        return new Assign(ca,va);
    }
}
