package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPageClass;
import com.mystore.pageobjects.LoginPage;

public class LoginTest extends BaseClass {

	public IndexPageClass indexPage;
	public LoginPage LoginPage;
	public HomePage HomePage;

	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {

		launchWeb(browser);
		 indexPage = new IndexPageClass();
	}

	@AfterTest(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		driver.get().quit();
	}
	@Test(dataProvider = "dp", dataProviderClass = DataProviders.class, groups = {"Smoke", "Sanity"})
	public void loginTest(String Username, String Password) {
		logger.debug("Login test started");
		LoginPage = indexPage.clickSignBtn();
		logger.debug("user is going to click Sign in button");
		//HomePage = LoginPage.login(prop.getProperty("newemail"), prop.getProperty("password"));
		HomePage = LoginPage.login(Username, Password);
		logger.debug("user enter username and password");
		String actualURL = HomePage.getCurretURL();
		String expectedURL = "http://www.automationpractice.pl/index.php?controller=my-account";
		logger.debug("Verify if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	
}
