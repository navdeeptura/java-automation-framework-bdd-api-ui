package utils;

import org.openqa.selenium.*;

public final class JavaScriptUtil {

    public static void scrollIntoView(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String jsScript = "arguments[0].scrollIntoView(true);";
        js.executeScript(jsScript, element);
    }

    public static void jsClick(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String jsScript = "arguments[0].click();";
        js.executeScript(jsScript, element);
    }
}
