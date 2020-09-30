package ta.visitors.liveness;

import formulae.cltloc.CLTLocFormula;
import ta.SystemDecl;

public class LivenessAnyTAProgresses implements Liveness2CLTLoc {
    @Override
    public CLTLocFormula getLivenessConstraint(SystemDecl system) {
        return null;
    }
}
