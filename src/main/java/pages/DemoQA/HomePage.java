package pages.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utils.JavaScriptUtil;

public class HomePage extends BasePage {

    private final String DEMOQA_URL = "https://demoqa.com/";
    private final String pageTitle = "DEMOQA";

    private final By elementsLocator = By.xpath(
            "//div[@id='app']//h5[text()='Elements']");
    private final By formsLocator = By.xpath("//div[@id='app']//h5[text()='Forms']");
    private final By alertsLocator = By.xpath("//div[@id='app']//h5[text()='Alerts, Frame & Windows']");
    private final By widgetsLocator = By.xpath("//div[@id='app']//h5[text()='Widgets']");
    private final By interactionsLocator = By.xpath("//div[@id='app']//h5[text()='Interactions']");
    private final By bookStoreAppLocator = By.xpath("//div[@id='app']//h5[text()='Book Store Application']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ElementsPage clickElements(){
        JavaScriptUtil.jsClick(driver, find(elementsLocator));
        return new ElementsPage(driver);
    }

    public FormsPage clickForms(){
        JavaScriptUtil.scrollIntoView(driver, find(formsLocator));
        click(formsLocator);
        return new FormsPage(driver);
    }

    public void clickAlerts(){
        click(alertsLocator);
    }
    public void clickInteractions(){
        click(interactionsLocator);
    }
    public void clickWidgets(){
        click(widgetsLocator);
    }
    public void clickBookStoreApp(){
        click(bookStoreAppLocator);
    }

}
