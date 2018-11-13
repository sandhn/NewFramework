package com.ProjectByJai.testScript;

import org.testng.annotations.Test;

import com.ProjectByJai.constant.Constant;
import com.ProjectByJai.helper.WaitHelper;
import com.ProjectByJai.pageObject.LoginPage;
import com.ProjectByJai.pageObject.NavigationMenu;
import com.ProjectByJai.pageObject.ProductCategoryPage;
import com.ProjectByJai.pageObject.ShoppinCartSummaryPage;
import com.ProjectByJai.testBase.TestBase;


public class TillPaymentPage extends TestBase
{
	@Test
	public void testTillPaymentPage()
	{
		LoginPage loginTest = new LoginPage();
		loginTest.loginToApplication(Constant.userName,Constant.passWord);
		NavigationMenu menu = new NavigationMenu();
		menu.mouseOver("Women");
		menu.clickOnIntem("Women");
		ProductCategoryPage page = new ProductCategoryPage();
		WaitHelper time = new WaitHelper();
		time.explicitlyWaitTimeWaitTime(10, "//*[@id='center_column']/ul/li[4]/div/div[2]/div[2]/a[1]/span");
		page.clickOnAddToCart();
		
		time.explicitlyWaitTimeWaitTime(10, "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span");
		page.clickOnProceedTocheckOut();
		
		ShoppinCartSummaryPage shop = new ShoppinCartSummaryPage();
		shop.clickOnProceedTocheckOutInCart();
		shop.clickOnProceedTocheckOutInAddress();
		shop.clickOnTermsOfService();
		shop.clickOnProceedTocheckOutInShipping();
	}
}
