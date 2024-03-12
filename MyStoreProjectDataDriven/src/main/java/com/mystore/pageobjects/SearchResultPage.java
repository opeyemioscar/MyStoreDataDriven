package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {

	@FindBy(xpath = "//li[@class='clearfix']//a[@class='product-name'][normalize-space()='Blouse']")
	public WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(driver.get(), this);
	}
	
	public boolean isProductAvailable() {
		return Action.isDisplayed(driver.get(), productResult);
	}
	
	public AddToCartPage clickonProduct() {
		Action.click(driver.get(), productResult);
		return new AddToCartPage();
	}
}
