package com.qa.SeleniumSessions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersConcept
{
	WebDriver driver;
	@BeforeSuite
	public void suite()
	{
		
	}
	
	@BeforeClass
	public void startServices()
	{
		
	}
	@BeforeTest
	@Parameters({"Browser"})
	public void enterUrl(String Browser) throws InterruptedException
	{
		if(Browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Browser.equals("ff"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		Thread.sleep(500);

		
		
	}

	
	@Test(groups = {"Test"}, invocationCount=5, description = "ebaySignInTest",alwaysRun = true)
	@Parameters({"UserName", "Password"})
	public void signIn(String UserName, String Password) throws InterruptedException
	{
		//Sign In Link
		driver.findElement(By.xpath("//a[text()=\"Sign in\"]")).click();
		//Input field UserName 
		driver.findElement(By.cssSelector("#userid")).sendKeys(UserName);
		Thread.sleep(500);
		driver.findElement(By.id("signin-continue-btn")).click();
		//Input field Password 
		driver.findElement(By.cssSelector("#pass")).sendKeys(Password);
		driver.findElement(By.id("sgnBt")).click();
	}
	
	@Test
	public void validateSellPage()
	{
		
	}
	@Test
	public void validateHelpPage()
	{
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@AfterClass
	public void stopServices()
	{
		
	}
	
	@AfterSuite
	public void aftersuite()
	{
		
	}
}
