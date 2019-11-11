package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}
	
	/*
	 * Motivation: checking the method GetName() in Currency class,
	 * we want to get name of a currency. We are checking
	 * whether it is working properly- returns correct values. 
	 */
	@Test
	public void testGetName() {
		assertEquals("SEK", SEK.getName());
		assertEquals("DKK", DKK.getName());
		assertEquals("EUR", EUR.getName());
	}
	
	/*
	 * Motivation: checking the method GetRate() in Currency class,
	 * we want to get rate of a currency. We are checking
	 * whether it is working properly- returns correct values. 
	 */
	@Test
	public void testGetRate() {
		assertEquals(Double.valueOf(0.15), SEK.getRate());
		assertEquals(Double.valueOf(0.20), DKK.getRate());
		assertEquals(Double.valueOf(1.5), EUR.getRate());
	}
	
	/*
	 * Motivation: checking the method SetRate() in Currency class,
	 * we want to set rate of a currency. We are checking
	 * whether it is working properly- returns correct values. 
	 */
	@Test
	public void testSetRate() {
		SEK.setRate(2.0);
		assertEquals(Double.valueOf(2.0), SEK.getRate());
		// checking big numbers
		SEK.setRate(123456789.77);
		assertEquals(Double.valueOf(123456789.77), SEK.getRate());
	}
	
	/*
	 * Motivation: check the method universalValue() Currency class,
	 * we want to check whether calculations are done correctly.
	 */
	@Test
	public void testGlobalValue() {
		assertEquals(0.15*20, SEK.universalValue(20), 0.00001);
		//0.00001 -> Delta, It represents the maximum difference between expected and actual value for which both numbers are still considered equal.
	}
	
	/*
	 * Motivation: check the method valueInThisCurrency in Currency class,
	 * we want to check whether calculations are done correctly.
	 */
	@Test
	public void testValueInThisCurrency() {
		assertEquals(20*0.20/0.15,SEK.valueInThisCurrency(20, DKK), 0.0001);
	}

}
