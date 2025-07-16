package tests.testng_features;

import java.time.LocalDate;

import org.testng.annotations.Test;

public class InvocationTest {
	
	@Test(invocationCount = 5, threadPoolSize = 2)
	public void invocationSampleTest() {
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
	}
	
	

}
