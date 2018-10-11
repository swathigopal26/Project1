package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;

public class CasualDressesPage extends BaseClass {
	
	@FindBy (xpath = "//img[@title = 'Printed Dress']")
	public WebElement dressImage;
	
	@FindBy (xpath = "//a[@title = 'Printed Dress']/parent::h5//following-sibling::div[@class = 'button-container']/a[@title = 'Add to cart']")
	public WebElement dressChossed;
	
	//@FindBy (xpath = "//a[contains(@title, 'Proceed to checkout')]")
	@FindBy (linkText = "Proceed to checkout")
	public WebElement proceedButton;
	
	public CasualDressesPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void casualdressPageTitleVerification()
	{
		String casualDressesTitle = driver.getTitle();
		Assert.assertEquals(casualDressesTitle, "Casual Dresses - My Store");
		System.out.println("Navigated to casual dresses page");
	}
	public OrderPage proceedToCheckOut() throws Throwable
	{
		Actions action = new Actions(driver);
		action.moveToElement(dressImage).build().perform();;
		Thread.sleep(3000);
		dressChossed.click();
		proceedButton.click();
		return new OrderPage();
	}
}
