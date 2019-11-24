package exercise_03;

public class DivideExpression extends Expression {

	public DivideExpression(Expression left, Expression right) 
	{
		super(left, right);
	}

	@Override
	public int accept(Visitor visitor) 
	{
		return visitor.visit(this);
	}

}

