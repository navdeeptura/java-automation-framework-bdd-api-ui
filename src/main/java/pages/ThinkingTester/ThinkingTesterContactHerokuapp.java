package pages.ThinkingTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.BasePage;

public class ThinkingTesterContactHerokuapp extends BasePage{
	
	private String url = "https://thinking-tester-contact-list.herokuapp.com/";
	private By emailLocator = By.id("email");
	private By passwordLocator = By.id("password");
	private By submitButtonLocator = By.id("submit");
	
	
	
	public ThinkingTesterContactHerokuapp(WebDriver driver) {
		super(driver);
	}
	
	public void enterEmail(String email) {
		type(emailLocator, email);
	}
	
	public void enterPassword(String password) {
		type(passwordLocator, password);
	}
	
	public void clickSubmitButton() {
		click(submitButtonLocator);
	}
	
	
	
	
	
	

}
