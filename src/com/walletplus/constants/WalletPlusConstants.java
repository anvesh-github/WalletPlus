package com.walletplus.constants;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class WalletPlusConstants
{
	
	public static WebDriver driver = new FirefoxDriver();
	public static String URL = "http://dev.walletplus.com/login";
	
	@BeforeSuite
	public void launchApp()
	{
		System.out.println(URL);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(URL);
		
	}
	

	@AfterSuite
	 public static void closeApp()
	 {
		 driver.close();
	 }
	

}
