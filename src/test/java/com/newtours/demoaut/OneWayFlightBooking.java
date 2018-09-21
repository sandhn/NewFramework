package com.newtours.demoaut;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;
import com.newtours.demoaur.library.Browser;
import com.newtours.demoaur.library.Constant;
import com.newtours.demoaur.library.Excel_Library;
import com.newtours.demoaur.library.ExceptionLib;
import com.newtours.demoaur.library.ReportFunction;
import com.newtours.demoaur.library.TestScreenShot;
import com.newtours.demoaut.pages.EnterPassengerDetails_page;
import com.newtours.demoaut.pages.FlightConfirmation_Page;
import com.newtours.demoaut.pages.SelectA_FlightPage;
import com.newtours.demoaut.pages.WelcomeMercuryToursPage;
import com.newtours.demoaut.pages.WelcomeMercuryToursPage_FindFlight_OneWayPage;

public class OneWayFlightBooking {
	WelcomeMercuryToursPage userTest;
	WelcomeMercuryToursPage_FindFlight_OneWayPage FindFlight_OneWayPage;
	SelectA_FlightPage selectFlight;
	EnterPassengerDetails_page passengerDetails;
	FlightConfirmation_Page FlightConfirmation;
	
	@BeforeClass
	
	public void launchBroser()
	{
		 Browser.getBrowser("chrome");
		 userTest=PageFactory.initElements(Constant.driver, WelcomeMercuryToursPage.class);
		 FindFlight_OneWayPage= PageFactory.initElements(Constant.driver, WelcomeMercuryToursPage_FindFlight_OneWayPage.class);
		 selectFlight=PageFactory.initElements(Constant.driver, SelectA_FlightPage.class);
		 passengerDetails= PageFactory.initElements(Constant.driver, EnterPassengerDetails_page.class);
		 FlightConfirmation=PageFactory.initElements(Constant.driver, FlightConfirmation_Page.class);
	}
	
	@Test
	public void OneWayFlightBookingTest() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException
	{
		/*for(int rowNum=0; )
		Excel_Library.setHashMapValue("TestData");*/
		
		
		try
		{
		ReportFunction extReport=new ReportFunction();		
		extReport.extentReportingMethod();
		ReportFunction.logger=ReportFunction.extent.createTest("OneWayFlightBookingTest");
		ReportFunction.logger.log(Status.INFO, "Browser launched");
		Constant.driver.get(Constant.url);
		ReportFunction.logger.log(Status.INFO, "URL launched= "+Constant.url);
		String title=Constant.driver.getTitle().replaceAll(":", "");
		TestScreenShot.attachScreenShot(title);		
		Excel_Library.setHashMapValue("TestData");
		userTest.WelcomeMercuryToursPage_test(Excel_Library.getKeyvalue("UserName"), Excel_Library.getKeyvalue("Password"));		
		FindFlight_OneWayPage.findFlights();		
		selectFlight.flightSelection();	
		passengerDetails.passengersDetails(Excel_Library.getKeyvalue("FirstName"), Excel_Library.getKeyvalue("LastName"), Excel_Library.getKeyvalue("Meal"));
		passengerDetails.enterCardDetails(Excel_Library.getKeyvalue("CC_FirstName"), Excel_Library.getKeyvalue("CC_LastName"), Excel_Library.getKeyvalue("CC_Number"), Excel_Library.getKeyvalue("CC_Type"), Excel_Library.getKeyvalue("CC_Expration_Month"), Excel_Library.getKeyvalue("CC_Expration_Year"));				
		passengerDetails.passengersBillingAddressDetails(Excel_Library.getKeyvalue("Billing_Address"), Excel_Library.getKeyvalue("Billing_City"), Excel_Library.getKeyvalue("Billing_State"), Excel_Library.getKeyvalue("Billing_PostalCode"), Excel_Library.getKeyvalue("Billing_Country"));		
		FlightConfirmation.FlightConfirmation();
		}
		catch(AssertionError e)
		{
			ExceptionLib exception=new ExceptionLib();
			exception.ExceptionLibHandle(e, ReportFunction.logger, ReportFunction.reporter);
		} 
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		//Constant.driver.close();
		ReportFunction.extent.flush();
		//Constant.driver.get("C:\\Users\\mbijalwa\\workspace\\mercury_newtours_com\\Report\\seleniumReport.html");
	}
}


