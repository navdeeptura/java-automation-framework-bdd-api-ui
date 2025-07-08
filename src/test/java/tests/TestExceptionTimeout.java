package tests;


import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class TestExceptionTimeout {
	
	
	@Test
	public void sanityTest() {
	    System.out.println(">>> sanityTest in TestExceptionTimeout is running");
	}
	
	@Test(timeOut = 3000, groups = {"timeout", "learning"})
	public void infiniteLoopTest() throws InterruptedException {
		 Thread.sleep(5000);
		}
	
	
	@Test(timeOut = 3000, groups = {"timeout", "learning"})
	public void infiniteLoopTest2() {
		int i = 0;
		int counter = 0;
		while (i < 10) {
			System.out.println("Loop 2 : " + counter);
			counter += 1;
			i += 1;
		}
	}
	
	@Test(timeOut = 3000, expectedExceptions = ThreadTimeoutException.class, groups = {"timeout", "learning"})
	public void infiniteLoopTest3() throws InterruptedException {
		 Thread.sleep(5000);
	}
	
	

}
