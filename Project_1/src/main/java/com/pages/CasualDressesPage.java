package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CasualDressesPage extends BaseClass {
	
	@FindBy (xpath = "//a[@title = 'Printed Dress']/parent::h5//following-sibling::div[@class = 'button-container']/a[@title = 'Add to cart']")
	public WebElement dressChossed;
	
	@FindBy (xpath = "//a[@title = 'Proceed to checkout']")
	public WebElement proceedButton;
	
	public CasualDressesPage()
	{
		PageFactory.initElements(driver, this);
	}

}
