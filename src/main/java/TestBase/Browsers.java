package TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Browsers 
{

	WebDriver driver;
	WebDriverWait wait;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	@BeforeTest
	public void extendReports()
	{
		extent = new ExtentReports(("user.dir")+"/test-output/ExtenetReport.html", true);
		extent.addSystemInfo("Host", "Noor lenovo");
		extent.addSystemInfo("username", "nmohammed");
		extent.addSystemInfo("Environment", "QA");
		
	}
	
	@AfterTest
	public void endExtentReport()
	{
		extent.flush();
		extent.close();
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	// after execution, you could see a folder "FailedTestsScreenshots"
	// under src folder
	String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
			+ ".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	return destination;
	}
	
	@BeforeMethod
	public void chromelogin() throws InterruptedException
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\chromedriver.exe");
		 driver = new ChromeDriver();
	     driver.get("https://www.ebay.com");
	    // driver.get("https://signin.ebay.com/");
	     System.out.println("Chrome and ebay site is opned");
	     Thread.sleep(500);
	}
	
	@Test
	public void ebayTitle()
	{
		String Actual = driver.getTitle();
		System.out.println(Actual);
		String Expected = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		Assert.assertEquals(Actual, Expected);
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = Browsers.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
		
		
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		driver.quit();
	}
	
	public void fireFoxlogin() throws InterruptedException 
	{
        
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\lib\\geckodriver.exe");
		 driver = new FirefoxDriver();
	     driver.get("https://www.ebay.com");
	     System.out.println("Firefox is opned");
	     Thread.sleep(500);
	}
	
	
}
