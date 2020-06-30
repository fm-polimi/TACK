package ta.visitors;

import ta.Variable;
import ta.declarations.VariableDecl;
import ta.expressions.EmptyExpression;
import ta.expressions.Expression;
import ta.expressions.Identifier;
import ta.expressions.binary.AssignementExpression;
import ta.expressions.binary.BinaryArithmeticExpression;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ExpressionVariableRenamingVisitor implements ExpressionVisitor<Expression> {

    private Map<String, Variable> variableMap;

    public ExpressionVariableRenamingVisitor(Map<String, Variable> variableMap, int dummy){
        this.variableMap = variableMap;
    }

    public ExpressionVariableRenamingVisitor(Map<String, VariableDecl> variableMap){

        this.variableMap = variableMap.entrySet().stream().map(e ->
                new AbstractMap.SimpleEntry<>(e.getKey(),new Variable(e.getValue().getId()))).collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> a));
    }

    @Override
    public Expression visit(EmptyExpression emptyExpression) {
        return emptyExpression;
    }

    @Override
    public <R extends Expression, S extends Expression> BinaryArithmeticExpression<R, S> visit(
            BinaryArithmeticExpression<R, S> binaryExpression) {
        return new BinaryArithmeticExpression<R, S>((R) visit(binaryExpression.getLeftChild()), binaryExpression.getOperator(),
                (S) visit(binaryExpression.getRightChild()));
    }

    public Expression visit(Expression expression) {
        if (expression instanceof BinaryArithmeticExpression) {
            BinaryArithmeticExpression<Expression,Expression> binExp = (BinaryArithmeticExpression) expression;
            return visit(binExp);
        } else if (expression instanceof Identifier) {
            Identifier identifier = (Identifier) expression;
            return visit(identifier);
        } else {
            return expression;
        }
    }

    // Replace name according to map
    public Identifier visit(Identifier identifier) {
        if (variableMap.containsKey(identifier.getId())) {
            return new Identifier(variableMap.get(identifier.getId()).getName());
        }
        return identifier;
    }
}
