package pages.ThinkingTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.BasePage;

public class ThinkingTesterAddContact extends BasePage{
	
	public ThinkingTesterAddContact(WebDriver driver) {
		super(driver);
	}
	
	private String url = "https://thinking-tester-contact-list.herokuapp.com/addContact";
	private By firstName = By.id("firstName");
	private By lastName = By.id("lastName");
	private By birthdate = By.id("birthdate");
	private By email = By.id("email");
	private By phone = By.id("phone");
	private By street1 = By.id("street1");
	private By street2 = By.id("street2");
	private By city = By.id("city");
	private By stateProvince = By.id("stateProvince");
	private By postalCode = By.id("postalCode");
	private By country = By.id("country");
	private By submit = By.id("submit");
	private By cancel = By.id("cancel");
	
	public void enterFirstName(String val) {
		type(firstName, val);
	}
	
	public void enterLastName(String val) {
		type(lastName, val);
	}
	
	public void enterBirthDate(String val) {
		type(birthdate, val);
	}
	
	public void enterEmail(String val) {
		type(email, val);
	}
	
	public void enterPhone(String val) {
		type(phone, val);
	}
	
	public void enterStreet1(String val) {
		type(street1, val);
	}
	
	public void enterStreet2(String val) {
		type(street2, val);
	}
	
	public void enterCity(String val) {
		type(city, val);
	}
	
	public void enterState(String val) {
		type(stateProvince, val);
	}
	
	public void enterPostalCode(String val) {
		type(postalCode, val);
	}
	
	public void enterCountry(String val) {
		type(country, val);
	}
	
	public void clickSubmit() {
		click(submit);
	}
	
	public void clickCancel() {
		click(cancel);
	}
	
}
