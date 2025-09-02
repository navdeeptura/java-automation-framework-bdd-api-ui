package Selenium.DemoQA;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQA.FormsPage;
import pages.DemoQA.PracticeFormPage;

public class RadioButtonTest extends BaseDemoQATest{

    private String HOME_PAGE_TITLE = "DEMOQA";
    private String URL = "https://demoqa.com/forms";
    private String PRACTICE_FORM_URL = "https://demoqa.com/automation-practice-form";

    @Test
    public void verifyFormsURL(){
        Assert.assertEquals(homePage.getPageTitle(), HOME_PAGE_TITLE);
        FormsPage formsPage = homePage.clickForms();
        Assert.assertEquals(formsPage.getURL(), URL);
        formsPage.clickPracticeForm();
        Assert.assertEquals(formsPage.getURL(), PRACTICE_FORM_URL);
    }

    @Test
    public void browseToPracticeForm(){
        PracticeFormPage practiceFormPage = homePage.clickForms().clickPracticeForm();
        practiceFormPage.verifyURL();
        practiceFormPage.enterFirstName("FirstName");
        practiceFormPage.enterLastName("LastName");
        practiceFormPage.enterUserEmail("test@gmail.com");
        practiceFormPage.clickFemale();
        practiceFormPage.enterMobile("9998882222");
        Assert.assertTrue(practiceFormPage.isFemaleSelected());
    }

    @Test
    public void isRadioButtonSelectedTest() {
        PracticeFormPage practiceFP = homePage.clickForms().clickPracticeForm();
        practiceFP.enterFirstName("First").enterLastName("Last")
                .enterUserEmail("Email").clickOthers()
                .enterMobile("9999999999");
//        Thread.sleep(10000);
        Assert.assertFalse(practiceFP.isFemaleSelected());
        Assert.assertTrue(practiceFP.isOthersSelected());
    }
}
