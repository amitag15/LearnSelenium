package com.wordpress.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExcel {
	WebDriver driver;
	
	@Test(dataProvider="DataforLogin")
	public void LoginWordPress(String UID, String Passwd) throws Exception{
	driver = new ChromeDriver(); 
	driver.get("http://demosite.center/wordpress/wp-login.php");
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(UID);
	driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(Passwd);
	driver.findElement(By.xpath("//input[@id='wp-submit'] ")).click();
	
	Thread.sleep(5000);
	
	Assert.assertTrue(driver.getTitle().contains("Dashboard"),"Login Failed this time as the uder name and password is not correct");
	System.out.println("Login was successfull with provided credenatials");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@DataProvider(name="DataforLogin")
	public Object[][] InputData()  /// 2 dimensional Array
	{
		ExcelDataConfig config = 
		new ExcelDataConfig("C:\\Users\\amita\\Desktop\\Selenium\\Workspace\\LearnTestNG\\TestData\\TestData.xlsx");
		int rowCount = config.getRowCount(2);
		
		System.out.println("Rowcount is:  "+ rowCount);
		
		Object[][] data = new Object[rowCount][2];
		
		for (int i=0;i<rowCount;i++)
		{
			data[i][0] = config.getData(2, i, 0);
			data[i][1] = config.getData(2, i, 1);
			
		}
			
		return data;
	}
}