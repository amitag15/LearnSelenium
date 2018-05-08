package com.wordpress.login;

public class ReadExcelData1 {

	public static void main(String[] args) {
	ExcelDataConfig excel = 
		new ExcelDataConfig("C:\\Users\\amita\\Desktop\\Selenium\\ExcelTestData\\TestData.xlsx");
		
	System.out.println("Excel Data is: " + excel.getData(1, 0, 0));

	}

}
