package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;



public class TC_LoginPage_001 extends BaseClass
{
    @Test
	public void logintest() throws IOException
	{
    	LoginPage lp = new LoginPage(driver);
    	
    	lp.enterUserName(username);
		logger.info("UserName is Entered");
		
		lp.enterPassword(password);
		logger.info("Password is Entered");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("loginTest Passed");
		}
		else
		{
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("loginTest Failed");
		}
		
	}
	
	
	
}
