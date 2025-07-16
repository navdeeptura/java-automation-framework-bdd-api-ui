package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class nopCommercePage extends BasePage {
	
	private static final String url = "https://demo.nopcommerce.com/register?returnUrl=%2Fcomputers";
	private By genderMaleLocator = By.id("gender-male");
	private By genderFemaleLocator = By.id("gender-female");
	private By firstNameLocator = By.id("FirstName");
	private By lastNameLocator = By.id("LastName");
	private By emailLocator = By.id("Email");
	private By companyLocator = By.id("Company");
	private By confirmPasswordErrorLocator = By.id("ConfirmPassword-error");
	private String confirmPasswordErrorMessage = "Password is required.";
	private By registerButtonLocator = By.id("register-button");
	
	
	public nopCommercePage(WebDriver driver) {
		super(driver);  // Pass WebDriver to BasePage
	}
	
	
	public void selectGenderMale() {
		click(genderMaleLocator);
	}
	
	public void selectGenderFemale() {
		click(genderFemaleLocator);
	}
	
	public void enterFirstName(String firstName) {
		type(firstNameLocator, firstName);
	}
	
	public void enterLastName(String lastName) {
		type(lastNameLocator, lastName);
	}
	
	public void enterEmail(String email) {
		type(emailLocator, email);
	}
	
	public void enterCompany(String company) {
		type(companyLocator, company);
	}
	
	public boolean verifyConfirmPasswordErrorMessage() {
		String actualText = getText(confirmPasswordErrorLocator);
		return actualText.equals(confirmPasswordErrorMessage);
	}
	
	public void clickRegister() {
	    click(registerButtonLocator);
	}
}
