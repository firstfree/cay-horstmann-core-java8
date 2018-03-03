package ch03.exercise.problem10;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Problem10 {

	public static FileSequence getFileSequence(File[] files) {
		return new FileSequence() {
			int position;
			
			@Override
			public File next() {
				return files[position++];
			}
			
			@Override
			public boolean hasNext() {
				return files.length > position;
			}
		};
	}
	
	public static void getSubDirectories(File parentDir, List<File> subDirs) {
		File[] dirs = parentDir.listFiles(File::isDirectory);
		FileSequence fileSequence = getFileSequence(dirs);
		while (fileSequence.hasNext()) {
			File subDir = fileSequence.next();
			subDirs.add(subDir);
			getSubDirectories(subDir, subDirs);
		}
	}
	
	public static void main(String[] args) {
		File rootDir = new File(args[0]);
		List<File> subDirs = new ArrayList<>();
		getSubDirectories(rootDir, subDirs);
		
		System.out.println(subDirs);
	}
}
