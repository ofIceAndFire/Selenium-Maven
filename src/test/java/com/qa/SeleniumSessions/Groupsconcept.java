package com.qa.SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Groupsconcept 
{
	static WebDriver driver;
	Actions action;
	
	@Parameters({"Browser","Url"})
	@BeforeTest(alwaysRun = true, enabled = true, groups = "Setup")
	public void setUp(@Optional("Chrome")String Browser,@Optional("Url")String Url) throws InterruptedException
	{
		 
	     if(Browser.equalsIgnoreCase("Chrome"))
	     {
	    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.get(Url);
		     
	     }
	     else if(Browser.equalsIgnoreCase("FF"))
	     {
	    	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\geckodriver.exe");
			 driver = new FirefoxDriver();
			 driver.get(Url);

		     
	     }
	     driver.manage().window().maximize();
	     driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	    // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     driver.manage().deleteAllCookies();

	}
	@BeforeMethod
	public void execute_BeforeMethod()
	{
		String ActualText = driver.findElement(By.cssSelector(".txtCenter.white.ico30.txtCap")).getText();
		Assert.assertEquals(ActualText, "Domestic And International Flights");
		driver.findElement(By.cssSelector("#roundTrip")).click();
	    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);


	}
	
	@Parameters({"From","Destination"})
	@Test(priority = 1, enabled = true, groups = "Smoketest")
	public void groupsConcept(String From, String Destination) throws InterruptedException
	{
		
		action = new Actions(driver);
		WebElement From_txt = driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']"));
		From_txt.click();
		//action.moveToElement(From_txt).clickAndHold(From_txt);
		From_txt.sendKeys(From);
		From_txt.sendKeys(Keys.RETURN);
		
		Thread.sleep(4000);
		//action.moveToElement(From_txt).release();



		WebElement Destination_txt = driver.findElement(By.cssSelector("#gosuggest_inputDest"));
		Destination_txt.click();
		//action.moveToElement(Destination_txt).clickAndHold(Destination_txt);
		Destination_txt.sendKeys(Destination);
		From_txt.sendKeys(Keys.RETURN); //Enter or tab
		Thread.sleep(4000);

		//action.moveToElement(From_txt).release();

	}
	
	@Parameters({"actualDepartureDate","actualReturnDate"})
	@Test(priority = 2, enabled = false, groups = "Smoketest")
	public static void departuresandreturns(String actualDepartureDate, String actualReturnDate) throws InterruptedException
	{
		driver.findElement(By.cssSelector("#departureCalendar")).click();
		System.out.println("Actual: " + actualDepartureDate);
		WebElement departureCalander = driver.findElement(By.cssSelector("#departureCalendar"));
		departureCalander.click();
		//List<WebElement> dayElements = driver.findElements(By.cssSelector(".DayPicker-Day"));
		//System.out.println("DayElement: " + dayElement.getText());
		List<WebElement> daysList = driver.findElements(By.cssSelector(".DayPicker-Day[aria-disabled=false]"));
		System.out.println("DaysList: " + daysList.size());
		for (int i = 0; i < daysList.size(); i++)
		{
			//WebElement dayElement = item.findElement(By.cssSelector(".calDate"));
			//WebElement dayElement = driver.findElement(By.cssSelector(".DayPicker-Day [css='" + actualDepartureDate + "']"));
			//String expectedDay = dayElement.getText(); //1
			//System.out.println("Expected Day: " + expectedDay);
			int expectedDay = i+1;
			System.out.println(expectedDay);
			if (actualDepartureDate.equals(String.valueOf(expectedDay)))
			{
				System.out.println("click");
				WebElement item = daysList.get(i-1);
				item.click();
				Thread.sleep(100);
				break;
			}
		}
	}
	
	@Parameters({"actualReturnDate"})
	@Test(priority = 2, enabled = true)
	public static void returns(String actualReturnDate) throws InterruptedException
	{
		
			 JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		
		driver.findElement(By.cssSelector("#departureCalendar")).click();
		System.out.println("Actual: " + actualReturnDate);
		WebElement returnCalander = driver.findElement(By.cssSelector("#returnCalendar"));
		returnCalander.click();
		List<WebElement> dayElements = driver.findElements(By.cssSelector(".calDate"));
		System.out.println("DaysList: " + dayElements.size());
		for(WebElement expectedReturnDate : dayElements)
		{
			System.out.println(expectedReturnDate.getText());
			if(actualReturnDate.equals(expectedReturnDate))
			{
				WebElement retun = driver.findElement(By.cssSelector(".DayPicker-Day"));
				retun.click();
				 //js.executeScript("arguments[0].click();", expectedReturnDate);
				 //js.executeScript("arguments[0].click();", retun);

			expectedReturnDate.click();
			}
		}
	}
		
		@Test
		public void dayPicker()
		{
			List<WebElement> DayPickerElements = driver.findElements(By.cssSelector(".DayPicker-Caption"));
			for( WebElement var : DayPickerElements)
			{
				String DayPicker = var.getText();
				System.out.println(DayPicker);
//				if(DayPicker.contains("25"))
//				{
//					var.click();
//				}
			}
		}
	

	
	@AfterMethod
	public void execute_AfterMethod()
	{
		
	}
	@AfterTest()
	public void afterTest()
	{
		//driver.close();
	}
	
	
}
