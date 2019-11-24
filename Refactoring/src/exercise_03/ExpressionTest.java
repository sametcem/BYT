package exercise_03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExpressionTest {

	ExpressionVisitor visitor;

	@Before
	public void setup() {
		visitor = new ExpressionVisitor();
	}

	@Test
	public void testConstant() {
		Expression e = new ConstExpression(-43);
		assertEquals(visitor.visit((ConstExpression) e), -43);
	}

	@Test
	public void testAddition() {
		Expression e = new AddExpression(new ConstExpression(800), new ConstExpression(-100));
		assertEquals(visitor.visit((AddExpression) e), 700);
	}

	@Test
	public void testSubtraction() {
		Expression e = new SubtractExpression(new ConstExpression(100), new ConstExpression(-250));
		assertEquals(visitor.visit((SubtractExpression) e), 350);
	}

	@Test
	public void testMultiplication() {
		Expression e = new MultiplyExpression(new ConstExpression(100), new ConstExpression(-2));
		assertEquals(visitor.visit((MultiplyExpression) e), -200);
	}

	@Test
	public void testDivision() {
		Expression e = new DivideExpression(new ConstExpression(100), new ConstExpression(-100));
		assertEquals(visitor.visit((DivideExpression) e), -1);
	}

	@Test
	public void testComplexExpression() {
		// (1+2-3*4/5)
		Expression e = new SubtractExpression(new AddExpression(new ConstExpression(1), new ConstExpression(2)),
				new DivideExpression(new MultiplyExpression(new ConstExpression(3), new ConstExpression(4)),
						new ConstExpression(5)));
		// TODO: WRONG Answer!!!! Should be 1+2-3*4/5 = 3 - 12/5 = 3/5
		assertEquals(visitor.visit((SubtractExpression) e), 1);
	}
}