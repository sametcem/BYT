package exercise_03;

public class ConstExpression extends Expression {

	public ConstExpression(int constant) 
	{
		super(constant);
	}

	@Override
	public int accept(Visitor visitor) 
	{
		return visitor.visit(this);
	}

}
