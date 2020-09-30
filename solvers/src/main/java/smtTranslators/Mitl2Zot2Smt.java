package smtTranslators;

import com.google.common.collect.BiMap;
import config.Config;
import formulae.cltloc.CLTLocFormula;
import formulae.cltloc.converters.CLTLoc2zot;
import formulae.cltloc.operators.unary.CLTLocYesterday;
import formulae.cltloc.visitor.CLTLocGetMaxBound;
import formulae.cltloc.visitor.ZotPlugin;
import formulae.mitli.MITLIFormula;
import formulae.mitli.atoms.MITLIPropositionalAtom;
import formulae.mitli.atoms.MITLIRelationalAtom;
import formulae.mitli.converters.MITLI2CLTLoc;
import formulae.mitli.visitors.GetPropositionalAtomsVisitor;
import formulae.mitli.visitors.GetRelationalAtomsVisitor;
import org.apache.commons.lang3.StringUtils;
import ta.StateAP;
import ta.VariableAssignementAP;
import ta.expressions.Value;
import zotrunner.DryZotRunner;
import zotrunner.ZotException;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Mitl2Zot2Smt {

    private final MITLIFormula formula;
    private final Config config;
    protected final PrintStream out;

    private Set<VariableAssignementAP> variableAssignementAPS;
    private Set<StateAP> stateAPS;

    public Mitl2Zot2Smt(MITLIFormula formula, Config config, PrintStream out) {
        this.formula = formula;
        this.config = config;
        this.out = out;
    }

    public String translate() throws IOException, ZotException {
        MITLI2CLTLoc translator = new MITLI2CLTLoc(formula);
        CLTLocFormula mitliTranslated = new CLTLocYesterday(translator.apply());
        out.println("MITLI formula converted in CLTLoc");

        BiMap<MITLIFormula, Integer> vocabular = translator.getVocabulary().inverse();
        Set<MITLIRelationalAtom> atoms = formula.accept(new GetRelationalAtomsVisitor());
        variableAssignementAPS = atoms
                .stream().map(
                        a -> new VariableAssignementAP(
                                (a.getIdentifier().contains("_") ? a
                                        .getIdentifier().substring(0, a.getIdentifier().indexOf("_")) : ""),
                                vocabular.get(a),
                                new ta.Variable(a.getIdentifier().contains("_") ? a.getIdentifier()
                                        .substring(a.getIdentifier().indexOf("_") + 1, a.getIdentifier().length())
                                        : a.getIdentifier()),
                                new Value(Integer.toString(a.getValue()))))
                .collect(Collectors.toSet());

        Set<MITLIPropositionalAtom> propositionalAtoms = formula.accept(new GetPropositionalAtomsVisitor());
        stateAPS = propositionalAtoms.stream().map(a -> {
            if (!vocabular.containsKey(a)) {
                throw new IllegalArgumentException(
                        "The proposition " + a + "is not contained in the alphabet of the vocabulary");
            }
            if (a.getAtomName().indexOf("_") == -1) {
                throw new IllegalArgumentException("Error in the proposition: " + a.getAtomName()
                        + "A state proposition  must have the form state_ap");

            }
            return new StateAP(vocabular.get(a), a.getAtomName().substring(0, a.getAtomName().indexOf("_")),
                    a.getAtomName().substring(a.getAtomName().indexOf("_") + 1, a.getAtomName().length()));
        }).collect(Collectors.toSet());

        CLTLoc2zot zotTransformer = new CLTLoc2zot(config.bound, mitliTranslated.accept(new CLTLocGetMaxBound()), ZotPlugin.AE2SBVZOT);
        zotTransformer.setDryRun(true);
        String zotEncoding = zotTransformer.apply(mitliTranslated);

        String smtProperty = new DryZotRunner(zotEncoding,config,out).run();
        List<String> propertyLines = new ArrayList<>(Arrays.asList(smtProperty.split("\\r?\\n")));
        propertyLines.remove(propertyLines.size()-1);
        propertyLines.remove(propertyLines.size()-1);
        return StringUtils.join(propertyLines, '\n');

    }

    public Set<StateAP> getStateAPS() {
        return this.stateAPS;
    }

    public Set<VariableAssignementAP> getVariableAssignementAPS() {
        return variableAssignementAPS;
    }
}
