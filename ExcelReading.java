package com.wordpress.login;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

	public static void main(String[] args) throws Exception {
		
		
		File inputExcel = new File("C:\\Users\\amita\\Desktop\\Selenium\\ExcelTestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(inputExcel);
		
		XSSFWorkbook wb1 = new XSSFWorkbook(fis); 	//loads the workbook .xlsx files
		///HSSFWorkbook  this class is used for .xls files 

		XSSFSheet sheet1=wb1.getSheetAt(0);  /// load the first sheet in the excel file
		
		String S1 = sheet1.getRow(1).getCell(1).getStringCellValue();
		System.out.println("Current data is   " + S1);
		
		String S2 = sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println("Current data is   " + S2);
		wb1.close();
}
}