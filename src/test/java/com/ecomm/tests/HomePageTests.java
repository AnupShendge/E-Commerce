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
	
	@BeforeMethod(alwaysRun=true)
	public void setup() throws InterruptedException {
		initialise();
		lp = new LoginPage();
		hp = lp.ClickLogin(username, password);
	}
	
	@Test(groups= {"smoke"}, priority=1, description="Verify HomePageTitle")
	public void HomePageTitleTest() {
		
		String actualTitle = hp.VerifyHomePageTitle();
		Assert.assertEquals(actualTitle, "My account - My Store");
	}
	 
	@Test(groups= {"regression"}, priority=2, description="Verify Order History")
	public void OrderHistory() throws InterruptedException {
		hp.ClickOnOrderHistory();
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown() {
		
		driver.quit();
	}
}
