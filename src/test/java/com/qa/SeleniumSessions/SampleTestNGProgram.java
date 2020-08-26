package com.qa.SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTestNGProgram
{
	WebDriver driver;
	@BeforeMethod()
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test(priority=-1)
	public void getmail()
	{
		System.out.println("Test2 :" +driver.findElement(By.linkText("Mail")));
	}
	@Test(priority=1)
	public void getTitle()
	{
		System.out.println("Test1 :" +driver.getTitle());
	}
	
	@Test(priority=2)
	public void getText()
	{
		System.out.println("Test3 :" +driver.findElement(By.className("gb_g")).getAttribute("class"));
	}
	@Test(priority=3)
	public void getAttribute()
	{
		System.out.println("Test4 :" +driver.findElement(By.linkText("Images")).getAttribute("a"));
	}

	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
}
