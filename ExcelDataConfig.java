package com.wordpress.login;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sh1;
	
	public ExcelDataConfig(String ExcelPath)
	{
		try {
			File fname = new File(ExcelPath);
			FileInputStream fis = new FileInputStream(fname);
			 wb = new XSSFWorkbook(fis);
			 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
							}
	}

	public String getData(int SheetNo, int RowNum, int ColNum)
	{
		sh1 = wb.getSheetAt(SheetNo);
		String data = sh1.getRow(RowNum).getCell(ColNum).getStringCellValue(); 
		return data;
	}
	
	public int getRowCount(int sheetIndex)
	{
		int RCount = wb.getSheetAt(sheetIndex).getLastRowNum();
		RCount = RCount+1;
		return RCount;
	}
	
}
