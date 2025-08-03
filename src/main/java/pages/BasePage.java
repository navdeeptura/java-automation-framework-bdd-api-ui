package pages;

import java.time.Duration;

import org.openqa.selenium.*;
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
		waitForPageLoad();
	}

	public String getURL(){ return driver.getCurrentUrl(); }

	public WebElement find(By locator){
		return driver.findElement(locator);
	}

	// ==== WAIT UTILITIES ====
    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

	protected WebElement waitPresenceOfElement(By locator){
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	protected void waitForPageLoad() {
		wait.until(
				driver -> ((JavascriptExecutor) driver)
						.executeScript("return document.readyState").equals("complete")
		);
	}


	// ==== ACTION UTILITIES ====
	protected void click(By locator) {
		try {
			scrollToElementPresenceWait(locator);
			waitForClickable(locator).click();
		} catch (ElementNotInteractableException | TimeoutException e) {
			clickJS(locator);
		}
	}

	protected void clickJS(By locator) {
		WebElement element = waitPresenceOfElement(locator);
		scrollToElementNoWait(locator);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	protected void type(By locator, String text) {
		WebElement element = waitPresenceOfElement(locator);
		scrollToElementNoWait(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	protected String getText(By locator) {
		return waitForVisibility(locator).getText();
	}
	
	protected String getAttribute(By locator, String attribute) {
		return waitForVisibility(locator).getAttribute(attribute);
	}
	
	protected boolean isElementDisplayed(By locator) {
		try{
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
		} catch (TimeoutException | NoSuchElementException e){
			return false;
		}
	}

	// ==== DROPDOWN HANDLING ====
    protected void selectByVisibleText(By locator, String visibleText) {
        WebElement dropdown = waitForVisibility(locator);
        new Select(dropdown).selectByVisibleText(visibleText);
    }


	// ==== ADVANCED ACTIONS ====
	protected void hoverOver(By locator) {
    	WebElement element = waitPresenceOfElement(locator);
    	new Actions(driver).moveToElement(element).perform();
    }
    
    protected void scrollToElement(By locator) {
    	WebElement element = waitForVisibility(locator);
    	((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
    }

	protected void scrollToElementNoWait(By locator) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", find(locator));
	}

	protected void scrollToElementPresenceWait(By locator) {
		WebElement element = waitPresenceOfElement(locator);
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
	}

	public void delay(int milliseconds){
		try{
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
