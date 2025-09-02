package pages.OrangeHRM;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OrangeHRMLoginPage extends BasePage {

    private static final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private final By userNameLocator = By.name("username");
    private final By passwordLocator = By.name("password");
    private final By loginButtonLocator = By.cssSelector("button.oxd-button[type='submit']");
    private final String pageTitle = "OrangeHRM";

    public OrangeHRMLoginPage(WebDriver driver){
        super(driver);
    }

    public void browseToURL(){
        driver.get(url);
        verifyPageTitle();
    }

    public void enterUserName(String userName){
        type(userNameLocator, userName);
    }

    public void enterPassword(String password){
        type(passwordLocator, password);
    }

    public OrangeDashboardPage clickLoginButton(){
        click(loginButtonLocator);
        return new OrangeDashboardPage(driver);
    }

    public void verifyPageTitle(){
        Assert.assertEquals(getPageTitle(), pageTitle);
    }

    public OrangeDashboardPage loginValidator(String userName, String password){
        this.verifyPageTitle();;
        this.enterUserName(userName);
        this.enterPassword(password);
        return this.clickLoginButton();
    }
}
