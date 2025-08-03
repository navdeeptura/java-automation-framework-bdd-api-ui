package TestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.Driver;

/**
 * Test class demonstrating TestNG @Parameters and @Optional for runtime data injection.
 * and also implement groups
 */

public class ParameterTest {
	
	WebDriver driver;
		
	@Test(groups = {"learning"}, invocationCount = 5, threadPoolSize = 1)
	@Parameters({"browser", "url", "username"})
	public void parameterCheck(
			@Optional("chrome") String browser, 
			@Optional("https://login.yahoo.com/") String url,
			@Optional("nonsence@gmail.com") String username
			) throws InterruptedException {
		
		Driver.initDriver(browser);
		driver = Driver.getDriver();

		driver.get(url);
		WebElement userNameLocator = driver.findElement(By.id("login-username"));
		userNameLocator.clear();
		userNameLocator.sendKeys(username);
		
		
		Driver.quitDriver();

	}

}
