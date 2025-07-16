package hooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import drivers.Driver;

public class TestHook {
	
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setUp(String browser) {
		Driver.initDriver(browser);
		System.out.println(" WebDriver initilized for: " + browser);
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		Driver.quitDriver();
		System.out.println(" WebDriver quit");
	}

}
