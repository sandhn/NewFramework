package com.newtours.demoaut.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.Status;
import com.newtours.demoaur.library.Constant;
import com.newtours.demoaur.library.ReportFunction;
import com.newtours.demoaur.library.TestScreenShot;
import com.newtours.demoaur.library.WaitTime;
import com.newtours.demoaut.OneWayFlightBooking;

public class WelcomeMercuryToursPage extends OneWayFlightBooking{

	@FindBy(xpath="//input[@name='userName']")
	public WebElement userName_W;
	
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement  password_W;
	
	 @FindBy(xpath="//input[@name='login']")
	 public WebElement loginButton_W;
	 
	 
	 public  void WelcomeMercuryToursPage_test(String Username, String Password) throws IOException
	 {

		 userName_W.sendKeys(Username);
		 ReportFunction.logger.log(Status.INFO,"username= " +Constant.userName);
		 password_W.sendKeys(Password);		 
		 ReportFunction.logger.log(Status.INFO, "Password=  "+Constant.passWord);
		 loginButton_W.click();
		 ReportFunction.logger.log(Status.INFO, "login button clicked.");
		 TestScreenShot.attachScreenShot("welcome page test");
		 WaitTime.implicitWaitTime(2);
	 
	}
	 
	/* public  void passWord(String Password)
	 {
		 password_W.sendKeys(Password);		 
		 ReportFunction.logger.log(Status.INFO, "Password=  "+Constant.passWord);
	 }
	 
	 public void clickOnLoginButton()
	 {
		 loginButton_W.click();
		 ReportFunction.logger.log(Status.INFO, "login button clicked.");
	 }*/
	 
}
