package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;

	public class DressesPage extends BaseClass {
		
	

	

	public DressesPage()
	{
	PageFactory.initElements(driver, this);
	}



}
