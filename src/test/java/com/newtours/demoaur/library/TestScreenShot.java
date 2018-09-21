package com.newtours.demoaur.library;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.common.io.Files;

public class TestScreenShot  {
	
	
	public static String TestScreenShotAs(String title) throws IOException
	{
		try
		{
		EventFiringWebDriver eDriver= new EventFiringWebDriver(Constant.driver);
		File srcFile=eDriver.getScreenshotAs(OutputType.FILE);
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("dd-MM-YYYY HH:mm:ss.SSS");
		String sDate=dateFormat.format(date);
		sDate=sDate.replaceAll("-", "").replaceAll(":", "").replace(".", "");
		String path="D:\\Report_Status\\TestScreenShots\\"+sDate+" "+title+".png";
		File dstFile= new File(path);
		Files.copy(srcFile, dstFile);
		return path;
		}
		catch(Exception e)
		{
			ExceptionLib eLib= new ExceptionLib();
			eLib.ExceptionLibHandle(e, ReportFunction.logger, ReportFunction.reporter);
			return e.toString();
		}
		
	}
	
	public static void attachScreenShot(String title) throws IOException
	{
		
		String screenShotPath=TestScreenShotAs(title);			
		ReportFunction.logger.pass(title, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	
	}

}


