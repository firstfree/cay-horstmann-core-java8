package ch09.exercise.problem01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class StreamCopyTest {
	public static void main(String[] args) throws IOException {
		Path inputPath = Paths.get("input.txt");
		Path outputPath = Paths.get("output.txt");
		try (InputStream in = Files.newInputStream(inputPath);
				OutputStream out = Files.newOutputStream(outputPath)) {
//			copyByLoop(in, out);
			copyByFiles(in, out);
		}
	}

	public static void copyByLoop(InputStream in, OutputStream out) throws IOException {
		int n = 0;
		byte[] buffer = new byte[128];

		while ((n = in.read(buffer)) != -1) {
			out.write(buffer, 0, n);
		}
	}

	public static void copyByFiles(InputStream in, OutputStream out) throws IOException {
		Files.copy(in, Paths.get("temp.txt"), StandardCopyOption.REPLACE_EXISTING);
		Files.copy(Paths.get("temp.txt"), out);
		Files.delete(Paths.get("temp.txt"));
	}
}
