package ch04.sec05;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyDemo {
	public static void main(String[] args) {
		Object[] values = new Object[1000];
		
		for (int i = 0; i < values.length; ++i) {
			Object value = i;
			values[i] = Proxy.newProxyInstance(
				null,
				value.getClass().getInterfaces(),
				(Object proxy, Method method, Object[] margs) -> {
					System.out.println(value + "." + method.getName() + Arrays.toString(margs));
					return method.invoke(value, margs);
				});
		}
		
		int position = Arrays.binarySearch(values, 500);
		System.out.println(values[position]);
	}
}
