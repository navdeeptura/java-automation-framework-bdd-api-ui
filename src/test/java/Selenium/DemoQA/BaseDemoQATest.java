package Selenium.DemoQA;

import drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DemoQA.HomePage;

public class BaseDemoQATest {

    protected HomePage homePage;
    private final String DEMOQA_URL = "https://demoqa.com/";

    @BeforeMethod
    public void setUp(){
        Driver.initDriver("chrome");
        WebDriver driver = Driver.getDriver();
        homePage = new HomePage(driver);
        homePage.navigateTo(DEMOQA_URL);
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}
