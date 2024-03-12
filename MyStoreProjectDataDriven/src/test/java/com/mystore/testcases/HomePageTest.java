package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPageClass;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass{
	public IndexPageClass indexPage;
	public LoginPage LoginPage;
	public HomePage HomePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {

		launchWeb(browser);
		indexPage = new IndexPageClass();
	}

	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void teardown() {
		driver.get().quit();
	}
	@Test(priority = 1, groups = "Smoke")
	public void verifyCreditSlip() {
	
		LoginPage = indexPage.clickSignBtn();
		HomePage = LoginPage.login(prop.getProperty("newemail"), prop.getProperty("password"));
		Boolean result = HomePage.validateCreditSlips();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2, groups = "Smoke")
	public void verifyOrderHistory() {
		
		LoginPage = indexPage.clickSignBtn();
		HomePage = LoginPage.login(prop.getProperty("newemail"), prop.getProperty("password"));
		Boolean result = HomePage.validateOrderHistory();
		Assert.assertTrue(result);
	}
	
}
