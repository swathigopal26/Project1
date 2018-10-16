package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;

public class HomePage extends BaseClass{
	@FindBy(xpath = "(//a[contains(@title, 'Dresses')])[5]")
	public WebElement dressesTab;

	@FindBy(xpath = "(//a[contains(text(),'Casual Dresses')])[2]")
	public WebElement casualDressesTab;
	
	@FindBy(xpath = "(//a[contains(text(),'Summer Dresses')])[2]")
	public WebElement summerDressesTab;
	
	@FindBy(xpath = "(//a[contains(text(), 'Women')])[1]")
	public WebElement womenTab;
	
	@FindBy(xpath = "(//a[contains(text(), 'T-shirts')])[1]")
	public WebElement tShirtTab;
	
	@FindBy(xpath = "//a[@title  = 'My wishlists']")
	public WebElement myWishListButton;
	
	@FindBy(xpath = "//table[@class  = 'table table-bordered']")
	public WebElement wishListTable;
	
	@FindBy(xpath ="//a[contains(text(), 'My wishlist')]/parent::td//following-sibling::td[@class= 'bold align_center']")
	public WebElement wishListQtyValue;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void homePageTitleVerification()
	{
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "My account - My Store");
		System.out.println("Navigated to My account page");
	}

	
	public CasualDressesPage CasualDressesPageNavigation() throws Throwable
	{

		Actions action = new Actions(driver);
		action.moveToElement(dressesTab).build().perform();
		Thread.sleep(2000);
		casualDressesTab.click();
		return new CasualDressesPage();
	}

	public SummerDressesPage summerDressesPageNavigation() throws Throwable
	{
		Actions action = new Actions(driver);
		action.moveToElement(dressesTab).build().perform();
		Thread.sleep(2000);
		summerDressesTab.click();
		return new SummerDressesPage();
	}
	
	public TshirtsPage tShirtPageNavigation() throws Throwable 
	{
		Actions action = new Actions(driver);
		action.moveToElement(womenTab).build().perform();
		Thread.sleep(2000);
		tShirtTab.click();
		return new TshirtsPage();
		
	}
	
	public void ViewmyWishList()
	{
		myWishListButton.click();
		Assert.assertEquals(driver.getTitle(), "My Store");
		Assert.assertEquals(wishListTable.isDisplayed(), true);
		System.out.println("qty in the wishlist is : " + wishListQtyValue.getText());
	}

}
