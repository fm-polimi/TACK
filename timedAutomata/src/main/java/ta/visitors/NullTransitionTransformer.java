package ta.visitors;

import ta.SystemDecl;
import ta.TA;
import ta.transition.Assign;
import ta.transition.Guard;
import ta.transition.Transition;
import ta.transition.sync.SyncExpression;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NullTransitionTransformer {


    public static SystemDecl transform(SystemDecl system) {
        Set<TA> newTA = new HashSet<>();
        for (TA ta: system.getTimedAutomata()) {
            Set<Transition> trans = new HashSet<>(ta.getTransitions());
            trans.addAll(ta.getStates().stream()
                    .map(s -> new Transition(s,s,new Guard(new HashSet<>(), new HashSet<>()),
                            new SyncExpression("nullTransition","TAU"),
                            new Assign(new HashSet<>(), new HashSet<>())))
                    .collect(Collectors.toSet()));
            newTA.add(new TA(ta.getIdentifier(),ta.getAtomicPropositions(),ta.getStates(),trans,ta.getInitialState(),
                    ta.getClocks(), ta.getVariables(), ta.getDeclarations(), ta.getClockDeclarations()));
        }
        return new SystemDecl(newTA,system.getClockDeclarations(),system.getVariableDeclaration());
    }
}