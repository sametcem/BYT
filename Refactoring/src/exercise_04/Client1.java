package exercise_04;

import java.io.*;

public class Client1 {

	public static void printPerson(Writer out, Person person) throws IOException {
		out.write(person.getFirst());
		out.write(" ");
		if (person.getMiddle() != null) {
			out.write(person.getMiddle());
			out.write(" ");
		}
		out.write(person.getLast());
	}

}
