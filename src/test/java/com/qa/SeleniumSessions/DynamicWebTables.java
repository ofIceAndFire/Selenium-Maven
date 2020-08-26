package com.qa.SeleniumSessions;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Method1 :- With List and for loop
//Method2 :- Custom xpath

public class DynamicWebTables
{

	WebDriver driver;
	@BeforeTest
	public void chromelogin() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		 driver = new ChromeDriver();
	     driver.get("https://cosmocode.io/automation-practice-webtable/");
	    // driver.get("https://signin.ebay.com/");
	     System.out.println("Chrome and WebTables site is opned");
	     Thread.sleep(500);
	}
	
	@Test
	public void webTables() throws InterruptedException
	{
//		java.util.List<WebElement> rownum = driver.findElements(By.tagName("tr"));
//		System.out.println(rownum.size());
//		for(int i = 0 ; i < rownum.size() ; i++)
//		{
//			System.out.println(rownum.get(i).getText());
//		}
		//table[@id='countries']/tbody/tr[6]/td[2]
		//table[@id='countries']/tbody/tr[5]/td[2]
//		String BeforeXpath = "//table[@id='countries']/tbody/tr[";
//		String AfterXpath = "]/td[2]/strong";
//		for(int i = 4 ; i <= 4 ; i++)
//		{
//				String CountryNames = driver.findElement(By.xpath(BeforeXpath+i+AfterXpath)).getText();
//				System.out.println(CountryNames);
//				if(CountryNames.equals("Algeria"))
//				{
//					Thread.sleep(400);
//					driver.findElement(By.className("hasVisited")).click();
//				}
//		}
		
		driver.findElement(By.xpath("//strong[text()='Algeria']/parent::td/preceding-sibling::td/input[@class='hasVisited']")).click();
		//JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement name = driver.findElement(By.xpath("//strong[contains(text(),'India')]/parent::td/preceding-sibling::td/input[@class='hasVisited']"));
		//js.executeScript("argument[0].scrollIntoView(true);",name);
		name.click();
	}
	
}
