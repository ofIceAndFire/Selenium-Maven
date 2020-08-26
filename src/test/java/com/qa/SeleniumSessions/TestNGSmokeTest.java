package com.qa.SeleniumSessions;



	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class TestNGSmokeTest 
	{
		WebDriver driver;
		@BeforeTest
		public void setUp()
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		@Test
		public void openChromeBrowserSmokeTest()
		{
			driver.get("https://www.google.com");
			//driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		@Test
		public void openFacebookSmokeTest()
		{
			driver.get("https://www.facebook.com");
			//driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
		@AfterTest
		public void tearDown()
		{
			//driver.close();
		}

	}



