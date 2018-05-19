package ch09.sec01;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharsetDemo {
	public static void main(String[] args) {
		System.out.println("Default charset on thid computer: " + Charset.defaultCharset());
		System.out.println("Available charsets on this JVM: " + Charset.availableCharsets().keySet());
		
		String str = "Java\u2122";
		System.out.println(str);
		byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
		showBytes(bytes);
		showBytes(str.getBytes(StandardCharsets.UTF_16));
		showBytes(str.getBytes(StandardCharsets.ISO_8859_1));
		
		System.out.println(new String(bytes, Charset.forName("windows-1252")));
	}
	
	public static void showBytes(byte[] bytes) {
		for (byte b : bytes) {
			System.out.printf("%2X ", b);
		}
		System.out.println();
	}
}
