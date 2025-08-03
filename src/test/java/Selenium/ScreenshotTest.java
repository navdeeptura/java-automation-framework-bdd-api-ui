package Selenium;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import drivers.Driver;

/**
 * This TestNG test class demonstrates screenshot capture on test failure.
 * It uses {@link utils.ScreenshotOnFailure} as a TestNG listener.
 * 
 * The test intentionally fails to trigger screenshot functionality.
 * Screenshots are saved using WebDriver's TakesScreenshot API.
 * 
 * @author Navdeep T
 * @since 2025-07-21
 */

@Listeners({utils.ScreenshotOnFailure.class})
public class ScreenshotTest {
	
	
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
	public void takeScreenshot() {
		driver.get("https://mvnrepository.com/artifact/commons-io/commons-io/2.20.0");
		Assert.assertEquals(true, false);
	}

}
