package com.ecomm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecomm.tests.BaseClass;

public class LoginPage extends BaseClass {
	
	
	@FindBy(xpath="//*[@class='login']")
	WebElement SignIn ;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement EmailAddress;
	
	@FindBy(name="passwd")
	WebElement Password;
	
	@FindBy(name="SubmitLogin")
	WebElement SubmitLogin;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
		
	
	public HomePage ClickLogin(String email, String pwd) throws InterruptedException {
		SignIn.click();
		EmailAddress.sendKeys(email);
		Password.sendKeys(pwd);
		SubmitLogin.click();
		return new HomePage();
		
	}
	
	public void InvalidLogin(String email, String pwd) {
		SignIn.click();
		EmailAddress.sendKeys(email);
		Password.sendKeys(pwd);
		SubmitLogin.click();
	}
		
		

}
