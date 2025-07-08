package tests;

import java.time.LocalDate;

import org.testng.annotations.Test;

public class InvocationTest {
	
	@Test(invocationCount = 15, threadPoolSize = 5)
	public void invocationSampleTest() {
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
	}
	

}
