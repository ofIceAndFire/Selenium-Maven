//package com.qa.SeleniumSessions;
//
//
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//
//public class SikuliFlashObject 
//{
//	//String FileName = "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\Images\\";
//	WebDriver driver;
//	@BeforeTest
//	public void chromelogin() throws InterruptedException
//	{
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
//		 driver = new ChromeDriver();
//	     driver.get("https://www.youtube.com/watch?v=ImVpGEbvxhA");
//	    // driver.get("https://signin.ebay.com/");
//	     System.out.println("Chrome and YouTube site is opned");
//	     Thread.sleep(500);
//	}
//	
//	@Test
//	public void flashObjectsTest() throws  FindFailed
//	{
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		
//		System.out.println("Pattren");
//
//		Screen s = new Screen();
//		System.out.println("Pattren");
//
//		//Pattern p = new Pattern(FileName.concat("Pause.PNG"));
//		Pattern p = new Pattern("Pause.PNG");
//
//		System.out.println("Pattren" +p);
//		s.wait(p, 2000);
//		s.click();
//		s.click();
//
//	}
//	
////	public static void main(String args[]) throws FindFailed
////	{
////		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
////			 WebDriver driver = new ChromeDriver();
////		     driver.get("https://www.youtube.com/watch?v=ImVpGEbvxhA");
////		     System.out.println("Chrome and YouTube site is opned");
////		     	driver.manage().window().maximize();
////				driver.manage().deleteAllCookies();
////		     	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
////				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////				
////				System.out.println("pre screen pattren");
////
////				Screen s = new Screen();
////				System.out.println("screen Pattren");
////
////				Pattern p = new Pattern("Pause.png");
////
////				System.out.println("post Pattren");
////		
////				//Pattern p = new Pattern(FileName.concat("Pause.PNG"));
////		
////				System.out.println("Pattren" +p);
////				s.wait(p, 2000);
////				s.click();
////				s.click();
////				s.click();
////				s.click();
////	}
//}
