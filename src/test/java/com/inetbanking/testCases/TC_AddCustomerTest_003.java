package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.enterUserName(username);
		logger.info("User name is provided");
		lp.enterPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		logger.info("Entering customer details....");
		
		addcust.custName("DhanaSekar");
		addcust.custgender("Male");
		addcust.custdob("12","02","1994");
		Thread.sleep(8000);
		addcust.custaddress("INDIA");
		addcust.custcity("Chennai");
		addcust.custstate("TN");
		addcust.custpinno("600001");
		addcust.custtelephoneno("987890091");
		
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.clicksubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res =driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res == true)
		{
			Assert.assertTrue(true);
			logger.info("Test case passed....");
			
		}
		else
		{
			logger.info("Test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
}
