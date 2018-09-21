package com.newtours.demoaur.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.util.TimeUtils;

import sun.java2d.Disposer.PollDisposable;

public class WaitTime {
	
	public static void implicitWaitTime(int time)
	{
		Constant.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void explicitlyWaitTimeWaitTime (int time, String xpath)
	{
		WebDriverWait wait= new WebDriverWait(Constant.driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}	
	
	public static void fluentWait (int maxTime, int frequencyTime, String xpath)
	{
Wait<WebDriver> wait= new FluentWait<WebDriver>(Constant.driver).withTimeout(maxTime, TimeUnit.SECONDS)
.pollingEvery(frequencyTime, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);


	}

}
