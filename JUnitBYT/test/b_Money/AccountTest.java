package b_Money;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank PolishBank;
	Bank JapaneseBank;
	Bank EnglishBank;
	Account testAccount;
	
	/*
	 * Set up initial accounts, currency and bank for testing 
	 */
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		EnglishBank = new Bank("EnglishBank", SEK);
		EnglishBank.openAccount("John");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		EnglishBank.deposit("John", new Money(1000000, SEK));
		
	}
	
	/*
	 * Testing adding and removing TimedPayment from HashTable
	 */
	@Test
	public void AddRemoveTimedPaymentTest() {
		testAccount.addTimedPayment("1", 5, 10, new Money(1000, SEK), EnglishBank, "John");
		assertTrue(testAccount.timedPaymentExists("1"));
		testAccount.removeTimedPayment("1");
		assertFalse(testAccount.timedPaymentExists("1"));
	}
	
	/*
	 * Testing if TimedPayments works properly it means that when we are calling tick(), 'next' value should decrement by 1 and when it will be 0 payment is going to proceed.
	 */
	@Test
	public void TimedPaymentTest() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("1", 2, 2, new Money(1000, SEK), EnglishBank, "John"); 
		//System.out.println(testAccount.getBalance().getAmount());
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();
		
		assertEquals(new Integer(10000000 - 1000), testAccount.getBalance().getAmount(), 0);
	}

	/*
	 * Testing depositing and withdrawing money from account
	 */
	@Test
	public void AddWithdrawTest() {
		testAccount.deposit(new Money(5000, SEK));
		assertEquals(10000000 + 5000, testAccount.getBalance().getAmount(), 0);  
		testAccount.withdraw(new Money(5000, SEK));
		assertEquals(10000000, testAccount.getBalance().getAmount(), 0);
		
	}
	/*
	 * Testing getBalance() method
	 */
	@Test
	public void GetBalanceTest() {
		assertTrue(new Money(10000000, SEK).equals(testAccount.getBalance()));
	}
}
