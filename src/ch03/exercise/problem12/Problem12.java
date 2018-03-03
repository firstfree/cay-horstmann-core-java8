package ch03.exercise.problem12;

import java.io.File;
import java.util.Arrays;

public class Problem12 {

	public static void sortFiles(File[] files) {
		Arrays.sort(files, File::compareTo);
	}
	
	public static void main(String[] args) {
		File[] files = new File[] {
			new File("/2/dd.bak"),
			new File("/112412414124/7_Code.txt"),
			new File("/112412414124"),
			new File("/2"),
			new File("/112412414124/dd2.bak"),
			new File("/2/7_Cod.txt")
		};
		
		sortFiles(files);
		
		System.out.println(Arrays.toString(files));
	}
}
