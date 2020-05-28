// Generated from /home/robert/documents/polimi/thesis/TACK/timedAutomata/src/main/antlr4/TA.g4 by ANTLR 4.8

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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TAParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

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
	public static final int
		RULE_ta = 0, RULE_declaration = 1, RULE_instantiation = 2, RULE_system = 3, 
		RULE_parameterList = 4, RULE_parameter = 5, RULE_procDecl = 6, RULE_procBody = 7, 
		RULE_boundedVariableDecl = 8, RULE_variableDecl = 9, RULE_variableId = 10, 
		RULE_arrayDecl = 11, RULE_type = 12, RULE_fieldDeclId = 13, RULE_prefix = 14, 
		RULE_range = 15, RULE_commit = 16, RULE_urgent = 17, RULE_stateList = 18, 
		RULE_typeDecl = 19, RULE_typeIdList = 20, RULE_fieldDecl = 21, RULE_functionDecl = 22, 
		RULE_block = 23, RULE_statement = 24, RULE_caseocc = 25, RULE_states = 26, 
		RULE_stateDecl = 27, RULE_invariant = 28, RULE_init = 29, RULE_transitions = 30, 
		RULE_transitionset = 31, RULE_transitionBody = 32, RULE_guard = 33, RULE_guardconditionList = 34, 
		RULE_clockconstraint = 35, RULE_constraintAtom = 36, RULE_sync = 37, RULE_assign = 38, 
		RULE_assignmentList = 39, RULE_assignment = 40, RULE_simpleassigment = 41, 
		RULE_exprList = 42, RULE_exprStatement = 43, RULE_expression = 44, RULE_declarationid = 45, 
		RULE_argList = 46;
	private static String[] makeRuleNames() {
		return new String[] {
			"ta", "declaration", "instantiation", "system", "parameterList", "parameter", 
			"procDecl", "procBody", "boundedVariableDecl", "variableDecl", "variableId", 
			"arrayDecl", "type", "fieldDeclId", "prefix", "range", "commit", "urgent", 
			"stateList", "typeDecl", "typeIdList", "fieldDecl", "functionDecl", "block", 
			"statement", "caseocc", "states", "stateDecl", "invariant", "init", "transitions", 
			"transitionset", "transitionBody", "guard", "guardconditionList", "clockconstraint", 
			"constraintAtom", "sync", "assign", "assignmentList", "assignment", "simpleassigment", 
			"exprList", "exprStatement", "expression", "declarationid", "argList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
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
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "LE", "LEQ", "GEQ", "GE", "EQCOMP", "NEQ", "EQASSIGN", 
			"EQ", "FRACTEQ", "MODEQ", "PLUS", "PLUSPLUS", "MINUSMINUS", "MINUS", 
			"MULT", "PLUSEQ", "MINUSEQ", "COLUMEQ", "MULTEQ", "POWEQ", "FRACT", "MOD", 
			"POW", "BIN_PROPOSITIONAL_LOGIC_OPERATOR", "NOT", "AND", "OR", "BITAND", 
			"BITANDEQ", "BITOREQ", "BITOR", "LPAR", "RPAR", "LBRA", "RBRA", "SEMICOLUMN", 
			"WS", "ID", "NAT", "TRUE", "FALSE", "NEWLINE", "COMMA", "COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	@Override
	public String getGrammarFileName() { return "TA.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	  boolean matchedEOF=false;
	 	
	 	 private static Map<String, String> declarations = new HashMap<String, String>();
	 	 private static Map<String, String> currentTaDeclarations = new HashMap<String, String>();
	 	 private static Map<String,Set<Integer>> boundedVariablesValues=new HashMap<>();
	 	 private static String currentProc;
	 	 private static List<String> currentParameters;
	 	 private boolean definedVar(String name){
	 	    if(!currentTaDeclarations.containsKey(name) && !declarations.containsKey(name) && !currentParameters.contains(name)){
	        	return false;
	        }
	        return true;
	    }
	    
	    private void clean(){
	    	boundedVariablesValues=new HashMap<>();
	    	declarations = new HashMap<String, String>();
	    	currentTaDeclarations = new HashMap<String, String>();
	    	currentProc="";
	    	currentParameters = new ArrayList<String>();
	    }
	    private void cleanCurrentTA(){
	    	currentTaDeclarations = new HashMap<String, String>();
	    	currentParameters = new ArrayList<String>();
	    	
	    }

	    private void addCurrentTADeecl(String name, String type){
	        currentTaDeclarations.put(name, type);
	    }
	    public static int TAU_COUNTER=0;
	 
	public TAParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class TaContext extends ParserRuleContext {
		public SystemDecl systemret;
		public DeclarationContext dec;
		public DeclarationContext declaration;
		public InstantiationContext instantiation;
		public TerminalNode EOF() { return getToken(TAParser.EOF, 0); }
		public List<InstantiationContext> instantiation() {
			return getRuleContexts(InstantiationContext.class);
		}
		public InstantiationContext instantiation(int i) {
			return getRuleContext(InstantiationContext.class,i);
		}
		public List<SystemContext> system() {
			return getRuleContexts(SystemContext.class);
		}
		public SystemContext system(int i) {
			return getRuleContext(SystemContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public TaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterTa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitTa(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitTa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TaContext ta() throws RecognitionException {
		TaContext _localctx = new TaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ta);
		 	
		 		declarations = new HashMap<>();
		 	 	currentTaDeclarations = new HashMap<>();
		 	 	boundedVariablesValues=new HashMap<>();
			 	 currentProc="";
			 	 
		 	
			Set<TA> timedAutomata=new HashSet<>();
			  Set<VariableDecl> variableDeclaration=new HashSet<>();
			  Set<ClockDecl> clockDeclaration=new HashSet<>();
			  Map<String, String> variabledeclret=new HashMap<>();
			  Map<String, Expression> variableinitializationret=new HashMap<>();
			   Map<String, Value> clockinitializationret=new HashMap<>();
			  

		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			clean();
			setState(100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(95);
					((TaContext)_localctx).dec = ((TaContext)_localctx).declaration = declaration();


									if(((TaContext)_localctx).declaration.timedAutomaton!=null) timedAutomata.add(((TaContext)_localctx).declaration.timedAutomaton);
									if(((TaContext)_localctx).declaration.variableinitializationret!=null) variableinitializationret.putAll(((TaContext)_localctx).declaration.variableinitializationret);
									if(((TaContext)_localctx).declaration.clockinitializationret!=null){
										clockinitializationret.putAll(((TaContext)_localctx).declaration.clockinitializationret);
									}
									
									if(((TaContext)_localctx).declaration.variabledeclret!=null) variabledeclret.putAll(((TaContext)_localctx).declaration.variabledeclret);
									
					 			
							
					}
					} 
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(103);
				((TaContext)_localctx).instantiation = instantiation();

				 	                    TA template = null;
				             	        for (TA t: timedAutomata) {
				             	            if (t.getIdentifier().equals(((TaContext)_localctx).instantiation.templateName)) template = t;
				             	        }
				             	        if (template == null) {
				             	            throw new IllegalStateException ("Line: "+_localctx.start.getLine()+
				                                    "\t Template does not exist:"+((TaContext)_localctx).instantiation.templateName);
				                        }
				                        List<String> params = template.getParameters();
				                        if (((TaContext)_localctx).instantiation.argumentList.size() > params.size()) {
				                            throw new IllegalStateException ("Line: "+_localctx.start.getLine()+
				                                    "\t Too many parameters, template accepts "+params.size());
				                        }
				                        Map<String, Value> parameterMap = new HashMap<>();
				                        for (int i=0; i < ((TaContext)_localctx).instantiation.argumentList.size(); i++) {
				                            parameterMap.put(params.get(i), new Value(Integer.toString(((TaContext)_localctx).instantiation.argumentList.get(i).evaluate())));
				                        }
				                        TA timedAutomaton = template.replaceParameters(((TaContext)_localctx).instantiation.name, parameterMap);
				 	                    timedAutomata.add(timedAutomaton);
				 	    
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(111);
				system();
				}
				}
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(116);
			match(EOF);

			 		
			 		if(variableinitializationret!=null){
							for(Entry<String,  Expression> entry :variableinitializationret.entrySet()){
							
							String type="";
							if(variabledeclret.containsKey(entry.getKey())){
								type=variabledeclret.get(entry.getKey());
							}
							if(declarations.containsKey(entry.getKey())){
								type=declarations.get(entry.getKey());
							}
						
						if(boundedVariablesValues.containsKey(entry.getKey())){
							variableDeclaration.add(new BoundedVariableDecl(type,  entry.getKey(), entry.getValue(),boundedVariablesValues.get(entry.getKey())));	
						}
						else{
							variableDeclaration.add(new VariableDecl(type,  entry.getKey(), entry.getValue()));	
						}
						
					}
				}
					if(clockinitializationret!=null){
						for(Entry<String,  Value> entry :clockinitializationret.entrySet()){
							 clockDeclaration.add(new ClockDecl("clock",  entry.getKey(), entry.getValue()));
						}
					}
					((TaContext)_localctx).systemret =  new SystemDecl(timedAutomata.stream()
					            .filter(ta -> ta.complete == true)
					            .collect(Collectors.toSet()), clockDeclaration, variableDeclaration);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TA timedAutomaton;
		public Map<String, String> variabledeclret;
		public Map<String, Expression> variableinitializationret;
		public Map<String, Value> clockinitializationret;
		public BoundedVariableDeclContext boundedVariableDecl;
		public VariableDeclContext variableDecl;
		public ProcDeclContext procDecl;
		public BoundedVariableDeclContext boundedVariableDecl() {
			return getRuleContext(BoundedVariableDeclContext.class,0);
		}
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public VariableDeclContext variableDecl() {
			return getRuleContext(VariableDeclContext.class,0);
		}
		public TypeDeclContext typeDecl() {
			return getRuleContext(TypeDeclContext.class,0);
		}
		public ProcDeclContext procDecl() {
			return getRuleContext(ProcDeclContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		 
		 	((DeclarationContext)_localctx).variabledeclret = new HashMap();
		 	((DeclarationContext)_localctx).variableinitializationret = new HashMap<>();
		 	((DeclarationContext)_localctx).clockinitializationret = new HashMap<>();
		 	
		 
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				((DeclarationContext)_localctx).boundedVariableDecl = boundedVariableDecl();

						 	declarations.putAll(((DeclarationContext)_localctx).boundedVariableDecl.variabledeclret);
							_localctx.variabledeclret.putAll(((DeclarationContext)_localctx).boundedVariableDecl.variabledeclret);
				 			_localctx.variableinitializationret.putAll(((DeclarationContext)_localctx).boundedVariableDecl.variableinitializationret);
				 			
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				functionDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				((DeclarationContext)_localctx).variableDecl = variableDecl();

				 		declarations.putAll(((DeclarationContext)_localctx).variableDecl.variabledeclret);
				 		_localctx.variabledeclret.putAll(((DeclarationContext)_localctx).variableDecl.variabledeclret);
				 		_localctx.variableinitializationret.putAll(((DeclarationContext)_localctx).variableDecl.variableinitializationret);
				 		((DeclarationContext)_localctx).clockinitializationret = ((DeclarationContext)_localctx).variableDecl.clockinitializationret;
				 	
				 	
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				typeDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				((DeclarationContext)_localctx).procDecl = procDecl();

					((DeclarationContext)_localctx).timedAutomaton = ((DeclarationContext)_localctx).procDecl.timedAutomaton;

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstantiationContext extends ParserRuleContext {
		public String name;
		public String templateName;
		public List<Expression> argumentList;
		public Token newName;
		public Token tName;
		public ArgListContext argList;
		public TerminalNode EQ() { return getToken(TAParser.EQ, 0); }
		public TerminalNode LPAR() { return getToken(TAParser.LPAR, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(TAParser.RPAR, 0); }
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public List<TerminalNode> ID() { return getTokens(TAParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TAParser.ID, i);
		}
		public InstantiationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instantiation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterInstantiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitInstantiation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitInstantiation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstantiationContext instantiation() throws RecognitionException {
		InstantiationContext _localctx = new InstantiationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instantiation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(132);
			((InstantiationContext)_localctx).newName = match(ID);
			setState(133);
			match(EQ);
			setState(134);
			((InstantiationContext)_localctx).tName = match(ID);
			setState(135);
			match(LPAR);
			setState(136);
			((InstantiationContext)_localctx).argList = argList();
			setState(137);
			match(RPAR);
			setState(138);
			match(SEMICOLUMN);

			 	        ((InstantiationContext)_localctx).name =  (((InstantiationContext)_localctx).newName!=null?((InstantiationContext)_localctx).newName.getText():null);
			 	        ((InstantiationContext)_localctx).templateName =  (((InstantiationContext)_localctx).tName!=null?((InstantiationContext)_localctx).tName.getText():null);
			 	        ((InstantiationContext)_localctx).argumentList =  ((InstantiationContext)_localctx).argList.args;


			 	    
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SystemContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TAParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TAParser.ID, i);
		}
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TAParser.COMMA, i);
		}
		public SystemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_system; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterSystem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitSystem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitSystem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemContext system() throws RecognitionException {
		SystemContext _localctx = new SystemContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_system);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__0);
			setState(142);
			match(ID);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(143);
				match(COMMA);
				setState(144);
				match(ID);
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(150);
			match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterListContext extends ParserRuleContext {
		public ArrayList<String> params;
		public ParameterContext param1;
		public ParameterContext nextParam;
		public TerminalNode LPAR() { return getToken(TAParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(TAParser.RPAR, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TAParser.COMMA, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameterList);

		    ((ParameterListContext)_localctx).params =  new ArrayList<String>();
		 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(152);
				match(LPAR);
				setState(153);
				((ParameterListContext)_localctx).param1 = parameter();

				 		    _localctx.params.add(((ParameterListContext)_localctx).param1.param.getName());
				 		
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(155);
					match(COMMA);
					setState(156);
					((ParameterListContext)_localctx).nextParam = parameter();

					 			    if (_localctx.params.contains(((ParameterListContext)_localctx).nextParam.param.getName())) {
					 			        throw new IllegalStateException ("Line: "+_localctx.start.getLine()+
					 			                "\t Duplicate parameter definition:"+((ParameterListContext)_localctx).nextParam.param.getName());
					 			    }
					 			    _localctx.params.add(((ParameterListContext)_localctx).nextParam.param.getName());
					 			
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(164);
				match(RPAR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public Variable param;
		public Token ID;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode BITAND() { return getToken(TAParser.BITAND, 0); }
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			type();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BITAND) {
				{
				setState(169);
				match(BITAND);
				}
			}

			setState(172);
			((ParameterContext)_localctx).ID = match(ID);
			((ParameterContext)_localctx).param =  new Variable((((ParameterContext)_localctx).ID!=null?((ParameterContext)_localctx).ID.getText():null));
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(174);
				arrayDecl();
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcDeclContext extends ParserRuleContext {
		public TA timedAutomaton;
		public Token ID;
		public ParameterListContext parameterList;
		public ProcBodyContext procBody;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ProcBodyContext procBody() {
			return getRuleContext(ProcBodyContext.class,0);
		}
		public ProcDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterProcDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitProcDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitProcDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcDeclContext procDecl() throws RecognitionException {
		ProcDeclContext _localctx = new ProcDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_procDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__1);
			setState(181);
			((ProcDeclContext)_localctx).ID = match(ID);
			currentProc=(((ProcDeclContext)_localctx).ID!=null?((ProcDeclContext)_localctx).ID.getText():null);
			setState(183);
			((ProcDeclContext)_localctx).parameterList = parameterList();

			 	     currentParameters = ((ProcDeclContext)_localctx).parameterList.params;
			 	 
			setState(185);
			match(T__2);
			setState(186);
			((ProcDeclContext)_localctx).procBody = procBody();
			setState(187);
			match(T__3);


			 	 String taID=(((ProcDeclContext)_localctx).ID!=null?((ProcDeclContext)_localctx).ID.getText():null);
				 cleanCurrentTA();
				 Map<String, String> variabledeclret=((ProcDeclContext)_localctx).procBody.variabledeclret;
				 
				  final Set<Clock> clocks=new HashSet<>();
				  
				  for(Entry<String, String> entry: variabledeclret.entrySet()){
				  	if(entry.getValue().equals("clock")){
				  			clocks.add(new Clock(entry.getKey()));
						
				  	}
				  }

				 
				 final Set<Variable> variables=new HashSet<>();
				  
				  for(Entry<String, String> entry: variabledeclret.entrySet()){
				  	if(!entry.getValue().equals("clock")){
				  			variables.add(new Variable(entry.getKey()));
				  	}
				  }
				
				 Set<VariableDecl> variableDeclaration=new HashSet<>();
				Map<String, Expression> variableinitializationret=((ProcDeclContext)_localctx).procBody.variableinitializationret;
				if(variableinitializationret!=null){
				for(Entry<String,  Expression> entry :variableinitializationret.entrySet()){
					
					String type="";
					if(variabledeclret.containsKey(entry.getKey())){
						type=variabledeclret.get(entry.getKey());
					}
					if(declarations.containsKey(entry.getKey())){
						type=declarations.get(entry.getKey());
					}
					if(boundedVariablesValues.containsKey(entry.getKey())){
						variableDeclaration.add(new BoundedVariableDecl(type,  entry.getKey(), entry.getValue(),boundedVariablesValues.get(entry.getKey())));	
					}
					else{
						variableDeclaration.add(new VariableDecl(type,  entry.getKey(), entry.getValue()));	
					}
					}
				}
					
				Set<ClockDecl> clockDeclaration=new HashSet<>();
				Map<String, Value> clockinitializationret=((ProcDeclContext)_localctx).procBody.clockinitializationret;
				
				if(clockinitializationret!=null){
					for(Entry<String,  Value> entry :clockinitializationret.entrySet()){
						 clockDeclaration.add(new ClockDecl("clock",  entry.getKey(), entry.getValue()));
					}
				}
				((ProcDeclContext)_localctx).timedAutomaton = new TA((((ProcDeclContext)_localctx).ID!=null?((ProcDeclContext)_localctx).ID.getText():null), null, ((ProcDeclContext)_localctx).procBody.stateset, ((ProcDeclContext)_localctx).procBody.transitionsetret, ((ProcDeclContext)_localctx).procBody.initstate, clocks,variables, variableDeclaration, clockDeclaration, ((ProcDeclContext)_localctx).parameterList.params);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcBodyContext extends ParserRuleContext {
		public State initstate;
		public Set<State> stateset;
		public Set<Transition> transitionsetret;
		public Map<String, String> variabledeclret;
		public Map<String, Expression> variableinitializationret;
		public Map<String, Value> clockinitializationret;
		public VariableDeclContext variableDecl;
		public BoundedVariableDeclContext boundedVariableDecl;
		public StatesContext states;
		public InitContext init;
		public TransitionsContext transitions;
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
		}
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<VariableDeclContext> variableDecl() {
			return getRuleContexts(VariableDeclContext.class);
		}
		public VariableDeclContext variableDecl(int i) {
			return getRuleContext(VariableDeclContext.class,i);
		}
		public List<BoundedVariableDeclContext> boundedVariableDecl() {
			return getRuleContexts(BoundedVariableDeclContext.class);
		}
		public BoundedVariableDeclContext boundedVariableDecl(int i) {
			return getRuleContext(BoundedVariableDeclContext.class,i);
		}
		public List<TypeDeclContext> typeDecl() {
			return getRuleContexts(TypeDeclContext.class);
		}
		public TypeDeclContext typeDecl(int i) {
			return getRuleContext(TypeDeclContext.class,i);
		}
		public CommitContext commit() {
			return getRuleContext(CommitContext.class,0);
		}
		public UrgentContext urgent() {
			return getRuleContext(UrgentContext.class,0);
		}
		public TransitionsContext transitions() {
			return getRuleContext(TransitionsContext.class,0);
		}
		public ProcBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterProcBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitProcBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitProcBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcBodyContext procBody() throws RecognitionException {
		ProcBodyContext _localctx = new ProcBodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_procBody);

		 	((ProcBodyContext)_localctx).variabledeclret = new HashMap<>();
		 	((ProcBodyContext)_localctx).variableinitializationret = new HashMap<>();
		 	((ProcBodyContext)_localctx).clockinitializationret = new HashMap<>();
		 	
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			 		currentTaDeclarations=new  HashMap<String, String>();
			 	
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13))) != 0) || _la==ID) {
				{
				setState(199);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(191);
					functionDecl();
					}
					break;
				case 2:
					{
					setState(192);
					((ProcBodyContext)_localctx).variableDecl = variableDecl();


									_localctx.variabledeclret.putAll(((ProcBodyContext)_localctx).variableDecl.variabledeclret);
									if(((ProcBodyContext)_localctx).variableDecl.variabledeclret!=null){
										currentTaDeclarations.putAll(((ProcBodyContext)_localctx).variableDecl.variabledeclret);
									}
									if(((ProcBodyContext)_localctx).variableDecl.variableinitializationret!=null){
										_localctx.variableinitializationret.putAll(((ProcBodyContext)_localctx).variableDecl.variableinitializationret);
									}
									if(((ProcBodyContext)_localctx).variableDecl.clockinitializationret!=null){
										_localctx.clockinitializationret.putAll(((ProcBodyContext)_localctx).variableDecl.clockinitializationret);
									}
									
								
							
					}
					break;
				case 3:
					{
					setState(195);
					((ProcBodyContext)_localctx).boundedVariableDecl = boundedVariableDecl();

							 	_localctx.variabledeclret.putAll(((ProcBodyContext)_localctx).boundedVariableDecl.variabledeclret);
					 			_localctx.variableinitializationret.putAll(((ProcBodyContext)_localctx).boundedVariableDecl.variableinitializationret);
					 			currentTaDeclarations.putAll(((ProcBodyContext)_localctx).boundedVariableDecl.variabledeclret);
					 			
							
					}
					break;
				case 4:
					{
					setState(198);
					typeDecl();
					}
					break;
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204);
			((ProcBodyContext)_localctx).states = states();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(205);
				commit();
				}
			}

			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(208);
				urgent();
				}
			}

			setState(211);
			((ProcBodyContext)_localctx).init = init();

			 		for(State s: ((ProcBodyContext)_localctx).states.stateset){
			 			if(s.getStringId().equals(((ProcBodyContext)_localctx).init.initString)){
			 				((ProcBodyContext)_localctx).initstate = s;
			 			}
			 		}
			 	
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(213);
				((ProcBodyContext)_localctx).transitions = transitions();
				}
			}


			 				    	((ProcBodyContext)_localctx).stateset = ((ProcBodyContext)_localctx).states.stateset;
			                    	((ProcBodyContext)_localctx).transitionsetret = ((ProcBodyContext)_localctx).transitions.transitionsret;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoundedVariableDeclContext extends ParserRuleContext {
		public Map<String, String> variabledeclret;
		public Map<String, Expression> variableinitializationret;
		public TypeContext type;
		public Token ID;
		public Token nat;
		public ExpressionContext expression;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public List<TerminalNode> NAT() { return getTokens(TAParser.NAT); }
		public TerminalNode NAT(int i) {
			return getToken(TAParser.NAT, i);
		}
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TAParser.COMMA, i);
		}
		public TerminalNode EQ() { return getToken(TAParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BoundedVariableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boundedVariableDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterBoundedVariableDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitBoundedVariableDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitBoundedVariableDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoundedVariableDeclContext boundedVariableDecl() throws RecognitionException {
		BoundedVariableDeclContext _localctx = new BoundedVariableDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_boundedVariableDecl);

		 	((BoundedVariableDeclContext)_localctx).variabledeclret = new HashMap<>();
		 	((BoundedVariableDeclContext)_localctx).variableinitializationret = new HashMap<>();
		 	Set<Integer> values=new HashSet<>();

		 	
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			((BoundedVariableDeclContext)_localctx).type = type();
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(219);
				arrayDecl();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(225);
			((BoundedVariableDeclContext)_localctx).ID = match(ID);
			setState(226);
			match(T__2);
			setState(227);
			((BoundedVariableDeclContext)_localctx).nat = match(NAT);

			 				values.add(Integer.parseInt((((BoundedVariableDeclContext)_localctx).nat!=null?((BoundedVariableDeclContext)_localctx).nat.getText():null)));
			 				
			 			
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(229);
				match(COMMA);
				setState(230);
				((BoundedVariableDeclContext)_localctx).nat = match(NAT);

				 				 	values.add(Integer.parseInt((((BoundedVariableDeclContext)_localctx).nat!=null?((BoundedVariableDeclContext)_localctx).nat.getText():null)));
				 				
				 			
				}
				}
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(237);
			match(T__3);

			 			if(definedVar((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null))){
			 				
			 				throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Duplicate variable definition:"+(((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null));
					
			 			}
			 			_localctx.variabledeclret.put((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null), (((BoundedVariableDeclContext)_localctx).type!=null?_input.getText(((BoundedVariableDeclContext)_localctx).type.start,((BoundedVariableDeclContext)_localctx).type.stop):null));
			 			boundedVariablesValues.put((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null),values);
			 		
			 		
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(239);
				match(EQ);
				setState(240);
				((BoundedVariableDeclContext)_localctx).expression = expression(0);

				 			_localctx.variableinitializationret.put((((BoundedVariableDeclContext)_localctx).ID!=null?((BoundedVariableDeclContext)_localctx).ID.getText():null), ((BoundedVariableDeclContext)_localctx).expression.exp);
						
				}
			}

			setState(245);
			match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclContext extends ParserRuleContext {
		public Map<String, String> variabledeclret;
		public Map<String, Expression> variableinitializationret;
		public Map<String, Value> clockinitializationret;
		public TypeContext type;
		public VariableIdContext var1;
		public VariableIdContext varn;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public List<VariableIdContext> variableId() {
			return getRuleContexts(VariableIdContext.class);
		}
		public VariableIdContext variableId(int i) {
			return getRuleContext(VariableIdContext.class,i);
		}
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TAParser.COMMA, i);
		}
		public VariableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterVariableDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitVariableDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitVariableDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclContext variableDecl() throws RecognitionException {
		VariableDeclContext _localctx = new VariableDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variableDecl);

		 	((VariableDeclContext)_localctx).variabledeclret = new HashMap<>();
		 	((VariableDeclContext)_localctx).variableinitializationret = new HashMap<>();
		 	((VariableDeclContext)_localctx).clockinitializationret = new HashMap<>();
		 	
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			((VariableDeclContext)_localctx).type = type();
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(248);
				arrayDecl();
				}
				}
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(254);
			((VariableDeclContext)_localctx).var1 = variableId();

			 			if(definedVar(((VariableDeclContext)_localctx).var1.id)){
			 				
			 				throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Duplicate variable definition:"+((VariableDeclContext)_localctx).var1.id);
					
			 			}
			 			_localctx.variabledeclret.put(((VariableDeclContext)_localctx).var1.id, (((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null));
			 			if(!(((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null).equals("clock")){
			 				if(((VariableDeclContext)_localctx).var1.exp!=null){
			 					_localctx.variableinitializationret.put(((VariableDeclContext)_localctx).var1.id, ((VariableDeclContext)_localctx).var1.exp);
			 				}
			 				else{
			 					_localctx.variableinitializationret.put(((VariableDeclContext)_localctx).var1.id, new EmptyExpression());
			 				}
			 			}
			 			if( (((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null).equals("clock")){
			 				if(((VariableDeclContext)_localctx).var1.exp!=null){
			 				 	_localctx.clockinitializationret.put(((VariableDeclContext)_localctx).var1.id, (Value) ((VariableDeclContext)_localctx).var1.exp);
			 				 }
			 				 else{
			 				 	_localctx.clockinitializationret.put(((VariableDeclContext)_localctx).var1.id, new Value("0"));
			 				 }
			 			}
			 		
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(256);
				match(COMMA);
				setState(257);
				((VariableDeclContext)_localctx).varn = variableId();

				 			
				 			if(definedVar(((VariableDeclContext)_localctx).varn.id)){
				 				throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Duplicate variable definition:"+((VariableDeclContext)_localctx).varn.id);
						
				 			}
				 			_localctx.variabledeclret.put(((VariableDeclContext)_localctx).varn.id, (((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null));
				 			if(!(((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null).equals("clock")){
				 				if(((VariableDeclContext)_localctx).varn.exp!=null){
				 					_localctx.variableinitializationret.put(((VariableDeclContext)_localctx).varn.id, ((VariableDeclContext)_localctx).varn.exp);
				 				}
				 				else{
				 					_localctx.variableinitializationret.put(((VariableDeclContext)_localctx).varn.id, new EmptyExpression());
				 				}
				 			}
				 			if( (((VariableDeclContext)_localctx).type!=null?_input.getText(((VariableDeclContext)_localctx).type.start,((VariableDeclContext)_localctx).type.stop):null).equals("clock")){
				 				if(((VariableDeclContext)_localctx).varn.exp!=null){
				 				 	_localctx.clockinitializationret.put(((VariableDeclContext)_localctx).varn.id, (Value) ((VariableDeclContext)_localctx).varn.exp);
				 				 }
				 				 else{
				 				 	_localctx.clockinitializationret.put(((VariableDeclContext)_localctx).varn.id, new Value("0"));
				 				 }
				 			}
				 		
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(265);
			match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableIdContext extends ParserRuleContext {
		public String id;
		public Expression exp;
		public Token ID;
		public ExpressionContext expression;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode EQ() { return getToken(TAParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterVariableId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitVariableId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitVariableId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableIdContext variableId() throws RecognitionException {
		VariableIdContext _localctx = new VariableIdContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variableId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			((VariableIdContext)_localctx).ID = match(ID);

					((VariableIdContext)_localctx).id = (((VariableIdContext)_localctx).ID!=null?((VariableIdContext)_localctx).ID.getText():null);

			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(269);
				match(EQ);
				setState(270);
				((VariableIdContext)_localctx).expression = expression(0);

						((VariableIdContext)_localctx).exp = ((VariableIdContext)_localctx).expression.exp;

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayDeclContext extends ParserRuleContext {
		public TerminalNode LBRA() { return getToken(TAParser.LBRA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRA() { return getToken(TAParser.RBRA, 0); }
		public ArrayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterArrayDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitArrayDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitArrayDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arrayDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(LBRA);
			setState(276);
			expression(0);
			setState(277);
			match(RBRA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Class typeret;
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		int _la;
		try {
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				prefix();
				setState(280);
				match(ID);
				setState(282);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(281);
					range();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				prefix();
				setState(285);
				match(T__4);
				setState(286);
				match(T__2);
				setState(288); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(287);
					fieldDecl();
					}
					}
					setState(290); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0) || _la==ID );
				setState(292);
				match(T__3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(294);
				prefix();
				setState(303);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__5:
					{
					setState(295);
					match(T__5);
					 ((TypeContext)_localctx).typeret = Integer.class;
					                		 
					}
					break;
				case T__6:
					{
					setState(297);
					match(T__6);
					 ((TypeContext)_localctx).typeret = Clock.class;
					                		 
					}
					break;
				case T__7:
					{
					setState(299);
					match(T__7);
					 ((TypeContext)_localctx).typeret = Character.class;
					                		 
					}
					break;
				case T__8:
					{
					setState(301);
					match(T__8);
					 ((TypeContext)_localctx).typeret = Boolean.class;
					                		 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclIdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public FieldDeclIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterFieldDeclId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitFieldDeclId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitFieldDeclId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclIdContext fieldDeclId() throws RecognitionException {
		FieldDeclIdContext _localctx = new FieldDeclIdContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fieldDeclId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(ID);
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(308);
				arrayDecl();
				}
				}
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixContext extends ParserRuleContext {
		public PrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitPrefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_prefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(314);
					match(T__9);
					}
				}

				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(317);
					match(T__10);
					}
				}

				}
				break;
			case 2:
				{
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(320);
					match(T__11);
					}
				}

				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangeContext extends ParserRuleContext {
		public TerminalNode LBRA() { return getToken(TAParser.LBRA, 0); }
		public List<TerminalNode> NAT() { return getTokens(TAParser.NAT); }
		public TerminalNode NAT(int i) {
			return getToken(TAParser.NAT, i);
		}
		public TerminalNode COMMA() { return getToken(TAParser.COMMA, 0); }
		public TerminalNode RBRA() { return getToken(TAParser.RBRA, 0); }
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(LBRA);
			setState(326);
			match(NAT);
			setState(327);
			match(COMMA);
			setState(328);
			match(NAT);
			setState(329);
			match(RBRA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommitContext extends ParserRuleContext {
		public StateListContext stateList() {
			return getRuleContext(StateListContext.class,0);
		}
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public CommitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterCommit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitCommit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitCommit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommitContext commit() throws RecognitionException {
		CommitContext _localctx = new CommitContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_commit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(T__12);
			setState(332);
			stateList();
			setState(333);
			match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UrgentContext extends ParserRuleContext {
		public StateListContext stateList() {
			return getRuleContext(StateListContext.class,0);
		}
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public UrgentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_urgent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterUrgent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitUrgent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitUrgent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UrgentContext urgent() throws RecognitionException {
		UrgentContext _localctx = new UrgentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_urgent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(T__9);
			setState(336);
			stateList();
			setState(337);
			match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TAParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TAParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TAParser.COMMA, i);
		}
		public StateListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterStateList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitStateList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitStateList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateListContext stateList() throws RecognitionException {
		StateListContext _localctx = new StateListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stateList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(ID);
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(340);
				match(COMMA);
				setState(341);
				match(ID);
				}
				}
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TypeIdListContext> typeIdList() {
			return getRuleContexts(TypeIdListContext.class);
		}
		public TypeIdListContext typeIdList(int i) {
			return getRuleContext(TypeIdListContext.class,i);
		}
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TAParser.COMMA, i);
		}
		public TypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterTypeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitTypeDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitTypeDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclContext typeDecl() throws RecognitionException {
		TypeDeclContext _localctx = new TypeDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_typeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(T__13);
			setState(348);
			type();
			setState(349);
			typeIdList();
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(350);
				match(COMMA);
				setState(351);
				typeIdList();
				}
				}
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(357);
			match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeIdListContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public TypeIdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterTypeIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitTypeIdList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitTypeIdList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeIdListContext typeIdList() throws RecognitionException {
		TypeIdListContext _localctx = new TypeIdListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_typeIdList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			match(ID);
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRA) {
				{
				{
				setState(360);
				arrayDecl();
				}
				}
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclContext extends ParserRuleContext {
		public Class typeret;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<FieldDeclIdContext> fieldDeclId() {
			return getRuleContexts(FieldDeclIdContext.class);
		}
		public FieldDeclIdContext fieldDeclId(int i) {
			return getRuleContext(FieldDeclIdContext.class,i);
		}
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TAParser.COMMA, i);
		}
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitFieldDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitFieldDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			type();
			setState(367);
			fieldDeclId();
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(368);
				match(COMMA);
				setState(369);
				fieldDeclId();
				}
				}
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(375);
			match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_functionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			type();
			setState(378);
			match(ID);
			setState(379);
			parameterList();
			setState(380);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<VariableDeclContext> variableDecl() {
			return getRuleContexts(VariableDeclContext.class);
		}
		public VariableDeclContext variableDecl(int i) {
			return getRuleContext(VariableDeclContext.class,i);
		}
		public List<TypeDeclContext> typeDecl() {
			return getRuleContexts(TypeDeclContext.class);
		}
		public TypeDeclContext typeDecl(int i) {
			return getRuleContext(TypeDeclContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(T__2);
			setState(387);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(385);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__4:
					case T__5:
					case T__6:
					case T__7:
					case T__8:
					case T__9:
					case T__10:
					case T__11:
					case ID:
						{
						setState(383);
						variableDecl();
						}
						break;
					case T__13:
						{
						setState(384);
						typeDecl();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(389);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__31) | (1L << T__34) | (1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SEMICOLUMN - 74)) | (1L << (ID - 74)) | (1L << (NAT - 74)))) != 0)) {
				{
				{
				setState(390);
				statement();
				}
				}
				setState(395);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(396);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> SEMICOLUMN() { return getTokens(TAParser.SEMICOLUMN); }
		public TerminalNode SEMICOLUMN(int i) {
			return getToken(TAParser.SEMICOLUMN, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(TAParser.LPAR, 0); }
		public List<ExprListContext> exprList() {
			return getRuleContexts(ExprListContext.class);
		}
		public ExprListContext exprList(int i) {
			return getRuleContext(ExprListContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(TAParser.RPAR, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<CaseoccContext> caseocc() {
			return getRuleContexts(CaseoccContext.class);
		}
		public CaseoccContext caseocc(int i) {
			return getRuleContext(CaseoccContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_statement);
		int _la;
		try {
			setState(456);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(398);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(399);
				match(SEMICOLUMN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(400);
				expression(0);
				setState(401);
				match(SEMICOLUMN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(403);
				match(T__14);
				setState(404);
				match(LPAR);
				setState(405);
				exprList();
				setState(406);
				match(SEMICOLUMN);
				setState(407);
				exprList();
				setState(408);
				match(SEMICOLUMN);
				setState(409);
				exprList();
				setState(410);
				match(RPAR);
				setState(411);
				statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(413);
				match(T__15);
				setState(414);
				match(LPAR);
				setState(415);
				exprList();
				setState(416);
				match(RPAR);
				setState(417);
				statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(419);
				match(T__16);
				setState(420);
				statement();
				setState(421);
				match(T__15);
				setState(422);
				match(LPAR);
				setState(423);
				exprList();
				setState(424);
				match(RPAR);
				setState(425);
				match(SEMICOLUMN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(427);
				match(T__17);
				setState(428);
				match(LPAR);
				setState(429);
				exprList();
				setState(430);
				match(RPAR);
				setState(431);
				statement();
				setState(434);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(432);
					match(T__18);
					setState(433);
					statement();
					}
					break;
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(436);
				match(T__19);
				setState(437);
				match(SEMICOLUMN);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(438);
				match(T__20);
				setState(439);
				match(LPAR);
				setState(440);
				exprList();
				setState(441);
				match(RPAR);
				setState(442);
				match(T__2);
				setState(444); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(443);
					caseocc();
					}
					}
					setState(446); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__22 || _la==T__24 );
				setState(448);
				match(T__3);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(450);
				match(T__21);
				setState(451);
				match(SEMICOLUMN);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(452);
				match(T__21);
				setState(453);
				expression(0);
				setState(454);
				match(SEMICOLUMN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaseoccContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CaseoccContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseocc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterCaseocc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitCaseocc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitCaseocc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseoccContext caseocc() throws RecognitionException {
		CaseoccContext _localctx = new CaseoccContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_caseocc);
		int _la;
		try {
			setState(475);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(458);
				match(T__22);
				setState(459);
				expression(0);
				setState(460);
				match(T__23);
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__31) | (1L << T__34) | (1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SEMICOLUMN - 74)) | (1L << (ID - 74)) | (1L << (NAT - 74)))) != 0)) {
					{
					{
					setState(461);
					statement();
					}
					}
					setState(466);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(467);
				match(T__24);
				setState(468);
				match(T__23);
				setState(472);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__31) | (1L << T__34) | (1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0) || ((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & ((1L << (SEMICOLUMN - 74)) | (1L << (ID - 74)) | (1L << (NAT - 74)))) != 0)) {
					{
					{
					setState(469);
					statement();
					}
					}
					setState(474);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatesContext extends ParserRuleContext {
		public Set<State> stateset;
		public StateDeclContext s1;
		public StateDeclContext s2;
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public List<StateDeclContext> stateDecl() {
			return getRuleContexts(StateDeclContext.class);
		}
		public StateDeclContext stateDecl(int i) {
			return getRuleContext(StateDeclContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TAParser.COMMA, i);
		}
		public StatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_states; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterStates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitStates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitStates(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatesContext states() throws RecognitionException {
		StatesContext _localctx = new StatesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_states);

			((StatesContext)_localctx).stateset = new HashSet<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(T__25);
			setState(478);
			((StatesContext)_localctx).s1 = stateDecl();

				_localctx.stateset.add(((StatesContext)_localctx).s1.state);

			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(480);
				match(COMMA);
				setState(481);
				((StatesContext)_localctx).s2 = stateDecl();

					_localctx.stateset.add(((StatesContext)_localctx).s2.state);

				}
				}
				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(489);
			match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateDeclContext extends ParserRuleContext {
		public State state;
		public Token ID;
		public InvariantContext inv;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public InvariantContext invariant() {
			return getRuleContext(InvariantContext.class,0);
		}
		public StateDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterStateDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitStateDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitStateDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StateDeclContext stateDecl() throws RecognitionException {
		StateDeclContext _localctx = new StateDeclContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_stateDecl);
		try {
			setState(500);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(491);
				((StateDeclContext)_localctx).ID = match(ID);

						((StateDeclContext)_localctx).state = new State((((StateDeclContext)_localctx).ID!=null?((StateDeclContext)_localctx).ID.getText():null));
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(493);
				((StateDeclContext)_localctx).ID = match(ID);
				{
				setState(494);
				match(T__2);
				setState(495);
				((StateDeclContext)_localctx).inv = invariant();
				setState(496);
				match(T__3);
				}

				 		if(((StateDeclContext)_localctx).inv.inv!=null){
							((StateDeclContext)_localctx).state = new State((((StateDeclContext)_localctx).ID!=null?((StateDeclContext)_localctx).ID.getText():null), ((StateDeclContext)_localctx).inv.inv);
						}
						else{
							((StateDeclContext)_localctx).state = new State((((StateDeclContext)_localctx).ID!=null?((StateDeclContext)_localctx).ID.getText():null), new EmptyInvariant());
						}	
					
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InvariantContext extends ParserRuleContext {
		public Invariant inv;
		public Token ID;
		public Token op;
		public ExpressionContext expression;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LE() { return getToken(TAParser.LE, 0); }
		public TerminalNode LEQ() { return getToken(TAParser.LEQ, 0); }
		public TerminalNode GE() { return getToken(TAParser.GE, 0); }
		public TerminalNode GEQ() { return getToken(TAParser.GEQ, 0); }
		public InvariantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invariant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterInvariant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitInvariant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitInvariant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvariantContext invariant() throws RecognitionException {
		InvariantContext _localctx = new InvariantContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_invariant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			((InvariantContext)_localctx).ID = match(ID);
			setState(503);
			((InvariantContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LEQ) | (1L << GEQ) | (1L << GE))) != 0)) ) {
				((InvariantContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(504);
			((InvariantContext)_localctx).expression = expression(0);

			 		((InvariantContext)_localctx).inv = new ExpInvariant(new Identifier((((InvariantContext)_localctx).ID!=null?((InvariantContext)_localctx).ID.getText():null)), (((InvariantContext)_localctx).op!=null?((InvariantContext)_localctx).op.getText():null), ((InvariantContext)_localctx).expression.exp);
			 	
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitContext extends ParserRuleContext {
		public String initString;
		public Token ID;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			match(T__26);
			setState(508);
			((InitContext)_localctx).ID = match(ID);
			setState(509);
			match(SEMICOLUMN);

				((InitContext)_localctx).initString = (((InitContext)_localctx).ID!=null?((InitContext)_localctx).ID.getText():null);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransitionsContext extends ParserRuleContext {
		public Set<Transition> transitionsret;
		public TransitionsetContext transitionset;
		public List<TransitionsetContext> transitionset() {
			return getRuleContexts(TransitionsetContext.class);
		}
		public TransitionsetContext transitionset(int i) {
			return getRuleContext(TransitionsetContext.class,i);
		}
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public TransitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterTransitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitTransitions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitTransitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TransitionsContext transitions() throws RecognitionException {
		TransitionsContext _localctx = new TransitionsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_transitions);
		((TransitionsContext)_localctx).transitionsret = new HashSet<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			match(T__27);
			setState(513);
			((TransitionsContext)_localctx).transitionset = transitionset();

					_localctx.transitionsret.addAll(((TransitionsContext)_localctx).transitionset.transitionsret);
				
			setState(520);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(515);
				((TransitionsContext)_localctx).transitionset = transitionset();

						_localctx.transitionsret.addAll(((TransitionsContext)_localctx).transitionset.transitionsret);		
					
				}
				}
				setState(522);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(523);
			match(SEMICOLUMN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransitionsetContext extends ParserRuleContext {
		public Set<Transition> transitionsret;
		public Token s1;
		public Token s2;
		public TransitionBodyContext transitionBody;
		public Token s3;
		public TransitionBodyContext b2;
		public List<TransitionBodyContext> transitionBody() {
			return getRuleContexts(TransitionBodyContext.class);
		}
		public TransitionBodyContext transitionBody(int i) {
			return getRuleContext(TransitionBodyContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(TAParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TAParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TAParser.COMMA, i);
		}
		public TransitionsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transitionset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterTransitionset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitTransitionset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitTransitionset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TransitionsetContext transitionset() throws RecognitionException {
		TransitionsetContext _localctx = new TransitionsetContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_transitionset);
		((TransitionsetContext)_localctx).transitionsret = new HashSet<>();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			((TransitionsetContext)_localctx).s1 = match(ID);
			setState(526);
			match(T__28);
			setState(527);
			((TransitionsetContext)_localctx).s2 = match(ID);
			setState(528);
			((TransitionsetContext)_localctx).transitionBody = transitionBody();

					_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s2.getText()), ((TransitionsetContext)_localctx).transitionBody.guardexp, ((TransitionsetContext)_localctx).transitionBody.syncexp,  ((TransitionsetContext)_localctx).transitionBody.assignexp));
				
			setState(538);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(530);
					match(COMMA);
					setState(531);
					match(T__28);
					setState(532);
					((TransitionsetContext)_localctx).s3 = match(ID);
					setState(533);
					((TransitionsetContext)_localctx).b2 = ((TransitionsetContext)_localctx).transitionBody = transitionBody();

							_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s3.getText()), ((TransitionsetContext)_localctx).b2.guardexp, ((TransitionsetContext)_localctx).b2.syncexp,  ((TransitionsetContext)_localctx).b2.assignexp));
							
						
					}
					} 
				}
				setState(540);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			setState(560);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(541);
				match(COMMA);
				setState(542);
				((TransitionsetContext)_localctx).s1 = match(ID);
				setState(543);
				match(T__28);
				setState(544);
				((TransitionsetContext)_localctx).s2 = match(ID);
				setState(545);
				((TransitionsetContext)_localctx).transitionBody = transitionBody();

						_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s2.getText()), ((TransitionsetContext)_localctx).transitionBody.guardexp, ((TransitionsetContext)_localctx).transitionBody.syncexp,  ((TransitionsetContext)_localctx).transitionBody.assignexp));
					
				setState(555);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(547);
						match(COMMA);
						setState(548);
						match(T__28);
						setState(549);
						((TransitionsetContext)_localctx).s3 = match(ID);
						setState(550);
						((TransitionsetContext)_localctx).b2 = ((TransitionsetContext)_localctx).transitionBody = transitionBody();

								_localctx.transitionsret.add(new Transition(new State(((TransitionsetContext)_localctx).s1.getText()), new State(((TransitionsetContext)_localctx).s3.getText()), ((TransitionsetContext)_localctx).b2.guardexp, ((TransitionsetContext)_localctx).b2.syncexp,  ((TransitionsetContext)_localctx).b2.assignexp));
								
							
						}
						} 
					}
					setState(557);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				}
				}
				}
				setState(562);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransitionBodyContext extends ParserRuleContext {
		public Guard guardexp;
		public SyncExpression syncexp;
		public Assign assignexp;
		public GuardContext guard;
		public SyncContext sync;
		public AssignContext assign;
		public SyncContext sync() {
			return getRuleContext(SyncContext.class,0);
		}
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public TransitionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transitionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterTransitionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitTransitionBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitTransitionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TransitionBodyContext transitionBody() throws RecognitionException {
		TransitionBodyContext _localctx = new TransitionBodyContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_transitionBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			match(T__2);
			setState(567);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(564);
				((TransitionBodyContext)_localctx).guard = guard();

				 			 ((TransitionBodyContext)_localctx).guardexp = ((TransitionBodyContext)_localctx).guard.guardexp;
				 		
				}
			}


					if(_localctx.guardexp==null) {((TransitionBodyContext)_localctx).guardexp = new Guard(new HashSet<VariableConstraintAtom>(), new HashSet<ClockConstraintAtom>());}
					
			{
			setState(570);
			((TransitionBodyContext)_localctx).sync = sync();

					((TransitionBodyContext)_localctx).syncexp = ((TransitionBodyContext)_localctx).sync.syncexp;
					
			}
			setState(576);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(573);
				((TransitionBodyContext)_localctx).assign = assign();

				 			((TransitionBodyContext)_localctx).assignexp = ((TransitionBodyContext)_localctx).assign.assignexp;
				 		
				}
			}

			setState(578);
			match(T__3);

					if(_localctx.assignexp==null){ ((TransitionBodyContext)_localctx).assignexp = new Assign(new HashSet<ClockAssignement>(), new HashSet<VariableAssignement>());}
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GuardContext extends ParserRuleContext {
		public Guard guardexp;
		public GuardconditionListContext exp1;
		public GuardconditionListContext guardconditionList;
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public GuardconditionListContext guardconditionList() {
			return getRuleContext(GuardconditionListContext.class,0);
		}
		public GuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterGuard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitGuard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitGuard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardContext guard() throws RecognitionException {
		GuardContext _localctx = new GuardContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(581);
			match(T__29);
			setState(582);
			((GuardContext)_localctx).exp1 = ((GuardContext)_localctx).guardconditionList = guardconditionList();
			setState(583);
			match(SEMICOLUMN);

				((GuardContext)_localctx).guardexp = new Guard(((GuardContext)_localctx).guardconditionList.variableconst==null? new HashSet<VariableConstraintAtom>() :((GuardContext)_localctx).guardconditionList.variableconst, ((GuardContext)_localctx).guardconditionList.clockconst==null? new HashSet<ClockConstraintAtom>():((GuardContext)_localctx).guardconditionList.clockconst);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GuardconditionListContext extends ParserRuleContext {
		public Set<VariableConstraintAtom> variableconst;
		public Set<ClockConstraintAtom> clockconst;
		public ClockconstraintContext clockconstraint;
		public List<ClockconstraintContext> clockconstraint() {
			return getRuleContexts(ClockconstraintContext.class);
		}
		public ClockconstraintContext clockconstraint(int i) {
			return getRuleContext(ClockconstraintContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TAParser.COMMA, i);
		}
		public List<TerminalNode> AND() { return getTokens(TAParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(TAParser.AND, i);
		}
		public GuardconditionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guardconditionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterGuardconditionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitGuardconditionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitGuardconditionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardconditionListContext guardconditionList() throws RecognitionException {
		GuardconditionListContext _localctx = new GuardconditionListContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_guardconditionList);

				((GuardconditionListContext)_localctx).variableconst = new HashSet<>();
				((GuardconditionListContext)_localctx).clockconst = new HashSet<>();
			
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
			((GuardconditionListContext)_localctx).clockconstraint = clockconstraint();

							if(((GuardconditionListContext)_localctx).clockconstraint.clockconst!=null) _localctx.clockconst.add(((GuardconditionListContext)_localctx).clockconstraint.clockconst) ;
							if(((GuardconditionListContext)_localctx).clockconstraint.variableconst!=null) _localctx.variableconst.add(((GuardconditionListContext)_localctx).clockconstraint.variableconst);
						
			setState(598);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (AND - 64)) | (1L << (ID - 64)) | (1L << (COMMA - 64)))) != 0)) {
				{
				{
				setState(591);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMMA:
					{
					setState(588);
					match(COMMA);
					}
					break;
				case ID:
					{
					}
					break;
				case AND:
					{
					setState(590);
					match(AND);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(593);
				((GuardconditionListContext)_localctx).clockconstraint = clockconstraint();

								if(((GuardconditionListContext)_localctx).clockconstraint.clockconst!=null) _localctx.clockconst.add(((GuardconditionListContext)_localctx).clockconstraint.clockconst);
								if(((GuardconditionListContext)_localctx).clockconstraint.variableconst!=null)_localctx.variableconst.add(((GuardconditionListContext)_localctx).clockconstraint.variableconst) ;
							
				}
				}
				setState(600);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClockconstraintContext extends ParserRuleContext {
		public ClockConstraintAtom clockconst;
		public VariableConstraintAtom variableconst;
		public ConstraintAtomContext constraintAtom;
		public ConstraintAtomContext constraintAtom() {
			return getRuleContext(ConstraintAtomContext.class,0);
		}
		public ClockconstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clockconstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterClockconstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitClockconstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitClockconstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClockconstraintContext clockconstraint() throws RecognitionException {
		ClockconstraintContext _localctx = new ClockconstraintContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_clockconstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			((ClockconstraintContext)_localctx).constraintAtom = constraintAtom();

							((ClockconstraintContext)_localctx).clockconst = ((ClockconstraintContext)_localctx).constraintAtom.atom;	
							((ClockconstraintContext)_localctx).variableconst = ((ClockconstraintContext)_localctx).constraintAtom.variableAtom;
						
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintAtomContext extends ParserRuleContext {
		public ClockConstraintAtom atom;
		public VariableConstraintAtom variableAtom;
		public Token id;
		public Token op;
		public Token nat;
		public Token param;
		public List<TerminalNode> ID() { return getTokens(TAParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TAParser.ID, i);
		}
		public TerminalNode EQCOMP() { return getToken(TAParser.EQCOMP, 0); }
		public TerminalNode GE() { return getToken(TAParser.GE, 0); }
		public TerminalNode GEQ() { return getToken(TAParser.GEQ, 0); }
		public TerminalNode LE() { return getToken(TAParser.LE, 0); }
		public TerminalNode LEQ() { return getToken(TAParser.LEQ, 0); }
		public TerminalNode NAT() { return getToken(TAParser.NAT, 0); }
		public ConstraintAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterConstraintAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitConstraintAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitConstraintAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintAtomContext constraintAtom() throws RecognitionException {
		ConstraintAtomContext _localctx = new ConstraintAtomContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_constraintAtom);

		     Value value = new Value("0");
		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			((ConstraintAtomContext)_localctx).id = match(ID);
			setState(605);
			((ConstraintAtomContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LEQ) | (1L << GEQ) | (1L << GE) | (1L << EQCOMP))) != 0)) ) {
				((ConstraintAtomContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(610);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAT:
				{
				setState(606);
				((ConstraintAtomContext)_localctx).nat = match(NAT);

				            value = new Value((((ConstraintAtomContext)_localctx).nat!=null?((ConstraintAtomContext)_localctx).nat.getText():null));
				        
				}
				break;
			case ID:
				{
				setState(608);
				((ConstraintAtomContext)_localctx).param = match(ID);

				            value = new Value((((ConstraintAtomContext)_localctx).param!=null?((ConstraintAtomContext)_localctx).param.getText():null), true);
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

					
					if(declarations==null){
						throw new InternalError("The set of the declarations cannot be null");	
					}
					if (value.parameter != null && !currentParameters.contains(value.parameter)) {
			            throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Param:"+value.parameter+" not declared");
			        }

					String identifier=(((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null);
					if(!declarations.containsKey((((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null)) && 
					!boundedVariablesValues.containsKey((((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null)) &&
					(currentTaDeclarations==null || !currentTaDeclarations.containsKey((((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null)))){
						throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Variable: "+(((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null)+" not defined");
					}
					
					
					if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("clock")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("clock"))){
						((ConstraintAtomContext)_localctx).atom = new ClockConstraintAtom(new Clock((((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null)), ClockConstraintAtomOperator.parse((((ConstraintAtomContext)_localctx).op!=null?((ConstraintAtomContext)_localctx).op.getText():null)), value);
					}
					if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("int")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("int"))){

						((ConstraintAtomContext)_localctx).variableAtom = new VariableConstraintAtom(new Variable((((ConstraintAtomContext)_localctx).id!=null?((ConstraintAtomContext)_localctx).id.getText():null)), VariableConstraintAtomOperator.parse((((ConstraintAtomContext)_localctx).op!=null?((ConstraintAtomContext)_localctx).op.getText():null)), value);
					}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SyncContext extends ParserRuleContext {
		public SyncExpression syncexp;
		public Token exp2;
		public Token op;
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public SyncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sync; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterSync(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitSync(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitSync(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyncContext sync() throws RecognitionException {
		SyncContext _localctx = new SyncContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_sync);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				{
				setState(614);
				match(T__30);
				setState(615);
				((SyncContext)_localctx).exp2 = match(ID);
				setState(616);
				((SyncContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__31 || _la==T__32) ) {
					((SyncContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(617);
				match(SEMICOLUMN);
				}

				 		if((((SyncContext)_localctx).op!=null?((SyncContext)_localctx).op.getText():null).equals("!") || (((SyncContext)_localctx).op!=null?((SyncContext)_localctx).op.getText():null).equals("?")){
				 				((SyncContext)_localctx).syncexp = new SyncExpression((((SyncContext)_localctx).exp2!=null?((SyncContext)_localctx).exp2.getText():null), (((SyncContext)_localctx).op!=null?((SyncContext)_localctx).op.getText():null));		
				 		}
				 		else{
				 			((SyncContext)_localctx).syncexp = new SyncExpression("tau"+TAU_COUNTER, "TAU");
				 			TAU_COUNTER++;
				 		}
					
				}
				break;
			case 2:
				{
				{
				setState(620);
				match(T__30);
				setState(621);
				((SyncContext)_localctx).exp2 = match(ID);
				setState(622);
				match(SEMICOLUMN);
				}

				 			((SyncContext)_localctx).syncexp = new SyncExpression("tau"+TAU_COUNTER, "TAU");
				 			TAU_COUNTER++;
				 	
				}
				break;
			case 3:
				{

				 			((SyncContext)_localctx).syncexp = new SyncExpression("tau"+TAU_COUNTER, "TAU");
				 			TAU_COUNTER++;
				 	
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public Assign assignexp;
		public AssignmentListContext expl;
		public AssignmentListContext assignmentList;
		public TerminalNode SEMICOLUMN() { return getToken(TAParser.SEMICOLUMN, 0); }
		public AssignmentListContext assignmentList() {
			return getRuleContext(AssignmentListContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
			match(T__33);
			setState(629);
			((AssignContext)_localctx).expl = ((AssignContext)_localctx).assignmentList = assignmentList();
			setState(630);
			match(SEMICOLUMN);

				((AssignContext)_localctx).assignexp = new Assign(((AssignContext)_localctx).assignmentList.clockassignement, ((AssignContext)_localctx).assignmentList.variableassignement);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentListContext extends ParserRuleContext {
		public Set<ClockAssignement> clockassignement;
		public Set<VariableAssignement> variableassignement;
		public AssignmentContext assignment;
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TAParser.COMMA, i);
		}
		public AssignmentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterAssignmentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitAssignmentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitAssignmentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentListContext assignmentList() throws RecognitionException {
		AssignmentListContext _localctx = new AssignmentListContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_assignmentList);

			((AssignmentListContext)_localctx).clockassignement = new HashSet<>();
			((AssignmentListContext)_localctx).variableassignement = new HashSet<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(633);
			((AssignmentListContext)_localctx).assignment = assignment();

				 		if(((AssignmentListContext)_localctx).assignment.clockassignementsret!=null){
				 			_localctx.clockassignement.add(((AssignmentListContext)_localctx).assignment.clockassignementsret);
				 		}
				 		if(((AssignmentListContext)_localctx).assignment.variableAssignementret!=null){
				 			_localctx.variableassignement.add(((AssignmentListContext)_localctx).assignment.variableAssignementret);
				 		}
				 	
			}
			setState(642);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				{
				setState(636);
				match(COMMA);
				setState(637);
				((AssignmentListContext)_localctx).assignment = assignment();

								if(((AssignmentListContext)_localctx).assignment.clockassignementsret!=null){
					 			_localctx.clockassignement.add(((AssignmentListContext)_localctx).assignment.clockassignementsret);
					 		}
					 		if(((AssignmentListContext)_localctx).assignment.variableAssignementret!=null){
					 			_localctx.variableassignement.add(((AssignmentListContext)_localctx).assignment.variableAssignementret);
					 		}
						
				}
				}
				}
				setState(644);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public ClockAssignement clockassignementsret;
		public VariableAssignement variableAssignementret;
		public Token id;
		public Token op;
		public Token nat;
		public Token param;
		public ExprStatementContext exprStatement;
		public List<TerminalNode> ID() { return getTokens(TAParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TAParser.ID, i);
		}
		public TerminalNode EQASSIGN() { return getToken(TAParser.EQASSIGN, 0); }
		public TerminalNode EQ() { return getToken(TAParser.EQ, 0); }
		public TerminalNode NAT() { return getToken(TAParser.NAT, 0); }
		public ExprStatementContext exprStatement() {
			return getRuleContext(ExprStatementContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_assignment);

		    Value value = new Value("0");
		 
		int _la;
		try {
			setState(660);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(645);
				((AssignmentContext)_localctx).id = match(ID);
				setState(646);
				((AssignmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EQASSIGN || _la==EQ) ) {
					((AssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(651);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NAT:
					{
					setState(647);
					((AssignmentContext)_localctx).nat = match(NAT);

					 		        value = new Value((((AssignmentContext)_localctx).nat!=null?((AssignmentContext)_localctx).nat.getText():null));
					 		    
					}
					break;
				case ID:
					{
					setState(649);
					((AssignmentContext)_localctx).param = match(ID);

					 		        value = new Value((((AssignmentContext)_localctx).param!=null?((AssignmentContext)_localctx).param.getText():null), true);
					 		    
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}

				 			if(declarations==null){
							throw new InternalError("The set of the declarations cannot be null");	
						}
						String identifier=(((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null);
						if(!declarations.containsKey((((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)) && (currentTaDeclarations==null || !currentTaDeclarations.containsKey((((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)))){
							throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Variable:"+(((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)+" not defined");
						}
						if (value.parameter != null && !currentParameters.contains(value.parameter)) {
						    throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Param:"+value.parameter+" not declared");
						}
						if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("clock")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("clock"))){
							((AssignmentContext)_localctx).clockassignementsret = new ClockAssignement(new Clock((((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)), value);
						}
						if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("int")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("int"))){
							((AssignmentContext)_localctx).variableAssignementret = new VariableAssignement(new Variable((((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)), value);
						}
				 	
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(654);
				((AssignmentContext)_localctx).id = match(ID);
				setState(655);
				((AssignmentContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EQASSIGN || _la==EQ) ) {
					((AssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(656);
				((AssignmentContext)_localctx).exprStatement = exprStatement();
				}

				 		if(declarations==null){
							throw new InternalError("The set of the declarations cannot be null");	
						}
						String identifier=(((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null);
						if(!declarations.containsKey((((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)) && (currentTaDeclarations==null || !currentTaDeclarations.containsKey((((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)))){
							throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Variable:"+(((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)+" not defined");
						}
						if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("clock")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("clock"))){
							throw new IllegalStateException ("Line: "+_localctx.start.getLine()+"\t Clock:"+(((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)+" cannot be assigned to an expression but only to an integer value");
						}
						if((declarations.containsKey(identifier))&&(declarations.get(identifier).equals("int")) || (currentTaDeclarations!=null && currentTaDeclarations.containsKey(identifier))&&(currentTaDeclarations.get(identifier).equals("int"))){
							((AssignmentContext)_localctx).variableAssignementret = new VariableAssignement(new Variable((((AssignmentContext)_localctx).id!=null?((AssignmentContext)_localctx).id.getText():null)),  ((AssignmentContext)_localctx).exprStatement.exp);
						}
				 		
				 		
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleassigmentContext extends ParserRuleContext {
		public ClockAssignement assignementsret;
		public Token id;
		public Token op;
		public Token nat;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode EQ() { return getToken(TAParser.EQ, 0); }
		public TerminalNode NAT() { return getToken(TAParser.NAT, 0); }
		public SimpleassigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleassigment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterSimpleassigment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitSimpleassigment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitSimpleassigment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleassigmentContext simpleassigment() throws RecognitionException {
		SimpleassigmentContext _localctx = new SimpleassigmentContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_simpleassigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(662);
			((SimpleassigmentContext)_localctx).id = match(ID);
			setState(663);
			((SimpleassigmentContext)_localctx).op = match(EQ);
			setState(664);
			((SimpleassigmentContext)_localctx).nat = match(NAT);
			}
			((SimpleassigmentContext)_localctx).assignementsret = new ClockAssignement(
			 						new Clock((((SimpleassigmentContext)_localctx).id!=null?((SimpleassigmentContext)_localctx).id.getText():null)),
			 						new Value((((SimpleassigmentContext)_localctx).nat!=null?((SimpleassigmentContext)_localctx).nat.getText():null))
			 					);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public List<Expression> exprListret;
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TAParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TAParser.COMMA, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitExprList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_exprList);
		((ExprListContext)_localctx).exprListret = new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(668);
			((ExprListContext)_localctx).exp1 = expression(0);

				_localctx.exprListret.add(((ExprListContext)_localctx).exp1.exp);

			setState(676);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(670);
				match(COMMA);
				setState(671);
				((ExprListContext)_localctx).exp2 = expression(0);

					_localctx.exprListret.add(((ExprListContext)_localctx).exp2.exp);
					
				}
				}
				setState(678);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprStatementContext extends ParserRuleContext {
		public Expression exp;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterExprStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitExprStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitExprStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStatementContext exprStatement() throws RecognitionException {
		ExprStatementContext _localctx = new ExprStatementContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_exprStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(679);
			((ExprStatementContext)_localctx).expression = expression(0);

				((ExprStatementContext)_localctx).exp = ((ExprStatementContext)_localctx).expression.exp;

			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression exp;
		public ExpressionContext exp1;
		public Token ID;
		public Token NAT;
		public Token op;
		public ExpressionContext exp2;
		public ExpressionContext exp3;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode NAT() { return getToken(TAParser.NAT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(TAParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TAParser.MINUS, 0); }
		public TerminalNode PLUSPLUS() { return getToken(TAParser.PLUSPLUS, 0); }
		public TerminalNode MINUSMINUS() { return getToken(TAParser.MINUSMINUS, 0); }
		public TerminalNode MULT() { return getToken(TAParser.MULT, 0); }
		public TerminalNode FRACT() { return getToken(TAParser.FRACT, 0); }
		public TerminalNode MOD() { return getToken(TAParser.MOD, 0); }
		public TerminalNode LEQ() { return getToken(TAParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(TAParser.GEQ, 0); }
		public TerminalNode GE() { return getToken(TAParser.GE, 0); }
		public TerminalNode LE() { return getToken(TAParser.LE, 0); }
		public TerminalNode EQCOMP() { return getToken(TAParser.EQCOMP, 0); }
		public TerminalNode NEQ() { return getToken(TAParser.NEQ, 0); }
		public TerminalNode BITAND() { return getToken(TAParser.BITAND, 0); }
		public TerminalNode POW() { return getToken(TAParser.POW, 0); }
		public TerminalNode BITOR() { return getToken(TAParser.BITOR, 0); }
		public TerminalNode AND() { return getToken(TAParser.AND, 0); }
		public TerminalNode OR() { return getToken(TAParser.OR, 0); }
		public TerminalNode COLUMEQ() { return getToken(TAParser.COLUMEQ, 0); }
		public TerminalNode EQ() { return getToken(TAParser.EQ, 0); }
		public TerminalNode PLUSEQ() { return getToken(TAParser.PLUSEQ, 0); }
		public TerminalNode MINUSEQ() { return getToken(TAParser.MINUSEQ, 0); }
		public TerminalNode MULTEQ() { return getToken(TAParser.MULTEQ, 0); }
		public TerminalNode FRACTEQ() { return getToken(TAParser.FRACTEQ, 0); }
		public TerminalNode BITANDEQ() { return getToken(TAParser.BITANDEQ, 0); }
		public TerminalNode BITOREQ() { return getToken(TAParser.BITOREQ, 0); }
		public TerminalNode POWEQ() { return getToken(TAParser.POWEQ, 0); }
		public TerminalNode MODEQ() { return getToken(TAParser.MODEQ, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 88;
		enterRecursionRule(_localctx, 88, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(695);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(683);
				((ExpressionContext)_localctx).ID = match(ID);

						((ExpressionContext)_localctx).exp = new Identifier((((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
					
				}
				break;
			case NAT:
				{
				setState(685);
				((ExpressionContext)_localctx).NAT = match(NAT);

						((ExpressionContext)_localctx).exp = new Value((((ExpressionContext)_localctx).NAT!=null?((ExpressionContext)_localctx).NAT.getText():null));
					
				}
				break;
			case PLUS:
			case PLUSPLUS:
			case MINUSMINUS:
			case MINUS:
				{
				setState(687);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << MINUS))) != 0)) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(688);
				((ExpressionContext)_localctx).exp1 = expression(13);

				    	((ExpressionContext)_localctx).exp = new LeftUnaryOperator((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).exp1.exp);
				    
				}
				break;
			case T__31:
			case T__34:
				{
				setState(691);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__31 || _la==T__34) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(692);
				((ExpressionContext)_localctx).exp1 = expression(12);

				    	((ExpressionContext)_localctx).exp = new LeftUnaryOperator((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).exp1.exp);
				    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(759);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(757);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(697);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(698);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << FRACT) | (1L << MOD))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(699);
						((ExpressionContext)_localctx).exp2 = expression(12);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(702);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(703);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(704);
						((ExpressionContext)_localctx).exp2 = expression(11);

						              		BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              		((ExpressionContext)_localctx).exp = exp;
						              	
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(707);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(708);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LE) | (1L << LEQ) | (1L << GEQ) | (1L << GE))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(709);
						((ExpressionContext)_localctx).exp2 = expression(10);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(712);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(713);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQCOMP || _la==NEQ) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(714);
						((ExpressionContext)_localctx).exp2 = expression(9);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(717);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(718);
						((ExpressionContext)_localctx).op = match(BITAND);
						setState(719);
						((ExpressionContext)_localctx).exp2 = expression(8);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(722);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(723);
						((ExpressionContext)_localctx).op = match(POW);
						setState(724);
						((ExpressionContext)_localctx).exp2 = expression(7);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(727);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(728);
						((ExpressionContext)_localctx).op = match(BITOR);
						setState(729);
						((ExpressionContext)_localctx).exp2 = expression(6);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(732);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(733);
						((ExpressionContext)_localctx).op = match(AND);
						setState(734);
						((ExpressionContext)_localctx).exp2 = expression(5);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(737);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(738);
						((ExpressionContext)_localctx).op = match(OR);
						setState(739);
						((ExpressionContext)_localctx).exp2 = expression(4);

						              	BinaryArithmeticExpression exp=new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null) ,((ExpressionContext)_localctx).exp2.exp);
						              	((ExpressionContext)_localctx).exp = exp;
						              
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(742);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(743);
						match(T__32);
						setState(744);
						((ExpressionContext)_localctx).exp2 = expression(0);
						setState(745);
						match(T__23);
						setState(746);
						((ExpressionContext)_localctx).exp3 = expression(3);

						              	((ExpressionContext)_localctx).exp = new TernaryExpression(((ExpressionContext)_localctx).exp1.exp, ((ExpressionContext)_localctx).exp2.exp, ((ExpressionContext)_localctx).exp3.exp);
						              
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(749);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(750);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 36)) & ~0x3f) == 0 && ((1L << (_la - 36)) & ((1L << (T__35 - 36)) | (1L << (T__36 - 36)) | (1L << (T__37 - 36)) | (1L << (EQ - 36)) | (1L << (FRACTEQ - 36)) | (1L << (MODEQ - 36)) | (1L << (PLUSEQ - 36)) | (1L << (MINUSEQ - 36)) | (1L << (COLUMEQ - 36)) | (1L << (MULTEQ - 36)) | (1L << (POWEQ - 36)) | (1L << (BITANDEQ - 36)) | (1L << (BITOREQ - 36)))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(751);
						((ExpressionContext)_localctx).exp2 = expression(2);

						              	((ExpressionContext)_localctx).exp = new BinaryArithmeticExpression(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).exp2.exp);
						              
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(754);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(755);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUSPLUS || _la==MINUSMINUS) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}

						                ((ExpressionContext)_localctx).exp = new RightUnaryOperator(((ExpressionContext)_localctx).exp1.exp, (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						              
						}
						break;
					}
					} 
				}
				setState(761);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DeclarationidContext extends ParserRuleContext {
		public Expression exp;
		public Token ID;
		public Token op;
		public ExpressionContext expr;
		public TerminalNode ID() { return getToken(TAParser.ID, 0); }
		public TerminalNode EQ() { return getToken(TAParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLUMEQ() { return getToken(TAParser.COLUMEQ, 0); }
		public DeclarationidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterDeclarationid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitDeclarationid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitDeclarationid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationidContext declarationid() throws RecognitionException {
		DeclarationidContext _localctx = new DeclarationidContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_declarationid);
		try {
			setState(774);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(762);
				((DeclarationidContext)_localctx).ID = match(ID);
				setState(763);
				((DeclarationidContext)_localctx).op = match(EQ);
				setState(764);
				((DeclarationidContext)_localctx).expr = expression(0);
				}
				((DeclarationidContext)_localctx).exp = new AssignementExpression(
				 						new Identifier((((DeclarationidContext)_localctx).ID!=null?((DeclarationidContext)_localctx).ID.getText():null)),
				 						(((DeclarationidContext)_localctx).op!=null?((DeclarationidContext)_localctx).op.getText():null), 
				 						((DeclarationidContext)_localctx).expr.exp
				 					);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(768);
				((DeclarationidContext)_localctx).ID = match(ID);
				setState(769);
				((DeclarationidContext)_localctx).op = match(COLUMEQ);
				setState(770);
				((DeclarationidContext)_localctx).expr = expression(0);
				}
				((DeclarationidContext)_localctx).exp = new AssignementExpression(
				 						 new Identifier((((DeclarationidContext)_localctx).ID!=null?((DeclarationidContext)_localctx).ID.getText():null)),
				 						(((DeclarationidContext)_localctx).op!=null?((DeclarationidContext)_localctx).op.getText():null),
				 						((DeclarationidContext)_localctx).expr.exp
				 					);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgListContext extends ParserRuleContext {
		public List<Expression> args;
		public ExpressionContext expression;
		public ArgListContext argList;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(TAParser.COMMA, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TAListener ) ((TAListener)listener).exitArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TAVisitor ) return ((TAVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_argList);

						     ((ArgListContext)_localctx).args =  new ArrayList<Expression>();
					
		int _la;
		try {
			setState(786);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
			case T__34:
			case PLUS:
			case PLUSPLUS:
			case MINUSMINUS:
			case MINUS:
			case ID:
			case NAT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(776);
				((ArgListContext)_localctx).expression = expression(0);
				setState(781);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(777);
					match(COMMA);
					setState(778);
					((ArgListContext)_localctx).argList = argList();

					 			    _localctx.args.addAll(((ArgListContext)_localctx).argList.args);
					 			
					}
				}

				}

								_localctx.args.add(((ArgListContext)_localctx).expression.exp);

					
				}
				break;
			case RPAR:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 44:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		case 11:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3U\u0317\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\7\2e\n\2\f\2\16\2h\13"+
		"\2\3\2\3\2\3\2\7\2m\n\2\f\2\16\2p\13\2\3\2\6\2s\n\2\r\2\16\2t\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u0085\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5\u0094\n\5\f\5\16\5\u0097"+
		"\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00a2\n\6\f\6\16\6\u00a5"+
		"\13\6\3\6\3\6\5\6\u00a9\n\6\3\7\3\7\5\7\u00ad\n\7\3\7\3\7\3\7\7\7\u00b2"+
		"\n\7\f\7\16\7\u00b5\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00ca\n\t\f\t\16\t\u00cd\13\t\3\t\3"+
		"\t\5\t\u00d1\n\t\3\t\5\t\u00d4\n\t\3\t\3\t\3\t\5\t\u00d9\n\t\3\t\3\t\3"+
		"\n\3\n\7\n\u00df\n\n\f\n\16\n\u00e2\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7"+
		"\n\u00eb\n\n\f\n\16\n\u00ee\13\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00f6\n\n"+
		"\3\n\3\n\3\13\3\13\7\13\u00fc\n\13\f\13\16\13\u00ff\13\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\7\13\u0107\n\13\f\13\16\13\u010a\13\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u0114\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\5"+
		"\16\u011d\n\16\3\16\3\16\3\16\3\16\6\16\u0123\n\16\r\16\16\16\u0124\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0132\n\16"+
		"\5\16\u0134\n\16\3\17\3\17\7\17\u0138\n\17\f\17\16\17\u013b\13\17\3\20"+
		"\5\20\u013e\n\20\3\20\5\20\u0141\n\20\3\20\5\20\u0144\n\20\5\20\u0146"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\7\24\u0159\n\24\f\24\16\24\u015c\13\24\3\25\3\25"+
		"\3\25\3\25\3\25\7\25\u0163\n\25\f\25\16\25\u0166\13\25\3\25\3\25\3\26"+
		"\3\26\7\26\u016c\n\26\f\26\16\26\u016f\13\26\3\27\3\27\3\27\3\27\7\27"+
		"\u0175\n\27\f\27\16\27\u0178\13\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\7\31\u0184\n\31\f\31\16\31\u0187\13\31\3\31\7\31\u018a"+
		"\n\31\f\31\16\31\u018d\13\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\5\32\u01b5\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\6\32"+
		"\u01bf\n\32\r\32\16\32\u01c0\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5"+
		"\32\u01cb\n\32\3\33\3\33\3\33\3\33\7\33\u01d1\n\33\f\33\16\33\u01d4\13"+
		"\33\3\33\3\33\3\33\7\33\u01d9\n\33\f\33\16\33\u01dc\13\33\5\33\u01de\n"+
		"\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u01e7\n\34\f\34\16\34\u01ea"+
		"\13\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u01f7"+
		"\n\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3 \7 \u0209\n \f \16 \u020c\13 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!"+
		"\3!\7!\u021b\n!\f!\16!\u021e\13!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\7"+
		"!\u022c\n!\f!\16!\u022f\13!\7!\u0231\n!\f!\16!\u0234\13!\3\"\3\"\3\"\3"+
		"\"\5\"\u023a\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0243\n\"\3\"\3\"\3\""+
		"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\5$\u0252\n$\3$\3$\3$\7$\u0257\n$\f$\16"+
		"$\u025a\13$\3%\3%\3%\3&\3&\3&\3&\3&\3&\5&\u0265\n&\3&\3&\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0275\n\'\3(\3(\3(\3(\3(\3)\3)"+
		"\3)\3)\3)\3)\3)\7)\u0283\n)\f)\16)\u0286\13)\3*\3*\3*\3*\3*\3*\5*\u028e"+
		"\n*\3*\3*\3*\3*\3*\3*\3*\5*\u0297\n*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,"+
		"\3,\7,\u02a5\n,\f,\16,\u02a8\13,\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\5.\u02ba\n.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\7.\u02f8"+
		"\n.\f.\16.\u02fb\13.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u0309\n/\3"+
		"\60\3\60\3\60\3\60\3\60\5\60\u0310\n\60\3\60\3\60\3\60\5\60\u0315\n\60"+
		"\3\60\2\3Z\61\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^\2\r\3\2),\3\2)-\3\2\"#\3\2/\60\3\2\63\66\4\2"+
		"\"\"%%\4\2\67\67=>\4\2\63\63\66\66\3\2-.\6\2&(\60\628<EF\3\2\64\65\2\u0346"+
		"\2`\3\2\2\2\4\u0084\3\2\2\2\6\u0086\3\2\2\2\b\u008f\3\2\2\2\n\u00a8\3"+
		"\2\2\2\f\u00aa\3\2\2\2\16\u00b6\3\2\2\2\20\u00c0\3\2\2\2\22\u00dc\3\2"+
		"\2\2\24\u00f9\3\2\2\2\26\u010d\3\2\2\2\30\u0115\3\2\2\2\32\u0133\3\2\2"+
		"\2\34\u0135\3\2\2\2\36\u0145\3\2\2\2 \u0147\3\2\2\2\"\u014d\3\2\2\2$\u0151"+
		"\3\2\2\2&\u0155\3\2\2\2(\u015d\3\2\2\2*\u0169\3\2\2\2,\u0170\3\2\2\2."+
		"\u017b\3\2\2\2\60\u0180\3\2\2\2\62\u01ca\3\2\2\2\64\u01dd\3\2\2\2\66\u01df"+
		"\3\2\2\28\u01f6\3\2\2\2:\u01f8\3\2\2\2<\u01fd\3\2\2\2>\u0202\3\2\2\2@"+
		"\u020f\3\2\2\2B\u0235\3\2\2\2D\u0247\3\2\2\2F\u024c\3\2\2\2H\u025b\3\2"+
		"\2\2J\u025e\3\2\2\2L\u0274\3\2\2\2N\u0276\3\2\2\2P\u027b\3\2\2\2R\u0296"+
		"\3\2\2\2T\u0298\3\2\2\2V\u029e\3\2\2\2X\u02a9\3\2\2\2Z\u02b9\3\2\2\2\\"+
		"\u0308\3\2\2\2^\u0314\3\2\2\2`f\b\2\1\2ab\5\4\3\2bc\b\2\1\2ce\3\2\2\2"+
		"da\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gn\3\2\2\2hf\3\2\2\2ij\5\6\4\2"+
		"jk\b\2\1\2km\3\2\2\2li\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2or\3\2\2\2"+
		"pn\3\2\2\2qs\5\b\5\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2uv\3\2\2\2"+
		"vw\7\2\2\3wx\b\2\1\2x\3\3\2\2\2yz\5\22\n\2z{\b\3\1\2{\u0085\3\2\2\2|\u0085"+
		"\5.\30\2}~\5\24\13\2~\177\b\3\1\2\177\u0085\3\2\2\2\u0080\u0085\5(\25"+
		"\2\u0081\u0082\5\16\b\2\u0082\u0083\b\3\1\2\u0083\u0085\3\2\2\2\u0084"+
		"y\3\2\2\2\u0084|\3\2\2\2\u0084}\3\2\2\2\u0084\u0080\3\2\2\2\u0084\u0081"+
		"\3\2\2\2\u0085\5\3\2\2\2\u0086\u0087\7N\2\2\u0087\u0088\7\60\2\2\u0088"+
		"\u0089\7N\2\2\u0089\u008a\7H\2\2\u008a\u008b\5^\60\2\u008b\u008c\7I\2"+
		"\2\u008c\u008d\7L\2\2\u008d\u008e\b\4\1\2\u008e\7\3\2\2\2\u008f\u0090"+
		"\7\3\2\2\u0090\u0095\7N\2\2\u0091\u0092\7S\2\2\u0092\u0094\7N\2\2\u0093"+
		"\u0091\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\7L\2\2\u0099"+
		"\t\3\2\2\2\u009a\u009b\7H\2\2\u009b\u009c\5\f\7\2\u009c\u00a3\b\6\1\2"+
		"\u009d\u009e\7S\2\2\u009e\u009f\5\f\7\2\u009f\u00a0\b\6\1\2\u00a0\u00a2"+
		"\3\2\2\2\u00a1\u009d\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\7I"+
		"\2\2\u00a7\u00a9\3\2\2\2\u00a8\u009a\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\13\3\2\2\2\u00aa\u00ac\5\32\16\2\u00ab\u00ad\7D\2\2\u00ac\u00ab\3\2\2"+
		"\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7N\2\2\u00af\u00b3"+
		"\b\7\1\2\u00b0\u00b2\5\30\r\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2"+
		"\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\r\3\2\2\2\u00b5\u00b3\3"+
		"\2\2\2\u00b6\u00b7\7\4\2\2\u00b7\u00b8\7N\2\2\u00b8\u00b9\b\b\1\2\u00b9"+
		"\u00ba\5\n\6\2\u00ba\u00bb\b\b\1\2\u00bb\u00bc\7\5\2\2\u00bc\u00bd\5\20"+
		"\t\2\u00bd\u00be\7\6\2\2\u00be\u00bf\b\b\1\2\u00bf\17\3\2\2\2\u00c0\u00cb"+
		"\b\t\1\2\u00c1\u00ca\5.\30\2\u00c2\u00c3\5\24\13\2\u00c3\u00c4\b\t\1\2"+
		"\u00c4\u00ca\3\2\2\2\u00c5\u00c6\5\22\n\2\u00c6\u00c7\b\t\1\2\u00c7\u00ca"+
		"\3\2\2\2\u00c8\u00ca\5(\25\2\u00c9\u00c1\3\2\2\2\u00c9\u00c2\3\2\2\2\u00c9"+
		"\u00c5\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2"+
		"\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce"+
		"\u00d0\5\66\34\2\u00cf\u00d1\5\"\22\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1"+
		"\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00d4\5$\23\2\u00d3\u00d2\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\5<\37\2\u00d6\u00d8\b\t"+
		"\1\2\u00d7\u00d9\5> \2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da"+
		"\3\2\2\2\u00da\u00db\b\t\1\2\u00db\21\3\2\2\2\u00dc\u00e0\5\32\16\2\u00dd"+
		"\u00df\5\30\r\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3"+
		"\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3"+
		"\u00e4\7N\2\2\u00e4\u00e5\7\5\2\2\u00e5\u00e6\7O\2\2\u00e6\u00ec\b\n\1"+
		"\2\u00e7\u00e8\7S\2\2\u00e8\u00e9\7O\2\2\u00e9\u00eb\b\n\1\2\u00ea\u00e7"+
		"\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00ef\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\7\6\2\2\u00f0\u00f5\b\n"+
		"\1\2\u00f1\u00f2\7\60\2\2\u00f2\u00f3\5Z.\2\u00f3\u00f4\b\n\1\2\u00f4"+
		"\u00f6\3\2\2\2\u00f5\u00f1\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2"+
		"\2\2\u00f7\u00f8\7L\2\2\u00f8\23\3\2\2\2\u00f9\u00fd\5\32\16\2\u00fa\u00fc"+
		"\5\30\r\2\u00fb\u00fa\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2"+
		"\u00fd\u00fe\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0101"+
		"\5\26\f\2\u0101\u0108\b\13\1\2\u0102\u0103\7S\2\2\u0103\u0104\5\26\f\2"+
		"\u0104\u0105\b\13\1\2\u0105\u0107\3\2\2\2\u0106\u0102\3\2\2\2\u0107\u010a"+
		"\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010b\3\2\2\2\u010a"+
		"\u0108\3\2\2\2\u010b\u010c\7L\2\2\u010c\25\3\2\2\2\u010d\u010e\7N\2\2"+
		"\u010e\u0113\b\f\1\2\u010f\u0110\7\60\2\2\u0110\u0111\5Z.\2\u0111\u0112"+
		"\b\f\1\2\u0112\u0114\3\2\2\2\u0113\u010f\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\27\3\2\2\2\u0115\u0116\7J\2\2\u0116\u0117\5Z.\2\u0117\u0118\7K\2\2\u0118"+
		"\31\3\2\2\2\u0119\u011a\5\36\20\2\u011a\u011c\7N\2\2\u011b\u011d\5 \21"+
		"\2\u011c\u011b\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u0134\3\2\2\2\u011e\u011f"+
		"\5\36\20\2\u011f\u0120\7\7\2\2\u0120\u0122\7\5\2\2\u0121\u0123\5,\27\2"+
		"\u0122\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125"+
		"\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\7\6\2\2\u0127\u0134\3\2\2\2\u0128"+
		"\u0131\5\36\20\2\u0129\u012a\7\b\2\2\u012a\u0132\b\16\1\2\u012b\u012c"+
		"\7\t\2\2\u012c\u0132\b\16\1\2\u012d\u012e\7\n\2\2\u012e\u0132\b\16\1\2"+
		"\u012f\u0130\7\13\2\2\u0130\u0132\b\16\1\2\u0131\u0129\3\2\2\2\u0131\u012b"+
		"\3\2\2\2\u0131\u012d\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0134\3\2\2\2\u0133"+
		"\u0119\3\2\2\2\u0133\u011e\3\2\2\2\u0133\u0128\3\2\2\2\u0134\33\3\2\2"+
		"\2\u0135\u0139\7N\2\2\u0136\u0138\5\30\r\2\u0137\u0136\3\2\2\2\u0138\u013b"+
		"\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\35\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013c\u013e\7\f\2\2\u013d\u013c\3\2\2\2\u013d\u013e\3\2"+
		"\2\2\u013e\u0140\3\2\2\2\u013f\u0141\7\r\2\2\u0140\u013f\3\2\2\2\u0140"+
		"\u0141\3\2\2\2\u0141\u0146\3\2\2\2\u0142\u0144\7\16\2\2\u0143\u0142\3"+
		"\2\2\2\u0143\u0144\3\2\2\2\u0144\u0146\3\2\2\2\u0145\u013d\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0146\37\3\2\2\2\u0147\u0148\7J\2\2\u0148\u0149\7O\2\2"+
		"\u0149\u014a\7S\2\2\u014a\u014b\7O\2\2\u014b\u014c\7K\2\2\u014c!\3\2\2"+
		"\2\u014d\u014e\7\17\2\2\u014e\u014f\5&\24\2\u014f\u0150\7L\2\2\u0150#"+
		"\3\2\2\2\u0151\u0152\7\f\2\2\u0152\u0153\5&\24\2\u0153\u0154\7L\2\2\u0154"+
		"%\3\2\2\2\u0155\u015a\7N\2\2\u0156\u0157\7S\2\2\u0157\u0159\7N\2\2\u0158"+
		"\u0156\3\2\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2"+
		"\2\2\u015b\'\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u015e\7\20\2\2\u015e\u015f"+
		"\5\32\16\2\u015f\u0164\5*\26\2\u0160\u0161\7S\2\2\u0161\u0163\5*\26\2"+
		"\u0162\u0160\3\2\2\2\u0163\u0166\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165"+
		"\3\2\2\2\u0165\u0167\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u0168\7L\2\2\u0168"+
		")\3\2\2\2\u0169\u016d\7N\2\2\u016a\u016c\5\30\r\2\u016b\u016a\3\2\2\2"+
		"\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e+\3"+
		"\2\2\2\u016f\u016d\3\2\2\2\u0170\u0171\5\32\16\2\u0171\u0176\5\34\17\2"+
		"\u0172\u0173\7S\2\2\u0173\u0175\5\34\17\2\u0174\u0172\3\2\2\2\u0175\u0178"+
		"\3\2\2\2\u0176\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0179\3\2\2\2\u0178"+
		"\u0176\3\2\2\2\u0179\u017a\7L\2\2\u017a-\3\2\2\2\u017b\u017c\5\32\16\2"+
		"\u017c\u017d\7N\2\2\u017d\u017e\5\n\6\2\u017e\u017f\5\60\31\2\u017f/\3"+
		"\2\2\2\u0180\u0185\7\5\2\2\u0181\u0184\5\24\13\2\u0182\u0184\5(\25\2\u0183"+
		"\u0181\3\2\2\2\u0183\u0182\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2"+
		"\2\2\u0185\u0186\3\2\2\2\u0186\u018b\3\2\2\2\u0187\u0185\3\2\2\2\u0188"+
		"\u018a\5\62\32\2\u0189\u0188\3\2\2\2\u018a\u018d\3\2\2\2\u018b\u0189\3"+
		"\2\2\2\u018b\u018c\3\2\2\2\u018c\u018e\3\2\2\2\u018d\u018b\3\2\2\2\u018e"+
		"\u018f\7\6\2\2\u018f\61\3\2\2\2\u0190\u01cb\5\60\31\2\u0191\u01cb\7L\2"+
		"\2\u0192\u0193\5Z.\2\u0193\u0194\7L\2\2\u0194\u01cb\3\2\2\2\u0195\u0196"+
		"\7\21\2\2\u0196\u0197\7H\2\2\u0197\u0198\5V,\2\u0198\u0199\7L\2\2\u0199"+
		"\u019a\5V,\2\u019a\u019b\7L\2\2\u019b\u019c\5V,\2\u019c\u019d\7I\2\2\u019d"+
		"\u019e\5\62\32\2\u019e\u01cb\3\2\2\2\u019f\u01a0\7\22\2\2\u01a0\u01a1"+
		"\7H\2\2\u01a1\u01a2\5V,\2\u01a2\u01a3\7I\2\2\u01a3\u01a4\5\62\32\2\u01a4"+
		"\u01cb\3\2\2\2\u01a5\u01a6\7\23\2\2\u01a6\u01a7\5\62\32\2\u01a7\u01a8"+
		"\7\22\2\2\u01a8\u01a9\7H\2\2\u01a9\u01aa\5V,\2\u01aa\u01ab\7I\2\2\u01ab"+
		"\u01ac\7L\2\2\u01ac\u01cb\3\2\2\2\u01ad\u01ae\7\24\2\2\u01ae\u01af\7H"+
		"\2\2\u01af\u01b0\5V,\2\u01b0\u01b1\7I\2\2\u01b1\u01b4\5\62\32\2\u01b2"+
		"\u01b3\7\25\2\2\u01b3\u01b5\5\62\32\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5"+
		"\3\2\2\2\u01b5\u01cb\3\2\2\2\u01b6\u01b7\7\26\2\2\u01b7\u01cb\7L\2\2\u01b8"+
		"\u01b9\7\27\2\2\u01b9\u01ba\7H\2\2\u01ba\u01bb\5V,\2\u01bb\u01bc\7I\2"+
		"\2\u01bc\u01be\7\5\2\2\u01bd\u01bf\5\64\33\2\u01be\u01bd\3\2\2\2\u01bf"+
		"\u01c0\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c2\3\2"+
		"\2\2\u01c2\u01c3\7\6\2\2\u01c3\u01cb\3\2\2\2\u01c4\u01c5\7\30\2\2\u01c5"+
		"\u01cb\7L\2\2\u01c6\u01c7\7\30\2\2\u01c7\u01c8\5Z.\2\u01c8\u01c9\7L\2"+
		"\2\u01c9\u01cb\3\2\2\2\u01ca\u0190\3\2\2\2\u01ca\u0191\3\2\2\2\u01ca\u0192"+
		"\3\2\2\2\u01ca\u0195\3\2\2\2\u01ca\u019f\3\2\2\2\u01ca\u01a5\3\2\2\2\u01ca"+
		"\u01ad\3\2\2\2\u01ca\u01b6\3\2\2\2\u01ca\u01b8\3\2\2\2\u01ca\u01c4\3\2"+
		"\2\2\u01ca\u01c6\3\2\2\2\u01cb\63\3\2\2\2\u01cc\u01cd\7\31\2\2\u01cd\u01ce"+
		"\5Z.\2\u01ce\u01d2\7\32\2\2\u01cf\u01d1\5\62\32\2\u01d0\u01cf\3\2\2\2"+
		"\u01d1\u01d4\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01de"+
		"\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d5\u01d6\7\33\2\2\u01d6\u01da\7\32\2\2"+
		"\u01d7\u01d9\5\62\32\2\u01d8\u01d7\3\2\2\2\u01d9\u01dc\3\2\2\2\u01da\u01d8"+
		"\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01de\3\2\2\2\u01dc\u01da\3\2\2\2\u01dd"+
		"\u01cc\3\2\2\2\u01dd\u01d5\3\2\2\2\u01de\65\3\2\2\2\u01df\u01e0\7\34\2"+
		"\2\u01e0\u01e1\58\35\2\u01e1\u01e8\b\34\1\2\u01e2\u01e3\7S\2\2\u01e3\u01e4"+
		"\58\35\2\u01e4\u01e5\b\34\1\2\u01e5\u01e7\3\2\2\2\u01e6\u01e2\3\2\2\2"+
		"\u01e7\u01ea\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01eb"+
		"\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb\u01ec\7L\2\2\u01ec\67\3\2\2\2\u01ed"+
		"\u01ee\7N\2\2\u01ee\u01f7\b\35\1\2\u01ef\u01f0\7N\2\2\u01f0\u01f1\7\5"+
		"\2\2\u01f1\u01f2\5:\36\2\u01f2\u01f3\7\6\2\2\u01f3\u01f4\3\2\2\2\u01f4"+
		"\u01f5\b\35\1\2\u01f5\u01f7\3\2\2\2\u01f6\u01ed\3\2\2\2\u01f6\u01ef\3"+
		"\2\2\2\u01f79\3\2\2\2\u01f8\u01f9\7N\2\2\u01f9\u01fa\t\2\2\2\u01fa\u01fb"+
		"\5Z.\2\u01fb\u01fc\b\36\1\2\u01fc;\3\2\2\2\u01fd\u01fe\7\35\2\2\u01fe"+
		"\u01ff\7N\2\2\u01ff\u0200\7L\2\2\u0200\u0201\b\37\1\2\u0201=\3\2\2\2\u0202"+
		"\u0203\7\36\2\2\u0203\u0204\5@!\2\u0204\u020a\b \1\2\u0205\u0206\5@!\2"+
		"\u0206\u0207\b \1\2\u0207\u0209\3\2\2\2\u0208\u0205\3\2\2\2\u0209\u020c"+
		"\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020d\3\2\2\2\u020c"+
		"\u020a\3\2\2\2\u020d\u020e\7L\2\2\u020e?\3\2\2\2\u020f\u0210\7N\2\2\u0210"+
		"\u0211\7\37\2\2\u0211\u0212\7N\2\2\u0212\u0213\5B\"\2\u0213\u021c\b!\1"+
		"\2\u0214\u0215\7S\2\2\u0215\u0216\7\37\2\2\u0216\u0217\7N\2\2\u0217\u0218"+
		"\5B\"\2\u0218\u0219\b!\1\2\u0219\u021b\3\2\2\2\u021a\u0214\3\2\2\2\u021b"+
		"\u021e\3\2\2\2\u021c\u021a\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u0232\3\2"+
		"\2\2\u021e\u021c\3\2\2\2\u021f\u0220\7S\2\2\u0220\u0221\7N\2\2\u0221\u0222"+
		"\7\37\2\2\u0222\u0223\7N\2\2\u0223\u0224\5B\"\2\u0224\u022d\b!\1\2\u0225"+
		"\u0226\7S\2\2\u0226\u0227\7\37\2\2\u0227\u0228\7N\2\2\u0228\u0229\5B\""+
		"\2\u0229\u022a\b!\1\2\u022a\u022c\3\2\2\2\u022b\u0225\3\2\2\2\u022c\u022f"+
		"\3\2\2\2\u022d\u022b\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u0231\3\2\2\2\u022f"+
		"\u022d\3\2\2\2\u0230\u021f\3\2\2\2\u0231\u0234\3\2\2\2\u0232\u0230\3\2"+
		"\2\2\u0232\u0233\3\2\2\2\u0233A\3\2\2\2\u0234\u0232\3\2\2\2\u0235\u0239"+
		"\7\5\2\2\u0236\u0237\5D#\2\u0237\u0238\b\"\1\2\u0238\u023a\3\2\2\2\u0239"+
		"\u0236\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\b\""+
		"\1\2\u023c\u023d\5L\'\2\u023d\u023e\b\"\1\2\u023e\u0242\3\2\2\2\u023f"+
		"\u0240\5N(\2\u0240\u0241\b\"\1\2\u0241\u0243\3\2\2\2\u0242\u023f\3\2\2"+
		"\2\u0242\u0243\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u0245\7\6\2\2\u0245\u0246"+
		"\b\"\1\2\u0246C\3\2\2\2\u0247\u0248\7 \2\2\u0248\u0249\5F$\2\u0249\u024a"+
		"\7L\2\2\u024a\u024b\b#\1\2\u024bE\3\2\2\2\u024c\u024d\5H%\2\u024d\u0258"+
		"\b$\1\2\u024e\u0252\7S\2\2\u024f\u0252\3\2\2\2\u0250\u0252\7B\2\2\u0251"+
		"\u024e\3\2\2\2\u0251\u024f\3\2\2\2\u0251\u0250\3\2\2\2\u0252\u0253\3\2"+
		"\2\2\u0253\u0254\5H%\2\u0254\u0255\b$\1\2\u0255\u0257\3\2\2\2\u0256\u0251"+
		"\3\2\2\2\u0257\u025a\3\2\2\2\u0258\u0256\3\2\2\2\u0258\u0259\3\2\2\2\u0259"+
		"G\3\2\2\2\u025a\u0258\3\2\2\2\u025b\u025c\5J&\2\u025c\u025d\b%\1\2\u025d"+
		"I\3\2\2\2\u025e\u025f\7N\2\2\u025f\u0264\t\3\2\2\u0260\u0261\7O\2\2\u0261"+
		"\u0265\b&\1\2\u0262\u0263\7N\2\2\u0263\u0265\b&\1\2\u0264\u0260\3\2\2"+
		"\2\u0264\u0262\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0267\b&\1\2\u0267K\3"+
		"\2\2\2\u0268\u0269\7!\2\2\u0269\u026a\7N\2\2\u026a\u026b\t\4\2\2\u026b"+
		"\u026c\7L\2\2\u026c\u026d\3\2\2\2\u026d\u0275\b\'\1\2\u026e\u026f\7!\2"+
		"\2\u026f\u0270\7N\2\2\u0270\u0271\7L\2\2\u0271\u0272\3\2\2\2\u0272\u0275"+
		"\b\'\1\2\u0273\u0275\b\'\1\2\u0274\u0268\3\2\2\2\u0274\u026e\3\2\2\2\u0274"+
		"\u0273\3\2\2\2\u0275M\3\2\2\2\u0276\u0277\7$\2\2\u0277\u0278\5P)\2\u0278"+
		"\u0279\7L\2\2\u0279\u027a\b(\1\2\u027aO\3\2\2\2\u027b\u027c\5R*\2\u027c"+
		"\u027d\b)\1\2\u027d\u0284\3\2\2\2\u027e\u027f\7S\2\2\u027f\u0280\5R*\2"+
		"\u0280\u0281\b)\1\2\u0281\u0283\3\2\2\2\u0282\u027e\3\2\2\2\u0283\u0286"+
		"\3\2\2\2\u0284\u0282\3\2\2\2\u0284\u0285\3\2\2\2\u0285Q\3\2\2\2\u0286"+
		"\u0284\3\2\2\2\u0287\u0288\7N\2\2\u0288\u028d\t\5\2\2\u0289\u028a\7O\2"+
		"\2\u028a\u028e\b*\1\2\u028b\u028c\7N\2\2\u028c\u028e\b*\1\2\u028d\u0289"+
		"\3\2\2\2\u028d\u028b\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u0297\b*\1\2\u0290"+
		"\u0291\7N\2\2\u0291\u0292\t\5\2\2\u0292\u0293\5X-\2\u0293\u0294\3\2\2"+
		"\2\u0294\u0295\b*\1\2\u0295\u0297\3\2\2\2\u0296\u0287\3\2\2\2\u0296\u0290"+
		"\3\2\2\2\u0297S\3\2\2\2\u0298\u0299\7N\2\2\u0299\u029a\7\60\2\2\u029a"+
		"\u029b\7O\2\2\u029b\u029c\3\2\2\2\u029c\u029d\b+\1\2\u029dU\3\2\2\2\u029e"+
		"\u029f\5Z.\2\u029f\u02a6\b,\1\2\u02a0\u02a1\7S\2\2\u02a1\u02a2\5Z.\2\u02a2"+
		"\u02a3\b,\1\2\u02a3\u02a5\3\2\2\2\u02a4\u02a0\3\2\2\2\u02a5\u02a8\3\2"+
		"\2\2\u02a6\u02a4\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7W\3\2\2\2\u02a8\u02a6"+
		"\3\2\2\2\u02a9\u02aa\5Z.\2\u02aa\u02ab\b-\1\2\u02abY\3\2\2\2\u02ac\u02ad"+
		"\b.\1\2\u02ad\u02ae\7N\2\2\u02ae\u02ba\b.\1\2\u02af\u02b0\7O\2\2\u02b0"+
		"\u02ba\b.\1\2\u02b1\u02b2\t\6\2\2\u02b2\u02b3\5Z.\17\u02b3\u02b4\b.\1"+
		"\2\u02b4\u02ba\3\2\2\2\u02b5\u02b6\t\7\2\2\u02b6\u02b7\5Z.\16\u02b7\u02b8"+
		"\b.\1\2\u02b8\u02ba\3\2\2\2\u02b9\u02ac\3\2\2\2\u02b9\u02af\3\2\2\2\u02b9"+
		"\u02b1\3\2\2\2\u02b9\u02b5\3\2\2\2\u02ba\u02f9\3\2\2\2\u02bb\u02bc\f\r"+
		"\2\2\u02bc\u02bd\t\b\2\2\u02bd\u02be\5Z.\16\u02be\u02bf\b.\1\2\u02bf\u02f8"+
		"\3\2\2\2\u02c0\u02c1\f\f\2\2\u02c1\u02c2\t\t\2\2\u02c2\u02c3\5Z.\r\u02c3"+
		"\u02c4\b.\1\2\u02c4\u02f8\3\2\2\2\u02c5\u02c6\f\13\2\2\u02c6\u02c7\t\2"+
		"\2\2\u02c7\u02c8\5Z.\f\u02c8\u02c9\b.\1\2\u02c9\u02f8\3\2\2\2\u02ca\u02cb"+
		"\f\n\2\2\u02cb\u02cc\t\n\2\2\u02cc\u02cd\5Z.\13\u02cd\u02ce\b.\1\2\u02ce"+
		"\u02f8\3\2\2\2\u02cf\u02d0\f\t\2\2\u02d0\u02d1\7D\2\2\u02d1\u02d2\5Z."+
		"\n\u02d2\u02d3\b.\1\2\u02d3\u02f8\3\2\2\2\u02d4\u02d5\f\b\2\2\u02d5\u02d6"+
		"\7?\2\2\u02d6\u02d7\5Z.\t\u02d7\u02d8\b.\1\2\u02d8\u02f8\3\2\2\2\u02d9"+
		"\u02da\f\7\2\2\u02da\u02db\7G\2\2\u02db\u02dc\5Z.\b\u02dc\u02dd\b.\1\2"+
		"\u02dd\u02f8\3\2\2\2\u02de\u02df\f\6\2\2\u02df\u02e0\7B\2\2\u02e0\u02e1"+
		"\5Z.\7\u02e1\u02e2\b.\1\2\u02e2\u02f8\3\2\2\2\u02e3\u02e4\f\5\2\2\u02e4"+
		"\u02e5\7C\2\2\u02e5\u02e6\5Z.\6\u02e6\u02e7\b.\1\2\u02e7\u02f8\3\2\2\2"+
		"\u02e8\u02e9\f\4\2\2\u02e9\u02ea\7#\2\2\u02ea\u02eb\5Z.\2\u02eb\u02ec"+
		"\7\32\2\2\u02ec\u02ed\5Z.\5\u02ed\u02ee\b.\1\2\u02ee\u02f8\3\2\2\2\u02ef"+
		"\u02f0\f\3\2\2\u02f0\u02f1\t\13\2\2\u02f1\u02f2\5Z.\4\u02f2\u02f3\b.\1"+
		"\2\u02f3\u02f8\3\2\2\2\u02f4\u02f5\f\20\2\2\u02f5\u02f6\t\f\2\2\u02f6"+
		"\u02f8\b.\1\2\u02f7\u02bb\3\2\2\2\u02f7\u02c0\3\2\2\2\u02f7\u02c5\3\2"+
		"\2\2\u02f7\u02ca\3\2\2\2\u02f7\u02cf\3\2\2\2\u02f7\u02d4\3\2\2\2\u02f7"+
		"\u02d9\3\2\2\2\u02f7\u02de\3\2\2\2\u02f7\u02e3\3\2\2\2\u02f7\u02e8\3\2"+
		"\2\2\u02f7\u02ef\3\2\2\2\u02f7\u02f4\3\2\2\2\u02f8\u02fb\3\2\2\2\u02f9"+
		"\u02f7\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa[\3\2\2\2\u02fb\u02f9\3\2\2\2"+
		"\u02fc\u02fd\7N\2\2\u02fd\u02fe\7\60\2\2\u02fe\u02ff\5Z.\2\u02ff\u0300"+
		"\3\2\2\2\u0300\u0301\b/\1\2\u0301\u0309\3\2\2\2\u0302\u0303\7N\2\2\u0303"+
		"\u0304\7:\2\2\u0304\u0305\5Z.\2\u0305\u0306\3\2\2\2\u0306\u0307\b/\1\2"+
		"\u0307\u0309\3\2\2\2\u0308\u02fc\3\2\2\2\u0308\u0302\3\2\2\2\u0309]\3"+
		"\2\2\2\u030a\u030f\5Z.\2\u030b\u030c\7S\2\2\u030c\u030d\5^\60\2\u030d"+
		"\u030e\b\60\1\2\u030e\u0310\3\2\2\2\u030f\u030b\3\2\2\2\u030f\u0310\3"+
		"\2\2\2\u0310\u0311\3\2\2\2\u0311\u0312\b\60\1\2\u0312\u0315\3\2\2\2\u0313"+
		"\u0315\3\2\2\2\u0314\u030a\3\2\2\2\u0314\u0313\3\2\2\2\u0315_\3\2\2\2"+
		"Bfnt\u0084\u0095\u00a3\u00a8\u00ac\u00b3\u00c9\u00cb\u00d0\u00d3\u00d8"+
		"\u00e0\u00ec\u00f5\u00fd\u0108\u0113\u011c\u0124\u0131\u0133\u0139\u013d"+
		"\u0140\u0143\u0145\u015a\u0164\u016d\u0176\u0183\u0185\u018b\u01b4\u01c0"+
		"\u01ca\u01d2\u01da\u01dd\u01e8\u01f6\u020a\u021c\u022d\u0232\u0239\u0242"+
		"\u0251\u0258\u0264\u0274\u0284\u028d\u0296\u02a6\u02b9\u02f7\u02f9\u0308"+
		"\u030f\u0314";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}