package com.qa.SeleniumSessions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadPropertiesFile
{
	 WebDriver driver;

	
	 @Test
	 public void setUP() throws IOException
	 {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\src\\test\\java\\com\\qa\\SeleniumSessions\\config.properties");
		prop.load(fis);
		
		
		//get,set,clear,contains methods
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.get("name"));
		System.out.println(prop.setProperty("name", "mohd"));
//		prop.clear();
//		System.out.println(prop.get("name"));
		System.out.println(prop.containsValue("URL"));
		System.out.println(prop.containsKey("URL"));
		System.out.println(prop.get("age"));
		System.out.println(prop.get("url"));
		
		//Launching Browser
		String URL = prop.getProperty("URL");
		System.out.println(URL);
		String Browser = prop.getProperty("Browser");
		System.out.println(Browser);
		
		
		if(Browser.equals("FF"))
		{
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		 driver = new ChromeDriver();
		}
		else if(Browser.equals("FireFox"))
		{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\geckodriver.exe");
		 driver = new FirefoxDriver();

		}
		 driver.get(URL);

	}
}
	

