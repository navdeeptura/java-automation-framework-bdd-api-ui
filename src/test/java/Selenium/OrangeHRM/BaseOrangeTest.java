package Selenium.OrangeHRM;

import drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.OrangeHRM.OrangeHRMLoginPage;

public class BaseOrangeTest {

    protected WebDriver driver;
    protected OrangeHRMLoginPage loginPage;


    @BeforeMethod
    public void setUP(){
        Driver.initDriver("chrome");
        driver = Driver.getDriver();
        loginPage = new OrangeHRMLoginPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
