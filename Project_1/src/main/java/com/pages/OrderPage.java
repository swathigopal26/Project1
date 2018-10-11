package com.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;

public class OrderPage extends BaseClass {

	public OrderPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Shopping-cart summary')]")
	public WebElement summarySection;
	
	@FindBy(linkText = "Proceed to checkout") 
	public WebElement ProceedToCheckoutLink;
	
	@FindBy(xpath = "//h1[contains(text(),'Addresses')]")
	public WebElement addressesSection;
	
	@FindBy(xpath = "//button[@type = 'submit' and @name='processAddress']")
	public WebElement ProceedToCheckoutLink_addressTab;
	
	@FindBy(xpath = "//h1[contains(text(),'Shipping')]")
	public WebElement shippingSection;
	
	@FindBy(xpath = "//button[@type = 'submit' and @name='processCarrier']")
	public WebElement ProceedToCheckoutLink_shippingTab;
	
	@FindBy(xpath = "//input[@type = 'checkbox']")
	public WebElement checkBox;
	
	@FindBy(xpath = "//h1[contains(text(), 'Please choose your payment method')]")
	public WebElement paymentSection;
	
	@FindBy(xpath = "//a[@class = 'cheque']")
	public WebElement payByCheckLink;
	
	@FindBy(xpath = "//h1[contains(text(), 'Order summary')]")
	public WebElement orderSummarySection;
	
	@FindBy(xpath = "(//button[@type = 'submit'])[2]")
	public WebElement confirmOrderButton;
	
	@FindBy(xpath = "//p[contains(text(), 'Your order on My Store is complete.')]")
	public WebElement orderCompleteMessageText;
	
	
	public void orderPageTitleVerification()
	{
		String OrderPageTitle = driver.getTitle();
		Assert.assertEquals(OrderPageTitle, "Order - My Store");
		System.out.println("order Page is displayed");
	}
	
	public void OrderSubmission()
	{
	
		Assert.assertEquals(summarySection.isDisplayed(), true);
		ProceedToCheckoutLink.click();
		Assert.assertEquals(addressesSection.isDisplayed(), true);
		ProceedToCheckoutLink_addressTab.click();
		Assert.assertEquals(shippingSection.isDisplayed(), true);
		checkBox.click();
		ProceedToCheckoutLink_shippingTab.click();
		Assert.assertEquals(paymentSection.isDisplayed(), true);
		payByCheckLink.click();
		Assert.assertEquals(orderSummarySection.isDisplayed(), true);
		confirmOrderButton.click();
		Assert.assertEquals(orderCompleteMessageText.isDisplayed(), true);
		System.out.println("order submission completed");
	}
	
}
