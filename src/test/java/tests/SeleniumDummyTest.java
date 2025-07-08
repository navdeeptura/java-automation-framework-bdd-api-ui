package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SeleniumDummyTest extends BaseSeleniumTest{

	
	@Test(priority = 2, groups = {"ui", "selenium", "learning"})
	public void googleTitleTest() {
		getDriver().get("https://www.google.com/");
		Assert.assertEquals(getDriver().getTitle(), "Google");
	}
	
	@Test(priority = 2, groups = {"ui", "selenium", "learning"})
	public void googleLogoTest() {
		getDriver().get("https://www.google.com/");
		By logoID = By.cssSelector("svg.lnXdpd");
		boolean logoStatus = getDriver().findElement(logoID).isDisplayed();
		Assert.assertEquals(logoStatus, true);
	}
	
	@Test(priority = 0, groups = {"ui", "selenium", "learning"}, enabled = false)
	public void googleSearchTest() throws InterruptedException {
		getDriver().get("https://www.google.com/");
		By textAreaLocator = By.xpath("//textarea[@id='APjFqb']");
		WebElement textAreaElement = getDriver().findElement(textAreaLocator);
		Assert.assertEquals(textAreaElement.isEnabled(), true);
		
		textAreaElement.sendKeys("Navdeep Tura");
		textAreaElement.sendKeys(Keys.ENTER);
		Thread.sleep(Duration.ofSeconds(30));
		
		String expectedTitle = "Navdeep Tura - Google Search";
		Assert.assertEquals(getDriver().getTitle(), expectedTitle);
	}
	
	@Test(priority = 1, groups = {"ui", "selenium", "learning"})
	public void googleStoreLink() {
		getDriver().get("https://www.google.com/");
		By aboutLinkLocator = By.linkText("Store");
		getDriver().findElement(aboutLinkLocator).click();
		
		String expectedAddMessage = "Google Store for Google Made Devices & Accessories";
		String actualTitle = getDriver().getTitle();
		Assert.assertEquals(actualTitle, expectedAddMessage, "Title Not Matching");
	}

}
