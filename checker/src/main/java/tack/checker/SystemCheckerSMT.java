package tack.checker;

import com.google.common.collect.BiMap;
import com.google.common.io.ByteStreams;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import formulae.mitli.MITLIFormula;
import formulae.mitli.atoms.MITLIPropositionalAtom;
import formulae.mitli.atoms.MITLIRelationalAtom;
import formulae.mitli.converters.MITLI2CLTLoc;
import formulae.mitli.visitors.GetPropositionalAtomsVisitor;
import formulae.mitli.visitors.GetRelationalAtomsVisitor;
import org.apache.commons.io.FileUtils;
import smtTranslators.Mitl2Zot2Smt;
import smtTranslators.TA2smt;
import solvers.HybridCLTLocsolver;
import ta.StateAP;
import ta.SystemDecl;
import ta.VariableAssignementAP;
import ta.expressions.Value;
import ta.visitors.TANetwork2Ae2sbvzot;
import config.Config;
import zotrunner.SmtRunner;
import zotrunner.ZotException;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;
import java.util.stream.Collectors;

public class SystemCheckerSMT {

    /**
     * The TA System to verify
     */
    protected final SystemDecl system;

    /**
     * The MITLI formula to be considered
     */
    protected final MITLIFormula mitliformula;

    /**
     * The bound to be considered in the verification
     */
    protected int bound;

    /**
     * Configuration settings
     */
    protected Config config;

    /**
     * The stream to be used to write output messages
     */
    protected final PrintStream out;

    public SystemCheckerSMT(SystemDecl system, MITLIFormula mitliformula, Config config,
                         PrintStream out) {
        this.system = system;
        this.mitliformula = mitliformula;
        this.bound = config.bound;
        this.config = config;
        this.out = out;
    }

    /**
     * checks the TA network with respect to the property of interest
     *
     * @return true iff the property of interest is satisfied
     *
     * @throws IOException
     * @throws ZotException
     */
    public boolean check() throws IOException, ZotException {
        out.println("************************************************");
        MITLIFormula negatedFormula = MITLIFormula.not(mitliformula);
        out.println("Converting the MITLI formula into SMT");
        Mitl2Zot2Smt mitlTranslator = new Mitl2Zot2Smt(negatedFormula,config,out);
        String smtProperty = mitlTranslator.translate();
        out.println("************************************************");
        out.println("Converting the TA Network into SMT");
        TA2smt taTranslator = new TA2smt(system,config,out);
        String smtNetwork = taTranslator.translate(mitlTranslator.getStateAPS(),
                mitlTranslator.getVariableAssignementAPS());

        String z3Command = "(check-sat-using (then elim-uncnstr (! simplify  :blast_eq_value true :local_ctx true) solve-eqs (repeat bit-blast) (! smt :bv.enable_int2bv true :arith.branch_cut_ratio 5 :case_split 0 :relevancy 0 :auto_config false :restart_strategy 2)) :print_model true)\n"+
                "(exit)";

        SmtRunner smtSolver = new SmtRunner(smtProperty+'\n'+smtNetwork+'\n'+z3Command+'\n',config,out);
        return smtSolver.run();
    }
}
