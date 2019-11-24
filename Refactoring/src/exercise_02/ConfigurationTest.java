package exercise_02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.*;
import java.util.*;

public class ConfigurationTest {

	@Test
	public void testGoodInput() throws IOException {
		String data = "interval = 10\nduration = 100\ndeparture = 200\n";

		Properties input = loadInput(data);

		Configuration props = new Configuration();
		try {
			props.load(input);
		} catch (ConfigurationException e) {
			assertTrue(false);
			return;
		}

		// TODO: changed from data members access to getters
		assertEquals(props.getInterval(), (Integer) 10);
		assertEquals(props.getDuration(), (Integer) 100);
		assertEquals(props.getDeparture(), (Integer) 200);
	}

	@Test
	public void testNegativeValues() throws IOException {
		processBadInput("interval = -10\nduration = 100\ndeparture = 200\n");
		processBadInput("interval = 10\nduration = -100\ndeparture = 200\n");
		processBadInput("interval = 10\nduration = 100\ndeparture = -200\n");
	}

	@Test
	public void testInvalidDuration() throws IOException {
		processBadInput("interval = 10\nduration = 99\ndeparture = 200\n");
	}

	@Test
	public void testInvalidDeparture() throws IOException {
		processBadInput("interval = 10\nduration = 100\ndeparture = 199\n");
	}

	// TODO: removed @Test
	private void processBadInput(String data) throws IOException {
		Properties input = loadInput(data);

		boolean failed = false;
		Configuration props = new Configuration();
		try {
			props.load(input);
		} catch (ConfigurationException e) {
			failed = true;
		}

		assertTrue(failed);
	}

	// TODO: removed @Test
	private Properties loadInput(String data) throws IOException {
		@SuppressWarnings("deprecation")
		InputStream is = new StringBufferInputStream(data);

		Properties input = new Properties();
		input.load(is);
		is.close();

		return input;
	}
}
