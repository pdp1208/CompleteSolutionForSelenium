package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Pages.BaseClass;

public class Listeners extends BaseClass implements ITestListener{

	WebDriver driver;

	public static void takeScreenshotAtEndOfTest() throws IOException {
		}
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*********Test Started***********");
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	
		System.out.println("*********Test Successfully passed***********"+result.getTestName());
		
	}
	
	public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
    	ITestContext context = result.getTestContext();
    	Object currentClass = result.getInstance();
    	WebDriver driver = ((BaseClass)currentClass).getDriver();

    	Screenshot.Screenshot(methodName, driver);
    }
	
	
	public void Screenshot(String methodName, WebDriver driver) {
		// TODO Auto-generated method stub
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String ProjectPath = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrFile, new File(ProjectPath + "\\screenshots"+methodName + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*********Test Skipped***********"+result.getTestName());
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("*********Test finish***********"+context.getName());
	}
}
