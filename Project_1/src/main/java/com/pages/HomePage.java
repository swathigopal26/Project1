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
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public CasualDressesPage CasualDressesPageNavigation() throws Throwable
	{

		Actions action = new Actions(driver);
		action.moveToElement(dressesTab).build().perform();
		//Thread.sleep(5000);
		casualDressesTab.click();
		//Thread.sleep(5000);
		return new CasualDressesPage();
	}

	public SummerDressesPage summerDressesPageNavigation() throws Throwable
	{
		Actions action = new Actions(driver);
		action.moveToElement(dressesTab).build().perform();
		Thread.sleep(5000);
		summerDressesTab.click();
		Thread.sleep(5000);
		return new SummerDressesPage();
		
	}

}
