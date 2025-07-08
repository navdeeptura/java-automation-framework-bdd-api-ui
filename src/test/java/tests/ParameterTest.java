package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterTest {
	
	WebDriver driver;
	
	@Test(groups = {"learning"}, invocationCount = 5, threadPoolSize = 2)
	@Parameters({"browser", "url", "username"})
	public void parameterCheck(
			@Optional("chrome") String browser, 
			@Optional("https://login.yahoo.com/") String url,
			@Optional("nonsence@gmail.com") String username
			) throws InterruptedException {
		
		if (browser.equals("edge")){
			driver = WebDriverManager.edgedriver().create();
		} else if(browser.equals("chrome")){
			driver = WebDriverManager.chromedriver().create();
		}

		driver.get(url);
		WebElement userNameLocator = driver.findElement(By.id("login-username"));
		userNameLocator.clear();
		userNameLocator.sendKeys(username);
		
		
		driver.quit();

	}

}
