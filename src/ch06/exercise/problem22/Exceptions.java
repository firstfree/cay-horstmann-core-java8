package ch06.exercise.problem22;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class Exceptions {
	public static <V, T extends Throwable> V doWorks(Callable<V> c,  Function<Throwable, T> constr) throws T {
		try {
			return c.call();
		} catch(Throwable realEx) {
			throw constr.apply(realEx);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Exceptions.doWorks(() -> "Hello, Jack.", IllegalStateException::new));
	}
}
