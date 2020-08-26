package com.excel.lib.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

//Excel file
public class TestUtil 
{
	static Workbook book;
	static Sheet sheet;


	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\ExcelSheets\\CreateAccount_ebay.xlsx";

	public static Object[][] getTestData(String sheetName){
			
			FileInputStream file = null;
			try{
				file = new FileInputStream(TESTDATA_SHEET_PATH);
			}catch (FileNotFoundException e){
				e.printStackTrace();
				
			}
			try{
				book = WorkbookFactory.create(file);
			}catch(IOException e){
			e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for (int i = 0; i < sheet.getLastRowNum();i++){
				for(int k = 0; k < sheet.getRow(0).getLastCellNum();k++){
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					//System.out.printlt(data[i][k]);
				}
			}
			return data;	
	}
}
