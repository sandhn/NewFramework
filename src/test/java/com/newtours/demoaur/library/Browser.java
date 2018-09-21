package com.newtours.demoaur.library;

import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	public static void  getBrowser(String Browser)
	{
		try
		{
		if (Browser.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver", "D:\\MunichRe Docs\\softwarwe\\Chrome_driver_66\\chromedriver.exe");
		Constant.driver=new ChromeDriver();
		Constant.driver.manage().window().maximize();
		}
		
		else if(Browser.equalsIgnoreCase("mozila")){
			System.setProperty("webdriver.chrome.driver", "D:\\MunichRe Docs\\softwarwe\\chromedriver.exe");
			Constant.driver=new ChromeDriver();
			Constant.driver.manage().window().maximize();
		}
		}
		catch(Exception e)
		{
			ExceptionLib eLib= new ExceptionLib();
			eLib.ExceptionLibHandle(e, ReportFunction.logger, ReportFunction.reporter);
		}
		
	}
	
	
}
