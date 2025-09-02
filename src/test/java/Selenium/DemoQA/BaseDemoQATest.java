package Selenium.DemoQA;

import drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DemoQA.HomePage;

import static base.BasePage.delay;

public class BaseDemoQATest {

    protected WebDriver driver;
    protected HomePage homePage;
    private final String DEMOQA_URL = "https://demoqa.com/";

    @BeforeMethod
    public void setUp(){
        Driver.initDriver("chrome");
        this.driver = Driver.getDriver();
        homePage = new HomePage(driver);
        homePage.navigateTo(DEMOQA_URL);
    }

    @AfterMethod
    public void tearDown(){
//        delay(50000);
        Driver.quitDriver();
    }
}
