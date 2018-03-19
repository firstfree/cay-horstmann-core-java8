package ch04.exercise.problem9;

import java.lang.reflect.Field;

public interface ToString {
	static String toString(Object obj) {
		StringBuilder sb = new StringBuilder("[");
		Class<?> cl = obj.getClass();
		Field[] fields = cl.getDeclaredFields();
		for (int i = 0; i < fields.length; ++i) {
			try {
				fields[i].setAccessible(true);
				sb.append(fields[i].getName());
				sb.append("=");
				sb.append(fields[i].get(obj));
				if (i < fields.length - 1) {
					sb.append(",");
				}
			} catch (IllegalAccessException e) {
				sb.append(e.getMessage());
			}
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}
