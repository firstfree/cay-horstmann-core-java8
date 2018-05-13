package ch08.exercise.problem06;

public class CharacterTest {
	public static boolean isWord(String target) {
		return target.codePoints().allMatch(Character::isAlphabetic);
	}
	
	public static boolean isJavaIdentifier(String target) {
		return target.codePoints().limit(1).anyMatch(Character::isJavaIdentifierStart)
				&& target.codePoints().skip(1).allMatch(Character::isJavaIdentifierPart);
	}
	
	public static void main(String[] args) {
		System.out.println(isWord("book"));
		System.out.println(isWord("I'm a programmer."));
		System.out.println(isWord("programmer"));
		System.out.println(isJavaIdentifier("$this"));
		System.out.println(isJavaIdentifier("1this"));
	}
}
