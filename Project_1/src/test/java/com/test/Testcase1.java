package com.test;




import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.CasualDressesPage;
import com.pages.DressesPage;
import com.pages.HomePage;
import com.pages.LoginPage;

public class Testcase1 extends BaseClass {

	public Testcase1(){
		super();
	}

	LoginPage loginpage;
	HomePage homepage;
	CasualDressesPage casualdressespage;
	DressesPage dressespage;
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		loginpage.signInLink.click();
	}
	
	@Test
	public void loginPageTestMethod1() throws Throwable{
		
		//Login page title verification
		String title = loginpage.verifyTitle();
		Assert.assertEquals(title, "Login - My Store");
		System.out.println("Login page Title is present");
		
		//Login page logo verification
		boolean logo = loginpage.logoVerify();
		Assert.assertEquals(logo, true);
		System.out.println("Login page Logo is present");
		
		//Login to myaccount
		homepage = loginpage.loginTest();
		
		
		//Navigation to Causaldresses page
		casualdressespage= homepage.CasualDressesPageNavigation();
		
		
	
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}