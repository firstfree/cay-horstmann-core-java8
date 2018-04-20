package ch06.exercise.problem14;

import java.util.ArrayList;

public class Closeables {
	public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception {
		Exception ex = null;
		
		for (T elem : elems) {
			try {
				elem.close();
			} catch (Exception e) {
				ex = new Exception(e.getMessage(), ex);
			}
		}
		
		if (ex != null)
			throw ex;
	}
}
