package com.ecomm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecomm.tests.BaseClass;

public class HomePage extends BaseClass {
		
	@FindBy(xpath="//*[text()='Order history and details']")
	WebElement orderHistoryAndDetails;
	
	@FindBy(xpath="(//*[text()='My credit slips'])[1]")
	WebElement myCreditSlips;
	
	@FindBy(xpath="//*[text()='My wishlists']")
	WebElement myWishLists;
	
	@FindBy(xpath="//*[text()='My addresses']")
	WebElement myAddress;
	
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public MyAddressPage ClickOnMyAddress() {
		myAddress.click();
		return new MyAddressPage();
	}
	public OrderHistoryPage ClickOnOrderHistory() throws InterruptedException {
		orderHistoryAndDetails.click();
		return new OrderHistoryPage();
	}
	
	public MyCreditSlipsPage ClickOnMyCredit() {
		myCreditSlips.click();
		return new MyCreditSlipsPage();
	}
	
	public MyWishListsPage ClickOnMyWishList() {
		myWishLists.click();
		return new MyWishListsPage();
	}
	
	
}
