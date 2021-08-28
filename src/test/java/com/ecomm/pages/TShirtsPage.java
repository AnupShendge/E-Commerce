package com.ecomm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecomm.tests.BaseClass;

public class TShirtsPage extends BaseClass {
	@FindBy(xpath="(//*[@title='Faded Short Sleeve T-shirts'])[2]")
	WebElement  shortSleeve;
	
	@FindBy(xpath="//*[@title='Add to cart']")
	WebElement  addToCart;
	
	@FindBy(xpath="//*[@title='Proceed to checkout']")
	WebElement  checkOut;
	
	@FindBy(xpath="(//*[@title='Proceed to checkout'])[2]")
	WebElement  proceedToCheckOut;
	
	@FindBy(xpath="//*[@name='processAddress']")
	WebElement  processAddress;
	
	@FindBy(xpath="//*[@type='checkbox']")
	WebElement  checkBox;
	
	@FindBy(xpath="//*[@name='processCarrier']")
	WebElement  processCarrier;
	
	@FindBy(xpath="//*[@class='bankwire']")
	WebElement  paymentMethod;
	
	@FindBy(xpath="(//*[@type='submit'])[2]")
	WebElement  confirmOrder;
	
	@FindBy(xpath="//*[@title='Back to orders']")
	WebElement  backToOrder;
	
	@FindBy(xpath="(//*[@href='http://automationpractice.com/'])[3]")
	WebElement  home;
	
	
	
	
	public TShirtsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void AddToCartFuncationality() throws InterruptedException {
		Actions ac = new Actions(driver);
		ac.moveToElement(shortSleeve).perform();
		addToCart.click();
		Thread.sleep(2000);
		checkOut.click();
		Thread.sleep(2000);
		proceedToCheckOut.click();
		processAddress.click();
		checkBox.click();
		processCarrier.click();
		paymentMethod.click();
		confirmOrder.click();
		Thread.sleep(3000);
		backToOrder.click();
		Thread.sleep(3000);
		home.click();
		
		
	}
}
