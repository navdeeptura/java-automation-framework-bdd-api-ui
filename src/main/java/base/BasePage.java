package base;

import java.time.Duration;

import org.openqa.selenium.*;
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
	
	public void navigateTo(String url) {
		driver.get(url);
		waitForPageLoad();
	}

	public String getURL(){ return driver.getCurrentUrl(); }

	// === FIND Element ===
	protected WebElement find(By locator){
		return driver.findElement(locator);
	}

	// ==== WAIT UTILITIES ====
    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

	protected WebElement waitForPresence(By locator){
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	protected boolean waitForPageLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String state = js.executeScript("return document.readyState").toString();
		return state.equals("complete");
	}


	// ==== Basic Actions ====
	protected void click(By locator) {
		waitForClickable(locator).click();
	}
	
	protected void type(By locator, String text) {
		WebElement element = waitForPresence(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	protected String getText(By locator) {
		return waitForVisibility(locator).getText();
	}
	
	protected String getAttribute(By locator, String attribute) {
		return waitForVisibility(locator).getAttribute(attribute);
	}
	
	protected boolean isDisplayed(By locator) {
		try{
			return waitForVisibility(locator).isDisplayed();
		} catch (TimeoutException | NoSuchElementException e){
			return false;
		}
	}

	// ==== DROPDOWN HANDLING ====
    protected void selectByVisibleText(By locator, String text) {
        WebElement dropdown = waitForVisibility(locator);
        new Select(dropdown).selectByVisibleText(text);
    }

	public static void delay(int milliseconds){
		try{
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
