package io.pigbrain.testrule;


import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;


public class ErrorCollectorRule {
	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void example() throws Exception {

		// If cases are failed, it will not be stopped. continued...
		collector.checkThat("first example", 1, CoreMatchers.equalTo(2)); // false
		collector.checkThat("second example", "A", CoreMatchers.equalTo("b")); // false
		collector.checkThat("third example", "A", CoreMatchers.equalTo("A")); // true
		collector.checkThat("firth example", 10L, CoreMatchers.equalTo(11L)); // false
	}
	
}
