package com.ecomm.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.ecomm.pages.HomePage;
import com.ecomm.pages.LoginPage;
import com.ecomm.pages.OrderHistoryPage;

public class HomePageTests extends BaseClass {
			
	LoginPage lp;
	
	HomePage hp;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialise();
		lp = new LoginPage();
		hp = lp.ClickLogin(username, password);
	}
	
	@Test(priority=1, description="Verify HomePageTitle")
	public void HomePageTitleTest() {
		
		String actualTitle = hp.VerifyHomePageTitle();
		Assert.assertEquals(actualTitle, "My account - My Store");
	}
	
	@Test(priority=2, enabled=false,  description="Verify Order History")
	public void OrderHistory() throws InterruptedException {
		hp.ClickOnOrderHistory();
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
}
