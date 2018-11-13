package com.ProjectByJai.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ProjectByJai.constant.Constant;
import com.ProjectByJai.helper.LoggerHelper;
import com.ProjectByJai.testBase.TestBase;

public class NavigationMenu 
{
	private final Logger log = LoggerHelper.takeLogger(NavigationMenu.class);
			
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
	public WebElement womenMenu;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[2]/a")
	public WebElement dressesMenu;
	
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[3]/a")
	public WebElement tshirtsMenu;
	
	public NavigationMenu() 
	{
		
		PageFactory.initElements(Constant.driver, this);
		TestBase.logExtentReport("Navigation page object created");
	}
	public void mouseOver(String data)
	{
		log.info("doing mouse over on :"+data);
		TestBase.logExtentReport("doing mouse over on :"+data);
		Actions action = new Actions(Constant.driver);	
		action.moveToElement(Constant.driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"))).build().perform();
	}
	public void  clickOnIntem(String data)
	{
		log.info("click on : "+data);
		TestBase.logExtentReport("click on : "+data);
		Constant.driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]")).click();
		
	}
}
