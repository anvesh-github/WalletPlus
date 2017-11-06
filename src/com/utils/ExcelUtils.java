package com.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{
	
	
	
		
		FileInputStream fi;
		FileOutputStream fo;
		XSSFWorkbook wb;
		XSSFSheet ws;
		XSSFRow row;
		XSSFCell cell;
		

		//method to count no. of rows present in xlSheet
		public int getRowCount(String xlfile,String xlsheet) throws IOException
		{		
		int rowcount;
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		rowcount=ws.getLastRowNum();
		return rowcount;		
		}
		
		
		public int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
		{
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			int cellcount=row.getLastCellNum();
			return cellcount;
		}
		
		
		
		public String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
		{
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			cell=row.getCell(colnum);
			String data=cell.getStringCellValue();
			return data;
		}
		
		
		
		
		public void setCellData(String inputxlfile,String xlsheet,
				     int rownum,int colnum,String data,String outputxlfile) throws IOException
		{
			fi=new FileInputStream(inputxlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			cell=row.createCell(colnum);
			cell.setCellValue(data);
			fo=new FileOutputStream(outputxlfile);
			wb.write(fo);
			
			fi.close();
			fo.close();
			
		}
		
		
		
		
	

	
	


}
