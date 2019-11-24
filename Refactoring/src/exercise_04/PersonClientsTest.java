package exercise_04;

// The Person class has multiple clients, but all of the clients are in 
// one file for convenience.  Imagine them as non-test methods in separate 
// client classes.

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.*;

public class PersonClientsTest {

	@Test
	public void testClients() throws IOException {
		Person bobSmith = new Person("Smith", "Bob", null);
		Person jennyJJones = new Person("Jones", "Jenny", "J");

		StringWriter out = new StringWriter();
		Client1.printPerson(out, bobSmith);
		assertEquals("Bob Smith", out.toString());
		assertEquals("Bob Smith", PersonFormatter.format(bobSmith, "f l"));

		out = new StringWriter();
		Client1.printPerson(out, jennyJJones);
		assertEquals("Jenny J Jones", out.toString());
		assertEquals("Jenny J Jones", PersonFormatter.format(jennyJJones, "f m l"));

		assertEquals("Smith, Bob", Client2.formatPerson(bobSmith));
		assertEquals("Smith, Bob", PersonFormatter.format(bobSmith, "l, f"));
		assertEquals("Jones, Jenny J", Client2.formatPerson(jennyJJones));
		assertEquals("Jones, Jenny J", PersonFormatter.format(jennyJJones, "l, f m"));

		out = new StringWriter();
		Client3.display(out, bobSmith);
		assertEquals("Smith, Bob", out.toString());
		assertEquals("Smith, Bob", PersonFormatter.format(bobSmith, "l, f"));

		out = new StringWriter();
		Client3.display(out, jennyJJones);
		assertEquals("Jones, Jenny J", out.toString());
		assertEquals("Jones, Jenny J", PersonFormatter.format(jennyJJones, "l, f m"));

		assertEquals("Smith, Bob", Client4.toString(bobSmith));
		assertEquals("Jones, Jenny J", Client4.toString(jennyJJones));
		assertEquals("Jones, Jenny J", PersonFormatter.format(jennyJJones, "l, f m"));
	}
}
