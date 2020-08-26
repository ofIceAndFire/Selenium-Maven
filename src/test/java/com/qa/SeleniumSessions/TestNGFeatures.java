package com.qa.SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//groups,alwaysRun,description,enabled,dependsOnGroups can use for all pre and post and test methods
//priority and dependsOnMethods are only for Test method
//first preference for groups,dependsOnMethod and then to Priority
//first preference for non prioritized methods that will execute then prioritized methods will execute
//groups = {"Arithmetic Operations", "Sub"} We can decalre multiple groups and DepndendsOnMethods dependsOnMethods= {"getTitles", "helpPage"}
//Cannot have Cyclic dependency among groups
//invocationCount=5 used to count same method 5 time
//Expected Exception :-is always followed by .class (Expected Exception = ArthematicException.class).
//alwaysRun :-For before methods (beforeSuite, beforeTest, beforeTestClass and beforeTestMethod, but notbeforeGroups): If set to true, this configuration method will be run regardless of what groupsit belongs to. 
//For after methods (afterSuite, afterClass, ...): If set to true, this configuration method will be run even if one or more methods invoked previously failed or was skipped.
//The description :- for this method. The string used will appear in the HTML report and also onstandard output if verbose >= 2.
//TimeOut :- The maximum number of milliseconds this method should take. If it hasn't returned after thistime, this method will fail and it will cause test methods depending on it to be skipped.






public class TestNGFeatures
{
	WebDriver driver;
	@BeforeSuite(groups = {"Site"})
	public void setUp()
	{
		System.out.println("setup");

	}
	
	@BeforeTest(groups = {"Login"})
	public void Login()
	{
		System.out.println("login");

	}
	
	@BeforeClass(groups = {"class"}, enabled = true, alwaysRun = true, description = "BeforeClass")
	public void startService()
	{
		System.out.println("start");
	}
	
	@BeforeMethod(groups = {"EnterUrl"}, alwaysRun = true, description = "URL")
	public void enterUrl()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		System.setProperty("Webdriver.chrome.silentOutput", "true");
		//HeadLess Browser
		ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,800");
		options.addArguments("headLess");
		driver = new ChromeDriver(options);
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1, groups = {"Test"})
	public void getTitles()
	{
		String Expected = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		String Title = driver.getTitle();
		System.out.println(Title);
		System.out.println(Expected);
		Assert.assertEquals(Title, Expected);
		Assert.assertTrue(true);	
	}
	
	@Test( priority =0, dependsOnMethods= {"getTitles", "helpPage"}, groups = {"Test"})
	public void sellPage()
	{

		driver.findElement(By.cssSelector("#gh-p-2")).click();
		System.out.println(driver.getTitle());
	}
	
	@Test(priority = 3, dependsOnMethods= {"getTitles"}, groups = {"Test"})
	public void helpPage()
	{
		driver.findElement(By.xpath("//a[text()=' Help & Contact']")).click();
		System.out.println(driver.getTitle());
	}
	
	@Test(groups = {"Arthimatic Operations"})
	public void sum()
	{
		int a = 10;
		int b = 20;
		int c = a+b;
		System.out.println(c);
	}
	@Test(groups = {"Arthimatic Operations"}, invocationCount=5, dependsOnMethods = {"div"},  description = "Multiplication", timeOut= 2,alwaysRun = false)
	public void mul()
	{
		int a = 10;
		int b = 20;
		int c = a*b;
		System.out.println(c);
	}
	@Test(groups = {"Arthimatic Operations"})
	public void sub()
	{
		int a = 10;
		int b = 20;
		int c = a-b;
		System.out.println(c);
	}
	@Test(groups = {"Arthimatic Operations"},alwaysRun = true)
	public void div()
	{
		int a = 1;
		int b = 0;
		int c = a/b;
		System.out.println(c);
	}
//	@Test
//	public void homepageregrestionTest()
//	{
//		
//	}
//	
//	@Test(groups = {"Smoke Test"})
//	public void payerportal()
//	{
//		
//	}
//	@Test(groups = {"Smoke Test"})
//	public void providalportal()
//	{
//		
//	}
//	
	@AfterMethod(groups = {"TearDown"}, dependsOnGroups= {"Arthimatic Operations"}, alwaysRun = true)
	public void tearDown()
	{
		driver.close();
	}
	
//	@AfterClass
//	public void stopService()
//	{
//		
//		System.out.println("stop service");
//
//	}
//	
//	@AfterTest
//	public void deleteAllCookies()
//	{
//	}
	
//	@AfterSuite()
//	public void generateReport()
//	{
//		System.out.println("Generate Report");
//	}
	
}
