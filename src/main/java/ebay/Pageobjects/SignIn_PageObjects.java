package ebay.Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn_PageObjects
{
		
		//Link SignIn
		@FindBy(how = How.XPATH, using = "//a[text()=\"Sign in\"]")
		public WebElement SignInLink;
		
	
		//Input field UserName 
		@FindBy(how = How.CSS, using = "#userid")
		public WebElement UserName;
		
		//Input field Password
		@FindBy(how = How.CSS, using = "#pass")
		public WebElement Password;
			
		//Button SignIn
		@FindBy(how = How.CSS, using = "#sgnBt")
		public WebElement SignInBtn;


}
