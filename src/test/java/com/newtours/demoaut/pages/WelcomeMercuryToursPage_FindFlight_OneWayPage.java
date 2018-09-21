package com.newtours.demoaut.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.newtours.demoaur.library.Constant;
import com.newtours.demoaur.library.ReportFunction;
import com.newtours.demoaur.library.TestScreenShot;
import com.newtours.demoaur.library.WaitTime;
import com.newtours.demoaut.OneWayFlightBooking;

public class WelcomeMercuryToursPage_FindFlight_OneWayPage extends OneWayFlightBooking {
	
	@FindBy(xpath="//input[@value='oneway']")
	public WebElement oneway;
	
	@FindBy(xpath="//select[@name='passCount']")
	public WebElement passengers;
	
	@FindBy(xpath="//select[@name='fromPort']")
	public WebElement departingFrom;
	
	@FindBy(xpath="//select[@name='fromMonth']")
	public WebElement fromMonth;
	
	@FindBy(xpath="//select[@name='fromDay']")
	public WebElement fromDay;
	
	@FindBy(xpath="//select[@name='toPort']")
	public WebElement departingTo;
	
	@FindBy(xpath="//select[@name='toMonth']")
	public WebElement toMonth;
	
	@FindBy(xpath="//select[@name='toDay']")
	public WebElement toDay;
	
	@FindBy(xpath="//input[@ name='servClass' and @value='Coach']")
	public WebElement serviceClass;
	
	@FindBy(xpath="//select[@name='airline']")
	public WebElement airline;
	
	@FindBy (xpath="//input[@name='findFlights' and @src='/images/forms/continue.gif']")
	public WebElement findFlights;
	
	public  void findFlights() throws IOException
	{
		WaitTime.implicitWaitTime(2);
		oneway.click();
		WaitTime.implicitWaitTime(2);
		WelcomeMercuryToursPage_FindFlight_OneWayPage page= new WelcomeMercuryToursPage_FindFlight_OneWayPage();
		WaitTime.implicitWaitTime(2);
		page.dropDownValueSelect(passengers, "2");
		WaitTime.implicitWaitTime(2);
		page.dropDownValueSelect(departingFrom, "Paris");
		WaitTime.implicitWaitTime(2);
		page.dropDownValueSelect(fromMonth, "July");
		WaitTime.implicitWaitTime(2);
		page.dropDownValueSelect(fromDay, "13");
		WaitTime.implicitWaitTime(2);
		page.dropDownValueSelect(departingTo, "Zurich");
		WaitTime.implicitWaitTime(2);
		page.dropDownValueSelect(toMonth, "November");
		WaitTime.implicitWaitTime(2);
		page.dropDownValueSelect(toDay, "11");
		WaitTime.implicitWaitTime(2);
		serviceClass.click();
		WaitTime.implicitWaitTime(2);
		page.dropDownValueSelect(airline, "Blue Skies Airlines");
		WaitTime.implicitWaitTime(3);
		String findFlightTitle=Constant.driver.getTitle().replaceAll(":", "");
		TestScreenShot.attachScreenShot(findFlightTitle);
		WaitTime.implicitWaitTime(1);
		findFlights.click();
		WaitTime.implicitWaitTime(1);	
		
		
		
	}
	
	public  void dropDownValueSelect(WebElement element, String visibleText)
	{
		Select sc=new Select(element);
		sc.selectByVisibleText(visibleText);
		String fieldName=element.getAttribute("name");
		ReportFunction.logger.log(Status.INFO, fieldName+" = "+ visibleText);
		WaitTime.implicitWaitTime(2);
	}

}
