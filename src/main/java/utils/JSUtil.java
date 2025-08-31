package utils;

import org.openqa.selenium.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class JSUtil {

    public static void jsClick(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void scrollIntoView(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
