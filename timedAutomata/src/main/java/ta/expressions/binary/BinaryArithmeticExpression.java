package ta.expressions.binary;

import ta.expressions.Expression;
import ta.visitors.ExpressionVisitor;
import ta.visitors.TAVisitor;

public class BinaryArithmeticExpression<T extends Expression, S extends Expression> extends Expression {

	private final T leftChild;
	private final S rightChild;
	private final String operator;

	public BinaryArithmeticExpression(T leftChild, String operator, S rightChild) {
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.operator = operator;
	}

	public T getLeftChild() {
		return this.leftChild;
	}

	public S getRightChild() {
		return this.rightChild;
	}

	public String getOperator() {
		return operator;
	}

	@Override
	public <R> R accept(TAVisitor<R> visitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <R> R accept(ExpressionVisitor<R> visitor) {
		return visitor.visit(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "(" + leftChild + ")" + operator + "(" + rightChild + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int evaluate() {
		switch (operator) {
		case "+":
			return leftChild.evaluate() + rightChild.evaluate();
			
		default:
			throw new IllegalArgumentException("The operator " + operator + " is not a valid operator");
		}
	}
}
