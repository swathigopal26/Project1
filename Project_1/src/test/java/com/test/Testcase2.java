package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.CasualDressesPage;
import com.pages.DressesPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.OrderPage;
import com.pages.SummerDressesPage;

public class Testcase2 extends BaseClass {
	
	public Testcase2()
	{
		super();
	}

	LoginPage loginpage;
	HomePage homepage;
	SummerDressesPage summerdressespage;
	OrderPage orderpage;
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test
	public void testMethod2() throws Throwable
	{
		//click on signin link
		loginpage.signInMethod();
				
		//Login page title verification
		loginpage.verifyTitle();
				
		//Login page logo verification
		loginpage.logoVerify();
				
		//Login to myaccount
		homepage = loginpage.loginTest();
		
		//Navigation to SummerDressesPage
		summerdressespage= homepage.summerDressesPageNavigation();
		
		//SummerDressesPage title verification
		summerdressespage.summerDressesPageTitleVerification();
		
		//View more detail about chossed dress and add to cart
		orderpage = summerdressespage.moreInfoAndAddToCart();
		
		//order page title verification test
		orderpage.orderPageTitleVerification();
		
		//order submission
		orderpage.OrderSubmission();
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
