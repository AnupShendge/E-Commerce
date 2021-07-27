package com.ecomm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ecomm.tests.BaseClass;

public class MyAddressPage extends BaseClass {
	
	@FindBy(xpath="//*[@title='Add an address']")
	WebElement addNewAddress;
	
	@FindBy(linkText="Add a new address")
	WebElement link;
	
	@FindBy(xpath="//*[@id='firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//*[@id='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//*[@id='address1']")
	WebElement Address;
	
	@FindBy(xpath="//*[@id='city']")
	WebElement City;
	
	@FindBy(xpath="//*[@id='id_state']")
	WebElement State;
	
	@FindBy(xpath="//*[@id='postcode']")
	WebElement PostCode;
	
	@FindBy(xpath="//*[@id='id_country']")
	WebElement Country;
	
	@FindBy(xpath="//*[@id='phone']")
	WebElement PhoneNumber;
	
	@FindBy(xpath="//*[@id='phone_mobile']")
	WebElement MobileNumber;
	
	@FindBy(xpath="//*[@id='alias']")
	WebElement ReferenceAddress;
	
	@FindBy(xpath="//*[@id='submitAddress']")
	WebElement Submit;
	
	
	
	
	
	public MyAddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void AddNewAddress(String fn, String ln, String address, String city, String postCode, String phoneNumber, String mobileNumber, String rfa) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", link);
		addNewAddress.click();
		firstName.clear();
		firstName.sendKeys(fn);
		lastName.clear();
		lastName.sendKeys(ln);
		Address.sendKeys(address);
		City.sendKeys(city);
		Select s = new Select(State);
		s.selectByIndex(32);
		PostCode.sendKeys(postCode);
		Select s1 = new Select(Country);
		s.selectByIndex(21);
		PhoneNumber.sendKeys(phoneNumber);
		MobileNumber.sendKeys(mobileNumber);
		ReferenceAddress.clear();
		ReferenceAddress.sendKeys(rfa);
		Submit.click();
		
		
		
		
		
	}

}
