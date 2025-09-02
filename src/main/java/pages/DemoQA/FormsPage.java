package pages.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class FormsPage extends BasePage {

    private By practiceFormLocator = By.xpath(
            "//li[@id='item-0']//span[text()='Practice Form']");


    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public PracticeFormPage clickPracticeForm(){
        click(practiceFormLocator);
        return new PracticeFormPage(driver);
    }
}
