package Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.LoginPage;
import utility.ByBaseClass;
import utility.TestDataFromExcel;

public class FacebookTest extends BaseClass {

	LoginPage obj;

	
	@DataProvider(name = "TestDataFromExcel")
	public Object[][] TestDataFromExcel() throws Exception {

		Object[][] testObjArray = TestDataFromExcel.ExcelFetchData("TestData", "Facebook", "FaceBookLogin");

		return (testObjArray);

	}

	@Test(dataProvider = "TestDataFromExcel")
	public void loginToFacebook(String UserName, String Password) throws InterruptedException {
		obj = new LoginPage(getDriver());
		obj.setUserName(UserName);
		obj.setPassword(Password);
		Thread.sleep(4000);
		obj.ClickLoginButton();

	}
}
