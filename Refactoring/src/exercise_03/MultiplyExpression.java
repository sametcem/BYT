package exercise_03;

public class MultiplyExpression extends Expression {

	public MultiplyExpression(Expression left, Expression right) 
	{
		super(left, right);
	}

	@Override
	public int accept(Visitor visitor) 
	{
		return visitor.visit(this);
	}
}

