package com.ecomm.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecomm.pages.HomePage;
import com.ecomm.pages.LoginPage;
import com.ecomm.pages.TShirtsPage;

public class TShirtsPageTest extends BaseClass {
		LoginPage lp;
		HomePage hp;
		TShirtsPage tp;
		
		 @BeforeMethod(alwaysRun=true)
			public void setup() throws InterruptedException {
				initialise();
				lp = new LoginPage();
				hp= lp.ClickLogin(username, password);
				tp = hp.clickOnTShirts();
		 }
		 
		 @Test(groups= {"smoke"}, description="Verify the Add To Cart Functionality")
		 public void VerifyAddToCart() throws InterruptedException {
			 tp.AddToCartFuncationality();
		 }
				
}
