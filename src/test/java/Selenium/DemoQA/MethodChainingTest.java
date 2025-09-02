package Selenium.DemoQA;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQA.PracticeFormPage;

public class MethodChainingTest extends BaseDemoQATest{

    @Test
    public void chainFillPracticeForm() {

        //Reach practice form in single line
        PracticeFormPage practiceFP = homePage.clickForms().clickPracticeForm();

        // fill all the form fields at once
        practiceFP.enterFirstName("First").enterLastName("Last")
                .enterUserEmail("Email").clickOthers()
                .enterMobile("9999999999");

        Assert.assertFalse(practiceFP.isFemaleSelected());
        Assert.assertTrue(practiceFP.isOthersSelected());
    }
}
