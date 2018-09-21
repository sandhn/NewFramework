package com.newtours.demoaur.library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReturnTypeNameClass {
	
	public static void  getBrowser(String Browser)
	{
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\MunichRe Docs\\softwarwe\\Chrome_driver_66\\chromedriver.exe");
		Constant.driver=new ChromeDriver();
		Constant.driver.manage().window().maximize();
		Constant.driver.switchTo();
		Constant.driver.switchTo().frame(3);
		WebElement wb= Constant.driver.findElement(By.xpath("s"));
		wb.getText();
		
		

}
}
	