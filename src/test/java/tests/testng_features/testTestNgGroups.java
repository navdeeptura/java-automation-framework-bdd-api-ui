package tests.testng_features;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Demonstrates usage of TestNG groups by running multiple grouped test methods 
 * using a common setup.
 */

public class testTestNgGroups extends BaseSeleniumTest {
	
		
	@Test(groups = "learning")
	public void groupTest() {
		getDriver().get("https://www.google.com/");
		String expectedTitle = "Google";
		Assert.assertEquals(getDriver().getTitle(), expectedTitle, "Title not Found");
	}
	
	@Test(groups = "learning")
	public void groupTest2() {
		getDriver().get("https://www.google.com/");
		String expectedTitle = "Google";
		Assert.assertEquals(getDriver().getTitle(), expectedTitle, "Title not Found");
	}
	
	@Test(groups = "learning")
	public void groupTest3() {
		getDriver().get("https://www.google.com/");
		String expectedTitle = "Google";
		Assert.assertEquals(getDriver().getTitle(), expectedTitle, "Title not Found");
	}
	
	@Test(groups = "learning")
	public void groupTest4() {
		getDriver().get("https://www.google.com/");
		String expectedTitle = "Google";
		Assert.assertEquals(getDriver().getTitle(), expectedTitle, "Title not Found");
	}
	
	@Test(groups = "learning")
	public void groupTest5() {
		getDriver().get("https://www.google.com/");
		String expectedTitle = "Google";
		Assert.assertEquals(getDriver().getTitle(), expectedTitle, "Title not Found");
	}
	
	@Test(groups = "learning")
	public void groupTest6() {
		getDriver().get("https://www.google.com/");
		String expectedTitle = "Google";
		Assert.assertEquals(getDriver().getTitle(), expectedTitle, "Title not Found");
	}
	
}
