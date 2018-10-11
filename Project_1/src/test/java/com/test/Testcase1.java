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
import com.pages.OrderPage;

public class Testcase1 extends BaseClass {

	public Testcase1(){
		super();
	}

	LoginPage loginpage;
	HomePage homepage;
	CasualDressesPage casualdressespage;
	DressesPage dressespage;
	OrderPage orderpage;
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		
	}
	
	@Test
	public void TestMethod1() throws Throwable{
		//click on signin link
		loginpage.signInMethod();
		
		//Login page title verification
		 loginpage.verifyTitle();
		
		//Login page logo verification
		 loginpage.logoVerify();
		
		//Login to myaccount
		homepage = loginpage.loginTest();
		
		//Navigation to Causaldresses page
		casualdressespage= homepage.CasualDressesPageNavigation();
	
		//Casualdresses Page title verification
		casualdressespage.casualdressPageTitleVerification();
		
		//Choosing the dress and adding to cart and proceeding to checkout
		orderpage = casualdressespage.proceedToCheckOut();
		
		//OrderPage title verification
		orderpage.orderPageTitleVerification();
		
		//Order submission
		orderpage.OrderSubmission();
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	
}