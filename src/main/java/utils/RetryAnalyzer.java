package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	int counter = 0;
	int retryLimit = 3;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		counter += 1;
		if (counter <= retryLimit) return true;
		return false;
	}
}
