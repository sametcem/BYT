package exercise_03;

public class SubtractExpression extends Expression {

	public SubtractExpression(Expression left, Expression right) 
	{
		super(left, right);
	}

	@Override
	public int accept(Visitor visitor) 
	{
		return visitor.visit(this);
	}

}

