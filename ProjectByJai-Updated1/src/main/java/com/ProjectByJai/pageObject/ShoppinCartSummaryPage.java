package com.ProjectByJai.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ProjectByJai.constant.Constant;
import com.ProjectByJai.helper.LoggerHelper;
import com.ProjectByJai.testBase.TestBase;

public class ShoppinCartSummaryPage 
{
	private final Logger log = LoggerHelper.takeLogger(ShoppinCartSummaryPage.class);
	@FindBy(xpath="//*[@id='columns']/div[1]/span[2]")
	WebElement yourShoppingCart;
	
	@FindBy(xpath="//a[@title='Delete']")
	List<WebElement> quantity_delete;
	
	@FindBy(xpath="//*[contains(text(),'Your shopping cart is empty')]")
	WebElement emptyShoppingCartMsg;
	
	@FindBy(xpath="//*[contains(@class,'cart_navigation clearfix')]/a/span")
	WebElement proceedToCheckOutAtSummary;
	
	@FindBy (xpath="//*[contains(@class,'button btn btn-default button-medium')]/span")
	WebElement proceedToCheckOutAtAddress;
	
	@FindBy (xpath="//*[@id='cgv']")
	WebElement termsOfService;
	
	@FindBy(xpath="//*[@name='processCarrier']/span")
	WebElement proceedToCheckOutAtShipping;

	public ShoppinCartSummaryPage()
	{
		PageFactory.initElements(Constant.driver, this);
		TestBase.logExtentReport("Shoppin Cart Summary Page object created");
	}
	
	public void clickOnProceedTocheckOutInCart()
	{	log.info("Clicked on Proceed to Checkout At Cart");
		TestBase.logExtentReport("Clicked on Proceed to Checkout At Cart");
		proceedToCheckOutAtSummary.click();
	}
	
	public void clickOnProceedTocheckOutInAddress()
	{
		log.info("Clicked on Proceed to Checkout At Address");
		TestBase.logExtentReport("Clicked on Proceed to Checkout At Address");
		proceedToCheckOutAtAddress.click();
	}
	
	public void clickOnTermsOfService()
	{
		log.info("Clicked on Terms and Services");
		TestBase.logExtentReport("Clicked on Terms and Services");
		termsOfService.click();
	}
	
	public void clickOnProceedTocheckOutInShipping()
	{
		log.info("Clicked on Proceed to Checkout At Shipping");
		TestBase.logExtentReport("Clicked on Proceed to Checkout At Shipping");
		proceedToCheckOutAtShipping.click();
	}
}
