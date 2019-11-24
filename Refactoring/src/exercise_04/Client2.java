package exercise_04;

public class Client2 {

	public static String formatPerson(Person person) {
		String result = person.getLast() + ", " + person.getFirst();
		if (person.getMiddle() != null)
			result += " " + person.getMiddle();
		return result;
	}

}
