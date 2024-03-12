package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPageClass;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartTest extends BaseClass {
	public IndexPageClass indexPage;
	public SearchResultPage SearchResultPage;
	public AddToCartPage AddToCartPage;
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
	@Test(groups = {"Regression", "Sanity"})
	public void addtoCartTest() {
		SearchResultPage = indexPage.clickSearchBox("T-SHIRT");
		AddToCartPage = SearchResultPage.clickonProduct();
		AddToCartPage.colourwhite();
		AddToCartPage.enterQuantity("2");
		AddToCartPage.selectSize("M");
		AddToCartPage.clickonAddToCart();
		boolean result = AddToCartPage.validateAddtoCart();
		Assert.assertTrue(result);
	}
	
	
}
