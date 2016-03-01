package io.pigbrain.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WhiteBox {

	public static <T> T invokeMethod(Object instance, String methodName, Object... arguments) throws Throwable {

		if (instance == null) {
			throw new Exception("ClassType can not be null");
		}

		Method method = getMethod(instance.getClass(), methodName);
		if (method == null) {
			throw new Exception("Method[" + methodName + "] is not found");
		}

		try {
			return (T) method.invoke(instance, arguments);
		} catch (InvocationTargetException e) {
			throw e.getTargetException();
		}
	}

	private static Method getMethod(Class<?> classType, String methodName) {

		if (methodName == null) {
			return null;
		}

		Method[] methods = classType.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				method.setAccessible(true);
				return method;
			}
		}

		return null;
	}
}
