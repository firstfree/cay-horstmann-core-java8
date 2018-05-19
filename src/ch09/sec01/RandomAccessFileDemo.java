package ch09.sec01;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		try (RandomAccessFile file = new RandomAccessFile("chart.bmp", "rw")) {
			int value = file.readInt();
			file.seek(file.getFilePointer() - 4);
			file.writeInt(value + 1);
		}
	}
}
