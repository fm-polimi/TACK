package formulae.mitli.parser;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import formulae.mitli.MITLIConjunction;
import formulae.mitli.MITLIFormula;

public class AndTest {

	@Test
	public void test() throws FileNotFoundException, IOException {
		String path = ClassLoader.getSystemResource("formulae/mitli/parser/and.mitli").getPath();

		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(path));
		MITLILexer lexer = new MITLILexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MITLIParser parser = new MITLIParser(tokens);
		parser.setBuildParseTree(true);
		MITLIFormula formula = parser.mitli().formula;
		assertNotNull("The parsed formula cannot be null", formula);

		assertTrue(formula instanceof  MITLIConjunction);
	}
	

}
