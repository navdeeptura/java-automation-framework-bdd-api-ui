package pages.ThinkingTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class ThinkingTesterContactList extends BasePage{
	
	String url = "https://thinking-tester-contact-list.herokuapp.com/contactList";
	private By AddNewContactButtonLocator = By.id("add-contact");
	
	
	public ThinkingTesterContactList(WebDriver driver) {
		super(driver);
	}
	
	public void clickAddNewContact() {
		click(AddNewContactButtonLocator);
	}
}
