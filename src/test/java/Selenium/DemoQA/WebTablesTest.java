package Selenium.DemoQA;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQA.WebTablesPage;

public class WebTablesTest extends BaseDemoQATest{

    private final String URL = "https://demoqa.com/webtables";
    private final String title = "DEMOQA";

    @Test
    public void workWithTablesTest(){
        WebTablesPage webTablesPage = homePage.clickElements().clickWebTable();
        String actualURL = webTablesPage.getURL();
        Assert.assertEquals(actualURL, URL);
    }
}
