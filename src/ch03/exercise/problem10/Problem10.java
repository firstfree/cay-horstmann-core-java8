package ch03.exercise.problem10;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class Problem10 {

	public static File[] getSubDirectoriesLamda(File parentDir) {
		return parentDir.listFiles((f) -> f.isDirectory());
	}
	
	public static File[] getSubDirectoriesMethod(File parentDir) {
		return parentDir.listFiles(File::isDirectory);
	}
	
	public static File[] getSubDirectoriesInnerClass(File parentDir) {
		return parentDir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		});
	}
	
	public static void main(String[] args) {
		File rootDir = new File(args[0]);
		System.out.println(Arrays.toString(getSubDirectoriesLamda(rootDir)));
		System.out.println(Arrays.toString(getSubDirectoriesMethod(rootDir)));
		System.out.println(Arrays.toString(getSubDirectoriesInnerClass(rootDir)));
	}
}
