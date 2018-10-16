package com.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.TshirtsPage;

public class Testcase3 extends BaseClass {
	
	public Testcase3()
	{
		super();
	}

	LoginPage loginpage;
	HomePage homepage;
	TshirtsPage tshirtpage;
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test
	public void testMethod3() throws Throwable
	{
		//click on signin link
		loginpage.signInMethod();
		
		//verify loginpage title
		loginpage.verifyTitle();
		
		//verify loginpage logo
		loginpage.logoVerify();
		
		//login to myaccount
		homepage = loginpage.loginTest();
		
		//verify homepage title
		homepage.homePageTitleVerification();
		
		//navigation to t-shirts page
		tshirtpage = homepage.tShirtPageNavigation();
		
		//verify t-shirt page title
		tshirtpage.tShirtPageTitleVerification();
		
		//add chossed dress to wishlist
		tshirtpage.moreInfoAndAddToWishList();
		
		//View details of wishlist
		homepage.ViewmyWishList();
	}
}
