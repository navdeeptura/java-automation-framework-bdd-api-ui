package pages.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.BasePage;
import utils.JSUtil;
import utils.PropertiesReader;

public class PracticeFormPage extends BasePage {

    private String URL = PropertiesReader.get("PRACTICE_FORM_URL");
    private By firstNameLocator = By.id("firstName");
    private By lastNameLocator = By.id("lastName");
    private By userEmailLocator = By.id("userEmail");
    private By maleRadioButtonLocator = By.id("gender-radio-1");
    private By femaleRadioButtonLocator = By.id("gender-radio-2");
    private By otherRadioButtonLocator = By.id("gender-radio-3");
    private By mobileNumberLocator = By.id("userNumber");
    private By subjectsLocator = By.id("subjectsContainer");


    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void verifyURL(){
        Assert.assertEquals(getURL(), URL);
    }

    public PracticeFormPage enterFirstName(String text){
        type(firstNameLocator, text);
        return this;
    }

    public PracticeFormPage enterLastName(String text){
        type(lastNameLocator, text);
        return this;
    }

    public PracticeFormPage enterUserEmail(String text){
        type(userEmailLocator, text);
        return this;
    }

    public PracticeFormPage clickMale(){
        WebElement el = find(maleRadioButtonLocator);
        JSUtil.jsClick(driver, el);
        return this;
    }

    public PracticeFormPage clickFemale(){
        WebElement el = find(femaleRadioButtonLocator);
        JSUtil.jsClick(driver, el);
        return this;
    }

    public boolean isFemaleSelected(){
        return find(femaleRadioButtonLocator).isSelected();
    }

    public PracticeFormPage clickOthers(){
        WebElement el = find(otherRadioButtonLocator);
//        JSUtil.scrollIntoView(driver, el);
        JSUtil.jsClick(driver, el);
        return this;
    }

    public boolean isOthersSelected(){
        return find(otherRadioButtonLocator).isSelected();
    }

    public PracticeFormPage enterMobile(String text){
        type(mobileNumberLocator, text);
        return this;
    }

    public PracticeFormPage enterSubjects(String text){
        type(subjectsLocator, text);
        return this;
    }














}
