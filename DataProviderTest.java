package com.wordpress.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
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
		
		Object[][] data1 = new Object[3][2];
		
		data1[0][0] = "admin";
		data1[0][1] = "pass";
		
		data1[1][0] = "admin";
		data1[1][1] = "demo123";
		
		data1[2][0] = "test";
		data1[2][1] = "test1245";
		return data1;
	}
}