package com.ProjectByJai.helper;

public class ResourcesHelper 
{
	public static String getPath(String path)
	{
		String base = System.getProperty("user.dir");
		return base +"/"+path;
	}
}
