package com.newtours.demoaur.library;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExceptionLib {
	

	public void ExceptionLibHandle(AssertionError e, ExtentTest logger, ExtentHtmlReporter reporter)
	{
		String error=e.toString();
		logger.log(Status.INFO, error);
		logger.log(Status.FAIL, error);
		logger.log(Status.FAIL, "Test case failed");
		Assert.fail();
		reporter.flush();
	}
	public void ExceptionLibHandle(Exception e, ExtentTest logger, ExtentHtmlReporter reporter)
	{
		String error=e.toString();
		logger.log(Status.INFO, error);
		logger.log(Status.FAIL, error);
		logger.log(Status.FAIL, "Test case failed");
		reporter.flush();
	}
	

}
