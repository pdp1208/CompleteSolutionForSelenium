package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ByBaseClass;

public class LoginPage extends BaseClass {

	
	 By userName1= By.id("email");
	 By passWord1= By.id("pass");
	 By submit = By.name("login");

	 

	public LoginPage(WebDriver driver) {
        super(driver);
    }
	
	public  void setUserName(String text) {
		driver.findElement(userName1).sendKeys(text);
	}

	public  void setPassword(String text) {
		driver.findElement(passWord1).sendKeys(text);
	}
	
	public  void ClickLoginButton() {
		driver.findElement(submit).sendKeys(Keys.RETURN);
	}
}
