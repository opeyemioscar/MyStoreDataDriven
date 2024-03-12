package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{

	@FindBy(xpath = "//p[@class='alert alert-success']")
	public WebElement confirmMessage;
	
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public String validateConfirmMessage() {
		String confirmMsg = confirmMessage.getText();
		return confirmMsg;
	}
}
