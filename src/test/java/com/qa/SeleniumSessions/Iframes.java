package com.qa.SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Iframes
{

	static WebDriver driver;
	@BeforeTest
	public static void chromelogin() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		 driver = new ChromeDriver();
	     driver.get("https://demoqa.com/iframe-practice-page/");
	     System.out.println("Chrome and demoqa site is opned");
	     Thread.sleep(500);
	}
	
	@Test
	public static void iframes() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()=\"Home\"]")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()=\"Interactions\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Widgets\"]")).click();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[text()=\"IFrame practice page\"]")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//a[text()=\"Skip to content\"]")).click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		System.out.println("default");
		//driver.findElement((By.xpath("//a[text()=\"Widgets\"]"))).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        System.out.println("scrolled");
        driver.switchTo().frame(1);
		//driver.switchTo().frame("iframe2");
		WebElement sortable = driver.findElement(By.xpath("//a[text()=\"Sortable\"]"));

		sortable.click();
	}
	
//	public static void main(String args[]) throws InterruptedException
//	{
//		chromelogin();
//		alertMethod();
//	}
}
