package ta.expressions;

import ta.visitors.Expression2CLTLocExpression;
import ta.visitors.ExpressionVisitor;

import java.util.Map;

public abstract class Expression {

	
	abstract public  formulae.cltloc.atoms.Expression accept(Expression2CLTLocExpression visitor);
	
	abstract public  <T> T accept(ExpressionVisitor<T> visitor);

	//abstract public Expression replaceParameters(Map<String, Value> parameterMap);
	
	abstract public int evaluate();
}
