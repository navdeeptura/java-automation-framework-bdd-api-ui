package Selenium.OrangeHRM;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.OrangeHRM.OrangeDashboardPage;

@Listeners({utils.ScreenshotOnFailure.class})
public class OrangeHRMLoginTest extends BaseOrangeTest {

    @Test
    public void TestLoginIntoOrangeHRM() {
        loginPage.browseToURL();
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        OrangeDashboardPage dashPage = loginPage.clickLoginButton();
        dashPage.verifyDashboardLabel();
    }

    @Test
    public void oneClickLogin() throws InterruptedException {
        OrangeDashboardPage dashPage = loginPage.loginValidator("Admin", "admin123");
        dashPage.verifyDashboardLabel();
    }
}
