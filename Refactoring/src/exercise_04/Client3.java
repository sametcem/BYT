package exercise_04;

import java.io.*;


public class Client3 {
	
	public static void display(Writer out, Person person) throws IOException {
		out.write(person.getLast());
		out.write(", ");
		out.write(person.getFirst());
		if (person.getMiddle() != null) {
			out.write(" ");
			out.write(person.getMiddle());
		}
	}

}
