package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.mystore.actionDriver.Action;
import com.mystore.utilities.ExcelReader;
import com.mystore.utilities.ExtentManager;


public class BaseClass {
	public static Properties prop;
	public static Action Action;
	public static Logger logger = LogManager.getLogger(BaseClass.class.getName());
	public static ExcelReader excel = new ExcelReader("C:\\Users\\hp\\eclipse-workspace\\MyStoreProjectDataDriven\\src\\test\\resources\\TestData\\TestData.xlsx");
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static WebDriver getWebDriver() {
		return driver.get();
	}

	
	/*
	 * @BeforeSuite public static void beforeSuite() {
	 * DOMConfigurator.confiqure("log4j2.xml"); }
	 */

	@BeforeSuite(groups = {"Smoke", "Sanity", "Regression"})
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
			
			Action = new Action();
		} catch (FileNotFoundException e) {
			logger.error("File not found: " + e.getMessage());
		} catch (IOException e) {
			logger.error("IO Exception: " + e.getMessage());
		}
	}
	
	public static void launchWeb(String browserName) {
		//String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			logger.info("chrome browser lauching");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}

		logger.info("Maximizing browser window");
		Action.maximizePageWindow(driver.get());
		logger.info("Setting implicit wait");
		Action.implicitWait(driver.get(), 10);
		logger.info("Setting page load timeout");
		Action.pageLoadTimeOut(driver.get(), 40);

		driver.get().get(prop.getProperty("url"));
	}
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();	
	}


	
}
