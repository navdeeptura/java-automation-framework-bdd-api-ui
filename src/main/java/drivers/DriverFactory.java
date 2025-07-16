package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static WebDriver createDriver(String browser) {
		
		switch(browser.toLowerCase()) {

		case "edge":
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver(DriverOptions.getEdgeOptions());

        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver(DriverOptions.getFirefoxOptions());

        case "safari":
            // SafariDriver doesn't require WebDriverManager setup on macOS
            return new SafariDriver(DriverOptions.getSafariOptions());
		
        case "chrome":
        	default:
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(DriverOptions.getChromeOptions());
		}
		
	}

}
