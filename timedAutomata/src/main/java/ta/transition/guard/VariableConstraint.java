package ta.transition.guard;

import java.util.Map;
import java.util.Set;

import ta.Variable;
import ta.expressions.Value;
import ta.visitors.TAVisitor;

public interface VariableConstraint {

	/**
	 * returns the set of the variables involved in the variable constraint
	 * 
	 * @return the set of the variables involved in the variable constraint
	 */
	public Set<Variable> getVariables();

	public VariableConstraint replaceParameters (Map<String, Value> parameterMap);

	public <R> R accept(TAVisitor<R> visitor);
}
