package com.ProjectByJai.testScript;

import org.testng.annotations.Test;

import com.ProjectByJai.constant.Constant;
import com.ProjectByJai.pageObject.LoginPage;
import com.ProjectByJai.testBase.TestBase;


public class LoginTest extends TestBase
{
	@Test
	public void testValidLogin()
	{
		LoginPage loginTest = new LoginPage();
		loginTest.loginToApplication(Constant.userName,Constant.passWord);
	}
}
