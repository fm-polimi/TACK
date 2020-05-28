package ta.transition;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Preconditions;

import ta.expressions.Value;
import ta.transition.guard.ClockConstraintAtom;
import ta.transition.guard.VariableConstraintAtom;

public class Guard {

	/**
	 * contains the constraint of the guard that are relative to clocks
	 */
	private final Set<ClockConstraintAtom> clockConstraints;

	private final Set<VariableConstraintAtom> conditions;

	public Guard(Set<VariableConstraintAtom> conditions, Set<ClockConstraintAtom> clockConstraints) {
		Preconditions.checkNotNull(conditions, "The set of conditions cannot be null");
		Preconditions.checkNotNull(clockConstraints, "The set of clock constraints be null");
		this.conditions = conditions;
		this.clockConstraints = clockConstraints;
	}

	public Set<VariableConstraintAtom> getConditions() {
		return Collections.unmodifiableSet(conditions);
	}

	public Set<ClockConstraintAtom> getClockConstraints() {
		return Collections.unmodifiableSet(clockConstraints);
	}

	// Param replacement - need to first change clockConstraint & variableConstraint to use Value class instead of int
	//public Guard replaceParameters(Map<String, Value> parameterMap) {
	//
	//}

	public Guard replaceParameters(Map<String, Value> parameterMap) {
		return new Guard(this.conditions, this.clockConstraints);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "clockConstraints=" + clockConstraints + ", variableConstraints=" + conditions + "]";
	}
}
