package pages.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HomePage extends BasePage {

    private final String DEMOQA_URL = "https://demoqa.com/";
    private final String pageTitle = "DEMOQA";

    private By elementsLocator = By.xpath("//div[@id='app']//h5[text()='Elements']");
    private By formsLocator = By.xpath("//div[@id='app']//h5[text()='Forms']");
    private By alertsLocator = By.xpath("//div[@id='app']//h5[text()='Alerts, Frame & Windows']");
    private By widgetsLocator = By.xpath("//div[@id='app']//h5[text()='Widgets']");
    private By interactionsLocator = By.xpath("//div[@id='app']//h5[text()='Interactions']");
    private By bookStoreAppLocator = By.xpath("//div[@id='app']//h5[text()='Book Store Application']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ElementsPage clickElements(){
        click(elementsLocator);
        return new ElementsPage(driver);
    }

    public FormsPage clickForms(){
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
