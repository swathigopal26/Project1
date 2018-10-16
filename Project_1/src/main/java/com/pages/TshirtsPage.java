package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;

public class TshirtsPage extends BaseClass {
	
	@FindBy (xpath = "//img[@title = 'Faded Short Sleeve T-shirts']")
	public WebElement dressImage;
	
	@FindBy(xpath = "//a[contains(text(), 'Faded Short Sleeve T-shirts')]/parent::h5//following-sibling::div[@class = 'button-container']//a[@title = 'View']")
	public WebElement dressChossedMoreIcon;
	
	@FindBy(id = "wishlist_button")
	public WebElement addToWishListButton;
	
	@FindBy(xpath ="//a[@title = 'Close']")
	public WebElement closeButton;
	
	@FindBy(xpath ="//a[@title = 'View my customer account']")
	public WebElement customerAccountLink;
	
	
	public TshirtsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void tShirtPageTitleVerification()
	{
		String tShirtTitle = driver.getTitle();
		Assert.assertEquals(tShirtTitle, "T-shirts - My Store");
		System.out.println("Navigated to T-shirt page");
	}
	
	public void moreInfoAndAddToWishList() throws Throwable
	{
		Actions action = new Actions(driver);
		action.moveToElement(dressImage).build().perform();
		dressChossedMoreIcon.click();
		addToWishListButton.click();
		closeButton.click();
		Thread.sleep(2000);
		customerAccountLink.click();
		Assert.assertEquals(driver.getTitle(), "My account - My Store");
	}

}
