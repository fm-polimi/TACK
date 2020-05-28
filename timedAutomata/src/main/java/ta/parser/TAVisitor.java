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

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TAParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TAVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TAParser#ta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTa(TAParser.TaContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(TAParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#instantiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstantiation(TAParser.InstantiationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#system}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystem(TAParser.SystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(TAParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(TAParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#procDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcDecl(TAParser.ProcDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#procBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcBody(TAParser.ProcBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#boundedVariableDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoundedVariableDecl(TAParser.BoundedVariableDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#variableDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDecl(TAParser.VariableDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#variableId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableId(TAParser.VariableIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#arrayDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDecl(TAParser.ArrayDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(TAParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#fieldDeclId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclId(TAParser.FieldDeclIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix(TAParser.PrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(TAParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#commit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommit(TAParser.CommitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#urgent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrgent(TAParser.UrgentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#stateList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateList(TAParser.StateListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#typeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDecl(TAParser.TypeDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#typeIdList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdList(TAParser.TypeIdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(TAParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(TAParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(TAParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(TAParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#caseocc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseocc(TAParser.CaseoccContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#states}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStates(TAParser.StatesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#stateDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateDecl(TAParser.StateDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#invariant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvariant(TAParser.InvariantContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(TAParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#transitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransitions(TAParser.TransitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#transitionset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransitionset(TAParser.TransitionsetContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#transitionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTransitionBody(TAParser.TransitionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard(TAParser.GuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#guardconditionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardconditionList(TAParser.GuardconditionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#clockconstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClockconstraint(TAParser.ClockconstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#constraintAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintAtom(TAParser.ConstraintAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#sync}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSync(TAParser.SyncContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(TAParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#assignmentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentList(TAParser.AssignmentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(TAParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#simpleassigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleassigment(TAParser.SimpleassigmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(TAParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#exprStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStatement(TAParser.ExprStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(TAParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#declarationid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationid(TAParser.DeclarationidContext ctx);
	/**
	 * Visit a parse tree produced by {@link TAParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(TAParser.ArgListContext ctx);
}