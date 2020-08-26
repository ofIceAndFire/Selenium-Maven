package ebay.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestBase.Browsers;
import ebay.Pageobjects.SignIn_PageObjects;

public class SignIn_Test 
{
	
	
	public static SignIn_PageObjects SignIn = new  SignIn_PageObjects();
	static Browsers browser = new Browsers();
	@BeforeTest 
	public void browser() throws InterruptedException
	{
		browser.chromelogin();
		}
	
		@Test
		public void signIn()
		{
			SignIn.SignInLink.click();
			SignIn.UserName.sendKeys("Nooraenit@gmail.com");
			SignIn.Password.sendKeys("Noorfar123#");
			SignIn.SignInBtn.click();
		}
	

}

