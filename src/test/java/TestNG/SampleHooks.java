package TestNG;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;

/**
 * TestNG hook class demonstrating suite-level and group-level setup and teardown.
 */

public class SampleHooks {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite -- Prepare environment");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite -- Clean environment");
	}
	
	@BeforeGroups("smoke")
	public void beforeGroupsSmoke() {
		System.out.println("@BeforeGroups -- Setup Smoke Tests");
	}
	
	@AfterGroups("smoke")
	public void afterSmokeGroups() {
		System.out.println("@AfterGroups -- Clean Smoke Tests");
	}


}
