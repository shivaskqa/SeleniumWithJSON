package com.jsonpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetDriver {

	private static WebDriver driver=new ChromeDriver();
	
	private GetDriver()
	{
		
	}
	public static WebDriver getDriver()
	{
		if(driver==null)
		  return driver;
		return driver;
	}
	
}
