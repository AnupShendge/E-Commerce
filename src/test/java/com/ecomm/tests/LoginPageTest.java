package com.ecomm.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecomm.pages.HomePage;
import com.ecomm.pages.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	
	
	@BeforeMethod(alwaysRun=true)
	public void setup() {
		initialise();
		lp = new LoginPage();
		
	}
	
	@Test(groups= {"smoke"}, priority=1, description="Verify Login Test")
	
	public void LoginTest() throws InterruptedException {
		hp = lp.ClickLogin(username, password);
		
	}
	
	@Test(groups= {"regression"}, priority=2, dataProvider="getData", description="Verify login with invalid credentials")
	public void InvalidLoginTest(String email, String pwd) {
		lp.InvalidLogin(email, pwd);
		
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[2][2] ;
		data[0][0] = "shendgeanup@gmail.com" ;
		data[0][1]= "$%Qwerty";
		
		data[1][0] = "anup@gmail.com" ;
		data[1][1]= "Qwerty#4627";
		
		
		return data;
	}
	@AfterMethod(alwaysRun=true)
	public void teardown() {
		
		driver.quit();
	}
	
	
	

}
