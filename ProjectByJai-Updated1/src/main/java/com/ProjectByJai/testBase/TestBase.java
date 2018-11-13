package com.ProjectByJai.testBase;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ProjectByJai.browser.Browser;
import com.ProjectByJai.constant.Constant;
import com.ProjectByJai.helper.LoggerHelper;
import com.ProjectByJai.helper.ReportFunction;
import com.ProjectByJai.helper.WaitHelper;
import com.aventstack.extentreports.Status;

public class TestBase 
{

	
	private Logger log = LoggerHelper.takeLogger(TestBase.class);

	@BeforeSuite
	public void beforeSuite() throws Exception
	{
	 ReportFunction.extentReportingMethod();
	}
	@BeforeClass
	public void beforeTest()
	{	
		ReportFunction.test = ReportFunction.extent.createTest(getClass().getSimpleName());
	}
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		ReportFunction.test.log(Status.INFO, method.getName()+"**************test started***************");
		log.info("**************"+method.getName()+"Started***************");
	}
	
	@BeforeTest
	public void beforeMethod()
	{
		Browser.getBrowser("chrome");
		Constant.driver.get(Constant.url);
		WaitHelper.impliciteWait(10);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE){
			ReportFunction.test.log(Status.FAIL, result.getThrowable());
			
		}
		else if(result.getStatus() == ITestResult.SUCCESS){
			ReportFunction.test.log(Status.PASS, result.getName()+" is pass");
			
		}
		else if(result.getStatus() == ITestResult.SKIP){
			ReportFunction.test.log(Status.SKIP, result.getThrowable());
		}
		log.info("**************"+result.getName()+"Finished***************");
		ReportFunction.extent.flush();
	}
	
	@AfterTest
	public void afterTest() throws Exception
	{
		if(Constant.driver!=null)
		{
			Constant.driver.quit();
		}
	}
	
	public static void logExtentReport(String s1){
		ReportFunction.test.log(Status.INFO, s1);
	}
}
