	package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import drivers.Driver;

/**
 * Listener that captures a screenshot on test failure using WebDriver.
 */

public class ScreenshotOnFailure implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Listener triggered for failure: " + result.getName());

		WebDriver driver =  Driver.getDriver();
		if (driver == null ) {
			System.out.println("Driver in listener = " + driver);
			return;
		}
		
		String className = result.getTestClass().getName();
		String testMethodName = result.getName();
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String fileName = className + testMethodName + timestamp + ".png";
		Path screenShotPath = Path.of("test-output", "screenshots", fileName);
		
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			Files.createDirectories(screenShotPath.getParent());
			Files.copy(srcFile.toPath(), screenShotPath);
			System.out.println("📸 Screenshot saved: " + screenShotPath.toAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
