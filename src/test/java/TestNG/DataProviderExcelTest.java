package TestNG;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import drivers.Driver;
import pages.ThinkingTester.ThinkingTesterAddContact;
import pages.ThinkingTester.ThinkingTesterContactHerokuapp;
import pages.ThinkingTester.ThinkingTesterContactList;
import utils.ContactFormDataProvider;

public class DataProviderExcelTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		Driver.initDriver("chrome");
		driver = Driver.getDriver();
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}
	
	
	@Test(dataProvider = "ContactData", dataProviderClass = ContactFormDataProvider.class)
    public void testAddContactForm(String firstName, String lastName, LocalDate dob, String email,
                                   Double phone, String street1, String street2,
                                   String city, String state, String postalCode, String country) {
        // Sample print – replace with Selenium actions
        System.out.printf("Testing with: %s %s, %s, %s, %s\n", firstName, lastName, email, phone, city);
    }
	
	@Test(dataProvider = "ContactData", dataProviderClass = ContactFormDataProvider.class)
	public void testContactForm(String firstName, String lastName, LocalDate dob, String email,
            Double phone, String street1, String street2,
            String city, String state, String postalCode, String country) {
		
		ThinkingTesterContactHerokuapp hero = new ThinkingTesterContactHerokuapp(driver);
		ThinkingTesterContactList cont = new ThinkingTesterContactList(driver);
		ThinkingTesterAddContact addCont = new ThinkingTesterAddContact(driver);
		
		String url = "https://thinking-tester-contact-list.herokuapp.com/";
		
		driver.get(url);
		hero.enterEmail("nav@gmail.com");
		hero.enterPassword("Login@123");
		hero.clickSubmitButton();
		cont.clickAddNewContact();
		addCont.enterFirstName(firstName);
		addCont.enterLastName(lastName);
		addCont.enterEmail(email);
		
	}
	
	@Test
	public void browseSite() {
		ThinkingTesterContactHerokuapp hero = new ThinkingTesterContactHerokuapp(driver);
		ThinkingTesterContactList cont = new ThinkingTesterContactList(driver);
		
		String url = "https://thinking-tester-contact-list.herokuapp.com/";
		
		driver.get(url);
		hero.enterEmail("nav@gmail.com");
		hero.enterPassword("Login@123");
		hero.clickSubmitButton();
		cont.clickAddNewContact();
		
		
	}

}
