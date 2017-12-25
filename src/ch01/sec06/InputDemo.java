package ch01.sec06;

import java.io.Console;
import java.util.Scanner;

public class InputDemo {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("What is your name?");
			String name = in.nextLine();
			System.out.println("How old are you?");
			if (in.hasNextInt()) {
				int age = in.nextInt();
				System.out.printf("Hello, %s. Next year, you'll be %d.\n", name, age + 1);
			} else {
				System.out.printf("Hello, %s. Are you too young to enter an integer?", name);
			}
			
			Console terminal = System.console();
			String username = terminal.readLine("User name: ");
			char[] passwd = terminal.readPassword("Password: ");
			System.out.println(username + " " + new String(passwd));
		}
		
	}
}
