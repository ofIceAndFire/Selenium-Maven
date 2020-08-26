package com.qa.SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BootStrapDropDown
{
	WebDriver driver;
	//JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeTest
	public void chromelogin() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		 driver = new ChromeDriver();
	     driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
	     driver.navigate().refresh();
	     System.out.println("Chrome and bootstrap site is opned");
	     Thread.sleep(500);
	     driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
//	@Test(priority = 1)
//	public void bootStrapDDTest() throws InterruptedException
//	{
//		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		WebElement dropdownmenubutton = driver.findElement(By.id("dropdownMenuButton"));
//		dropdownmenubutton.click();
//		List<WebElement> List = driver.findElements(By.xpath("//div[@aria-labelledby=\"dropdownMenuButton\"]/a[@class=\"dropdown-item\"]"));
//		System.out.println(List.size());
//		
//		//To Select all elements from Drop-Down list
//		for(int i = 0; i < List.size(); i++)
//		{
//			System.out.println(List.get(i).getText());
//			List.get(i).click();
//
//			dropdownmenubutton.click();
//		}
		
		//To Select one Element from Drop-Down list
//		for(int i = 0; i < List.size(); i++)
//		{
//			System.out.println(List.get(i).getText());
//			if(List.get(i).getText().equals("Another action"))
//			{
//				Thread.sleep(1000);
//				List.get(i).click();
//				break;
//			}
//		}
		
		//}
	
	@Test(priority = 0)
	public void dropDownButtonTwo() throws InterruptedException
	{
		Thread.sleep(100);
		WebElement MenuLink = driver.findElement(By.xpath("//div[@class='dropdown show']/a[@class='btn btn-secondary dropdown-toggle']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//js.executeScript("arguments[0].scrollIntoView();", MenuLink);
		System.out.println("Attribute");
		System.out.println(driver.findElement(By.xpath("//div[@class='dropdown show']/a[@class='btn btn-secondary dropdown-toggle']")).getAttribute("a"));
		System.out.println(driver.findElement(By.xpath("//div[@class='dropdown show']/a[@class='btn btn-secondary dropdown-toggle']")).getAttribute("href"));
		System.out.println(driver.findElement(By.xpath("//div[@class='dropdown show']/a[@class='btn btn-secondary dropdown-toggle']")).getAttribute("class"));
		System.out.println(driver.findElement(By.xpath("//div[@class='dropdown show']/a[@class='btn btn-secondary dropdown-toggle']")).getAttribute("div"));
		System.out.println(driver.findElement(By.xpath("//div[@class='dropdown show']/a[@class='btn btn-secondary dropdown-toggle']")).getAttribute("label"));
		System.out.println(driver.findElement(By.xpath("//div[@class='dropdown show']/a[@class='btn btn-secondary dropdown-toggle']")).getAttribute("role"));


		


		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dropdown show']"))).click();
		MenuLink.click();
		
		List<WebElement> List = driver.findElements(By.xpath("//div[@class='dropdown-menu show']/a[@class='dropdown-item']"));
		System.out.println(List.size());
		for(int i = 0; i < List.size(); i++)
		{
			System.out.println("Split Drop Down Button");
			System.out.println(List.get(i).getText());
			List.get(i).click();
			driver.findElement(By.id("dropdownMenuLink")).click();

		}
	}
	
	@Test(priority = 1)
	public void dropDownButtonThree() throws InterruptedException
	{
		Thread.sleep(100);
		driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle']")).click();
		Thread.sleep(100);
		buttonGroup();
		driver.findElement(By.xpath("//button[@class='btn btn-secondary dropdown-toggle dropdown-toggle-split'][1]")).click();
		Thread.sleep(100);
		buttonGroup();

		driver.findElement(By.xpath("//button[@class='btn btn-success dropdown-toggle dropdown-toggle-split'][1]")).click();
		Thread.sleep(100);
		buttonGroup();

		driver.findElement(By.xpath("//button[@class='btn btn-info dropdown-toggle dropdown-toggle-split'][1]")).click();
		Thread.sleep(100);
		buttonGroup();

		driver.findElement(By.xpath("//button[@class='btn btn-warning dropdown-toggle dropdown-toggle-split'][1]")).click();
		Thread.sleep(100);
		buttonGroup();

		driver.findElement(By.xpath("//button[@class='btn btn-danger dropdown-toggle dropdown-toggle-split'][1]")).click();
		Thread.sleep(100);
		buttonGroup();
	}

	public void buttonGroup() 
	{
		List<WebElement>  list = driver.findElements(By.xpath("//div[@class='dropdown-menu show']/a[@class='dropdown-item']"));
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println("Button Group Options");
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals("Action"))
			{
			list.get(i).click();
			}
		}
		
	}
	
	@Test(priority = 2)
	public void signIn()
	{
		//driver.findElement(By.xpath("//div[@class='btn-group dropup']/button[@class=\"btn btn-secondary dropdown-toggle\"]")).click();
		//driver.findElement(By.xpath("//div[@class='btn-group dropright']/button[@class=\"btn btn-secondary dropdown-toggle\"]")).click();
		driver.findElement(By.xpath("//button[text()='Sign in'][1]")).click();
		driver.findElement(By.id("exampleDropdownFormEmail1")).sendKeys("noor");
	}

}
