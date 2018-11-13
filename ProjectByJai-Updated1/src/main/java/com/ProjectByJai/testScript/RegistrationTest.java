package com.ProjectByJai.testScript;

import org.testng.annotations.Test;

import com.ProjectByJai.pageObject.LoginPage;
import com.ProjectByJai.pageObject.RegistrationPage;
import com.ProjectByJai.testBase.TestBase;



public class RegistrationTest extends TestBase
{
	@Test
	public void testRegistration()
	{
		LoginPage loginTest = new LoginPage();
		loginTest.clickOnSignInLink();
		loginTest.enterRegistrationEmail();
		loginTest.clickOnCreateAnAccount();
		RegistrationPage register = new RegistrationPage();
		register.setMrRadioButton();
		register.setFirstName("TESTfirstName");
		register.setLastname("TESTlastname");
		register.setPassword("TESTpassword");
		register.setAddress("TESTaddress");
		register.setDay("5");
		register.setMonth("June");
		register.setYear("2017");
		register.setYourAddressFirstName("TESTyourAddressFirstName");
		register.setYourAddressLastName("TESTyourAddressLastName");
		register.setYourAddressCompany("TESTyourAddressCompany");
		register.setYourAddressCity("TESTyourAddressCity");
		register.setYourAddressState("Alaska");
		register.setYourAddressPostCode("99501");
		register.setMobilePhone("9999999888");
		register.setAddressAlias("TESTaddressAlias");
		register.clickRegistration();
	}
}
