package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{

	@FindBy(xpath = "//li[@class='price']")
	public WebElement unitPrice;
	
	@FindBy(xpath = "//span[@id='total_price']")
	public WebElement totalPrice;
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	public WebElement procendToCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	 public double getUnitPrice() {
	        String unitPriceText = unitPrice.getText().replaceAll("[^0-9.]", ""); // Remove non-numeric characters except for dots
	        double finalUnitPrice = Double.parseDouble(unitPriceText);
	        return finalUnitPrice ; // Assuming the unit price is in cents, so dividing by 100 to get the actual price
	    }

	    public double getTotalPrice() {
	        String totalPriceText = totalPrice.getText().replaceAll("[^0-9.]", ""); // Remove non-numeric characters except for dots
	        double finalTotalPrice = Double.parseDouble(totalPriceText);
	        return finalTotalPrice ; // Assuming the total price is in cents, so dividing by 100 to get the actual price
	    }

	
	public LoginPage clickOnCheckOut() {
		Assert.assertTrue(false);// delibrate failin the test
		Action.click(driver.get(), procendToCheckOut);
		
		return new LoginPage() ;
		
		
	}
}
