package BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class GoogleTest extends BaseClass {
	@Test(priority = 1)
	public void firstTest() {
		String actual = "Google";
		String expected = driver.getTitle();
			Assert.assertEquals(actual, expected);
			System.out.println(expected);
	}
	@Test(priority = 2)
	public void SecondTest() {
			WebElement img = driver.findElement(By.xpath("//img[@alt='Google']"));
			img.isDisplayed();
	}
	@Test(priority = 3)
	public void thirdTest() {
		WebElement searchfield = driver.findElement(By.name("q"));	
		searchfield.isDisplayed();
		Assert.fail("I decided to fail this one");
	}
}
