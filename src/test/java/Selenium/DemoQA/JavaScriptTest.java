package Selenium.DemoQA;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQA.FormsPage;

public class JavaScriptTest extends BaseDemoQATest{

    private String FORMS_PAGE_TITLE = "DEMOQA";
    private String FORMS_PAGE_URL = "https://demoqa.com/forms";


    @Test
    public void scrollToFormsPageTest(){
        FormsPage formsPage = homePage.clickForms();
        String url = formsPage.getURL();
        String pageTitle = formsPage.getPageTitle();

        Assert.assertEquals(url, FORMS_PAGE_URL);
        Assert.assertEquals(pageTitle, FORMS_PAGE_TITLE);
    }
}
