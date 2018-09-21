package com.newtours.demoaut.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.newtours.demoaur.library.ExceptionLib;
import com.newtours.demoaur.library.ReportFunction;
import com.newtours.demoaur.library.WaitTime;

public class FlightConfirmation_Page {
	@FindBy(xpath="//font[contains(text(), ' itinerary has been booked!')]")
	public WebElement FlightConfirmation;
	
	@FindBy(xpath="//font[contains(text(),'Confirmation')]")
	public WebElement confirmationDetails;
	
	public void FlightConfirmation()
	{
		try
		{
		
		//String s1="Your itinerary has been booked!";
		Assert.assertEquals("Your itinerary has been booked!", FlightConfirmation.getText());
		WaitTime.implicitWaitTime(1);
		ReportFunction.logger.log(Status.INFO, FlightConfirmation.getText());
		WaitTime.implicitWaitTime(1);
		ReportFunction.logger.log(Status.INFO, "Flight confirmation datails is = " + confirmationDetails.getText());
		WaitTime.implicitWaitTime(2);
		}
		
	catch(AssertionError e)
		{
		ExceptionLib eLib= new ExceptionLib();
		eLib.ExceptionLibHandle(e, ReportFunction.logger, ReportFunction.reporter);
		WaitTime.implicitWaitTime(1);
		}
	}

}
