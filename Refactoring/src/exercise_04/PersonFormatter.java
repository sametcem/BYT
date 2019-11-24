package exercise_04;

public class PersonFormatter {
	public static String format(Person p, String format)
	{
		String out = "";
		for (int i = 0; i < format.length(); ++i)
		{
			switch (format.charAt(i))
			{
				case 'f':
					if (p.getFirst() != null) out += p.getFirst();
					break;
				case 'l':
					if (p.getLast() != null) out += p.getLast();
					break;
				case 'm':
					if (p.getMiddle() != null) out += p.getMiddle();
					break;
				default:
					out += format.charAt(i);
					break;
			}
		}
		
		return out;
	}
}
