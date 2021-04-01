package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailureRetryAnalyser implements IRetryAnalyzer {
	int currentRetry=0;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		MaxRetryCount failureCount = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(MaxRetryCount.class);
		
		int maxRetryCount = (failureCount==null)? 1:
								failureCount.value();	
		if(++currentRetry> maxRetryCount){
			currentRetry=0;
			return false;
		}
		return true;
	}

}
