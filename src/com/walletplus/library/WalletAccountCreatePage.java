package com.walletplus.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import com.walletplus.constants.WalletPlusConstants;

public class WalletAccountCreatePage extends WalletPlusConstants
{
   
	public String emailID, passWord;
	public String fNames, lNames, countrys, states, streets, cites, currency, dob;
	public long zipCodes, phones;
	
	
	public void createAccountWithoutCard(String fullName,String passWord, String countriesname, String statesname, 
			String streetsname, String citesname, long zipCode, String phoneNo, String currencycode,String doB)
		{
		
		String[] temp = dob.split("/");
		String day = temp[0];
		String mnth = temp[1];
		String year = temp[2];
		
		WebElement createLink = driver.findElement(By.xpath("/html/body/wallet-plus/wp-login/div/div[2]/div/div[3]/a"));
		createLink.click();
		WebElement enterEmail = driver.findElement(By.xpath("//input[@type='email']"));
		temp = fullName.split(" ");
		String email = temp[0].concat("@smail.com");
		enterEmail.sendKeys(email);
		WebElement enterPassword = driver.findElement(By.xpath("//input[@ngcontrol='password']"));
		enterPassword.sendKeys(passWord);
		WebElement rePassword = driver.findElement(By.xpath("//input[@ngcontrol='cpswd']"));
		rePassword.sendKeys(passWord);
		WebElement continue1 = driver.findElement(By.xpath("//button[@class='wpBtn']"));
		continue1.click();
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		String fName = temp[0];
		firstName.sendKeys(fName);
		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		String lName = temp[2];
		lastName.sendKeys(lName);
		WebElement country = driver.findElement(By.xpath("html/body/wallet-plus/wp-signup/div/div/div/div/div[3]/div[2]/form/div[2]/div[1]/wp-country/select"));
		Select countryList = new Select(country);
		countryList.selectByVisibleText(countriesname.toUpperCase());
		WebElement state = driver.findElement(By.xpath("//select[@ngcontrol='state']"));
		Select stateList = new Select(state);
		stateList.selectByVisibleText(statesname);
		WebElement street = driver.findElement(By.xpath("//input[@ngcontrol='addressline1']"));
		street.sendKeys(streets);
		WebElement city = driver.findElement(By.xpath("//input[@ngcontrol='city']"));
		city.sendKeys(cites);
		WebElement zip = driver.findElement(By.xpath("//input[@ngcontrol='zip']"));
		String zcode = Long.toString(zipCode);
		zip.sendKeys(zcode);
		WebElement mobileNo = driver.findElement(By.xpath("//input[@ngcontrol='mobile']"));
		mobileNo.sendKeys(phoneNo);
		WebElement currency = driver.findElement(By.xpath("//input[@ngcontrol='currency']"));
		Select CurrencyList = new Select(currency);
		CurrencyList.selectByVisibleText(currencycode);
		//WebElement mobileCode = driver.findElement(By.xpath("//button[@id='split-button']"));
		//DOB-CONVERSION ------ TODO
		WebElement birthDate = driver.findElement(By.xpath("//input[@placeholder='Date Of Birth']"));
		birthDate.click();
		WebElement years = driver.findElement(By.xpath("//select[@data-handler='selectYear']"));
		Select yearList = new Select(years);
		yearList.selectByValue(year);
		
		WebElement month = driver.findElement(By.xpath("//select[@data-handler='selectMonth']"));
		Select monthList = new Select(month);
		int mon = Integer.parseInt(mnth);
		System.out.println(mon);
		monthList.selectByIndex(mon-1);
		
		/*switch (mnth) {
		case "01": 
			
			//monthList.selectByValue("0");
			//monthList.selectByVisibleText("Jan");
			monthList.selectByIndex(11);
			break;
			
		case "02": 
			
			monthList.selectByValue("1");
			break;

		default:
			break;
		}
		*/
		
		WebElement table = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']"));
		
		List<WebElement> rowList = table.findElements(By.tagName("tr"));
		
		List<WebElement> columnList;
		
		System.out.println("No of rows in the tble are "+rowList.size());
		boolean status = false;
		for(int i=0 ; i<rowList.size(); i++)
		{
			System.out.println("4");
			columnList = rowList.get(i).findElements(By.tagName("td"));
			
			
			//int columnListSize = columnList.size();
			for(WebElement tdElement :  columnList)
			{
				String dayNo = tdElement.getText();
				if(dayNo.length()==1)
				{
					dayNo = "0".concat(dayNo);
				}
				System.out.println(dayNo);
				if(dayNo.equalsIgnoreCase(day))
				{
					tdElement.click();
					status = true;
					System.out.println("date selected "+status);
					break;
				}
			}
			
			if(status == true)
			{
				System.out.println("Loop is broken");
				break;
			}
			
			
		}
		
		
		
		WebElement checkOK = driver.findElement(By.xpath("//input[@ngcontrol='isAccepted']"));
		checkOK.click();
		WebElement continue2 = driver.findElement(By.xpath("/html/body/wallet-plus/wp-signup/div/div/div/div/div[3]/div[2]/form/button"));
		continue2.click();
		     
		
		

		}
	
}
