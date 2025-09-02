package Selenium.DemoQA;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQA.PracticeFormPage;

public class CheckBoxTest extends BaseDemoQATest{

    @Test
    public void testCheckBoxSelectedOrUnSelected(){
        PracticeFormPage practiceFormPage = homePage.clickForms().clickPracticeForm();

        practiceFormPage.clickSportsCheckBox();
        Assert.assertTrue(practiceFormPage.isSportsCheckboxSelected());
        practiceFormPage.unclickSportsCheckBox();
        Assert.assertFalse(practiceFormPage.isSportsCheckboxSelected());

        practiceFormPage.clickReadingCheckBox();
        Assert.assertTrue(practiceFormPage.isReadingCheckboxSelected());
        practiceFormPage.unclickReadingCheckBox();
        Assert.assertFalse(practiceFormPage.isReadingCheckboxSelected());

        practiceFormPage.clickMusicCheckBox();
        Assert.assertTrue(practiceFormPage.isMusicCheckboxSelected());
        practiceFormPage.unclickMusicCheckBox();
        Assert.assertFalse(practiceFormPage.isMusicCheckboxSelected());
    }
}