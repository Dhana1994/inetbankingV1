package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{

@Test(dataProvider = "LoginData")
public void loginDDT(String UserName,String Password) throws InterruptedException
{
	LoginPage lp = new LoginPage(driver);
	
	lp.enterUserName(UserName);
	logger.info("user name provided");
	
	lp.enterPassword(Password);
	logger.info("password provided");
	
	lp.clickSubmit();
	logger.info("Submit button Clicked");
	
	Thread.sleep(3000);
	
	if(isAlertPresent()==true)
	{
		driver.switchTo().alert().accept();//close alert
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		logger.warn("Login failed");
	}
	else
	{
		Assert.assertTrue(true);
		logger.info("Login passed");
		lp.clickLogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();//close logout alert
		driver.switchTo().defaultContent();
		
	}

}

public boolean isAlertPresent() //user defined method created to check alert is present or not
{
	try
	{
	driver.switchTo().alert();
	return true;
	}
	catch(NoAlertPresentException e)
	{
     return false;
	}
	
}


@DataProvider(name="LoginData")
String [][]getData() throws IOException
{
	
	String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
    int rownum = XLUtils.getRowCount(path, "Sheet1");
    int colcount = XLUtils.getCellCount(path, "Sheet1", rownum);
    
    String logindata[][]=new String[rownum][colcount];
    
    for (int i=1;i<=rownum;i++)
    {
    	for(int j=0;j<colcount;j++ )
    	{
    		logindata[i-1][j] = XLUtils.getCellData(path,"Sheet1" , i, j); // row 1 ,Col 0 [i-1][j] //for row 2,col 0 [i][j] 
    	}
    }
	return logindata;

}


	
	
	
}
