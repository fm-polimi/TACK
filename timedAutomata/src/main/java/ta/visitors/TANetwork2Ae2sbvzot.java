package ta.visitors;

import ta.*;
import ta.declarations.ClockDecl;
import ta.state.State;
import ta.transition.Transition;

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

    // Sets of Global & local clocks, modified to have a unique naming scheme
    // 'c_' is prepended to the names of global clocks
    // 'cl_[TA-id]_' is prepended to the names of local clocks
    // although the parser guarantees that all variable names are unique,
    // the TA template feature means that TAs derived from the same template will have
    // local clocks with the same name
    private Map<String,ClockDecl> globalClockMap = new HashMap<>();
    private Map<TA,Map<String,ClockDecl>> localClockMap = new HashMap<>();




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
        for (ClockDecl c : system.getClockDeclarations()) {
            globalClockMap.put(c.getId(), new ClockDecl(c.getType(), "c_" + c.getId(), c.getValue()));
        }
        for (TA ta : system.getTimedAutomata()) {
            localClockMap.put(ta, new HashMap<>());
            for (ClockDecl c : ta.getClockDeclarations()) {
                localClockMap.get(ta).put(c.getId(), new ClockDecl(c.getType(), "cl_" + ta.getId() + "_" +
                        c.getId(), c.getValue()));
            }
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
            // null transition
            //TODO: necessary?
            mapTransitionId.put(new AbstractMap.SimpleEntry<>(ta, null), count);
            mapIdTransition.put(new AbstractMap.SimpleEntry<>(ta, count), null);
            this.mapIdTA.put(ta.getId(), ta);
        }
    }

    public String convert () {

        return declarations();
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
        declarations.append("define-fun ones () "+vectorType+"\n" +
                "    (bvnot zeros))\n");
        declarations.append("(define-fun eqzeros ((A "+vectorType+")) "+vectorType+"\n" +
                "    (= zeros A))\n");
        declarations.append("(define-fun eqones ((A "+vectorType+")) "+vectorType+"\n" +
                "    (= ones A))\n");
        declarations.append("(define-fun bviff ((A "+vectorType+") (B "+vectorType+")) "+vectorType+"\n" +
                "    (bvxnor A B))\n");
        declarations.append("(define-fun bvimpl ((A "+vectorType+") (B "+vectorType+")) "+vectorType+"\n" +
                "    (bvor (bvnot A) B))\n");
        declarations.append("(define-fun getprev ((A "+vectorType+")) "+vectorType+"\n" +
                "    ((_ zero_extend 1) ((_ extract " + (bound-2) + "0) A)))\n");
        declarations.append("(define-fun getnext ((A "+vectorType+")) "+vectorType+"\n" +
                "    ((_ zero_extend 1) ((_ extract " + (bound-1) + "1) A)))\n");

        // I-loop
        declarations.append("(declare-fun i_loop () " + vectorType + ")\n");
        declarations.append("(declare-fun i-loop () Int)\n");
        declarations.append("(assert (= ((_ int2bv " + boundStr + ") i-loop) i_loop))\n");

        // Global Clocks
        declarations.append("; Global Clocks\n");
        declarations.append(globalClockMap.values().stream().map(c ->
                "(declare-fun " + c.getId() + " (Int) Real)\n" +
                "(declare-fun c" + c.getId() + " () Int)\n").collect(Collectors.joining()));
        initalizations.append(globalClockMap.values().stream().map(c ->
                "(assert (= " + c.getValue().evaluate() + "(" + c.getId() + " 0)))\n").collect(Collectors.joining()));
        declarations.append("(declare-fun now (Int) Real)\n");
        declarations.append("(declare-fun delta (Int) Real)\n");

        // TODO Global Variables


        for (TA ta : system.getTimedAutomata()) {
            int taId = ta.getId();

            // Local Clocks
            declarations.append(localClockMap.get(ta).values().stream().map(c ->
                    "(declare-fun " + c.getId() + " (Int) Real)\n" +
                    "(declare-fun c" + c.getId() + " () Int\n").collect(Collectors.joining()));
            initalizations.append(localClockMap.get(ta).values().stream().map(c ->
                    "(assert (= " + c.getValue().evaluate() + " (" + c.getId() + " 0)))\n").collect(Collectors.joining()));

            // TODO Local Variables

            // Bit representation of states
            // Copied enumeration code from TANetwork2CLTLocRC, placed in class init
            int stateBits = intToNumBits(ta.getStates().size());
            for (int i = 0; i < stateBits; i++) {
                declarations.append("(declare-fun s_" + ta.getId() + "_" + i + " () " + vectorType + ")\n");
            }

            //Shorthand for accessing individual states:
            for (State s: ta.getStates()) {
                int stateId = mapStateId.get(new AbstractMap.SimpleEntry<>(ta, s.getStringId()));
                declarations.append("(define-fun state_" + taId + "_" + stateId + " () " + vectorType + "\n" +
                        "    " + genStateBits(ta, s) + ")\n");
            }

            // Bit representation of transitions
            int transBits = intToNumBits(ta.getTransitions().size()+1); // +1 is for no transition taken
            for (int i=0; i < transBits; i++) {
                declarations.append("(declare-fun t_" + ta.getId() + "_" + i + " () " + vectorType + ")\n");
            }
            // Shorthand for accessing individual transitions:
            for (Transition t: ta.getTransitions()) {
                int transId = mapTransitionId.get(new AbstractMap.SimpleEntry<>(ta, t));
                declarations.append("(define-fun trans_" + taId + "_" + transId + " () " + vectorType + "\n" +
                        "    " + genTransitionBits(ta, t) + ")\n");
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

        }
        return declarations.toString() + initalizations.toString() + constraints.toString() + loopConstraints.toString();
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
