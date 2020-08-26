package com.qa.SeleniumSessions;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandles
{
	WebDriver driver;
	@BeforeTest
	public void chromelogin() throws InterruptedException
	{
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		 driver = new ChromeDriver();
	     driver.get("https://demoqa.com/automation-practice-switch-windows/");
	     System.out.println("Chrome and ebay site is opned");

	  }
	@Test
	public void windowHandles() throws InterruptedException, IOException
	{
		driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     System.out.println(driver.getTitle());
	     driver.findElement(By.id("button1")).click();
		 driver.findElement(By.xpath("//button[text()=\"New Message Window\"]")).click();
		 driver.findElement(By.xpath("//button[text()=\"New Browser Tab\"]")).click();
		 
		 //MainWindow
		 String MainWindow = driver.getWindowHandle();
		 //Set of Child Windows
		 Set<String> NumWindows = driver.getWindowHandles();
		 
		 System.out.println("Number of Windows :" +NumWindows.size());
		 Iterator<String> Iterator = NumWindows.iterator();
		 while(Iterator.hasNext())
		 {
			 String ChildWindow = Iterator.next();
			 if(!MainWindow.equals(ChildWindow))
			 {
				 driver.switchTo().window(ChildWindow);
				// System.out.println("Title After popup :" +driver.getTitle());
				 driver.close();
			 }
			 else
			 {
				 driver.switchTo().window(MainWindow);
				 System.out.println("Title before popup :" +driver.getTitle());
				 
			 }
		 }
		 driver.switchTo().window(MainWindow);
		 Thread.sleep(300);
		 driver.findElement(By.id("alert")).click();
		 Alert alert = driver.switchTo().alert();
		 System.out.println(driver.switchTo().alert().getText());
		 alert.accept();
		 
	     driver.quit();
//	     String ParentWindowID = iterator.next();
//	     System.out.println("ParentWindowID :"+ParentWindowID);
//	     driver.switchTo().window(ParentWindowID);
//	     
//	     String ChildWindowone = iterator.next();
//	     System.out.println("ChildWindowID :" +ChildWindowone);
//	     driver.switchTo().window(ChildWindowone);
//	     driver.close();
//	     
//	     //ChildWindowTwo
//	     Thread.sleep(500);
//	  
//	     System.out.println("Clicked on WindowTwo");
//	    String ChildWindowIDTwo = iterator.next();
//	     System.out.println("ChildWindowIDTwo :" +ChildWindowIDTwo);
//	    driver.switchTo().window(ChildWindowIDTwo);
//	    Thread.sleep(200);
//	    driver.close();
//	    System.out.println("closed");
//	    driver.quit();
	     

	}

	

}
