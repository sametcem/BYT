package exercise_03;

// Design Patter Visitor:
// https://www.geeksforgeeks.org/visitor-design-pattern/
// https://dzone.com/articles/design-patterns-visitor

//TODO: added Visitor pattern.
//TODO : bad smell: Removed Switch Statement.
public abstract class Expression implements Visitable {
	
	private Expression left;
	private Expression right;
	private int constant;

	public Expression(int constant) {
		this.constant = constant;
	}

	public Expression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

	public int getConstant() {
		return constant;
	}

	public void setLeft(Expression left) {
		this.left = left;
	}

	public void setRight(Expression right) {
		this.right = right;
	}

	public void setConstant(int constant) {
		this.constant = constant;
	}
	
	
}
