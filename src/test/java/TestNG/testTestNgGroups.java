package TestNG;

import Selenium.OrangeHRM.BaseOrangeTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Demonstrates usage of TestNG groups by running multiple grouped test methods 
 * using a common setup.
 */

public class testTestNgGroups extends BaseOrangeTest {

		
	@Test(groups = "learning")
	public void groupTest() {
		driver.get("https://www.google.com/");
		String expectedTitle = "Google";
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Title not Found");
	}
	
	@Test(groups = "learning")
	public void groupTest2() {
		driver.get("https://www.google.com/");
		String expectedTitle = "Google";
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Title not Found");
	}
	
	@Test(groups = "learning")
	public void groupTest3() {
		driver.get("https://www.google.com/");
		String expectedTitle = "Google";
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Title not Found");
	}
	
	@Test(groups = "learning")
	public void groupTest4() {
		driver.get("https://www.google.com/");
		String expectedTitle = "Google";
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Title not Found");
	}
	
	@Test(groups = "learning")
	public void groupTest5() {
		driver.get("https://www.google.com/");
		String expectedTitle = "Google";
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Title not Found");
	}
	
	@Test(groups = "learning")
	public void groupTest6() {
		driver.get("https://www.google.com/");
		String expectedTitle = "Google";
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Title not Found");
	}
	
}
