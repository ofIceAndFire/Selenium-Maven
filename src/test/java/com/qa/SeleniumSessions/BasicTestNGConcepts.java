package com.qa.SeleniumSessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicTestNGConcepts 
{

	@BeforeSuite
	public void setUp()
	{
		System.out.println("@BeforeSuite---SetUp system properties");
	}
	@BeforeTest
	public void launchBrowser()
	{
		System.out.println("@BeforeTest---Launch Browser");
	}
	@BeforeClass
	public void startApp()
	{
		System.out.println("@BeforeClass---StartApp");
	}
	@BeforeMethod
	public void enterurl()
	{
		System.out.println("@BeforeMethod---enterurl");
	}
	@Test(groups="title")
	public void getTitle()
	{
		System.out.println("@Test----Google Page Title");
	}
	@AfterMethod
	public void logOut()
	{
		System.out.println("@AfterMethod----LogOut");
	}
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("@AfterClass----Close Browser");
	}
	@AfterTest
	public void deleteAllCookies()
	{
		System.out.println("@AfterTest----Delete All Cookies");
	}
	@AfterSuite
	public void generateReport()
	{
		System.out.println("@AfterSuite----Generate Reports");
	}
	
}
