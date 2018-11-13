package com.ProjectByJai.helper;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class AssertHelper 
{
	private static Logger log = LoggerHelper.takeLogger(AssertHelper.class);
	public static void makePass()
	{
		log.info("making script PASS..");
		Assert.assertTrue(true);
	}
	public static void makeFail()
	{
		log.info("making script Fail..");
		Assert.assertTrue(false);
	}
}
