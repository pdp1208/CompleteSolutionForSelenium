package Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.ForgetPasswordPage;
import Pages.LoginPage;
import utility.TestDataFromExcel;

public class ForgetPasswordTest extends BaseClass{

	ForgetPasswordPage obj;

	
	@DataProvider(name = "TestDataFromExcel")
	public Object[][] TestDataFromExcel() throws Exception {

		Object[][] testObjArray = TestDataFromExcel.ExcelFetchData("TestData", "ForgetPasswordPage", "ForgetPasswordPage");

		return (testObjArray);

	}

	@Test(dataProvider = "TestDataFromExcel")
	public void ForgetPassword(String PhoneNumber) throws InterruptedException {
		obj = new ForgetPasswordPage(getDriver());
		obj.ClickOnForgetPassowardLink();
		obj.EnterValueInSearchByPhoneNumberOrEmail(PhoneNumber);
		Thread.sleep(4000);
		obj.ClickOnSubmitButton();
		Assert.assertTrue((driver.getTitle()).equals("Forgotten Password | Can't Log In | Facebook"));

	}
}
