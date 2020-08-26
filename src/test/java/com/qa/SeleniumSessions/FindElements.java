package com.qa.SeleniumSessions;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElements
{
	
	WebDriver driver;
	@BeforeTest
	public void chromelogin() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		 driver = new ChromeDriver();
	     driver.get("https://www.spicejet.com/");
	     System.out.println("Chrome and spicejet site is opned");
	     
	     
	}
	
	@Test
	public void getText()
	{
		driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     java.util.List<WebElement> ls = driver.findElements(By.tagName("div"));
	     System.out.println(ls.size());
	     for(int i = 0; i < ls.size(); i++)
	     {
	    	 System.out.println(ls.get(i).getText());
	     }
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}
