/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

/**
 * @author hp
 *
 */
public class LoginPage extends BaseClass{
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emails;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement passwd;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement signBtn;
	
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement emailforNewAccount;
	
	@FindBy(xpath="//span[normalize-space()='Create an account']")
	WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public HomePage login(String email, String password) {
		Action.type(emails, email);
		Action.type(passwd, password);
		Action.click(driver.get(), signBtn);
		
		return new HomePage();
	}
	
	public AddressPage login1(String email, String password) {
		Action.type(emails, email);
		Action.type(passwd, password);
		Action.click(driver.get(), signBtn);
		
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String email) {
		Action.type(emailforNewAccount, email);
		Action.click(driver.get(), createNewAccountBtn);
		
		return new AccountCreationPage();
	}

}
