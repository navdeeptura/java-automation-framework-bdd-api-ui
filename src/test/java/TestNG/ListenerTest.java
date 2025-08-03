package TestNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import drivers.Driver;


/**
 * Test class to verify screenshot capture on failure using a TestNG listener.
 */

@Listeners({utils.ScreenshotOnFailure.class})
public class ListenerTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		Driver.initDriver("chrome");
		driver = Driver.getDriver();
		
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}
	
	@Test
	public void screenshotTest() {
		driver.get("https://mvnrepository.com/open-source/defect-detection-metadata");
		Assert.assertTrue(false);
	}
	
	
	

}
