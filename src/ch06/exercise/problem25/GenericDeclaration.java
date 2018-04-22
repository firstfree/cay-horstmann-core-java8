package ch06.exercise.problem25;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;


public class GenericDeclaration {
	public static String genericDeclaration(Method m) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(Modifier.toString(m.getModifiers()));
		
		sb.append(" <");
		TypeVariable<Method>[] vars = m.getTypeParameters();
		StringJoiner sj = new StringJoiner(",");
		for (TypeVariable<Method> var : vars) {
			StringBuilder tsb = new StringBuilder();
			tsb.append(var.getName());
			
			Type[] types = var.getBounds();
			for (Type type : types) {
				tsb.append(" extends ");
				tsb.append(type.getTypeName());
			}
			sj.add(tsb.toString());
		}
		sb.append(sj.toString());
		sb.append("> ");
		
		sb.append(m.getGenericReturnType());
		sb.append(" ");
		
		sb.append(m.getName());
		
		sb.append("(");
		Type[] types = m.getGenericParameterTypes();
		sj = new StringJoiner(",");
		for (Type type : types) {
			sj.add(type.getTypeName());
		}
		sb.append(sj.toString());
		sb.append(")");
		
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws ReflectiveOperationException {
		System.out.println(genericDeclaration(Collections.class.getMethod("sort", List.class)));
	}
}
