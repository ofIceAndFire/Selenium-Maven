package com.qa.SeleniumSessions;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Calendar 
{

	WebDriver driver;
	@BeforeTest
	public void chromelogin() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		Thread.sleep(500);
		driver.get("https://www.southwest.com/");
		Thread.sleep(500);
	}
	
	@Test
	public void datePickerTest() throws InterruptedException
	{
		String Exp_MonthYear = "August 2020";
		String Exp_Date = "29";
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(500);
		driver.findElement(By.id("LandingAirBookingSearchForm_departureDate")).click();
		Thread.sleep(500);
		
		
		while(true)
		{
			String MonthYear = driver.findElement(By.xpath("//div[@class=\"calendar-month--title\"]")).getText();
			String[] month = Exp_MonthYear.split(" ");
//			System.out.println(month[0].toString());
//			System.out.println(month[1].toString());

			if(MonthYear.equals(Exp_MonthYear))
			{
				break;
			}
			else if (!MonthYear.equals(Exp_MonthYear) && month[1].equals("2020"))
			{
				//Next month button
				 driver.findElement(By.xpath("//button[@class=\"actionable actionable_button actionable_icon-only actionable_light button calendar-controls--button calendar-controls--next\"]")).click();
			}
			
			else
			{
				//previous month button
				driver.findElement(By.xpath("//button[@aria-label=\"Previous Month\"]")).click();
			}
		}
		System.out.println("Navigated to page" +Exp_MonthYear);
		List<WebElement> dateslist =driver.findElements(By.xpath("//div[@class='calendar-month--days']/button"));
		//for(WebElement dates : dateslist)
			for(int i = 0; i < dateslist.size(); i++)
		{
			System.out.println(dateslist.get(i).getText());
			if(dateslist.get(i).getText().contains(Exp_Date))
			{
				Thread.sleep(1000);
				dateslist.get(i).click();
				Thread.sleep(1000);
				break;
			}
		}
	}
	
	
	@AfterTest
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.quit();
	}
	

	}

