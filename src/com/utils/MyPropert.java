package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.walletplus.constants.WalletPlusConstants;



public class MyPropert extends WalletPlusConstants {
	
	public static String propertiespath=".//properties//";

	public static void main(String[] args) 
	{
		try{
			
			FileInputStream file = new FileInputStream(propertiespath+"walletplus_variables.properties");
			Properties prop = new Properties();
			prop.load(file);
			System.out.println(prop.getProperty("WalletPLUS_URL"));
			
		   }
		catch(IOException ie)
		{
			System.err.println(ie);
		}


	}
	
	
}
