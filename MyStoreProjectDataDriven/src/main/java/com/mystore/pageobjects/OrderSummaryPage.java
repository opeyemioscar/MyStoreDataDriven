package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderSummaryPage extends BaseClass{


	@FindBy(xpath ="//span[normalize-space()='I confirm my order']" )
	public WebElement bankWireMethod;
	
	

	public OrderSummaryPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public OrderConfirmationPage clickPaymentType() {
		Action.click(driver.get(), bankWireMethod);
		return new OrderConfirmationPage();
		
	}
	
}
