package exercise_05;

import java.io.IOException;
import java.io.PrintStream;

//TODO:  - added flexible PrinStream for output
//		 - added separator's specification     
// 		Divergent Change

public class CsvWriter {
	private PrintStream os;
	private char separator;

	public CsvWriter(char separator, PrintStream os) {
		this.separator = separator;
		this.os = os;
	}

	public void write(String[][] lines) {
		for (int i = 0; i < lines.length; i++)
			try {
				writeLine(lines[i]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void writeLine(String[] fields) throws IOException {
		if (fields.length == 0)
			os.println();
		else {
			writeField(fields[0]);

			for (int i = 1; i < fields.length; i++) {
				os.print(separator);
				writeField(fields[i]);
			}
			os.println();
		}
	}

	private void writeField(String field) {
		if (field.indexOf(',') != -1 || field.indexOf('\"') != -1)
			writeQuoted(field);
		else
			os.print(field);
	}

	private void writeQuoted(String field) {
		os.print('\"');
		for (int i = 0; i < field.length(); i++) {
			char c = field.charAt(i);
			if (c == '\"')
				os.print("\"\"");
			else
				os.print(c);
		}
		os.print('\"');
	}
}