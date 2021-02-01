package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPasswordPage extends BaseClass{

	By ForgetPassword=By.linkText("Forgotten password?");
	By SearchByPhoneNumberOrEmail = By.name("email");
	By Submit = By.id("u_0_2");
	
	public ForgetPasswordPage(WebDriver driver){
		super(driver);
	}
	
	public void ClickOnForgetPassowardLink(){
		driver.findElement(ForgetPassword).click();
	}
	
	public void EnterValueInSearchByPhoneNumberOrEmail(String PhoneNumber){
		driver.findElement(SearchByPhoneNumberOrEmail).sendKeys(PhoneNumber);
	}
	
	public void ClickOnSubmitButton(){
		driver.findElement(Submit).submit();
	}
}
