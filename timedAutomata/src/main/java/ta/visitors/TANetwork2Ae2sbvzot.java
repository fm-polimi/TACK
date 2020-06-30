package ta.visitors;

import ta.*;
import ta.declarations.BoundedVariableDecl;
import ta.declarations.ClockDecl;
import ta.declarations.VariableDecl;
import ta.expressions.Value;
import ta.state.EmptyInvariant;
import ta.state.ExpInvariant;
import ta.state.Invariant;
import ta.state.State;
import ta.transition.Assign;
import ta.transition.Guard;
import ta.transition.Transition;
import ta.transition.assignments.ClockAssignement;
import ta.transition.guard.ClockConstraint;
import ta.transition.guard.ClockConstraintAtom;

import java.util.*;
import java.util.stream.Collectors;

public class TANetwork2Ae2sbvzot {

    private SystemDecl system;
    private Set<StateAP> propositionsOfInterest;
    private Set<VariableAssignementAP> atomicpropositionsVariable;
    private int bound;
    private String boundStr;

    private String vectorType;

    private Map<Map.Entry<TA, String>, Integer> mapStateId;
    private Map<Map.Entry<TA, Integer>, State> mapIdState;
    private Map<Map.Entry<TA, Transition>, Integer> mapTransitionId;
    private Map<Map.Entry<TA, Integer>, Transition> mapIdTransition;
    private Map<Integer, TA> mapIdTA;
    //null iff global clock
    private Map<String, TA> mapClockTA;

    //Keep track of max bound for each clock
    private Map<String, Integer> clockBounds = new HashMap<>();

    // Sets of Global & local clocks, modified to have a unique naming scheme
    // 'c_' is prepended to the names of global clocks
    // 'cl_[TA-id]_' is prepended to the names of local clocks
    // although the parser guarantees that all variable names are unique,
    // the TA template feature means that TAs derived from the same template will have
    // local clocks with the same name
    private Map<String,ClockDecl> globalClockMap = new HashMap<>();
    private Map<TA,Map<String,ClockDecl>> localClockMap = new HashMap<>();
    // private Map<String,VariableDecl> globalVarMap = new HashMap<>();
    // private Map<TA,Map<String,VariableDecl>> localVarMap = new HashMap<>();


    // Plan:
    // First make MVP that handles only clocks, then expand to variables, sync

    public TANetwork2Ae2sbvzot (SystemDecl system, Set<StateAP> propositionsOfInterest,
                                Set<VariableAssignementAP> atomicpropositionsVariable,
                                int bound) {
        this.system = system;
        this.propositionsOfInterest = propositionsOfInterest;
        this.atomicpropositionsVariable = atomicpropositionsVariable;
        this.bound = bound+2;
        this.boundStr = Integer.toString(this.bound);

        this.vectorType = "(_ BitVec " + boundStr + ")";

        this.mapStateId = new HashMap<>();
        this.mapIdTA = new HashMap<>();
        this.mapIdState = new HashMap<>();
        this.mapTransitionId = new HashMap<>();
        this.mapIdTransition = new HashMap<>();
        this.mapClockTA = new HashMap<>();
        for (ClockDecl c : system.getClockDeclarations()) {
            globalClockMap.put(c.getId(), new ClockDecl(c.getType(), "c_" + c.getId(), c.getValue()));
            mapClockTA.put("c_"+c.getId(),null);
        }
        ClockBoundVisitor boundVisitor = new ClockBoundVisitor();
        for (TA ta : system.getTimedAutomata()) {
            localClockMap.put(ta, new HashMap<>());
            for (ClockDecl c : ta.getClockDeclarations()) {
                localClockMap.get(ta).put(c.getId(), new ClockDecl(c.getType(), "cl_" + ta.getId() + "_" +
                        c.getId(), c.getValue()));
                mapClockTA.put("cl_" + ta.getId() + "_" + c.getId(),ta);
            }
            this.clockBounds = ClockBoundVisitor.mergeMaps(this.clockBounds,
                    boundVisitor.visit(ta).entrySet().stream().map(e -> {
                        Clock c = e.getKey();
                        String cId = getClockId(c.getName(),ta);
                        return new AbstractMap.SimpleEntry<>(cId,e.getValue());
                    }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> a)));
            int count = 0;
            for (State s : ta.getStates()) {
                mapStateId.put(new AbstractMap.SimpleEntry<>(ta, s.getStringId()), count);
                mapIdState.put(new AbstractMap.SimpleEntry<>(ta, count), s);
                count++;
            }
            count = 0;
            for (Transition t: ta.getTransitions()) {
                mapTransitionId.put(new AbstractMap.SimpleEntry<>(ta, t), count);
                mapIdTransition.put(new AbstractMap.SimpleEntry<>(ta, count), t);
                count++;
            }
            // null transition - TA stays in same state
            mapTransitionId.put(new AbstractMap.SimpleEntry<>(ta, null), count);
            mapIdTransition.put(new AbstractMap.SimpleEntry<>(ta, count), null);
            this.mapIdTA.put(ta.getId(), ta);
        }
    }

    public String convert () {

        return declarations();
    }

    // We will often want to assert an expression at every time instance. For states and transitions, the BitVector
    // representation allows us to do this immediately. However since Clocks and Variables are represented as functions,
    // we will use this functional interface to build an expression once, then create a copy for each time instance.
    // This is more reliable than using smt-lib's quantifiers.
    @FunctionalInterface
    private interface TimedExpression {
        String generate(int i);
    }

    private String assertExp(String exp) {
        return "(assert " + exp + ")\n";
    }

    private TimedExpression assertExp(TimedExpression exp) {
        return (i) -> "(assert " + exp.generate(i) + ")\n";
    }

    // Function to convert timed expressions to strings
    private String evalTimedExpression(TimedExpression exp, int begin, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = begin; i < end; i++) {
            result.append(exp.generate(i));
        }
        return result.toString();
    }

    // Simple helper fn, useful for relations <, >, <=, etc.
    private TimedExpression combine2TimedExpressions(String op, TimedExpression exp1, TimedExpression exp2) {
        return (i) -> "(" + op + " " + exp1.generate(i) + " " + exp2.generate(i) + ")";
    }

    String declarations () {
        // Just for organization, don't worry too much if you aren't sure where something belongs
        StringBuilder declarations = new StringBuilder();
        StringBuilder initalizations = new StringBuilder();
        StringBuilder constraints = new StringBuilder();
        StringBuilder loopConstraints = new StringBuilder();

        declarations.append("; System Declarations\n;;;;;;;;;;;;;;;;;;;;;\n");
        initalizations.append("; System Initializations\n;;;;;;;;;;;;;;;;;;;;;;;;\n");
        constraints.append("; System Constraints\n;;;;;;;;;;;;;;;;;;;;\n");
        loopConstraints.append("; Loop Constraints\n;;;;;;;;;;;;;;;;;;\n");

        // Convenience
        declarations.append("(define-fun zeros () "+vectorType+"\n" +
                "    (_ bv0 " + boundStr + "))\n");
        declarations.append("(define-fun ones () "+vectorType+"\n" +
                "    (bvnot zeros))\n");
        declarations.append("(define-fun one () "+vectorType+"\n" +
                "    (_ bv1 "+bound+"))\n");
        declarations.append("(define-fun eqzeros ((A "+vectorType+")) Bool\n" +
                "    (= zeros A))\n");
        declarations.append("(define-fun eqones ((A "+vectorType+")) Bool\n" +
                "    (= ones A))\n");
        declarations.append("(define-fun bviff ((A "+vectorType+") (B "+vectorType+")) "+vectorType+"\n" +
                "    (bvxnor A B))\n");
        declarations.append("(define-fun bvimpl ((A "+vectorType+") (B "+vectorType+")) "+vectorType+"\n" +
                "    (bvor (bvnot A) B))\n");
        declarations.append("(define-fun getprev ((A "+vectorType+")) "+vectorType+"\n" +
                "    ((_ zero_extend 1) ((_ extract " + (bound-2) + " 0) A)))\n");
        declarations.append("(define-fun getnext ((A "+vectorType+")) "+vectorType+"\n" +
                "    ((_ zero_extend 1) ((_ extract " + (bound-1) + " 1) A)))\n");

        // I-loop
        declarations.append("(declare-fun i_loop () " + vectorType + ")\n");
        declarations.append("(declare-fun i-loop () Int)\n");
        constraints.append(assertExp("(<= i-loop " + (bound-2) + ")"));
        constraints.append(assertExp("(<= 0 i-loop)"));
        declarations.append("(define-fun inloop () "+vectorType+"\n"+
                "    (bvand (bvnot (bvshl one ((_ int2bv " + bound + ") " + (bound-1) +"))) (bvor");
        for (int i=0; i<(bound-1); i++) {
            declarations.append(" (bvshl (bvshl one i_loop) ((_ int2bv " + bound + ") " + i + "))");
        }
        declarations.append(")))\n");

        declarations.append("(define-fun loopex () Bool\n" +
                "    (not (= 0 i-loop)))\n");
        //NOTE: int2bv is a Z3 extension, maybe should be replaced
        // We could iterate over all possible values of i_loop, 0-bound
        declarations.append("(assert (= ((_ int2bv " + boundStr + ") i-loop) i_loop))\n");
        // loopConF
        declarations.append("(define-fun getbit ((x "+vectorType+") (index "+vectorType+")) (_ BitVec 1)\n" +
                "    ((_ extract 0 0) (bvlshr x index)))\n");
        declarations.append("(define-fun loopConF ((x "+vectorType+")) Bool\n" +
                "    (= (getbit x i_loop) ((_ extract "+(bound-1) + " " + (bound-1) + ") x)))\n");

        //At least 1 TA must transition
        constraints.append("(assert (eqzeros (bvand");
        for (TA ta: system.getTimedAutomata()) {
            constraints.append(" trans_" + ta.getId() + "_" + mapTransitionId.get(new AbstractMap.SimpleEntry<>(ta,null)));
        }
        constraints.append(")))\n");

        //APs
        for (StateAP stateAP: this.propositionsOfInterest) {
            String taName = stateAP.getAutomata();
            String stateName = stateAP.getState();
            int apId = stateAP.getEncodingSymbol();
            TA ta = system.getTimedAutomata().stream().filter(t -> t.getIdentifier().equals(taName)).collect(Collectors.toList()).get(0);
            if (ta == null) {
                throw new IllegalArgumentException("Non-existant TA in model Property: "+taName);
            }
            String stateStr = "state_" + ta.getId() + "_" + mapStateId.get(new AbstractMap.SimpleEntry(ta,stateName));
            // The zot code declares this with declare-fun, so for compatibility we can't use define-fun
            declarations.append("(declare-fun h_" + apId + " () "+vectorType+")\n");
            constraints.append(assertExp("(= h_" + apId + " " +
                    stateStr + ")"));
           declarations.append("(declare-fun p_" + apId + " () "+vectorType+")\n");
            declarations.append(assertExp("(= p_" + apId + " " +
                    "(bvor (bvand one h_" + apId + ") (bvshl h_" + apId + " one)))"));
            //        "    (ite (= t 0.0) (h_" + apId + " 0.0) (h_" + apId + " (- t 1))))\n");
        }

        // Global Clocks
        declarations.append("; Global Clocks\n");
        declarations.append(globalClockMap.values().stream().map(c ->
                "(declare-fun " + c.getId() + " (Int) Real)\n" +
                "(declare-fun c" + c.getId() + " () Int)\n").collect(Collectors.joining()));
        initalizations.append(globalClockMap.values().stream().map(c ->
                assertExp("(= " + c.getValue().evaluate() + " (" + c.getId() + " 0))")).collect(Collectors.joining()));
        //declarations.append("(declare-fun now (Int) Real)\n");
        //initalizations.append(assertExp("(= (now 0) 0)"));
        declarations.append("(declare-fun delta (Int) Real)\n");

        // Clocks must increase by delta, unless a transition that assigns a value to the clock is fired
        constraints.append("; Clock progression constraints (Global Clocks)\n");
        for (ClockDecl clock: globalClockMap.values()) {
            String cId = clock.getId();
            Set<String> assigningTransitions = new HashSet<>();
            for (TA ta: system.getTimedAutomata()) {
                assigningTransitions.addAll(getAssigningTransitionIds(ta, cId));
            }
            //just in case there are 0 matches, add 'false'
            TimedExpression noAssignment = (i) -> "(not (or false" +
                    assigningTransitions.stream().map(s -> " (= ((_ extract " + i + " " + i + ") " + s + ") #b1)")
                            .collect(Collectors.joining()) + "))";
            constraints.append(evalTimedExpression(assertExp(combine2TimedExpressions(
                    "=>",
                    noAssignment,
                    // If no assignment, c[i+1] = c[i]+delta[i]
                    (i) -> "(= (" + cId + " " + (i+1) + ") (+ (" + cId + " " + i + ") (delta " + i + ")))")),0,bound-1));
        }

        // Simple progression constraints for special clocks 'now' and 'delta'
        initalizations.append(assertExp("(< 0 (delta 0))")); // for loop starts at 1, this needs to start at 0
        for (int i = 1; i < bound; i++) {
            int finalI = i;
            constraints.append("(assert (< 0 (delta " + i + ")))\n");
            //constraints.append("(assert (= (now " + i + ") (+ (now " + (i-1) + ") (delta " + (i-1) + "))))\n");
        }

        // TODO Global Variables

        for (VariableDecl var: system.getVariableDeclaration()) {
            if (false) { //(var instanceof BoundedVariableDecl) {
                // TODO: implement bounded variables more efficiently
            } else {
                // for now lets just treat everything as an unbounded variable
                declarations.append("declare-fun v_" + var.getId() + " (Int) Int)\n");

            }
        }


        for (TA ta : system.getTimedAutomata()) {
            int taId = ta.getId();

            // Local Clocks
            declarations.append(localClockMap.get(ta).values().stream().map(c ->
                    "(declare-fun " + c.getId() + " (Int) Real)\n" +
                    "(declare-fun c" + c.getId() + " () Int\n").collect(Collectors.joining()));
            initalizations.append(localClockMap.get(ta).values().stream().map(c ->
                    "(assert (= " + c.getValue().evaluate() + " (" + c.getId() + " 0)))\n").collect(Collectors.joining()));

            for (ClockDecl clock: localClockMap.get(ta).values()) {
                String cId = clock.getId();
                Set<String> assigningTransitions = getAssigningTransitionIds(ta, cId);
                //just in case there are 0 matches, add 'false'
                TimedExpression anyAssignment = (i) -> "(not (or false" +
                        assigningTransitions.stream().map(s -> " (= ((_ extract " + i + " " + i + ") " + s + ") #b1)")
                                .collect(Collectors.joining()) + "))";
                constraints.append(evalTimedExpression(assertExp(combine2TimedExpressions(
                        "=>",
                        anyAssignment,
                        (i) -> "(= (" + cId + " " + (i+1) + ") (+ (" + cId + " " + i + ") (delta " + i + ")))")),0,bound-1));
            }

            // TODO Local Variables

            // Bit representation of states
            // Copied enumeration code from TANetwork2CLTLocRC, placed in class init
            int stateBits = intToNumBits(ta.getStates().size());
            for (int i = 0; i < stateBits; i++) {
                declarations.append("(declare-fun s_" + ta.getId() + "_" + i + " () " + vectorType + ")\n");
                loopConstraints.append(assertExp("(=> loopex (loopConF s_" + ta.getId() + "_" + i + "))"));
            }

            //Shorthand for accessing individual states:
            for (State s: ta.getStates()) {
                int stateId = mapStateId.get(new AbstractMap.SimpleEntry<>(ta, s.getStringId()));
                declarations.append("(define-fun state_" + taId + "_" + stateId + " () " + vectorType + "\n" +
                        "    " + genStateBits(ta, s) + ")\n");
            }

            // if number of states != power of 2, there will be illegal combinations of the s_bits
            constraints.append(assertExp("(eqones (bvor" + ta.getStates().stream().map(s -> " " + genState(ta, s))
                    .collect(Collectors.joining()) + "))"));

            initalizations.append("; TA must start in initial state\n");
            initalizations.append("(assert (eqones (bvimpl (_ bv1 " + boundStr + ") " + genState(ta,ta.getInitialState()) + ")))\n");

            // Bit representation of transitions
            int transBits = intToNumBits(ta.getTransitions().size()+1); // +1 is for no transition taken
            for (int i=0; i < transBits; i++) {
                declarations.append("(declare-fun t_" + ta.getId() + "_" + i + " () " + vectorType + ")\n");
                loopConstraints.append(assertExp("(=> loopex (loopConF t_" + ta.getId() + "_" + i + "))"));
            }
            // Shorthand for accessing individual transitions:
            Set<Transition> transitionSet = new HashSet<>(ta.getTransitions());
            transitionSet.add(null);
            for (Transition t: transitionSet) {
                int transId = mapTransitionId.get(new AbstractMap.SimpleEntry<>(ta, t));
                declarations.append("(define-fun trans_" + taId + "_" + transId + " () " + vectorType + "\n" +
                        "    " + genTransitionBits(ta, t) + ")\n");
            }
            // if the number of transitions isn't a power of 2 there will be illegal combinations of the t_bits
            if (transitionSet.size() > 0) {
                constraints.append("(assert (eqones (bvor");
                for (Transition t : transitionSet) {
                    int transId = mapTransitionId.get(new AbstractMap.SimpleEntry<>(ta, t));
                    constraints.append(" trans_" + taId + "_" + transId);
                }
                constraints.append(")))\n");
            }

            // following the convention used in past versions, if a transition t from state a to state b is true at
            // time position 0, that means that the TA is in state a at time 0 and in state b at time 1
            for (Transition t : ta.getTransitions()) {
               String transition = genTransition(ta, t);
               String sourceState = genState(ta, t.getSource());
               String destState = genState(ta, t.getDestination());
               //assert that a transition implies the TA is currently in the source state
                constraints.append("(assert (eqones (bvimpl " + transition + " " + sourceState + ")))\n");
                //assert that a transition implies the TA will be in the dest state next
                constraints.append("(assert (eqones (bvimpl (getprev " + transition + ") (getnext " + destState + "))))\n");
            }
            // null transition constraint
            constraints.append("(assert (eqones (bvimpl " + genTransition(ta, null) + " (bvand");
            for (int i = 0; i < stateBits; i++) {
                String sBit = "s_" + ta.getId() + "_" + i;
                constraints.append(" (bviff (getnext " + sBit + ") (getprev " + sBit + "))");
            }
            constraints.append("))))\n");

            //Each transition implies that its guard is true at the moment of transition
            constraints.append("; Transition Guards\n");
            for (Transition t : ta.getTransitions()) {
                TimedExpression transBit = (i) -> "(= ((_ extract " + i + " " + i + ") " + genTransition(ta,t) + ") #b1)";
                Guard g = t.getGuard();
                Set<ClockConstraintAtom> clockConstraints = g.getClockConstraints();
                for (ClockConstraintAtom atom: clockConstraints){
                    constraints.append(evalTimedExpression(assertExp(combine2TimedExpressions("=>",
                            transBit, clockGuardParser(atom,ta))), 0, bound-1));
                }
            }

            //If a transition is fired, then its assignments must be enforced
            constraints.append("; Transition Assignments\n");
            for (Transition t: ta.getTransitions()) {
                TimedExpression transBit = (i) -> "(= ((_ extract " + i + " " + i + ") " + genTransition(ta,t) + ") #b1)";
                //TODO: variable assignments
                for (ClockAssignement ca: t.getAssignement().getClockassigments()) {
                    String clockId = getClockId(ca.getClock().getName(),ta);
                    int value = ca.getValue().evaluate();
                    constraints.append(evalTimedExpression(assertExp(combine2TimedExpressions("=>",
                            transBit, (i) -> "(= (" + clockId + " " + (i+1) + ") " + value + ")")),0, bound-1));
                }
            }

            constraints.append("; Invariant constraints\n");
            for (Transition t: ta.getTransitions()) {
                TimedExpression transBit = (i) -> "(= ((_ extract " + i + " " + i + ") " + genTransition(ta,t) + ") #b1)";
                //TODO: Transitions don't refer to the 'real' state objects, just a clone without Inv information
                Invariant sourceInv = getStateFromId(ta, t.getSource().getStringId()).getInvariant();
                Invariant destInv = getStateFromId(ta, t.getDestination().getStringId()).getInvariant();
                ClockConstraintAtom sourceConstraint;
                ClockConstraintAtom destConstraint;
                if (sourceInv instanceof EmptyInvariant && destInv instanceof EmptyInvariant) continue;
                if (sourceInv instanceof EmptyInvariant) {
                    sourceConstraint = null;
                } else {
                    sourceConstraint = invariantTransformer(ta, (ExpInvariant) sourceInv);
                }
                if (destInv instanceof EmptyInvariant) {
                    destConstraint = null;
                } else {
                    destConstraint = invariantTransformer(ta, (ExpInvariant) destInv);
                }
                constraints.append(evalTimedExpression(assertExp(combine2TimedExpressions("=>",
                        transBit, combine2TimedExpressions("or",
                                combine2TimedExpressions("and", clockInvariantParser(sourceConstraint, ta), clockWeakInvariantParser(destConstraint, ta)),
                                combine2TimedExpressions("and", clockWeakInvariantParser(sourceConstraint, ta), clockInvariantParser(destConstraint, ta))))),
                        0, bound-1));
            }

        }
        // Clock Loop Constraints
        Set<String> allClocks = new HashSet<>();
        allClocks.addAll(globalClockMap.values().stream().map(c -> c.getId()).collect(Collectors.toSet()));
        for (TA ta: system.getTimedAutomata()) {
            allClocks.addAll(localClockMap.get(ta).values().stream().map(c -> c.getId()).collect(Collectors.toSet()));
        }
        // The constant c[clockId] must be the floor of the clock value at the last instant
        loopConstraints.append(allClocks.stream().map(c -> assertExp("(and (<= (to_real c" + c + ") (" + c + " " + (bound-1) + "))" +
                " (> (to_real (+ 1 c" + c + ")) (" + c + " " + (bound-1) + ")))")).collect(Collectors.joining()));
        for (String clockId: allClocks) {
            if (!clockBounds.containsKey(clockId)) {
                clockBounds.put(clockId, 0);
            }
            int cBound = clockBounds.get(clockId);
            // If loopex, then c[clockId] must also be the floor of the clock value at i-loop,
            // unless the clock value is greater than the maximum value at both locations
            loopConstraints.append(assertExp("(=> loopex (or " +
                    "(and (> c" + clockId + " " + cBound + ") (>= (" + clockId + " i-loop) " + (cBound+1) + ")) " +
                    "(and (<= (to_real c" + clockId + ") (" + clockId + " i-loop))" +
                        " (> (to_real (+ 1 c" + clockId + ")) (" + clockId + " i-loop)))))"));
            loopConstraints.append(assertExp("(=> loopex (=> (<= c" + clockId + " " + cBound + ") " +
                    "(iff (= (to_real c" + clockId + ") (" + clockId + " " + (bound-1) + ")) " +
                         "(= (to_real c" + clockId + ") (" + clockId + " " + "i-loop)))))"));
            for (String clockId2: allClocks) {
                int cBound2 = clockBounds.get(clockId2);
                loopConstraints.append(assertExp("(=> loopex (=> (< c" + clockId2 + " " + cBound2 + ") " +
                        "(iff " +
                         "(<= (- (" + clockId + " " + (bound-1) + ") c" + clockId + ") " +
                             "(- (" + clockId2 + " " + (bound-1) + ") c" + clockId2 + ")) " +
                         "(<= (- (" + clockId + " i-loop) c" + clockId + ") " +
                             "(- (" + clockId2 + " i-loop) c" + clockId2 + ")))))"));
            }
            // Non-Zeno Constraints
            // Each clock must either be reset inside the loop OR be greater than the max bound for that clock at the
            // final loop state (second-to-last bit)
            Set<String> assigningTransitions = new HashSet<>();
            TA clockTA = mapClockTA.get(clockId);
            //Global Clock
            if (clockTA == null) {
                for (TA ta: system.getTimedAutomata()) {
                    assigningTransitions.addAll(getAssigningTransitionIds(ta, clockId));
                }
            } else {
                // Else local clock
                assigningTransitions.addAll(getAssigningTransitionIds(clockTA, clockId));
            }
            loopConstraints.append(assertExp("(=> loopex (or (> (" + clockId+" "+(bound-2) + ") " + cBound + ") " +
                    "(not (eqzeros (bvand inloop (bvor zeros" +
                    assigningTransitions.stream().map(t -> " " + t).collect(Collectors.joining()) + "))))))"));
        }


        return declarations.toString() + initalizations.toString() + constraints.toString() + loopConstraints.toString();
    }

    private State getStateFromId(TA ta, String sId) {
        return mapIdState.get(new AbstractMap.SimpleEntry<>(ta, mapStateId.get(new AbstractMap.SimpleEntry<>(ta, sId))));
    }

    private Set<String> getAssigningTransitionIds(TA ta, String canonicalClockId) {
        String clock = canonicalClockId;
        Set<Transition> candidates = ta.getTransitions();
        return candidates.stream().filter(t -> {
            for (ClockAssignement ca: t.getAssignement().getClockassigments()) {
                if (canonicalClockId.equals(getClockId(ca.getClock().getName(),ta))) {
                    return true;
                }
            }
            return false;
        }).map(t -> genTransition(ta, t)).collect(Collectors.toSet());
    }

    //Guard
    private TimedExpression clockGuardParser(ClockConstraintAtom constraint, TA ta) {
        if (constraint == null) return (i) -> "true";
        String operator = constraint.getOperator().toString();
        if (operator.equals("==")) operator = "=";

        String clockId = getClockId(constraint.getClock().getName(), ta);
        String value = Integer.toString(constraint.getValue());
        // We can't use the value of the clock at instant (i+1) because a transition might reset the clock
        // which would change the clock value but wouldn't affect the guard
        String finalOperator = operator;
        return (i) -> "(" + finalOperator + " (+ (" + clockId + " " + i + ") (delta " + i + ")) " + value + ")";
    }

    // Invariants

    private TimedExpression clockInvariantParser(ClockConstraintAtom constraint, TA ta) {
        if (constraint == null) return (i) -> "true";
        String operator = constraint.getOperator().toString();
        if (operator.equals("==")) operator = "=";

        String clockId = getClockId(constraint.getClock().getName(), ta);
        String value = Integer.toString(constraint.getValue());
        String resBegin = "(" + operator + " (" + clockId + " ";
        String resEnd = ") " + value + ")";
        //add 1 here because transition is true the instance *before* the transition, but contraints must be true
        // the instance *of* the transition
        return (i) -> resBegin + (i+1) + resEnd;
    }

    private TimedExpression clockWeakInvariantParser(ClockConstraintAtom constraint, TA ta) {
        if (constraint == null) return (i) -> "true";
        String operator = constraint.getOperator().toString();
        if (operator.equals("==")) return (i) -> "false";
        if (operator.equals("<=")) operator = "<";
        if (operator.equals(">=")) operator = ">";

        String clockId = getClockId(constraint.getClock().getName(), ta);
        String value = Integer.toString(constraint.getValue());
        String resBegin = "(" + operator + " (" + clockId + " ";
        String resEnd = ") " + value + ")";
        //add 1 here because transition is true the instance *before* the transition, but contraints must be true
        // the instance *of* the transition
        return (i) -> resBegin + (i+1) + resEnd;
    }

    private ClockConstraintAtom invariantTransformer(TA ta, ExpInvariant inv) {
        //TODO: refactor into its own visitor
        //TODO: maybe do everyone a favor and fix this dumb Identifier/Value/Expression confusion
        //this is so dumb... so, so dumb
        return new ClockConstraintAtom(new Clock(inv.getId().getId()), ClockConstraintAtom.ClockConstraintAtomOperator.parse(inv.getOperator()),
                inv.getExp().evaluate());

    }

    private String genTransition(TA ta, Transition t) {
        int tId = mapTransitionId.get(new AbstractMap.SimpleEntry<>(ta, t));
        return "trans_" + ta.getId() + "_" + tId;
    }

    private String genState(TA ta, State s) {
        int sId = mapStateId.get(new AbstractMap.SimpleEntry<>(ta, s.getStringId()));
        return "state_" + ta.getId() + "_" + sId;
    }

    private String getClockId(String cId, TA ta) {
        if (ta == null) {
            return globalClockMap.get(cId).getId();
        } else {
            ClockDecl cl = localClockMap.get(ta).get(cId);
            if (cl == null) {
                return globalClockMap.get(cId).getId();
            } else {
                return cl.getId();
            }
        }
    }

    private String genTransitionBits(TA ta, Transition t) {
        int transBits = intToNumBits(ta.getTransitions().size()+1); //+1 is for no transition taken
        int tId = mapTransitionId.get(new AbstractMap.SimpleEntry<>(ta, t));
        List<String> bits = new LinkedList<>();
        for (int i = 0; i < transBits; i++) {
            if ((tId & 1 << i) > 0) {
                bits.add("t_" + ta.getId() + "_" + i);
            } else {
                bits.add("(bvnot " + "t_" + ta.getId() + "_" + i + ")");
            }
        }
        String result = "";
        //Unfortunately this isn't lisp, bvand takes *exactly* two arguments
        //TODO ^not true, bvand will accept any # of args > 0
        while (bits.size() > 0) {
            if (bits.size() == 1) {
                return bits.remove(0);
            } else {
                String item1 = bits.remove(0);
                String item2 = bits.remove(0);
                bits.add("(bvand " + item1 + " " + item2 + ")");
            }
        }
        return result;
    }

    private String genStateBits(TA ta, State s) {
        int stateBits = intToNumBits(ta.getStates().size());
        int sId = mapStateId.get(new AbstractMap.SimpleEntry<>(ta, s.getStringId()));
        List<String> bits = new LinkedList<>();
        for (int i =0; i < stateBits; i++) {
            if ((sId & (1 << i)) > 0) {
                bits.add("s_" + ta.getId() + "_" + i);
            } else {
                bits.add("(bvnot s_" + ta.getId() + "_" + i + ")");
            }
        }
        String result = "";
        //Unfortunately this isn't lisp, bvand takes *exactly* two arguments
        //TODO ^again, not true
        while (bits.size() > 0) {
            if (bits.size() == 1) {
                return bits.remove(0);
            } else {
                String item1 = bits.remove(0);
                String item2 = bits.remove(0);
                bits.add("(bvand " + item1 + " " + item2 + ")");
            }
        }
        return result;
    }

    String mitliIntegration () {
        return null;
    }

    int intToNumBits(int i) {
        if (i == 0) return 0;
        if (i < 0) i = -1*i;
        int b = 1;
        while (i > Math.pow(2,b)) {
            b++;
        }
        return b;
    }
}
