package pages.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import base.BasePage;
import utils.JavaScriptUtil;
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

    private By sportsCheckBoxLocator = By.id("hobbies-checkbox-1");
    private By readingCheckBoxLocator = By.id("hobbies-checkbox-2");
    private By musicCheckBoxLocator = By.id("hobbies-checkbox-3");



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
        JavaScriptUtil.jsClick(driver, el);
        return this;
    }

    public PracticeFormPage clickFemale(){
        WebElement el = find(femaleRadioButtonLocator);
        JavaScriptUtil.jsClick(driver, el);
        return this;
    }

    public boolean isFemaleSelected(){
        return find(femaleRadioButtonLocator).isSelected();
    }

    public PracticeFormPage clickOthers(){
        WebElement el = find(otherRadioButtonLocator);
        JavaScriptUtil.jsClick(driver, el);
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

    public boolean isSportsCheckboxSelected(){
        WebElement element = find(sportsCheckBoxLocator);
        return element.isSelected();
    }

    public void clickSportsCheckBox(){
        WebElement element = find(sportsCheckBoxLocator);
        JavaScriptUtil.scrollIntoView(driver, element);
        if (!isSportsCheckboxSelected()) {
            JavaScriptUtil.jsClick(driver, element);
        }
    }

    public void unclickSportsCheckBox(){
        WebElement element = find(sportsCheckBoxLocator);
        JavaScriptUtil.scrollIntoView(driver, element);
        if (element.isSelected()){
            JavaScriptUtil.jsClick(driver, element);
        }
    }

    public boolean isReadingCheckboxSelected(){
        WebElement element = find(readingCheckBoxLocator);
        return element.isSelected();
    }

    public void clickReadingCheckBox(){
        WebElement element = find(readingCheckBoxLocator);
        JavaScriptUtil.scrollIntoView(driver, element);
        if (!isReadingCheckboxSelected()) {
            JavaScriptUtil.jsClick(driver, element);
        }
    }

    public void unclickReadingCheckBox(){
        WebElement element = find(readingCheckBoxLocator);
        JavaScriptUtil.scrollIntoView(driver, element);
        if (element.isSelected()){
            JavaScriptUtil.jsClick(driver, element);
        }
    }

    public boolean isMusicCheckboxSelected(){
        WebElement element = find(musicCheckBoxLocator);
        return element.isSelected();
    }

    public void clickMusicCheckBox(){
        WebElement element = find(musicCheckBoxLocator);
        JavaScriptUtil.scrollIntoView(driver, element);
        if (!isReadingCheckboxSelected()) {
            JavaScriptUtil.jsClick(driver, element);
        }
    }

    public void unclickMusicCheckBox(){
        WebElement element = find(musicCheckBoxLocator);
        JavaScriptUtil.scrollIntoView(driver, element);
        if (element.isSelected()){
            JavaScriptUtil.jsClick(driver, element);
        }
    }
}
