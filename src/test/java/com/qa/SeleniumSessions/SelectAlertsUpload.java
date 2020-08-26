package com.qa.SeleniumSessions;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.Var;

public class SelectAlertsUpload 
{

	WebDriver driver;
	@BeforeTest
	public void chromelogin() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		 driver = new ChromeDriver();
	     driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	     System.out.println("Chrome and rediff site is opned");
	     Thread.sleep(500);
	}
	
	
	@Test(priority = 0)
	public void alertMethod()
	{
		driver.findElement(By.name("proceed")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();     //Clicks OK button
		//alert.dismiss(); //Clicks cancel button 
	}
	
	
	@Test
	public void creatingAccount() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class=\"create-new-account\"]/a/u")).click();
		Thread.sleep(1000);
		WebElement select = driver.findElement(By.xpath("//table[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/Select[1]"));
		Select action = new Select(select);
////		List<WebElement> options = action.getOptions();
////		for(WebElement l : options)
////		{
////			l.click();
////		}
		
		action.selectByValue("01");
		WebElement month = driver.findElement(By.xpath("//table[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/Select[2]"));
		Select mn = new Select(month);
		mn.selectByVisibleText("JAN");
		WebElement year = driver.findElement(By.xpath("//table[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/Select[3]"));
		Select yr = new Select(year);
		yr.selectByIndex(1);
		
	}

	
}
