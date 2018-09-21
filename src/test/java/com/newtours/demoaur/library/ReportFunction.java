package com.newtours.demoaur.library;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportFunction {
	
	public static ExtentReports extent=null;
	public static ExtentTest logger=null;
	public static ExtentHtmlReporter reporter=null;
	
	public void extentReportingMethod()
	{
		try
		{
		reporter= new ExtentHtmlReporter("D:\\Report_Status\\seleniumReport.html");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		}
		
		catch(Exception e)
		{
			ExceptionLib eLib= new ExceptionLib();
			eLib.ExceptionLibHandle(e, ReportFunction.logger, ReportFunction.reporter);
		}
	}		

}
