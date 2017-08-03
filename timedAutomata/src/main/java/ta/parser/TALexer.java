// Generated from TA.g4 by ANTLR 4.5

package ta.parser;

import java.text.ParseException;
import java.util.*;
import ta.declarations.*;
import ta.expressions.*;
import ta.expressions.binary.*;
import ta.expressions.unary.*;
import ta.expressions.ternary.*;
import ta.*;
import java.util.Map.Entry;

import ta.state.*;
import ta.transition.Transition;
import ta.transition.Guard;
import ta.transition.assignments.*;
import ta.SystemDecl;
import ta.Variable;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import ta.TA;
import ta.transition.Assign;
import ta.transition.sync.*;
import ta.transition.guard.*;
import ta.transition.guard.ClockConstraintAtom.ClockConstraintAtomOperator;
import ta.transition.guard.VariableConstraintAtom.VariableConstraintAtomOperator;
import operators.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TALexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		LE=39, LEQ=40, GEQ=41, GE=42, EQCOMP=43, NEQ=44, EQASSIGN=45, EQ=46, FRACTEQ=47, 
		MODEQ=48, PLUS=49, PLUSPLUS=50, MINUSMINUS=51, MINUS=52, MULT=53, PLUSEQ=54, 
		MINUSEQ=55, COLUMEQ=56, MULTEQ=57, POWEQ=58, FRACT=59, MOD=60, POW=61, 
		BIN_PROPOSITIONAL_LOGIC_OPERATOR=62, NOT=63, AND=64, OR=65, BITAND=66, 
		BITANDEQ=67, BITOREQ=68, BITOR=69, LPAR=70, RPAR=71, LBRA=72, RBRA=73, 
		SEMICOLUMN=74, WS=75, ID=76, NAT=77, TRUE=78, FALSE=79, NEWLINE=80, COMMA=81, 
		COMMENT=82, LINE_COMMENT=83;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "LE", "LEQ", "GEQ", "GE", 
		"EQCOMP", "NEQ", "EQASSIGN", "EQ", "FRACTEQ", "MODEQ", "PLUS", "PLUSPLUS", 
		"MINUSMINUS", "MINUS", "MULT", "PLUSEQ", "MINUSEQ", "COLUMEQ", "MULTEQ", 
		"POWEQ", "FRACT", "MOD", "POW", "BIN_PROPOSITIONAL_LOGIC_OPERATOR", "NOT", 
		"AND", "OR", "BITAND", "BITANDEQ", "BITOREQ", "BITOR", "LPAR", "RPAR", 
		"LBRA", "RBRA", "SEMICOLUMN", "WS", "ID", "NAT", "TRUE", "FALSE", "NEWLINE", 
		"COMMA", "COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'system'", "'process'", "'{'", "'}'", "'struct'", "'int'", "'clock'", 
		"'char'", "'bool'", "'urgent'", "'broadcast'", "'const'", "'commit'", 
		"'typedef'", "'for'", "'while'", "'do'", "'if'", "'else'", "'break'", 
		"'switch'", "'return'", "'case'", "':'", "'default'", "'state'", "'init'", 
		"'trans'", "'->'", "'guard'", "'sync'", "'!'", "'?'", "'assign'", "'~'", 
		"'>>='", "'>>>='", "'<<='", "'<'", "'<='", "'>='", "'>'", "'=='", "'!='", 
		null, "'='", "'/='", "'%='", "'+'", "'++'", "'--'", "'-'", "'*'", "'+='", 
		"'-='", null, "'*='", "'^='", "'/'", "'%'", "'^'", null, null, "'&&'", 
		"'||'", "'&'", "'&='", "'|='", "'|'", "'('", "')'", "'['", "']'", "';'", 
		null, null, null, "'true'", "'false'", null, "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "LE", "LEQ", "GEQ", "GE", "EQCOMP", "NEQ", "EQASSIGN", 
		"EQ", "FRACTEQ", "MODEQ", "PLUS", "PLUSPLUS", "MINUSMINUS", "MINUS", "MULT", 
		"PLUSEQ", "MINUSEQ", "COLUMEQ", "MULTEQ", "POWEQ", "FRACT", "MOD", "POW", 
		"BIN_PROPOSITIONAL_LOGIC_OPERATOR", "NOT", "AND", "OR", "BITAND", "BITANDEQ", 
		"BITOREQ", "BITOR", "LPAR", "RPAR", "LBRA", "RBRA", "SEMICOLUMN", "WS", 
		"ID", "NAT", "TRUE", "FALSE", "NEWLINE", "COMMA", "COMMENT", "LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	  boolean matchedEOF=false;
	 	
	 	 private static Map<String, String> declarations = new HashMap<String, String>();
	 	  private static Map<String, String> currentTaDeclarations = new HashMap<String, String>();
	 	  private static Map<String,Set<Integer>> boundedVariablesValues=new HashMap<>();
	 	  private static String currentProc;
	 	   private boolean definedVar(String name){
	 	    if(!currentTaDeclarations.containsKey(name) && !declarations.containsKey(name)){
	        	return false;
	        }
	        return true;
	    }
	    
	    private void cleanCurrentTA(){
	    	currentTaDeclarations = new HashMap<String, String>();
	    }

	    private void addCurrentTADeecl(String name, String type){
	        currentTaDeclarations.put(name, type);
	    }
	    public static int TAU_COUNTER=0;
	 

	public TALexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TA.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2U\u020a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3 \3 \3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3%\3%\3%\3%\3"+
		"&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3,\3,\3,\3"+
		"-\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\63\3"+
		"\63\3\63\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3\67\38\38\38\3"+
		"9\39\39\3:\3:\3:\3;\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\5?\u01ad\n?\3@\3@\3"+
		"A\3A\3A\3B\3B\3B\3C\3C\3D\3D\3D\3E\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3"+
		"J\3K\3K\3L\6L\u01cc\nL\rL\16L\u01cd\3L\3L\3M\3M\7M\u01d4\nM\fM\16M\u01d7"+
		"\13M\3N\3N\7N\u01db\nN\fN\16N\u01de\13N\3O\3O\3O\3O\3O\3P\3P\3P\3P\3P"+
		"\3P\3Q\5Q\u01ec\nQ\3Q\3Q\3R\3R\3S\3S\3S\3S\7S\u01f6\nS\fS\16S\u01f9\13"+
		"S\3S\3S\3S\3S\3S\3T\3T\3T\3T\7T\u0204\nT\fT\16T\u0207\13T\3T\3T\3\u01f7"+
		"\2U\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008d"+
		"H\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1"+
		"R\u00a3S\u00a5T\u00a7U\3\2\6\5\2\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aa"+
		"c|\4\2\f\f\17\17\u0210\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2"+
		"\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2"+
		"w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2"+
		"\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b"+
		"\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2"+
		"\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d"+
		"\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2"+
		"\2\2\u00a7\3\2\2\2\3\u00a9\3\2\2\2\5\u00b0\3\2\2\2\7\u00b8\3\2\2\2\t\u00ba"+
		"\3\2\2\2\13\u00bc\3\2\2\2\r\u00c3\3\2\2\2\17\u00c7\3\2\2\2\21\u00cd\3"+
		"\2\2\2\23\u00d2\3\2\2\2\25\u00d7\3\2\2\2\27\u00de\3\2\2\2\31\u00e8\3\2"+
		"\2\2\33\u00ee\3\2\2\2\35\u00f5\3\2\2\2\37\u00fd\3\2\2\2!\u0101\3\2\2\2"+
		"#\u0107\3\2\2\2%\u010a\3\2\2\2\'\u010d\3\2\2\2)\u0112\3\2\2\2+\u0118\3"+
		"\2\2\2-\u011f\3\2\2\2/\u0126\3\2\2\2\61\u012b\3\2\2\2\63\u012d\3\2\2\2"+
		"\65\u0135\3\2\2\2\67\u013b\3\2\2\29\u0140\3\2\2\2;\u0146\3\2\2\2=\u0149"+
		"\3\2\2\2?\u014f\3\2\2\2A\u0154\3\2\2\2C\u0156\3\2\2\2E\u0158\3\2\2\2G"+
		"\u015f\3\2\2\2I\u0161\3\2\2\2K\u0165\3\2\2\2M\u016a\3\2\2\2O\u016e\3\2"+
		"\2\2Q\u0170\3\2\2\2S\u0173\3\2\2\2U\u0176\3\2\2\2W\u0178\3\2\2\2Y\u017b"+
		"\3\2\2\2[\u017e\3\2\2\2]\u0181\3\2\2\2_\u0183\3\2\2\2a\u0186\3\2\2\2c"+
		"\u0189\3\2\2\2e\u018b\3\2\2\2g\u018e\3\2\2\2i\u0191\3\2\2\2k\u0193\3\2"+
		"\2\2m\u0195\3\2\2\2o\u0198\3\2\2\2q\u019b\3\2\2\2s\u019e\3\2\2\2u\u01a1"+
		"\3\2\2\2w\u01a4\3\2\2\2y\u01a6\3\2\2\2{\u01a8\3\2\2\2}\u01ac\3\2\2\2\177"+
		"\u01ae\3\2\2\2\u0081\u01b0\3\2\2\2\u0083\u01b3\3\2\2\2\u0085\u01b6\3\2"+
		"\2\2\u0087\u01b8\3\2\2\2\u0089\u01bb\3\2\2\2\u008b\u01be\3\2\2\2\u008d"+
		"\u01c0\3\2\2\2\u008f\u01c2\3\2\2\2\u0091\u01c4\3\2\2\2\u0093\u01c6\3\2"+
		"\2\2\u0095\u01c8\3\2\2\2\u0097\u01cb\3\2\2\2\u0099\u01d1\3\2\2\2\u009b"+
		"\u01d8\3\2\2\2\u009d\u01df\3\2\2\2\u009f\u01e4\3\2\2\2\u00a1\u01eb\3\2"+
		"\2\2\u00a3\u01ef\3\2\2\2\u00a5\u01f1\3\2\2\2\u00a7\u01ff\3\2\2\2\u00a9"+
		"\u00aa\7u\2\2\u00aa\u00ab\7{\2\2\u00ab\u00ac\7u\2\2\u00ac\u00ad\7v\2\2"+
		"\u00ad\u00ae\7g\2\2\u00ae\u00af\7o\2\2\u00af\4\3\2\2\2\u00b0\u00b1\7r"+
		"\2\2\u00b1\u00b2\7t\2\2\u00b2\u00b3\7q\2\2\u00b3\u00b4\7e\2\2\u00b4\u00b5"+
		"\7g\2\2\u00b5\u00b6\7u\2\2\u00b6\u00b7\7u\2\2\u00b7\6\3\2\2\2\u00b8\u00b9"+
		"\7}\2\2\u00b9\b\3\2\2\2\u00ba\u00bb\7\177\2\2\u00bb\n\3\2\2\2\u00bc\u00bd"+
		"\7u\2\2\u00bd\u00be\7v\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7w\2\2\u00c0"+
		"\u00c1\7e\2\2\u00c1\u00c2\7v\2\2\u00c2\f\3\2\2\2\u00c3\u00c4\7k\2\2\u00c4"+
		"\u00c5\7p\2\2\u00c5\u00c6\7v\2\2\u00c6\16\3\2\2\2\u00c7\u00c8\7e\2\2\u00c8"+
		"\u00c9\7n\2\2\u00c9\u00ca\7q\2\2\u00ca\u00cb\7e\2\2\u00cb\u00cc\7m\2\2"+
		"\u00cc\20\3\2\2\2\u00cd\u00ce\7e\2\2\u00ce\u00cf\7j\2\2\u00cf\u00d0\7"+
		"c\2\2\u00d0\u00d1\7t\2\2\u00d1\22\3\2\2\2\u00d2\u00d3\7d\2\2\u00d3\u00d4"+
		"\7q\2\2\u00d4\u00d5\7q\2\2\u00d5\u00d6\7n\2\2\u00d6\24\3\2\2\2\u00d7\u00d8"+
		"\7w\2\2\u00d8\u00d9\7t\2\2\u00d9\u00da\7i\2\2\u00da\u00db\7g\2\2\u00db"+
		"\u00dc\7p\2\2\u00dc\u00dd\7v\2\2\u00dd\26\3\2\2\2\u00de\u00df\7d\2\2\u00df"+
		"\u00e0\7t\2\2\u00e0\u00e1\7q\2\2\u00e1\u00e2\7c\2\2\u00e2\u00e3\7f\2\2"+
		"\u00e3\u00e4\7e\2\2\u00e4\u00e5\7c\2\2\u00e5\u00e6\7u\2\2\u00e6\u00e7"+
		"\7v\2\2\u00e7\30\3\2\2\2\u00e8\u00e9\7e\2\2\u00e9\u00ea\7q\2\2\u00ea\u00eb"+
		"\7p\2\2\u00eb\u00ec\7u\2\2\u00ec\u00ed\7v\2\2\u00ed\32\3\2\2\2\u00ee\u00ef"+
		"\7e\2\2\u00ef\u00f0\7q\2\2\u00f0\u00f1\7o\2\2\u00f1\u00f2\7o\2\2\u00f2"+
		"\u00f3\7k\2\2\u00f3\u00f4\7v\2\2\u00f4\34\3\2\2\2\u00f5\u00f6\7v\2\2\u00f6"+
		"\u00f7\7{\2\2\u00f7\u00f8\7r\2\2\u00f8\u00f9\7g\2\2\u00f9\u00fa\7f\2\2"+
		"\u00fa\u00fb\7g\2\2\u00fb\u00fc\7h\2\2\u00fc\36\3\2\2\2\u00fd\u00fe\7"+
		"h\2\2\u00fe\u00ff\7q\2\2\u00ff\u0100\7t\2\2\u0100 \3\2\2\2\u0101\u0102"+
		"\7y\2\2\u0102\u0103\7j\2\2\u0103\u0104\7k\2\2\u0104\u0105\7n\2\2\u0105"+
		"\u0106\7g\2\2\u0106\"\3\2\2\2\u0107\u0108\7f\2\2\u0108\u0109\7q\2\2\u0109"+
		"$\3\2\2\2\u010a\u010b\7k\2\2\u010b\u010c\7h\2\2\u010c&\3\2\2\2\u010d\u010e"+
		"\7g\2\2\u010e\u010f\7n\2\2\u010f\u0110\7u\2\2\u0110\u0111\7g\2\2\u0111"+
		"(\3\2\2\2\u0112\u0113\7d\2\2\u0113\u0114\7t\2\2\u0114\u0115\7g\2\2\u0115"+
		"\u0116\7c\2\2\u0116\u0117\7m\2\2\u0117*\3\2\2\2\u0118\u0119\7u\2\2\u0119"+
		"\u011a\7y\2\2\u011a\u011b\7k\2\2\u011b\u011c\7v\2\2\u011c\u011d\7e\2\2"+
		"\u011d\u011e\7j\2\2\u011e,\3\2\2\2\u011f\u0120\7t\2\2\u0120\u0121\7g\2"+
		"\2\u0121\u0122\7v\2\2\u0122\u0123\7w\2\2\u0123\u0124\7t\2\2\u0124\u0125"+
		"\7p\2\2\u0125.\3\2\2\2\u0126\u0127\7e\2\2\u0127\u0128\7c\2\2\u0128\u0129"+
		"\7u\2\2\u0129\u012a\7g\2\2\u012a\60\3\2\2\2\u012b\u012c\7<\2\2\u012c\62"+
		"\3\2\2\2\u012d\u012e\7f\2\2\u012e\u012f\7g\2\2\u012f\u0130\7h\2\2\u0130"+
		"\u0131\7c\2\2\u0131\u0132\7w\2\2\u0132\u0133\7n\2\2\u0133\u0134\7v\2\2"+
		"\u0134\64\3\2\2\2\u0135\u0136\7u\2\2\u0136\u0137\7v\2\2\u0137\u0138\7"+
		"c\2\2\u0138\u0139\7v\2\2\u0139\u013a\7g\2\2\u013a\66\3\2\2\2\u013b\u013c"+
		"\7k\2\2\u013c\u013d\7p\2\2\u013d\u013e\7k\2\2\u013e\u013f\7v\2\2\u013f"+
		"8\3\2\2\2\u0140\u0141\7v\2\2\u0141\u0142\7t\2\2\u0142\u0143\7c\2\2\u0143"+
		"\u0144\7p\2\2\u0144\u0145\7u\2\2\u0145:\3\2\2\2\u0146\u0147\7/\2\2\u0147"+
		"\u0148\7@\2\2\u0148<\3\2\2\2\u0149\u014a\7i\2\2\u014a\u014b\7w\2\2\u014b"+
		"\u014c\7c\2\2\u014c\u014d\7t\2\2\u014d\u014e\7f\2\2\u014e>\3\2\2\2\u014f"+
		"\u0150\7u\2\2\u0150\u0151\7{\2\2\u0151\u0152\7p\2\2\u0152\u0153\7e\2\2"+
		"\u0153@\3\2\2\2\u0154\u0155\7#\2\2\u0155B\3\2\2\2\u0156\u0157\7A\2\2\u0157"+
		"D\3\2\2\2\u0158\u0159\7c\2\2\u0159\u015a\7u\2\2\u015a\u015b\7u\2\2\u015b"+
		"\u015c\7k\2\2\u015c\u015d\7i\2\2\u015d\u015e\7p\2\2\u015eF\3\2\2\2\u015f"+
		"\u0160\7\u0080\2\2\u0160H\3\2\2\2\u0161\u0162\7@\2\2\u0162\u0163\7@\2"+
		"\2\u0163\u0164\7?\2\2\u0164J\3\2\2\2\u0165\u0166\7@\2\2\u0166\u0167\7"+
		"@\2\2\u0167\u0168\7@\2\2\u0168\u0169\7?\2\2\u0169L\3\2\2\2\u016a\u016b"+
		"\7>\2\2\u016b\u016c\7>\2\2\u016c\u016d\7?\2\2\u016dN\3\2\2\2\u016e\u016f"+
		"\7>\2\2\u016fP\3\2\2\2\u0170\u0171\7>\2\2\u0171\u0172\7?\2\2\u0172R\3"+
		"\2\2\2\u0173\u0174\7@\2\2\u0174\u0175\7?\2\2\u0175T\3\2\2\2\u0176\u0177"+
		"\7@\2\2\u0177V\3\2\2\2\u0178\u0179\7?\2\2\u0179\u017a\7?\2\2\u017aX\3"+
		"\2\2\2\u017b\u017c\7#\2\2\u017c\u017d\7?\2\2\u017dZ\3\2\2\2\u017e\u017f"+
		"\7<\2\2\u017f\u0180\7?\2\2\u0180\\\3\2\2\2\u0181\u0182\7?\2\2\u0182^\3"+
		"\2\2\2\u0183\u0184\7\61\2\2\u0184\u0185\7?\2\2\u0185`\3\2\2\2\u0186\u0187"+
		"\7\'\2\2\u0187\u0188\7?\2\2\u0188b\3\2\2\2\u0189\u018a\7-\2\2\u018ad\3"+
		"\2\2\2\u018b\u018c\7-\2\2\u018c\u018d\7-\2\2\u018df\3\2\2\2\u018e\u018f"+
		"\7/\2\2\u018f\u0190\7/\2\2\u0190h\3\2\2\2\u0191\u0192\7/\2\2\u0192j\3"+
		"\2\2\2\u0193\u0194\7,\2\2\u0194l\3\2\2\2\u0195\u0196\7-\2\2\u0196\u0197"+
		"\7?\2\2\u0197n\3\2\2\2\u0198\u0199\7/\2\2\u0199\u019a\7?\2\2\u019ap\3"+
		"\2\2\2\u019b\u019c\7<\2\2\u019c\u019d\7?\2\2\u019dr\3\2\2\2\u019e\u019f"+
		"\7,\2\2\u019f\u01a0\7?\2\2\u01a0t\3\2\2\2\u01a1\u01a2\7`\2\2\u01a2\u01a3"+
		"\7?\2\2\u01a3v\3\2\2\2\u01a4\u01a5\7\61\2\2\u01a5x\3\2\2\2\u01a6\u01a7"+
		"\7\'\2\2\u01a7z\3\2\2\2\u01a8\u01a9\7`\2\2\u01a9|\3\2\2\2\u01aa\u01ad"+
		"\5\u0081A\2\u01ab\u01ad\5\u0083B\2\u01ac\u01aa\3\2\2\2\u01ac\u01ab\3\2"+
		"\2\2\u01ad~\3\2\2\2\u01ae\u01af\7#\2\2\u01af\u0080\3\2\2\2\u01b0\u01b1"+
		"\7(\2\2\u01b1\u01b2\7(\2\2\u01b2\u0082\3\2\2\2\u01b3\u01b4\7~\2\2\u01b4"+
		"\u01b5\7~\2\2\u01b5\u0084\3\2\2\2\u01b6\u01b7\7(\2\2\u01b7\u0086\3\2\2"+
		"\2\u01b8\u01b9\7(\2\2\u01b9\u01ba\7?\2\2\u01ba\u0088\3\2\2\2\u01bb\u01bc"+
		"\7~\2\2\u01bc\u01bd\7?\2\2\u01bd\u008a\3\2\2\2\u01be\u01bf\7~\2\2\u01bf"+
		"\u008c\3\2\2\2\u01c0\u01c1\7*\2\2\u01c1\u008e\3\2\2\2\u01c2\u01c3\7+\2"+
		"\2\u01c3\u0090\3\2\2\2\u01c4\u01c5\7]\2\2\u01c5\u0092\3\2\2\2\u01c6\u01c7"+
		"\7_\2\2\u01c7\u0094\3\2\2\2\u01c8\u01c9\7=\2\2\u01c9\u0096\3\2\2\2\u01ca"+
		"\u01cc\t\2\2\2\u01cb\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01cb\3\2"+
		"\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\bL\2\2\u01d0"+
		"\u0098\3\2\2\2\u01d1\u01d5\t\3\2\2\u01d2\u01d4\t\4\2\2\u01d3\u01d2\3\2"+
		"\2\2\u01d4\u01d7\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6"+
		"\u009a\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01dc\4\62;\2\u01d9\u01db\4\62"+
		";\2\u01da\u01d9\3\2\2\2\u01db\u01de\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc"+
		"\u01dd\3\2\2\2\u01dd\u009c\3\2\2\2\u01de\u01dc\3\2\2\2\u01df\u01e0\7v"+
		"\2\2\u01e0\u01e1\7t\2\2\u01e1\u01e2\7w\2\2\u01e2\u01e3\7g\2\2\u01e3\u009e"+
		"\3\2\2\2\u01e4\u01e5\7h\2\2\u01e5\u01e6\7c\2\2\u01e6\u01e7\7n\2\2\u01e7"+
		"\u01e8\7u\2\2\u01e8\u01e9\7g\2\2\u01e9\u00a0\3\2\2\2\u01ea\u01ec\7\17"+
		"\2\2\u01eb\u01ea\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed"+
		"\u01ee\7\f\2\2\u01ee\u00a2\3\2\2\2\u01ef\u01f0\7.\2\2\u01f0\u00a4\3\2"+
		"\2\2\u01f1\u01f2\7\61\2\2\u01f2\u01f3\7,\2\2\u01f3\u01f7\3\2\2\2\u01f4"+
		"\u01f6\13\2\2\2\u01f5\u01f4\3\2\2\2\u01f6\u01f9\3\2\2\2\u01f7\u01f8\3"+
		"\2\2\2\u01f7\u01f5\3\2\2\2\u01f8\u01fa\3\2\2\2\u01f9\u01f7\3\2\2\2\u01fa"+
		"\u01fb\7,\2\2\u01fb\u01fc\7\61\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\bS"+
		"\2\2\u01fe\u00a6\3\2\2\2\u01ff\u0200\7\61\2\2\u0200\u0201\7\61\2\2\u0201"+
		"\u0205\3\2\2\2\u0202\u0204\n\5\2\2\u0203\u0202\3\2\2\2\u0204\u0207\3\2"+
		"\2\2\u0205\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0208\3\2\2\2\u0207"+
		"\u0205\3\2\2\2\u0208\u0209\bT\2\2\u0209\u00a8\3\2\2\2\n\2\u01ac\u01cd"+
		"\u01d5\u01dc\u01eb\u01f7\u0205\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}