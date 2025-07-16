package drivers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class DriverOptions {
	
	public static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        return options;
	}
	
	public static EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--inprivate");
        return options;
	}
	
	public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");
        options.addArguments("--private");
        return options;
    }

	
	public static SafariOptions getSafariOptions() {
        SafariOptions options = new SafariOptions();
        // Safari has limited options; placeholder for future config
        return options;
    }

}