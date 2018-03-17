package ch04.sec04;

import java.io.UnsupportedEncodingException;
import java.util.ServiceLoader;

public class ServiceLoaderDemo {
	public static ServiceLoader<Cipher> cipherLoader = ServiceLoader.load(Cipher.class);
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		Cipher cipher = getCipher(1);
		String message = "Meet me at the toga party.";
		byte[] key = new byte[]{3};
		
		byte[] bytes = cipher.encrypt(message.getBytes(), key);
		System.out.println(new String(bytes, "UTF-8"));
		
		bytes = cipher.decrypt(bytes, key);
		System.out.println(new String(bytes, "UTF-8"));
	}
	
	public static Cipher getCipher(int minStrength) {
		for (Cipher cipher : cipherLoader) {
			if (cipher.strength() >= minStrength) {
				return cipher;
			}
		}
		
		return null;
	}
}
