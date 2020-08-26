package com.qa.SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SvgImageHandling
{
	WebDriver driver;
	@BeforeTest
	public void chromelogin() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		 driver = new ChromeDriver();
	     driver.get("http://debeissat.nicolas.free.fr/svg3d.php");
	     System.out.println("Chrome and svgimage site is opned");
	     Thread.sleep(500);
	}
	
	@Test
	public void svgImageHanling() throws InterruptedException
	{
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame("svg_result");
		Thread.sleep(100);
		List<WebElement> element = driver.findElements(By.xpath("//*[name()='svg']//*[local-name()='g' and @id='g2']//*[local-name()='path' and contains(@id,\"face\")]"));
		while(true)
		{
		for(int i = 0; i < element.size(); i++)
		{
			System.out.println(element.get(i).getAttribute("d"));
		}
		break;//optional
		}
	}


}
