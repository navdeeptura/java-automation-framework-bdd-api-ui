package base;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Base class for all page objects, providing reusable WebDriver utilities such as:
 * - Navigation and page title retrieval
 * - Waits for visibility and clickability
 * - Click, type, and getText operations
 * - Dropdown selection
 * - Element hover, scroll, and JavaScript click
 * - Attribute fetching and element visibility check
 */


public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void browseToPage(String url) {
		driver.get(url);
	}
	
	// 🔹 Wait for visibility only
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // 🔹 Wait for element to be clickable
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
	
	public void click(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public void type(By locator, String text) {
		WebElement element = waitForVisibility(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	public String getText(By locator) {
		return waitForVisibility(locator).getText();
	}
	
	public String getAttribute(By locator, String attribute) {
		return waitForVisibility(locator).getAttribute(attribute);
	}
	
	public boolean isElementDisplayed(By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
	}
	
	// 🔹 Select from dropdown (visible text)
    public void selectByVisibleText(By locator, String visibleText) {
        WebElement dropdown = waitForVisibility(locator);
        new Select(dropdown).selectByVisibleText(visibleText);
    }
    
    public void hoverOver(By locator) {
    	WebElement element = waitForVisibility(locator);
    	new Actions(driver).moveToElement(element).perform();
    }
    
    public void scrollToElement(By locator) {
    	WebElement element = waitForVisibility(locator);
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    public void jsClick(By locator) {
    	WebElement element = waitForClickable(locator);
    	((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }
}
