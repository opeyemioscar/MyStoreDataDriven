/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPageClass;

/**
 * @author hp
 *
 */
public class IndexPageTest extends BaseClass {
	public IndexPageClass indexPage ;
	
	
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
	
	@Test(priority = 1)
	public void verifylogo() {
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);	
		
	}
	
	@Test(priority = 2)
	public void verifyTitle() {
		String actTitle = indexPage.getTitle1();
		Assert.assertEquals(actTitle, "My Shop1");
		
	}
	
	

}
