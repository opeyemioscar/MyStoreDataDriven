package com.mystore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPageClass;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.MyAccountPage;

public class AccountCreationTest extends BaseClass {
	public IndexPageClass indexPage;
	public LoginPage LoginPage;
	public AccountCreationPage AccountCreationPage;
	public MyAccountPage MyAccountPage;
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

	/*
	 * @Test(groups = "Sanity") public void accountCreate() { LoginPage =
	 * indexPage.clickSignBtn(); AccountCreationPage =
	 * LoginPage.createNewAccount("testsaccount@gmail.com"); boolean result =
	 * AccountCreationPage.validateAccountCreatePage(); Assert.assertTrue(result); }
	 */
	 

	@Test(groups = "Regression",dataProvider = "newAcountDetailsData",dataProviderClass = DataProviders.class)
	public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
		//indexPage= new IndexPageClass();
		LoginPage=indexPage.clickSignBtn();
		AccountCreationPage=LoginPage.createNewAccount(hashMapValue.get("Email"));
		AccountCreationPage.accountCreationPages(
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"));
		MyAccountPage=AccountCreationPage.validateRegistration();
		MyAccountPage.verifyaccount();
}
}