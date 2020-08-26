package com.qa.SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseOverDragDrop
{
	
	static WebDriver driver;
	static Actions action;

	@BeforeTest
	public static void chromelogin() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		 driver = new ChromeDriver();
	     driver.get("https://www.spicejet.com/");
	     System.out.println("Chrome and spicejet site is opned");
	     Thread.sleep(500);
	}
	
	@Test(priority = 0)
	public static void iframes() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String Title = driver.getTitle();
		System.out.println(Title);
		if(Title.equals("SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets"))
		{
			//driver.switchTo().frame(0);
			WebElement AddOnn = driver.findElement(By.id("highlight-addons"));
			//action.moveToElement(AddOnn).perform();
			 action = new Actions(driver);
				action.doubleClick(AddOnn);
			action.clickAndHold(AddOnn).build().perform();
			driver.findElement(By.xpath("//a[contains(text(),\"Seat + Meal Combo\")]")).click();
			
		}
	}
	
	@Test(priority = 1)
	public static void Dragdrop() throws InterruptedException
	{
		 action = new Actions(driver);
		 Thread.sleep(100);
			driver.get("https://demoqa.com/droppable/");
			WebElement Draggable = driver.findElement(By.id("draggable"));
			WebElement Droppable = driver.findElement(By.id("droppable"));
			action.dragAndDrop(Draggable, Droppable).build().perform();
	
	}

}
