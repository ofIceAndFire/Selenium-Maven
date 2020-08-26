package com.qa.SeleniumSessions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutor
{

	public static void main(String[] args) throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 
		 
		driver.manage().deleteAllCookies();
		// driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		driver.get("https://facebook.com/login/");
		System.out.println("Chrome and payspan site is opned");
		
		driver.findElement(By.id("email")).sendKeys("noor");
		Thread.sleep(500);
		WebElement loginButton = driver.findElement(By.id("loginbutton"));
		WebElement helpLink = driver.findElement(By.xpath("//a[text()=\"Help\"]"));
		flash(loginButton, driver);
		drawborder(loginButton, driver);
		takescreenshot(driver);
		//generateAlert(driver, "login button error message alert");
		refreshBrowserByJS(driver);
		clickElementByJS(loginButton, driver);
		System.out.println(getTitleByJS(driver));
		System.out.println(getPageInnerText(driver));
		scrollPageDown(driver);
		scrollintoView(helpLink, driver);
		driver.close();
	}

	//HighLighting the Element
	public static void flash(WebElement element,WebDriver driver)
	{
		String bgcolor = element.getCssValue("backgroundColor");
		System.out.println(bgcolor);
		for(int i = 0; i < 10; i++)
		{
			changecolor("rgb(0,200,0)",element,driver);
			System.out.println("change color");
			changecolor(bgcolor,element,driver);
			System.out.println("change,element,driver color");
		}
	}

	//Change the background color
	public static void changecolor(String color, WebElement element, WebDriver driver)
	{
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		 js.executeScript("arguments[0].style.backgroundColor ='"+color+"'" , element);
		 System.out.println("Changing Color");
		 try
		 {
			Thread.sleep(200);
		 }catch(InterruptedException ie){
		}
	}
	
	//DrawBoarder
	public static void drawborder(WebElement element, WebDriver driver)
	{
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border ='3px solid red'", element);
		System.out.println("Drawing Boarder");
	}
	
	//TakeScreenShot
	public static void takescreenshot(WebDriver driver) throws IOException
	{
		String Dest = "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\ScreenShots\\JavaScriptExecutor\\";
		//DestFile.delete();
		//DestFile.mkdir();
		//String DestnationFile = DestFile + "facebook.png";

		System.out.println("create file");
		TakesScreenshot src = ((TakesScreenshot) driver);
		File srcFile = src.getScreenshotAs(OutputType.FILE);	
		org.apache.commons.io.FileUtils.deleteDirectory(new File(Dest));
		File file = new File(Dest);
		file.mkdir();
		org.apache.commons.io.FileUtils.copyFile(srcFile,new File(Dest.concat("facebook.png")));
	}
	
	//Generate Alert
	public static void generateAlert(WebDriver driver,String message)
	{
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		 js.executeScript("alert('"+message+"')");
	}
	
	//Click Element
	public static void clickElementByJS(WebElement element, WebDriver driver)
	{
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		 js.executeScript("arguments[0].click();", element);
	}
	
	//Refresh Browser
	public static void refreshBrowserByJS(WebDriver driver)
	{
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		 js.executeScript("history.go[0]");
	}
	
	//GetTitle
	public static String getTitleByJS(WebDriver driver)
	{
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		 String title = js.executeScript("return document.title;").toString();
		 return title;
	}
	
	//GetInnerText
	public static String getPageInnerText(WebDriver driver)
	{
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		 String PageText = js.executeScript("return document.documentElement.innerText;").toString();
		 return PageText;
	}
	
	//Scroll Page Down
		public static String scrollPageDown(WebDriver driver)
		{
			 JavascriptExecutor js = ((JavascriptExecutor)driver);
			 String PageText = js.executeScript("window.scrollTo(0,document.body.scrollHeight)").toString();
			 return PageText;
		}
		
		//Scroll into View
				public static void scrollintoView(WebElement element,WebDriver driver)
				{
					 JavascriptExecutor js = ((JavascriptExecutor)driver);
					 js.executeScript("argument[0].scrollIntoView(true);", element);
				}
	
}	
	
	

