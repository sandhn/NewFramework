package com.newtours.demoaut.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.newtours.demoaur.library.TestScreenShot;
import com.newtours.demoaur.library.WaitTime;
import com.newtours.demoaut.OneWayFlightBooking;

public class EnterPassengerDetails_page extends  OneWayFlightBooking {
	
	EnterPassengerDetails_page selectDetails;
	
	@FindBy(xpath="//input[@name='passFirst0']")
	public WebElement firstName_W;
	
	@FindBy(xpath="//input[@name='passLast0']")
	public WebElement lastName_W;
	
	@FindBy(xpath="//select[@name='pass.0.meal']")
	public WebElement Meal;
	
	@FindBy(xpath="//select[@name='creditCard']")
	public WebElement cardType;
	
	@FindBy(xpath="//input[@type='text' and @name='creditnumber']")
	public WebElement cardNumber_W;
	
	@FindBy(xpath="//select[@name='cc_exp_dt_mn']")
	public WebElement expiration_month;
	
	@FindBy(xpath="//select[@name='cc_exp_dt_yr']")
	public WebElement expiration_year;
	
	@FindBy(xpath="//input[@name='cc_frst_name']")
	public WebElement cardFirstName;
	
	@FindBy(xpath="//input[@name='cc_mid_name']")
	public WebElement cardMiddleName;
		
	@FindBy(xpath="//input[@name='cc_last_name']")
	public WebElement cardLastName;
	
	@FindBy(xpath="//input[@name='billAddress1']")
	public WebElement billAddress_W;
	
	@FindBy(xpath="//input[@name='billCity']")
	public WebElement billCity_W;
	
	@FindBy(xpath="//input[@name='billState']")
	public WebElement billState_W;
	
	@FindBy(xpath="//input[@name='billZip']")
	public WebElement billZipCode_W;
	
	@FindBy(xpath="//select[@name='billCountry']")
	public WebElement billCountry_W;
	
	@FindBy(xpath="//input[@name='buyFlights']")
	public WebElement buyFlights;
	
	public void passengersDetails(String firstname, String lastName, String mealValue) throws IOException
	{
		firstName_W.sendKeys(firstname);
		lastName_W.sendKeys(lastName);
		selectDetails=new EnterPassengerDetails_page();
		selectDetails.selectDropDownValue(Meal, mealValue);
		WaitTime.implicitWaitTime(1);
		TestScreenShot.attachScreenShot("passengersDetails");
		WaitTime.implicitWaitTime(3);
	}
	
	public void enterCardDetails(String firstname, String lastName, String cardNumber, String cardTypeValue, String expirationMonthValue, String expirationYearValue) 
	{
		cardFirstName.sendKeys(firstname);
		cardMiddleName.sendKeys("");
		cardLastName.sendKeys(lastName);
		//EnterPassengerDetails_page Details=new EnterPassengerDetails_page();
		selectDetails=new EnterPassengerDetails_page();
		selectDetails.selectDropDownValue(cardType,cardTypeValue );
		WaitTime.implicitWaitTime(2);
		cardNumber_W.sendKeys(cardNumber);
		WaitTime.implicitWaitTime(2);
		selectDetails.selectDropDownValue(expiration_month, expirationMonthValue);
		WaitTime.implicitWaitTime(2);
		
		selectDetails.selectDropDownValue(expiration_year, expirationYearValue);
		WaitTime.implicitWaitTime(2);
		
		
	}
	
	
	public void passengersBillingAddressDetails(String billAddress, String billCity, String billState, String postalCode, String Country) throws IOException
	{
		billAddress_W.clear();
		billAddress_W.sendKeys(billAddress);
		billCity_W.clear();
		billCity_W.sendKeys(billCity);
		billState_W.clear();
		billState_W.sendKeys(billState);
		billZipCode_W.clear();
		billZipCode_W.sendKeys(postalCode);
		//EnterPassengerDetails_page details=new EnterPassengerDetails_page();
		selectDetails=new EnterPassengerDetails_page();
		selectDetails.selectDropDownValue(billCountry_W, Country);
		TestScreenShot.attachScreenShot("passengersBillingAddressDetails");
		buyFlights.click();
		TestScreenShot.attachScreenShot("passengersBillingAddressDetails");
		WaitTime.implicitWaitTime(2);
	}
	
	
	
	public void selectDropDownValue(WebElement element, String value)
	{
		Select sc=new Select(element);
		sc.selectByVisibleText(value);
		WaitTime.implicitWaitTime(2);
		
	}
	
	

}
