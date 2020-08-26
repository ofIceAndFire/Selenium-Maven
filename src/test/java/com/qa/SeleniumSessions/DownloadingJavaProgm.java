package com.qa.SeleniumSessions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class DownloadingJavaProgm {
		static WebDriver driver;

		public static void main(String[] args) throws AWTException {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		       String downloadFilepath = "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\DownloadFile";
	 
		       HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		       chromePrefs.put("profile.default_content_settings.popups", 0);
		       chromePrefs.put("download.default_directory", downloadFilepath);
		       
		       ChromeOptions options = new ChromeOptions();
		       options.setExperimentalOption("prefs", chromePrefs);
		       options.addArguments("--test-type");
		       options.addArguments("--disable-extensions"); //to disable browser extension popup
		       options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	 
		       driver = new ChromeDriver(options);  
		                driver.get("http://www.seleniumhq.org/download/");
		                driver.findElement(By.linkText("32 bit Windows IE")).click();
//		       driver.get("https://www.google.com/chrome/");
//		       driver.findElement(By.cssSelector("#js-download-hero")).click();
//		       Robot r=new Robot();
//		       r.keyPress(KeyEvent.VK_ENTER);
//		       r.keyRelease(KeyEvent.VK_ENTER);
		      // driver.switchTo().alert().dismiss();	
		       
	}

}
