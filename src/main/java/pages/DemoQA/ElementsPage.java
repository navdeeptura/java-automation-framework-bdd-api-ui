package pages.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import org.openqa.selenium.WebElement;
import utils.JavaScriptUtil;

public class ElementsPage extends BasePage {

    private final String URL = "https://demoqa.com/elements";
    private final String title = "DEMOQA";
    private final By webTablesLocator = By.xpath(
            "//li[@id='item-3']//span[text()='Web Tables']");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public WebTablesPage clickWebTable(){
        WebElement element = find(webTablesLocator);
        JavaScriptUtil.scrollIntoView(driver, element);
        click(webTablesLocator);
        return new WebTablesPage(driver);
    }







}
