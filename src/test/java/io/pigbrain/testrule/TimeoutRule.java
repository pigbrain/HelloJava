package io.pigbrain.testrule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeoutRule {
	
	@Rule
	public Timeout timeOutRule = new Timeout(2);

	@Test
	public void timeOutTest() throws InterruptedException {
		
		// org.junit.runners.model.TestTimedOutException: test timed out after 2 milliseconds
		
		Thread.sleep(3 * 1000);
	}

	@Test
	public void infiniteLoopTest() {
		
		// org.junit.runners.model.TestTimedOutException: test timed out after 2 milliseconds
	
		while (true) {
			
		}
	}
}
