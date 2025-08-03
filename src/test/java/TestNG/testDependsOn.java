package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Demonstrates TestNG method dependencies using dependsOnMethods annotation.
 */

public class testDependsOn {
	
	@Test(groups = {"learning"})
	public void testLogin() {
		System.out.println("Login Test");
		Assert.assertEquals(true, false, "Assertion is failing - Custom");
	}
	
	@Test(dependsOnMethods = "testLogin", groups = {"learning"})
	public void homePage() {
		System.out.println("Home Page Test");
	}
	
	@Test(dependsOnMethods = "testLogin")
	public void dashboardPage() {
		System.out.println("Dashboard Page Test");
	}
	

}
