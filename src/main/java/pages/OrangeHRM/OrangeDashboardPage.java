package pages.OrangeHRM;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OrangeDashboardPage extends BasePage {

    private static final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    private final By dashboardLabelLocator = By.tagName("h6");
    private final String expecteddashboardLabel = "Dashboard";

    public OrangeDashboardPage(WebDriver driver){
        super(driver);
    }

    public void verifyDashboardLabel(){
        Assert.assertEquals(getText(dashboardLabelLocator), expecteddashboardLabel);
    }


}
