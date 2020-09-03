package com.qa.SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Groupsconcept_ebaySite 
{
	static WebDriver driver;
	
	@Parameters({"Browser","Url"})
	@BeforeTest(alwaysRun = true, enabled = true, groups = "Setup")
	public void setUp(@Optional("Chrome")String Browser,@Optional("Url")String Url) throws InterruptedException
	{
		 
	     if(Browser.equalsIgnoreCase("Chrome"))
	     {
	    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.get(Url);
		     
	     }
	     else if(Browser.equalsIgnoreCase("FF"))
	     {
	    	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\geckodriver.exe");
			 driver = new FirefoxDriver();
			 driver.get(Url);

		     
	     }
	     driver.manage().window().maximize();
	     driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	    // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     driver.manage().deleteAllCookies();

	}
	
	@Parameters({"Username", "Password"})
	@BeforeMethod(enabled = true, groups = "LoginPage")
	public void loginTest(String Username,String Password) throws InterruptedException
	{
		//Click on SignIn Link
		driver.findElement(By.xpath("//a[text()=\"Sign in\"]")).click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector("#userid")).sendKeys(Username);
	    driver.findElement(By.cssSelector("#pass")).sendKeys(Password);
	    driver.findElement(By.cssSelector("#sgnBt")).click();
	}
	
	@Test
	public void validateCatogery()
	{
		System.out.println("checking catogry dropdown list");
	}
}
