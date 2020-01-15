package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import utility.ByBaseClass;

public class BaseClass extends ByBaseClass{

	public  WebDriver driver;
	public static Properties prop;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public BaseClass() {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public BaseClass(WebDriver driver) {
		// TODO Auto-generated constructor stub
		driver = new ByBaseClass(driver);
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeSuite
	public void ProjectBaseClass() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\env.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void SetupTest() {
		String browserName = prop.getProperty("browser");
		String ProjectPath = System.getProperty("user.dir");
		String url = prop.getProperty("URL");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ProjectPath + "\\drivers\\chromedriver79.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", ProjectPath + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(url);
	}

	@AfterMethod
	public void tearDownDriver() {
		if (driver != null) {
			try {
				driver.quit();
			} catch (WebDriverException e) {
				System.out.println("***** CAUGHT EXCEPTION IN DRIVER TEARDOWN *****");
				System.out.println(e);
			}

		}
	}
}
