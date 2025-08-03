package Selenium;

import java.time.Duration;

import Selenium.OrangeHRM.BaseOrangeTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.nopCommercePage;

/**
 * Test class leveraging Page Object Model (POM) to separate page logic from test flow.
 * Verifies nopCommerce registration form validation using static data.
 */

public class POMTest extends BaseOrangeTest {
		
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
