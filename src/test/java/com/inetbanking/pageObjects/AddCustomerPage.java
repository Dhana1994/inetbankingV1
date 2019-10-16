package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.LINK_TEXT, using ="New Customer")
	@CacheLookup
	WebElement AddNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement EnterCustomerName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement EnterGender;

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement Enterdob;

	@CacheLookup
	@FindBy(how = How.NAME, using = "addr")
	WebElement Enteraddress;

	@CacheLookup
	@FindBy(how = How.NAME, using = "city")
	WebElement Entercity;

	@CacheLookup
	@FindBy(how = How.NAME, using = "state")
	WebElement Enterstate;

	@CacheLookup
	@FindBy(how = How.NAME, using = "pinno")
	WebElement Enterpinno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement Entertelephoneno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement Enteremailid;

	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	WebElement Enterpassword;

	@CacheLookup
	@FindBy(how = How.NAME, using = "sub")
	WebElement ClickOnSubmit;
	
	public void clickAddNewCustomer() {
		AddNewCustomer.click();
			
	}

	public void custName(String cname) {
		EnterCustomerName.sendKeys(cname);
		
	}

	public void custgender(String cgender) {
		EnterGender.click();
	}

	public void custdob(String mm,String dd,String yy) {
		Enterdob.sendKeys(mm);
		Enterdob.sendKeys(dd);
		Enterdob.sendKeys(yy);
		
	}

	public void custaddress(String caddress) {
		Enteraddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		Entercity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		Enterstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) { //Int for Integer Value so String.Valueof is Present
		Enterpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		Entertelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		Enteremailid.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		Enterpassword.sendKeys(cpassword);
	}

	public void clicksubmit() {
		ClickOnSubmit.click();
	}
	
	
	
}
