package com.practice.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.practice.utilities.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	protected static WebDriver driver;
	protected static Properties config = new Properties();
	protected static Properties OR = new Properties();
	protected static FileInputStream fis;
	protected static WebDriverWait wait; 
	protected static String browser;

	@BeforeSuite
	public void setup() throws IOException {


		if(driver == null) {

			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			config.load(fis);


			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);

		}

		if(System.getenv("browser") != null && !System.getenv("browser").isEmpty())
			browser = System.getenv("browser");
		else
			browser = config.getProperty("browser");    

		config.setProperty("browser", browser);     

		if(config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}else if (config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		driver.get(config.getProperty("testsiteurl"));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));


	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}catch(NoSuchElementException ex) {
			return false;
		}
	}

	public void click(String locator) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
	}

	public void type(String locator, String value) {

		driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
	}

	public void verifyEquals(String expected, String actual) throws IOException {
		SoftAssert sa = new SoftAssert();
		try {
			sa.assertEquals(expected, actual);
			sa.assertAll();
		}catch(Throwable t) {
			TestUtil.captureScreenshot();
		}
	}

	public void select(String locator, String value) {
		WebElement dropDown;
		dropDown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		Select select = new Select(dropDown);
		select.selectByVisibleText(value);
	}

	@AfterSuite
	public void tearDown() throws IOException {
		if(driver!= null)
			driver.quit();
		fis.close();
	}
}
