package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;

public class IndexPageClass extends BaseClass{

	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signinBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement mystoreLogo;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchBox;
	
	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement submitBtn;
	
	
	public  IndexPageClass() {
	PageFactory.initElements(driver.get(), this);	
	}
	
	public LoginPage clickSignBtn() {
		Action.click(driver.get(), signinBtn);
		return new LoginPage();
	}
	
	@Test(groups = "Smoke")
	public boolean validateLogo() {
		Action.explicitWait(driver.get(), mystoreLogo, 10);
		return Action.isDisplayed(driver.get(), mystoreLogo);
		
	}
	
	@Test(groups = "Smoke")
	public String getTitle1() {
		String myStoreTitle = Action.getTitle(driver.get());
		return myStoreTitle;
	}
	
	public SearchResultPage clickSearchBox(String productName) {
		Action.type(searchBox, productName);
		Action.click(driver.get(), submitBtn);
		
		return new SearchResultPage();
	}
}
