package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath = "//a[contains(@class , 'login')]")
	public WebElement signInLink ;
	
	@FindBy(xpath = "//input[@id =  'email']")
	public WebElement emailAddressTextbox  ;

	@FindBy(xpath = "//input[@id =  'passwd']")
	public WebElement passwordTextbox   ;
	
	@FindBy(xpath = "//button[@id='SubmitLogin']")
	public WebElement signInButton    ;
	
	@FindBy(xpath = "//img[@alt='My Store']")
	public WebElement logoImage;
	
	
			
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void signInMethod()
	{
		signInLink.click();
	}
	
	public void verifyTitle()
	{
		String title = driver.getTitle();
		Assert.assertEquals(title, "Login - My Store");
		System.out.println("Login page Title is present");
		
	}
	
	public void logoVerify()
	{
		boolean logo = logoImage.isDisplayed();
		Assert.assertEquals(logo, true);
		System.out.println("Login page Logo is present");
	}
	
	public HomePage loginTest()
	{
		emailAddressTextbox.sendKeys(prop.getProperty("username"));
		passwordTextbox.sendKeys(prop.getProperty("password"));
		signInButton.click();
		String myaccountTitle = driver.getTitle();
		Assert.assertEquals(myaccountTitle, "My account - My Store");
		System.out.println("Login is successfull and navigated to home page");
		return new HomePage();
		
	}
}
