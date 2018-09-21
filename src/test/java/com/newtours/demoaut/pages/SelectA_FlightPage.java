package com.newtours.demoaut.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.newtours.demoaur.library.Constant;
import com.newtours.demoaur.library.ReportFunction;
import com.newtours.demoaur.library.TestScreenShot;
import com.newtours.demoaur.library.WaitTime;
import com.newtours.demoaut.OneWayFlightBooking;

public class SelectA_FlightPage extends OneWayFlightBooking  {
	
	@FindBy(xpath="//input[@value='Unified Airlines$363$281$11:24']")
	public WebElement unifiedAirlines;
	//String fieldName=unifiedAirlines.getAttribute("name");
	
	@FindBy(xpath="//input[@name='reserveFlights']")
	public WebElement reserveFlights;
	
	public void flightSelection() throws IOException
	{
		
		unifiedAirlines.click();
		WaitTime.implicitWaitTime(3);
		ReportFunction.logger.log(Status.INFO, "Flight Reserved"+ "  flight selected");
		WaitTime.implicitWaitTime(3);		
		Constant.driver.getTitle().replaceAll(":", "");
		WaitTime.implicitWaitTime(1);
		TestScreenShot.attachScreenShot("Booking below flight");
		WaitTime.implicitWaitTime(2);
		ReportFunction.logger.log(Status.INFO, reserveFlights.getAttribute("name")+"below flight has been Booked");
		reserveFlights.click();	
		ReportFunction.logger.log(Status.INFO, "reserveFlights button clicked");
		WaitTime.implicitWaitTime(1);
	}
	
	/*public void printFieldName()
	{
		
		//String fieldName=unifiedAirlines.getAttribute("name");
		ReportFunction.logger.log(Status.INFO, fieldName+ "  flight selected");
		
	}*/

}
