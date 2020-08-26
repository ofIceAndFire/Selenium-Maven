package com.qa.SeleniumSessions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HTMLUnitDriverConcept 
{
	WebDriver driver;
	@BeforeTest
	public void chromelogin() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		WebDriver driver = new org.openqa.selenium.htmlunit.HtmlUnitDriver();
        
        //driver = new ChromeDriver();
         System.out.println("Title before browser :" +driver.getTitle());
	     driver.get("https://www.spicejet.com/");
	     System.out.println("Title after launching browser :" +driver.getTitle());
	     System.out.println("Chrome and ebay site is opned");
	     Thread.sleep(500);
//			driver.findElement(By.id("header-addons")).click();
//			Thread.sleep(500);
//
//			driver.findElement(By.xpath("//a[contains(text(),'SpiceMax')]")).click();
//			System.out.println(driver.getTitle());
	}
	
	
	
	
}
