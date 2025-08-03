package TestNG;

import java.time.LocalDate;

import org.testng.annotations.Test;

/**
 * Demonstrates use of TestNG invocationCount and threadPoolSize for 
 * repeated parallel test execution.
 */

public class InvocationTest {
	
	@Test(invocationCount = 5, threadPoolSize = 2)
	public void invocationSampleTest() {
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
	}
	
	

}
