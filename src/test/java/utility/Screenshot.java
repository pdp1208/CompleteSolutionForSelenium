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

public class Screenshot extends BaseClass  {

	static WebDriver driver;

	public static void Screenshot(String methodName, WebDriver driver) {
		// TODO Auto-generated method stub
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String ScreenshotPath = System.getProperty("user.dir")+"\\screenshots\\";
		try {
			FileUtils.copyFile(scrFile,
					new File(ScreenshotPath + methodName + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
