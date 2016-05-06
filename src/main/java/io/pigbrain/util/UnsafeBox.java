package io.pigbrain.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;

import sun.misc.Unsafe;

public class UnsafeBox {

	private Unsafe unsafe;

	public UnsafeBox() {

	}

	public Object allocateInsatnce(Class clazz) throws Exception {

		return getUnsafe().allocateInstance(clazz);
	}

	public int objectFieldOffset(Object object, String fieldName) throws Exception {

		Field f = object.getClass().getDeclaredField(fieldName);

		return (int) getUnsafe().objectFieldOffset(f);
	}

	public long sizeOf(Object object) throws Exception {
		
		// return getUnsafe().getAddress(normalize(getUnsafe().getInt(object, 4L)) + 12L);
		
		Unsafe u = getUnsafe();
		HashSet<Field> fields = new HashSet<Field>();
		Class c = object.getClass();
		while (c != Object.class) {
			for (Field f : c.getDeclaredFields()) {
				if ((f.getModifiers() & Modifier.STATIC) == 0) {
					fields.add(f);
				}
			}
			c = c.getSuperclass();
		}

		long maxSize = 0;
		for (Field f : fields) {
			long offset = u.objectFieldOffset(f);
			if (offset > maxSize) {
				maxSize = offset;
			}
		}

		return ((maxSize / 8) + 1) * 8; // padding
	}

	private long normalize(int address) {
		if (address >= 0) {
			return address;
		} else {
			return (~0L >>> 32) & address;
		}
	}

	private Unsafe getUnsafe() throws Exception {

		if (unsafe != null) {
			return unsafe;
		}

		Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
		unsafeField.setAccessible(true);

		unsafe = (Unsafe) unsafeField.get(null);

		return unsafe;
	}
}
