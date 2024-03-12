package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPageClass;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultTest extends BaseClass {

public IndexPageClass indexPage ;
public SearchResultPage SearchResultPage;

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
	@Test(groups = "Smoke")
	public void productAvailability() {
		
		SearchResultPage = indexPage.clickSearchBox("T-SHIRT");
		boolean result =SearchResultPage.isProductAvailable();
		Assert.assertTrue(result);
	}
}
