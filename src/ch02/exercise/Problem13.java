package ch02.exercise;

import java.io.FileReader;
import java.util.Arrays;

import com.opencsv.CSVReader;

public class Problem13 {

	public static void main(String[] args) throws Exception {
		CSVReader reader = new CSVReader(new FileReader("src/hello.csv"));

		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			System.out.println(Arrays.deepToString(nextLine));
		}

		reader.close();
	}
}
