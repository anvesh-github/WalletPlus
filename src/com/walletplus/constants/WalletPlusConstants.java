package com.walletplus.constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class WalletPlusConstants
{
	public  WebDriver driver = null;;
	private String WALLET_PLUS_URL = null;;
	private Long timeout = null;
	public static String propertiespath=".//properties//";
	public String browser=null;
	FileInputStream fis = null;
	Properties property = null;
	
	
	
	@BeforeSuite( alwaysRun = true)
	public void launchApp()
	{
		
		try{
		fis = new FileInputStream(propertiespath+"walletplus_variables.properties");
		property = new Properties();
		property.load(fis);
		this.WALLET_PLUS_URL = property.getProperty("WalletPLUS_URL");
		this.timeout =Long.parseLong(property.getProperty("ImplicitTimeOut"));
		}catch(IOException ie)
		{
			System.err.println("Unable to find property file in the specified path");
			ie.printStackTrace();
		}
		String browser = property.getProperty("Browser");
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		
		driver.navigate().to(property.getProperty(WALLET_PLUS_URL));
		}
	}
	

	@AfterSuite(alwaysRun = true)
	 public void tearDown()
	 {
		 driver.close();
		//Thread.sleep(3000);
		 driver.quit();
	 }
	

}
