package ch09.sec02;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class DirectoryDemo {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get(System.getProperty("java.home"));
		System.out.printf("Directories inside %s:\n", path);
		try (Stream<Path> entries = Files.list(path)) {
			entries.forEach(System.out::println);
		}
		
		System.out.printf("\nDirectories and subdirectories inside %s:\n", path);
		try (Stream<Path> entries = Files.walk(path)) {
			System.out.printf("%d files\n", entries.count());
		}
		
		Path source = path;
		Path target = Files.createTempDirectory("corejava").resolve("jre");
		Files.walk(source).forEach(p -> {
			try {
				Path q = target.resolve(source.relativize(p));
				if (Files.isDirectory(p)) {
					System.out.printf("Creating %s\n", q);
					Files.createDirectory(q);
				} else {
					System.out.printf("Copying %s to %s\n", p, q);
					Files.copy(p, q);
				}
			} catch (IOException e) {
				throw new UncheckedIOException(e);
			}
		});
		
		Path root = target;
		Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Files.delete(file);
				System.out.printf("Deleting %s\n", file);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				if (exc != null) {
					throw exc;
				}
				Files.delete(dir);
				System.out.printf("Deleting %s\n", dir);
				return FileVisitResult.CONTINUE;
			}
		});
	}
}
