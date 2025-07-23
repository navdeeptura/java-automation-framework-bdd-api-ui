package drivers;

import org.openqa.selenium.WebDriver;


/**
 * Manages WebDriver instances using ThreadLocal for safe parallel test execution.
 */


public class Driver {
	
	public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static void initDriver(String browser) {
		if (driver.get() == null) {
			WebDriver webDriver = DriverFactory.createDriver(browser);
			driver.set(webDriver);
		}
	}
	
	public static WebDriver getDriver() {
//		if (driver.get() == null) {
//			throw new IllegalStateException("Webdriver not initialied, Call initDriver()");
//		}
		return driver.get();
	}
	
	public static void quitDriver() {
		 WebDriver webDriver = driver.get();
		 if (webDriver != null) {
			driver.get().quit();
			driver.remove();
		}
	}

}
