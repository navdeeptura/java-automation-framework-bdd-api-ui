package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import drivers.Driver;

/**
 * Sample Selenium test class using TestNG to validate basic Google UI functionality.
 * Demonstrates grouped tests, priorities, and assertions.
 * Add merged this with Listener testng xml file
 */


public class SeleniumDummyTest {
	
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
	
	@Test(priority = 2, groups = {"ui", "selenium", "learning"})
	public void googleTitleTest() {
		driver.get("https://www.google.com/");
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	
	@Test(priority = 2, groups = {"ui", "selenium", "learning"})
	public void googleLogoTest() {
		driver.get("https://www.google.com/");
		By logoID = By.cssSelector("svg.lnXdpd");
		boolean logoStatus = driver.findElement(logoID).isDisplayed();
		Assert.assertEquals(logoStatus, true);
	}
	
	@Test(priority = 0, groups = {"ui", "selenium", "learning"}, enabled = false)
	public void googleSearchTest() throws InterruptedException {
		driver.get("https://www.google.com/");
		By textAreaLocator = By.xpath("//textarea[@id='APjFqb']");
		WebElement textAreaElement = driver.findElement(textAreaLocator);
		Assert.assertEquals(textAreaElement.isEnabled(), true);
		
		textAreaElement.sendKeys("Navdeep Tura");
		textAreaElement.sendKeys(Keys.ENTER);
		Thread.sleep(Duration.ofSeconds(30));
		
		String expectedTitle = "Navdeep Tura - Google Search";
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
	
	@Test(priority = 1, groups = {"ui", "selenium", "learning"})
	public void googleStoreLink() {
		driver.get("https://www.google.com/");
		By aboutLinkLocator = By.linkText("Store");
		driver.findElement(aboutLinkLocator).click();
		
		String expectedAddMessage = "Google Store for Google Made Devices & Accessories";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedAddMessage, "Title Not Matching");
		Assert.assertTrue(false); // intentionally failing
	}

}
