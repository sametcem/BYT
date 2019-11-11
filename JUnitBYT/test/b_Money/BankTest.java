package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank, EnglishBank, PolishBank,JapaneseBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
		
		EnglishBank = new Bank("EnglishBank", SEK);
		PolishBank = new Bank("PolishBank", SEK);
		JapaneseBank = new Bank("JapaneseBank", DKK);
		EnglishBank.openAccount("Jane");
		EnglishBank.openAccount("Bob");
		PolishBank.openAccount("Bob");
		JapaneseBank.openAccount("Toho");
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank",SweBank.getName());
		assertEquals("Nordea",Nordea.getName());
		assertEquals("DanskeBank",DanskeBank.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK,SweBank.getCurrency());
		assertEquals(SEK,Nordea.getCurrency());
		assertEquals(DKK,DanskeBank.getCurrency());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		SweBank.openAccount("William");
		assertEquals("William",SweBank.getAccount("William").getName());
		Nordea.openAccount("Samet");
		assertEquals("Samet",Nordea.getAccount("Samet").getName());
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(1000, SEK));
		assertEquals(Integer.valueOf(1000),SweBank.getBalance("Ulrika"));
		
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		SweBank.withdraw("Bob", new Money(1000, SEK));
		assertEquals(Integer.valueOf(-1000),SweBank.getBalance("Bob"));
		SweBank.withdraw("Bob", new Money(1000, DKK)); // 1000x0.20 / 0.15
		assertEquals(Integer.valueOf(-2333),SweBank.getBalance("Bob"));
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		Nordea.deposit("Bob", new Money(1000, SEK));
		assertEquals(Integer.valueOf(1000),Nordea.getBalance("Bob"));
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		// In the same bank
				SweBank.deposit("Bob", new Money(1000, SEK));
				SweBank.transfer("Bob", "Ulrika", new Money(1000, SEK));
				assertEquals(Integer.valueOf(0),SweBank.getBalance("Bob"));
				assertEquals(Integer.valueOf(1000),SweBank.getBalance("Ulrika"));
				
		// From a bank to another bank
				SweBank.deposit("Bob", new Money(1000, SEK));
				SweBank.transfer("Bob", Nordea, "Bob", new Money(1000, SEK));
				assertEquals(Integer.valueOf(0),SweBank.getBalance("Bob"));
				assertEquals(Integer.valueOf(1000),Nordea.getBalance("Bob"));
	}
	
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		EnglishBank.deposit("Bob", new Money(1000, SEK));
		EnglishBank.addTimedPayment("Bob", "1", 2, 0, new Money(1000, SEK), EnglishBank, "Jane"); 
		EnglishBank.tick(); 

		assertEquals(0, EnglishBank.getBalance("Bob"), 0);
		assertEquals(1000, EnglishBank.getBalance("Jane"), 0);
		
	}
	
}
