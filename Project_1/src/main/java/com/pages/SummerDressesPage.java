package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.base.BaseClass;

public class SummerDressesPage extends BaseClass {
	
	@FindBy (xpath ="(//a[@class = 'product_img_link'])[3]/img[@title = 'Printed Chiffon Dress']")
	public WebElement summerDressesImage;
	
	@FindBy(xpath ="//a[contains(text(), 'Printed Chiffon Dress')]/parent::h5//following-sibling::div[@class = 'button-container']//a[@title = 'View']")
	public WebElement dressesChossedMoreIcon;
	
	@FindBy (xpath = "//a[@class = 'btn btn-default button-plus product_quantity_up']")
	public WebElement quantityPlusIcon;
	
	@FindBy (xpath ="//input[@id= 'quantity_wanted']")
	public WebElement quantityTextBox;
	
	@FindBy(name = "Green")
	public WebElement greenColourIcon;
	
	@FindBy(name = "group_1")
	public WebElement sizeDropDown;
	
	@FindBy(xpath ="//button[@name= 'Submit']")
	public WebElement addToCartButton;
	
	@FindBy (linkText = "Proceed to checkout")
	public WebElement proceedToCheckOutButton;
	

	public SummerDressesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void summerDressesPageTitleVerification()
	{
		String summerDressesTitle = driver.getTitle();
		Assert.assertEquals(summerDressesTitle, "Summer Dresses - My Store");
		System.out.println("Navigated to summer dresses page");
	}
	
	//choose the dress and view the more information and add to cart
	public OrderPage moreInfoAndAddToCart() throws Throwable
	{
	Actions action = new Actions(driver);
	action.moveToElement(summerDressesImage).build().perform();
	Thread.sleep(3000);
	//more icon is clicked
	dressesChossedMoreIcon.click();
	//quantity increased to 2
	quantityPlusIcon.click();
	Thread.sleep(2000);
	Assert.assertEquals(quantityTextBox.getAttribute("value"), "2");
	//'M' size selected 
	Select sel = new Select(sizeDropDown);
	sel.selectByValue("2");
	//green colour choosed
	greenColourIcon.click();
	//addToCart button is clicked
	addToCartButton.click();
	//click on Proceed to check out
	proceedToCheckOutButton.click();
	return new OrderPage();
	}
}
