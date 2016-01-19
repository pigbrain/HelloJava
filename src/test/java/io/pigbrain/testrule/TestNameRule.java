package io.pigbrain.testrule;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestNameRule {
	
	@Rule
	public TestName testNameRule = new TestName();

	@Test
	public void testMethod1() {
		Assert.assertEquals("testMethod1", testNameRule.getMethodName());
	}

	@Test
	public void testMethod2() {
		Assert.assertEquals("testMethod2", testNameRule.getMethodName());
	}
}
