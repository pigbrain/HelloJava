package io.pigbrain.testrule;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestWatcherRule {

	@Rule
	public TestWatcher watchman = new TestWatcher() {

		@Override
		protected void failed(Throwable e, Description description) {
			System.err.println("unit test is failed. description : " + description.getMethodName());
		}

		@Override
		protected void succeeded(Description description) {
			System.err.println("unit test is passed. description : " + description.getMethodName());
		}
	};

	@Test
	public void fail1() {
		fail();
	}

	@Test
	public void fail2() {
		fail();
	}

	@Test
	public void success1() {

	}

	@Test
	public void success2() {

	}
}
