package com.excel.lib.util;

public class ExcelUtilTest {

	public static void main(String[] args)
	{
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\ExcelSheets\\Book1.xlsx");
		int RowCount = reader.getRowCount("SampleTestData");
		System.out.println("RowCount :" +RowCount);
		int ColumnCount = reader.getColumnCount("SampleTestData");
		System.out.println("ColumnCount :" +ColumnCount);
		reader.removeColumn("SampleTestData", 10);
		System.out.println("ColumnCount :" +ColumnCount);

//		reader.addSheet("PayerPortal");
//		reader.addSheet("ProviderPortal");

		int rowCount = reader.getRowCount("PayerPortal");
		System.out.println(rowCount);
		int columnCount = reader.getColumnCount("PayerPortal");
		System.out.println(columnCount);
		String cellData = reader.getCellData("PayerPortal", 1, 2);
		System.out.println(cellData);
		


		
	}

}
