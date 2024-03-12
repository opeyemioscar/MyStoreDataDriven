package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DetailPrice;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPageClass;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
		public IndexPageClass indexPage;
		public SearchResultPage SearchResultPage;
		public AddToCartPage AddToCartPage;
		public OrderPage OrderPage;
		
		
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
		@Test(groups = "Regression", dataProvider = "dp", dataProviderClass = DetailPrice.class)
		public void verifyProductPrice(String Product, String qty , String Size) {
			SearchResultPage = indexPage.clickSearchBox(Product);
			AddToCartPage = SearchResultPage.clickonProduct();
			AddToCartPage.colourwhite();
			AddToCartPage.selectSize(Size);
			AddToCartPage.enterQuantity(qty);		
			AddToCartPage.clickonAddToCart();
			OrderPage = AddToCartPage.clickonCheckOut();
			Double unitPrice = OrderPage.getUnitPrice();
			Double totalPrice = OrderPage.getTotalPrice();
			double totalExpectedPrice = (unitPrice * 2) + 7;
			
			
			 System.out.println("Unit Price: " + unitPrice);
			    System.out.println("Total Price: " + totalPrice);
			    System.out.println("Total Expected Price: " + totalExpectedPrice);
			Assert.assertEquals(totalPrice, totalExpectedPrice);
			
			
		}
		
		
}
