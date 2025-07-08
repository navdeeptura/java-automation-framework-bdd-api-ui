package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testSampleTestNGClass {
	

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass -- Launch Browser");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@beforeMethod -- Login to Application");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest -- Login to Application");
	}
	
	@Test(groups = {"annotations", "learning"})
	public void testHelloWorld() {
		boolean value = "Hello".equals("Hello") ;
		System.out.println("@Test - Execute TestCase");
		Assert.assertEquals(value, true);
	}
	
	@Test(groups = {"annotations", "learning"})
	public void testHelloWorld2() {
		boolean value = "Hello".equals("Hello") ;
		System.out.println("@Test - Execute TestCase 2");
		Assert.assertEquals(value, true);
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest - Logout from Application");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod -- Quit Driver");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass -- clean test Data");
	}
	

}
