package com.qa.SeleniumSessions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverSessions {
 
	public WebDriver driver;
    public static void main(String[] args) 
    {
     }
    
    
    	
    	@Test
    	//Launch Chrome Browser
       public void chromeBrowser() 
       {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
         driver = new ChromeDriver();
        driver.get("https://www.PaySpan.com");
        System.out.println("Chrome is opned");
       }
        
    	@Test   
      //Launch FireFox Browser
       public void firefoxBrowser() 
       {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.paySpan.com");
       System.out.println("Firefox is opned");
       }
        
//       @Test
//      //Launch IE Browser
//       public void ieBrowser() 
//       {
//        System.setProperty("webdriver.ie.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\IEDriverServer.exe");
//       driver = new InternetExplorerDriver();
//        driver.get("https://www.PaySpan.com");
//       System.out.println("InternetExplorer is opned");
//      }
//
//       @Test
//       public void edgeBrowser()
//       {
//       	System.setProperty("webdriver.edge.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chrome-win\\chrome_proxy.exe");
//       	driver = new EdgeDriver();
//           driver.get("https://www.PaySpan.com");
//           //driver.get("https://www.Google.com");
//
//
//       }
        @AfterMethod
       public void tearDown() throws InterruptedException
       {
    	   driver.manage().window().maximize();
    	   //System.out.println("Page Source :          " +driver.getPageSource());
    	   String Title = driver.getTitle();
    	   System.out.println("Page Title  :           " +Title);
        	if(Title.equals("Payspan | Healthcare Reimbursement Solutions | Hospital Payment Systems"))
        	{
        	   System.out.println("Correct PageTitle");
        	}
        	else
        	{
        		System.out.println("Incorrect PageTitle");
        	}
        	
        	System.out.println("Get Class :    "    +driver.getClass());
        	System.out.println("Get Current URL :   "  +driver.getCurrentUrl());
        	System.out.println("Get WindowHandle :  "+driver.getWindowHandle());
        	System.out.println("Get WindowHandles :  "+driver.getWindowHandles());
        	driver.quit();
           
       }
      

    }

	
