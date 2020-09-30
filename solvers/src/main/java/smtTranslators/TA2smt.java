package smtTranslators;

import config.Config;
import ta.StateAP;
import ta.SystemDecl;
import ta.VariableAssignementAP;
import ta.visitors.TANetwork2Ae2sbvzot;

import java.io.PrintStream;
import java.util.Set;

public class TA2smt {

    private final SystemDecl system;
    private final Config config;
    protected final PrintStream out;

    public TA2smt(SystemDecl system, Config config, PrintStream out) {
        this.system = system;
        this.config = config;
        this.out = out;
    }

    public String translate(Set<StateAP> stateAPS, Set<VariableAssignementAP> variableAssignementAPS) {
        final TANetwork2Ae2sbvzot smtConv= new TANetwork2Ae2sbvzot(system, stateAPS, variableAssignementAPS, config.bound);
        return smtConv.convert();
    }
}
