package ta.visitors;

import ta.*;
import ta.expressions.EmptyExpression;
import ta.state.EmptyInvariant;
import ta.state.ExpInvariant;
import ta.state.Invariant;
import ta.state.State;
import ta.transition.Guard;
import ta.transition.Transition;
import ta.transition.assignments.ClockAssignement;
import ta.transition.guard.BinaryClockConstraint;
import ta.transition.guard.BinaryVariableConstraint;
import ta.transition.guard.ClockConstraintAtom;
import ta.transition.guard.VariableConstraintAtom;

import java.util.*;
import java.util.stream.Collectors;

public class ClockBoundVisitor implements TAVisitor<Map<Clock,Integer>>{

    public static <T> Map<T,Integer> mergeMaps(Collection<Map<T,Integer>> maps) {
        return maps.stream().map(Map::entrySet).flatMap(Set::stream).collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue, (a,b) -> (a < b) ? b : a));
    }

    public static <T> Map<T,Integer> mergeMaps(Map<T,Integer> map1, Map<T,Integer> map2) {
        Set<Map<T,Integer>> maps = new HashSet<>();
        maps.add(map1);
        maps.add(map2);
        return mergeMaps(maps);

    }

    @Override
    public Map<Clock, Integer> visit(TA ta) {
        Set<Map<Clock,Integer>> maps = new HashSet<>();
        for (State s: ta.getStates()) {
            maps.add(visit(s));
        }
        for (Transition t: ta.getTransitions()) {
            maps.add(visit(t));
        }
        return mergeMaps(maps);
    }

    @Override
    public Map<Clock, Integer> visit(AP ap) {
        return null;
    }

    @Override
    public Map<Clock, Integer> visit(State state) {
        return visit(state.getInvariant());
    }

    public Map<Clock, Integer> visit(Invariant invariant) {
        if (invariant instanceof EmptyInvariant) {
            return new HashMap<>();
        } else if (invariant instanceof ExpInvariant) {
            ExpInvariant inv = (ExpInvariant) invariant;
            String id = inv.getId().getId();
            HashMap<Clock,Integer> result = new HashMap<>();
            result.put(new Clock(id), inv.getExp().evaluate());
            return result;
        } else {
            throw new IllegalArgumentException("Unknown Invariant Subclass: " + invariant.getClass().toString());
        }
    }

    public Map<Clock,Integer> visit(Transition transition) {
        return visit(transition.getGuard());
    }

    public Map<Clock, Integer> visit(Guard guard) {
        return mergeMaps(guard.getClockConstraints().stream().map(c -> visit(c)).collect(Collectors.toSet()));
    }

    @Override
    public Map<Clock, Integer> visit(EmptyExpression emptyExpression) {
        return null;
    }

    @Override
    public Map<Clock, Integer> visit(BinaryClockConstraint binaryClockConstraint) {
        return null;
    }

    @Override
    public Map<Clock, Integer> visit(ClockConstraintAtom clockConstraintAtom) {
        Map<Clock, Integer> result = new HashMap<>();
        result.put(clockConstraintAtom.getClock(), clockConstraintAtom.getValue());
        return result;
    }

    @Override
    public Map<Clock, Integer> visit(VariableConstraintAtom variableConstraintAtom) {
        return null;
    }

    @Override
    public Map<Clock, Integer> visit(BinaryVariableConstraint binaryVariableConstraint) {
        return null;
    }

    @Override
    public Map<Clock, Integer> visit(ClockAssignement clockAssignement) {
        return null;
    }

    @Override
    public Map<Clock, Integer> visit(VariableAssignementAP ap) {
        return null;
    }

    @Override
    public Map<Clock, Integer> visit(StateAP ap) {
        return null;
    }
}
