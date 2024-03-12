package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPageClass;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass {
	public IndexPageClass indexPage;
	public SearchResultPage SearchResultPage;
	public AddToCartPage AddToCartPage;
	public OrderPage OrderPage;
	public LoginPage LoginPage;
	public AddressPage AddressPage;
	public ShippingPage ShippingPage;
	public PaymentPage PaymentPage;
	public OrderSummaryPage OrderSummaryPage;
	public OrderConfirmationPage OrderConfirmationPage;

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

	@Test(groups = "Regression")
	public void endToEndTesting() {
		SearchResultPage = indexPage.clickSearchBox("T-SHIRT");
		AddToCartPage = SearchResultPage.clickonProduct();
		AddToCartPage.colourwhite();
		AddToCartPage.enterQuantity("2");
		AddToCartPage.selectSize("M");
		AddToCartPage.clickonAddToCart();
		OrderPage = AddToCartPage.clickonCheckOut();
		LoginPage = OrderPage.clickOnCheckOut();
		AddressPage = LoginPage.login1(prop.getProperty("newemail"), prop.getProperty("password"));
		ShippingPage = AddressPage.clickOnCheckOut();
		ShippingPage.clickOnTermAndCondition();
		PaymentPage = ShippingPage.clickproceedToCheckOut();
		OrderSummaryPage = PaymentPage.clickOnPaymentMethod();
		OrderConfirmationPage = OrderSummaryPage.clickPaymentType();
		String ActualMssg = OrderConfirmationPage.validateConfirmMessage();
		String ExpectedMssg = "Your order on My Shop is complete.";
		Assert.assertEquals(ActualMssg, ExpectedMssg);

	}

}
