package tests.testng_features;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryListenerTest {
	
//	@Test(retryAnalyzer = utils.RetryAnalyzer.class)
	
	@Test
	public void test1() {
		System.out.println("Retry");
		Assert.assertTrue(false);
	}

}
