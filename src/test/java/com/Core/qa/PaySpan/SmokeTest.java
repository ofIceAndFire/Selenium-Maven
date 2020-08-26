package com.Core.qa.PaySpan;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excel.lib.util.XMLReaderDOM;

public class SmokeTest 
{
	
	
	@BeforeTest
	public void login()
	{
		XMLReaderDOM.getValue("uat", "supportportal", "url", "username", "password");

	}
	@Test
	public void payerSmokeTest()
	{
		XMLReaderDOM.getValue("uat", "payerportal", "url", "username", "password");

	}
	@Test
	public void providerSmokeTest()
	{
		XMLReaderDOM.getValue("uat", "providerportal", "url", "username", "password");

	}

}
