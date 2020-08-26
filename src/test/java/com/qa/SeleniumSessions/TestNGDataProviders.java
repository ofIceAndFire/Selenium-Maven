package com.qa.SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.lib.util.TestUtil;
import com.excel.lib.util.Xls_Reader;

public class TestNGDataProviders
{
	WebDriver driver;
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
	        System.setProperty("webdriver.chrome.silentOutput", "true");
			 driver = new ChromeDriver();
		     driver.get("https://www.ebay.com");
		    // driver.get("https://signin.ebay.com/");
		     System.out.println("Chrome and ebay site is opned");
		     Thread.sleep(500);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object data[][] = TestUtil.getTestData("ebay_AccountsData");
		return data;


	}
	@Test(dataProvider = "getData")
	public void createAccount(String FirstName,String LastName,String Email,String Password) throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()='register']")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("firstname")).sendKeys(FirstName);
		Thread.sleep(500);
		driver.findElement(By.id("lastname")).sendKeys(LastName);
		Thread.sleep(500);
		driver.findElement(By.id("email")).sendKeys(Email);
		Thread.sleep(500);
		driver.findElement(By.id("PASSWORD")).sendKeys(Password);
		Thread.sleep(500);
		driver.findElement(By.id("ppaFormSbtBtn")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[text()='register']")).click();

	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
