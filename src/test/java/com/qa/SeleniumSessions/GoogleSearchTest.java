package com.qa.SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.Var;

public class GoogleSearchTest
{

	WebDriver driver;
	@BeforeTest
	public void chromelogin() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		 driver = new ChromeDriver();
	     driver.get("https://www.google.com");
	    // driver.get("https://signin.ebay.com/");
	     System.out.println("Chrome is opned");
	     Thread.sleep(500);
	}
	
	@Test
	public void googleSearch() throws InterruptedException
	{
		WebElement search = driver.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]"));
		driver.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]")).sendKeys("test java");
		Thread.sleep(500);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li/div/div/div/span"));
		Thread.sleep(500);
		System.out.println(list.size());
		for(int i = 0 ; i < list.size(); i++)
		{
			String ListName = list.get(i).getText();
			//System.out.println(ListName);
			if(ListName.equals("test java online"))
			{
				list.get(i).click();
				break;
			}
		}
		
	}
}
