package io.pigbrain.util;

import org.junit.Test;

import org.junit.Assert;


public class UnsafeBoxTest {

	@Test
	public void allocateInsatnceTest() throws Exception {
		
		UnsafeBox unsafeBox = new UnsafeBox();
		Temp instance = (Temp) unsafeBox.allocateInsatnce(Temp.class);
		
		Assert.assertEquals(0, instance.getA());
	}
	
	@Test
	public void objectFieldOffsetTest() throws Exception {

		UnsafeBox unsafeBox = new UnsafeBox();
		
		Temp t = new Temp();
		
		Assert.assertEquals(8, unsafeBox.objectFieldOffset(t, "a"));
		Assert.assertEquals(12, unsafeBox.objectFieldOffset(t, "b"));
		Assert.assertEquals(16, unsafeBox.objectFieldOffset(t, "c"));
	}
	
	@Test
	public void sizeOfTest() throws Exception {

		UnsafeBox unsafeBox = new UnsafeBox();
		
		Temp t = new Temp();
		
		Assert.assertEquals(24, unsafeBox.sizeOf(t));
	}
	
	class Temp {
		private int a;
		private int b;
		private char c;
		
		public Temp() {
			a = 1;
		}
		
		public int getA() {
			return a;
		}
	}
}
