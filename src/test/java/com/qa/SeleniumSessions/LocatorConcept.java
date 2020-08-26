package com.qa.SeleniumSessions;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.Var;


public class LocatorConcept {
	
	WebDriver driver;
	//@FindBy(css = "#pass")
	//@FindBy(how = How.CSS, using  = "#pass")
	
	
//	@BeforeTest
//	public void fireFoxlogin() throws InterruptedException 
//	{
//        
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\geckodriver.exe");
//		 driver = new FirefoxDriver();
//	     driver.get("https://www.ebay.com");
//	     System.out.println("Firefox is opned");
//	     Thread.sleep(500);
//	}
	
	@BeforeTest
	public void chromelogin() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
		 driver = new ChromeDriver();
	     driver.get("https://www.ebay.com");
	    // driver.get("https://signin.ebay.com/");
	     System.out.println("Chrome and ebay site is opned");
	     Thread.sleep(500);
	}
	

	
	@Test 
	public void loginintoPage() throws InterruptedException
	{
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		WebDriverWait LoginPage = new WebDriverWait(driver, 20);
		//Sign In Link
		driver.manage().deleteAllCookies();
		Thread.sleep(1000);

		//Sign In Link
		LoginPage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign in']")));
		driver.findElement(By.xpath("//a[text()=\"Sign in\"]")).click();
		//Input field UserName 
		LoginPage.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userid")));
		driver.findElement(By.cssSelector("#userid")).sendKeys("nooraenit@gmail.com");
		//Input field Password 
		LoginPage.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pass")));
		driver.findElement(By.cssSelector("#pass")).sendKeys("Noorfar123#");
		System.out.println(driver.findElement(By.cssSelector("#pass")).getAttribute("input"));//null
		System.out.println(driver.findElement(By.cssSelector("#pass")).getAttribute("type"));//password
		System.out.println(driver.findElement(By.cssSelector("#pass")).getAttribute("value"));//Noorfar123#
		System.out.println(driver.findElement(By.cssSelector("#pass")).getAttribute("id"));//pass




		
		//Button SignIn
		driver.findElement(By.cssSelector("#sgnBt")).click();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MINUTES);
		
		//List Drop-down select category
		LoginPage.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gh-cat")));
		Select Category = new Select(driver.findElement(By.cssSelector("#gh-cat")));
		driver.findElement(By.cssSelector("#gh-cat")).click();
		Category.selectByVisibleText("Home & Garden");
		//Search Button
		driver.findElement(By.cssSelector("#gh-btn")).click();
		
		//PageHeader of Home and Garden
		LoginPage.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.b-pageheader__text")));
		String lbl_HomeandGarden = driver.findElement(By.cssSelector("span.b-pageheader__text")).getText();
		System.out.println(lbl_HomeandGarden);

		String li_HomeandGarden = driver.findElement(By.xpath("//li/span[text()=\"Home & Garden\"]")).getText();
		System.out.println(li_HomeandGarden);
		if(lbl_HomeandGarden.equals(li_HomeandGarden))
		{
			//Tools Link
			 LoginPage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Tools ')]"))).click();
			 WebElement Arrow = driver.findElement(By.cssSelector("g#ebay-ui-arrow"));
			 
			 //javascriptexecutor
			LoginPage.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g#ebay-ui-arrow"))).click();
			
			 
			 driver.navigate().back();
			 
		}
		else
		{
			System.out.println("Wrong Page");
		}
		

	}
	
	
//	@AfterMethod
//	public void tearDown() throws InterruptedException
//	{
//
//		driver.close();
//		driver.quit();
//	     Thread.sleep(100);
//	}

}
