package exercise_03;

public interface Visitor 
{
	int visit(AddExpression expr);
	int visit(SubtractExpression expr);
	int visit(MultiplyExpression expr);
	int visit(DivideExpression expr);
	int visit(ConstExpression expr);
}

