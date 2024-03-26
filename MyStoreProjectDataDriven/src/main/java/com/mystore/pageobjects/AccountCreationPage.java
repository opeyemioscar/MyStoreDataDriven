package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass {

	@FindBy(xpath = "//input[@id='id_gender1']")
	public WebElement male;
	
	@FindBy(xpath = "//input[@id='customer_firstname']")
	public WebElement customerFirstName;
	
	@FindBy(xpath = "//input[@id='customer_lastname']")
	public WebElement customerLastName;
	
	@FindBy(xpath = "//input[@id='email']")
	public WebElement customereemail;
	
	@FindBy(xpath = "//input[@id='passwd']")
	public WebElement createPassword;
	
	@FindBy(xpath = "//select[@id='days']")
	public WebElement days;
	
	@FindBy(xpath = "//select[@id='months']")
	public WebElement months;
	
	@FindBy(xpath = "//select[@id='years']")
	public WebElement years;
	
	
	@FindBy(xpath = "//input[@id='newsletter']")
	public WebElement newsletter;
	
	@FindBy(xpath = "//span[normalize-space()='Register']")
	public WebElement register;
	
	@FindBy(xpath = "//h1[text() = 'Create an account']")
	public WebElement formTitle;
	
	
	
	
	
	public AccountCreationPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	
	public void accountCreationPages(String firstName, String lastName, String day, String month, String year, String setPassword) {
		Action.click(driver.get(), male);
		Action.type(customerFirstName, firstName);
		Action.type(customerLastName, lastName);
		Action.explicitWait(getWebDriver(), createPassword, 5);
		Action.type(createPassword, setPassword);
	
		Action.selectBySendkeys(day, days);
		Action.selectBySendkeys(month, months);
		Action.selectBySendkeys(year, years);
		Action.click(driver.get(), newsletter);
	}
	public MyAccountPage validateRegistration() throws Throwable {
		register.click();
		return new MyAccountPage();
	}
	
	
	public boolean validateAccountCreatePage() {
		return Action.isDisplayed(driver.get(), formTitle);
	}
	
	
}
