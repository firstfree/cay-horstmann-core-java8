package ch05.exercise.problem05;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class WithoutTryWithResources {
	public static void main(String[] args) {
		Scanner in = null;
		PrintWriter out = null;
		
		try {
			in = new Scanner(Paths.get("/usr/share/dict/words"));
			out = new PrintWriter("output.txt");
			
			while (in.hasNext()) {
				out.println(in.next().toLowerCase());
			}
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		} finally {
			if (out != null) {
				out.close();
			}
			
			if (in != null) {
				in.close();
			}
		}
	}
}
