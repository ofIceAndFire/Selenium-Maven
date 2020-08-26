package com.qa.SeleniumSessions;
import java.io.File;

import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;


public class NavigateScreenShot
{

	WebDriver driver;
	 String Dest = "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\ScreenShots\\";

	@BeforeTest
	public void chromelogin() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		 driver = new ChromeDriver();
	     driver.get("https://www.spicejet.com/");
	     System.out.println("Chrome and spicejet site is opned");
	     driver.navigate().to("https://demoqa.com/droppable/");
	     driver.navigate().to("https://www.facebook.com/");

	  }
	
	@Test
	public void takeScreenShot() throws InterruptedException, IOException
	{
		driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     Thread.sleep(100);
	     driver.navigate().refresh();
	     driver.navigate().back();
		 driver.navigate().forward();
		 
		//Convert webdriver object to TakeScreenshot
		 TakesScreenshot src = ((TakesScreenshot)(driver));
		//Call getScreenshotAs method to create image file
		 File SrcFile = src.getScreenshotAs(OutputType.FILE);
		 org.apache.commons.io.FileUtils.deleteDirectory(new File(Dest));
		//Copy file at destination
		 org.apache.commons.io.FileUtils.copyFile(SrcFile, new File(Dest.concat("facebook.png")));
		 System.out.println("the Screenshot is taken");
		//FileHandler.createDir("C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\ScreenShots\\");
		 
		 
		 

	}

	
	
}
