package com.walletplus.tests;

import java.io.IOException;

import javax.print.attribute.SetOfIntegerSyntax;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.ExcelUtils;
import com.walletplus.constants.WalletPlusConstants;
import com.walletplus.library.WalletAccountCreatePage;



public class CreateAccountDDT extends WalletPlusConstants
{
	public String xlfile=".\\src\\com\\walletplus\\testdata\\Automation_sheet.xlsx";
	public String xlsheet="";
	ExcelUtils xl=new ExcelUtils();
	Object[][] data;
	//public int j=1;
	
	
	@Test(dataProvider="createWalletdata")
	public void createWalletDDT( String fullName, String passWord, String country, String state,
            String street, String city, long zipCode, String mobile, String currCode, String dOB) 
	{
		//boolean res;
		
		
		System.out.println("country- "+country);
		System.out.println("currCode- "+currCode);
		
		
		WalletAccountCreatePage whome=new WalletAccountCreatePage();
		whome.createAccountWithoutCard(fullName,passWord,country,state,street,city,zipCode,mobile,currCode,dOB);
	/*if (res) 
		{
			xl.setCellData(xlfile, xlsheet, j, 3, "Pass");
			xl.fillGreenColor(xlfile, xlsheet, j, 3);
		} else 
		{
			xl.setCellData(xlfile, xlsheet, j, 3, "Fail");
			xl.fillRedColor(xlfile, xlsheet, j, 3);
		}
		j++;*/
	}
	
	
	@DataProvider
 	public Object[][] createWalletdata() 	
	{
 			
	try{
			
		//rc - RowCount, cc - ColumnCount
		int rc,cc;
		rc=xl.getRowCount(xlfile, xlsheet);
 		cc=xl.getCellCount(xlfile, xlsheet, 1);
 		data=new Object[rc][cc];
 		for (int i = 1; i <= rc; i++) 
 		{
 			
 			data[i-1][1]=xl.getCellData(xlfile, xlsheet, i, 0);   // FULL NAME
 			data[i-1][2]=xl.getCellData(xlfile, xlsheet, i, 1);   // PASSWORD
 			data[i-1][2]=xl.getCellData(xlfile, xlsheet, i, 2);   // COUNTRY
 			data[i-1][2]=xl.getCellData(xlfile, xlsheet, i, 3);   // STATE
 			data[i-1][2]=xl.getCellData(xlfile, xlsheet, i, 4);   // STREET
 			data[i-1][2]=xl.getCellData(xlfile, xlsheet, i, 5);   // CITY
 			data[i-1][2]=xl.getCellData(xlfile, xlsheet, i, 6);   // ZIPCODES
 			data[i-1][2]=xl.getCellData(xlfile, xlsheet, i, 7);   // PHONES
 			data[i-1][2]=xl.getCellData(xlfile, xlsheet, i, 8);   // CURRENCY
 			data[i-1][2]=xl.getCellData(xlfile, xlsheet, i, 9);   // DOB
 		}
 			
		} catch(IOException ie)
		  {
			System.err.println("EXCEL FILE/SHEET is MISSING -"+ie);
		  }
		return data;
 	}

}




