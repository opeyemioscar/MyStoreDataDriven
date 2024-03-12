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
public class AddToCartPage extends BaseClass {
	
	
	
	@FindBy(xpath= "//a[@id='color_8']")
	public WebElement whiteSleeve;
	
	@FindBy(xpath = "//input[@id = 'quantity_wanted']")
	public WebElement quantity;
	
	@FindBy(xpath = "//select[@id = 'group_1']")
	public WebElement size;
	
	@FindBy(xpath = "//span[normalize-space()='Add to cart']")
	public WebElement addToCartBTn;
	

	
	@FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
	public WebElement addToCartMessage;
	
	@FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
	public WebElement proceedToCheckOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public void colourwhite() {
		Action.click(driver.get(), whiteSleeve);
	}
	
	public void enterQuantity(String total) {
		Action.fluentWait(driver.get(), quantity, 10);
		Action.type(quantity, total);
	}

	public void clickonAddToCart() {
		Action.click(driver.get(), addToCartBTn);
	}
	
	public void selectSize(String large) {
		Action.selectByVisibleText(large, size);
	}
	
	public boolean validateAddtoCart() {
		Action.fluentWait(driver.get(), addToCartMessage, 10);
		return Action.isDisplayed(driver.get(), addToCartMessage);
	}
	
	public OrderPage clickonCheckOut() {
		Action.fluentWait(driver.get(), proceedToCheckOutBtn, 10);
		Action.JSClick(driver.get(), proceedToCheckOutBtn);
		return new OrderPage();
	}
}
