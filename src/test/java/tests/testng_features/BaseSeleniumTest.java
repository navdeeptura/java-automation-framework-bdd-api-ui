package tests.testng_features;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseSeleniumTest {

    protected WebDriver driver;

    protected WebDriver getDriver() {
    	if (driver == null) {
            throw new IllegalStateException("WebDriver not initialized.");
        }

        try {
            driver.getTitle(); // sanity ping
        } catch (Exception e) {
            System.err.println("Browser died during test: " + e.getMessage());
            throw new IllegalStateException("Browser became unreachable.");
        }

        return driver;
    }
  

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
    	if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Warning: Browser already closed or unreachable. Skipping quit().");
         }
    }
}
    }