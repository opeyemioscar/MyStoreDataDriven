package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class MyAccountPage extends BaseClass {
	
	@FindBy(xpath = "//span[normalize-space()='Add my first address']")
	public WebElement address;
	
	@FindBy(xpath = "//span[normalize-space()='Order history and details']")
	public WebElement orderHistory;
	
	@FindBy(xpath = "//span[normalize-space()='My credit slips']")
	public WebElement myCreditSlip;
	
	@FindBy(xpath = "//span[normalize-space()='My addresses']")
	public WebElement myAddress;
	
	@FindBy(xpath = "//span[normalize-space()='My personal information']")
	public WebElement personalInformation;
	
	@FindBy(xpath = "//p[contains(text(),'Your account has been created.')]")
	public WebElement accountCreated;

	public MyAccountPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public boolean verifyaccount() {
		return accountCreated.isDisplayed();
		
	}
}
