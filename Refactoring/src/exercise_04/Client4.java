package exercise_04;


public class Client4 {

	public static String toString(Person person) {
		return person.getLast() + ", " + person.getFirst()
				+ ((person.getMiddle() == null) ? "" : " " + person.getMiddle());
	}

}

