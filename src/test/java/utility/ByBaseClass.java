package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class ByBaseClass extends RemoteWebDriver {

	public WebDriver driver;
	public static Properties prop;

	
	
	public ByBaseClass() {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public ByBaseClass(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebDriver getDriver() {
		driver = new ByBaseClass(driver);
		return driver;
	}

	public WebDriver driver() {
		return driver;
	}

	@Override
	public void close() {
		getDriver().close();
	}

	@Override
	public WebElement findElement(By locator) {

		System.out.println("Finding this element using ="+ locator);
		return driver().findElement(locator);
	}

	@Override
	public List findElements(By arg0) {
		return driver().findElements(arg0);
	}

	@Override
	public void get(String arg0) {
		driver().get(arg0);
	}

	@Override
	public String getCurrentUrl() {
		return driver().getCurrentUrl();
	}

	@Override
	public String getPageSource() {
		return driver().getPageSource();
	}

	@Override
	public String getTitle() {
		return driver().getTitle();
	}

	@Override
	public String getWindowHandle() {
		return driver().getWindowHandle();
	}

	@Override
	public Set getWindowHandles() {
		return driver().getWindowHandles();
	}

	@Override
	public Options manage() {
		return driver().manage();
	}

	@Override
	public Navigation navigate() {
		return driver().navigate();
	}

	@Override
	public void quit() {
		driver().quit();
	}

	@Override
	public TargetLocator switchTo() {
		return driver().switchTo();
	}

}
