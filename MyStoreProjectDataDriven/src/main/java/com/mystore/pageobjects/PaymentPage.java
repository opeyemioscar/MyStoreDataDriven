package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {

	@FindBy(xpath ="//a[@title='Pay by bank wire']")
	public WebElement bankWireMethod;
	
	@FindBy(xpath ="//a[@title='Pay by check.']" )
	public WebElement payByCheckMethod;
	

	public PaymentPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public OrderSummaryPage clickOnPaymentMethod() {
		Action.explicitWait(driver.get(), bankWireMethod, 5);
		Action.click(driver.get(), bankWireMethod);
		return new OrderSummaryPage();
	}
	

}
