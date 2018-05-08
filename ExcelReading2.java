package com.wordpress.login;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading2 {

	public static void main(String[] args) throws Exception {
		
		
		File inputExcel = new File("C:\\Users\\amita\\Desktop\\Selenium\\ExcelTestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(inputExcel);
		
		XSSFWorkbook wb1 = new XSSFWorkbook(fis); 	//loads the workbook .xlsx files
		///HSSFWorkbook  this class is used for .xls files 

		XSSFSheet sheet1=wb1.getSheetAt(0);  /// load the first sheet in the excel file
		int rowcount = sheet1.getLastRowNum();
		
		System.out.println("The total rows are  "  + rowcount);
		System.out.println("Below is data from spread sheet");
		for (int i=0;i<rowcount;i++) {
			
			String Col1=sheet1.getRow(i).getCell(0).getStringCellValue();
			String Col2=sheet1.getRow(i).getCell(1).getStringCellValue();
			
			System.out.println(Col1 + "  " + Col2);
}
			
				
		wb1.close();
}
}