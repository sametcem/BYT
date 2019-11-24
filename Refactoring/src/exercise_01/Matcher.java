package exercise_01;

// TODO: bad smell: comments
// 		 solutions: extracting methods with explanatory names
public class Matcher {
	public Matcher() {}

	public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {

		if (!areLengthsEqual(expected, actual))
			return false;

		clipArray(actual, clipLimit);

		if (!areEntriesEqual(expected, actual, delta))
			return false;

		return true;
	}

	private boolean areLengthsEqual(int[] expected, int[] actual) {
		if (actual.length != expected.length)
			return false;
		return true;
	}

	private void clipArray(int[] actual, int clipLimit) {
		for (int i = 0; i < actual.length; i++)
			if (actual[i] > clipLimit)
				actual[i] = clipLimit;
	}

	private boolean areEntriesEqual(int[] expected, int[] actual, int delta) {
		for (int i = 0; i < actual.length; i++)
			if (Math.abs(expected[i] - actual[i]) > delta)
				return false;
		return true;
	}
}