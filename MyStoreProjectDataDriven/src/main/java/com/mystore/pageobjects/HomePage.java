package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//span[normalize-space()='Order history and details']")
	public WebElement orderHistory;
	

	@FindBy(xpath = "//span[normalize-space()='My credit slips']")
	public WebElement creditSlips;
	

	@FindBy(xpath = "//span[normalize-space()='My addresses']")
	public WebElement myAddresses;
	

	@FindBy(xpath = "//span[normalize-space()='My personal information']")
	public WebElement myPersonalInformation;
	
	public HomePage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public boolean validateCreditSlips() {
		return Action.isDisplayed(driver.get(), creditSlips);
		
	}
	
	public boolean validateOrderHistory() {
		return Action.isDisplayed(driver.get(), orderHistory);
		
	}
	
	public String getCurretURL() {
	String HomePageURL = Action.getCurrentURL(driver.get());	
	return HomePageURL;
	}
}
