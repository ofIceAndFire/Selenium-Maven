package com.qa.SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HeadLessBrowser 
{
	WebDriver driver;
	//JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeTest
	public void chromelogin() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
        String extensions = "C:\\Users\\Test1\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\ghbmnnjooekpmoecnnnilnnbdlolhkhi\\";
        ChromeOptions options = new ChromeOptions();
         options.addArguments("window-size=1400,800");
         options.addArguments("HeadLess");
		 driver = new ChromeDriver(options);
        // options.addArguments("load-extension =" +extensions);
	     driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
	     driver.navigate().refresh();
	     System.out.println("Chrome and bootstrap site is opned");
	     Thread.sleep(500);
	     driver.manage().window().maximize();
	     System.out.println("Maximized chrome browser");
			
	}
//	@BeforeTest
//	public void fireFoxlogin() throws InterruptedException 
//	{
//        
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\geckodriver.exe");
//		FirefoxOptions options = new FirefoxOptions();
//		options.addArguments("window-size=1400,800");
//			options.addArguments("-headless");
//		 driver = new FirefoxDriver(options);
//	     driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
//	     System.out.println("Firefox is opned");
//	     Thread.sleep(500);
//	}
//	@Test
//  //Launch IE Browser
//   public void ieBrowser() 
//   {
//    System.setProperty("webdriver.ie.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\IEDriverServer.exe");
//    InternetExplorerOptions options = new InternetExplorerOptions();
//    options.ad
//   driver = new InternetExplorerDriver();
//    driver.get("https://www.PaySpan.com");
//   System.out.println("InternetExplorer is opned");
//  }
	
	@Test
	public void bootStrapDDTest() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement dropdownmenubutton = driver.findElement(By.id("dropdownMenuButton"));
		dropdownmenubutton.click();
		
	     System.out.println("Clicked on Dropdown Menu");

		List<WebElement> List = driver.findElements(By.xpath("//div[@aria-labelledby=\"dropdownMenuButton\"]/a[@class=\"dropdown-item\"]"));
		System.out.println(List.size());
		
		//To Select all elements from Drop-Down list
		for(int i = 0; i < List.size(); i++)
		{
			System.out.println(List.get(i).getText());
			List.get(i).click();
			dropdownmenubutton.click();
		}
	     System.out.println("Clicked on OptionButton");

		
		//To Select one Element from Drop-Down list
		for(int i = 0; i < List.size(); i++)
		{
			//System.out.println(List.get(i).getText());
			List.get(i).getText();
			if(List.get(i).getText().equals("Another action"))
			{
				Thread.sleep(1000);
				List.get(i).click();
			     System.out.println("Clicked on Another action");

				break;
			}
		}
	}
	
//	@AfterTest
//	public void teardown()
//	{
//		driver.quit();
//		System.out.println("Closing Browser");
//	}

}
