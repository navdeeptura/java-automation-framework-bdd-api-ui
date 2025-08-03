package Selenium.DemoQA;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQA.ElementsPage;

public class ElementsTest extends BaseDemoQATest {

    private String URL = "https://demoqa.com/elements";

    @Test
    public void verifyElementsURL(){
        Assert.assertEquals(homePage.getPageTitle(), "DEMOQA");
        ElementsPage elementsPage = homePage.clickElements();
        Assert.assertEquals(elementsPage.getURL(), URL);
    }
}
