package com.qa.SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipCartSvgElements 
{
	WebDriver driver;
	@BeforeTest
	public void chromelogin() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.flipkart.com/");
	     System.out.println("Chrome and svgimage site is opned");
	     Thread.sleep(500);
	}
	
	@Test
	public void svgImageHanling() throws InterruptedException
	{
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath("//button[@class=\"vh79eN\"]//*[name()='svg']//*[local-name()='g']//*[local-name()='path']")).click();

}
}
