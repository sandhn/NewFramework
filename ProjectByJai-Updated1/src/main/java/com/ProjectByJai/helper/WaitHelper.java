package com.ProjectByJai.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ProjectByJai.constant.Constant;

public class WaitHelper 
{
	public static void impliciteWait(long time)
	{
		Constant.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	
	}
	
	public WebElement waitForElement(WebDriver driver,long time,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void explicitlyWaitTimeWaitTime (int time, String xpath)
	{
		WebDriverWait wait= new WebDriverWait(Constant.driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}	
}
