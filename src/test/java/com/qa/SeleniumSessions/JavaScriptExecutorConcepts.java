package com.qa.SeleniumSessions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;		
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class JavaScriptExecutorConcepts  
{

			WebDriver driver;
			@BeforeTest
			public void chromelogin() throws InterruptedException
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("https://facebook.com/login/");
				System.out.println("Chrome and payspan site is opned");
			 }
	
			@Test
			public void loginPage() throws InterruptedException
			{
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(By.id("email")).sendKeys("noor");
				Thread.sleep(500);
				WebElement loginButton = driver.findElement(By.id("loginbutton"));
				flash(loginButton, driver);
				drawborder(loginButton, driver);
			}
			
			public static void flash(WebElement element,WebDriver driver)
			{
					String bgcolor = element.getCssValue("backgroundColor");
					for(int i = 0; i < 10; i++)
					{
						changecolor("rgb(0,200,0)",element,driver);
						changecolor(bgcolor,element,driver);
					}
					
				}
			
			public static void changecolor(String color, WebElement element, WebDriver driver)
			{
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].style.backgroundColor =  '"+color+"'" , element);
				try
				{
					Thread.sleep(200);
				}catch(InterruptedException ie)
				{
				
				}
			
				}
			
			
			public static void drawborder(WebElement element, WebDriver driver)
			{
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].style.border = '3px solid red'", element);
			}
}
