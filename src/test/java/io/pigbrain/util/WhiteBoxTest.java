package io.pigbrain.util;

import org.junit.Assert;
import org.junit.Test;

public class WhiteBoxTest {

	
	@Test
	public void whiteBoxTest() throws Throwable {

		Temp temp = new Temp();
		
		Assert.assertTrue(4 == WhiteBox.<Integer>invokeMethod(temp, "getPrivateInt", new Integer(4)));
		Assert.assertTrue(3 == WhiteBox.<Integer>invokeMethod(temp, "getPublicInt", new Integer(3)));
	}
	
	class Temp {
		
		public int getPublicInt(int a) {
			return a;
		}
		
		private int getPrivateInt(int a) {
			return a;
		}
	}
	
}
