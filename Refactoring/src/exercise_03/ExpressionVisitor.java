package exercise_03;

public class ExpressionVisitor implements Visitor {

	@Override
	public int visit(AddExpression expr) 
	{
		return expr.getLeft().accept(this) + expr.getRight().accept(this);
	}

	@Override
	public int visit(SubtractExpression expr) 
	{
		return expr.getLeft().accept(this) - expr.getRight().accept(this);
	}

	@Override
	public int visit(MultiplyExpression expr) 
	{
		return expr.getLeft().accept(this) * expr.getRight().accept(this);
	}

	@Override
	public int visit(DivideExpression expr) 
	{
		return expr.getLeft().accept(this) / expr.getRight().accept(this);
	}

	@Override
	public int visit(ConstExpression expr) 
	{
		return expr.getConstant();
	}

}
