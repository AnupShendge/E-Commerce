package com.ecomm.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ecomm.utilities.ReadConfig;

public class BaseClass {
	static ReadConfig rc = new ReadConfig();
	
	public static String baseURL = rc.getApplicationURL() ;
	public String username = rc.getUsername() ;
	public String password = rc.getPassword() ;
	public static WebDriver driver;
	
	
	
	public static void initialise() {
		
		System.setProperty("webdriver.chrome.driver",rc.getChromePath());
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		
	}
	
	
	
	
}
