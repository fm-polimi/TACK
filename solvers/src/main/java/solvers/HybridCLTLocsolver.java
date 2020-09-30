package solvers;

import com.google.common.io.ByteStreams;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.converters.CLTLoc2zot;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import formulae.cltloc.visitor.CLTLocGetMaxBound;
import formulae.cltloc.visitor.ZotPlugin;
import formulae.mitli.MITLIFormula;
import ta.AP;
import ta.StateAP;
import ta.SystemDecl;
import ta.VariableAssignementAP;
import ta.visitors.TANetwork2Ae2sbvzot;
import zotrunner.HybridZotRunner;
import zotrunner.ZotException;
import zotrunner.ZotRunner;

import java.io.*;
import java.util.Set;

public class HybridCLTLocsolver {
    private final String smtTA;
    private final CLTLocFormula mitliFormula;
    private final PrintStream out;
    private final int bound;

    public HybridCLTLocsolver(String smtTA, CLTLocFormula mitliFormula, int bound, PrintStream out) {
        this.smtTA = smtTA;
        this.mitliFormula = mitliFormula;
        this.bound = bound;
        this.out = out;
    }

    public boolean solve() throws IOException, ZotException {
        ZotPlugin zotPlugin = ZotPlugin.AE2SBVZOT;

        File f = new File("config.txt");
        boolean parallel = false;
        if (f.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.startsWith("parallel: 2")) {
                    parallel = true;
                }
            }
            reader.close();
        }

        CLTLoc2zot zotTransformer = new CLTLoc2zot(bound, mitliFormula.accept(new CLTLocGetMaxBound()), zotPlugin);
        zotTransformer.setDryRun(true);
        String zotEncoding = zotTransformer.apply(mitliFormula);
        HybridZotRunner zotRunner = new HybridZotRunner(smtTA, zotEncoding, out, parallel);
        return zotRunner.run();


    }
}
