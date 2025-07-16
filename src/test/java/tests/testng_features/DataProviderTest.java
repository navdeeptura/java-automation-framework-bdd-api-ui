package tests.testng_features;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.nopCommercePage;

public class DataProviderTest extends BaseSeleniumTest{
	
	
	
	
	@Test
	public void dataProviderTest() throws InterruptedException {
		String url = "https://demo.nopcommerce.com/register?returnUrl=%2Fcomputers";		
		driver.get(url);
		nopCommercePage page = new nopCommercePage(driver);
		
		page.selectGenderMale();
		page.enterFirstName("Nav");
		page.enterLastName("Tu");
		page.enterEmail("nav@gmail.com");
		page.enterCompany("comp");
		page.clickRegister();
		
		// Assert – verify confirm password error message
		Assert.assertTrue(page.verifyConfirmPasswordErrorMessage(), "Expected error message not displayed");
		
		Thread.sleep(Duration.ofSeconds(10));
	}

}
