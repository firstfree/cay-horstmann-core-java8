package ch03.exercise.problem11;

import java.io.File;
import java.util.Arrays;

public class Problem11 {

	public static String[] getFiles(File parentDir, String extension) {
		return parentDir.list((dir, name) -> name.toLowerCase().endsWith(extension));
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getFiles(new File(args[0]), args[1])));
	}
}
