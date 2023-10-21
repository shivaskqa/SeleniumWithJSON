package com.jsonpractice;

import java.io.FileReader;
import java.time.Duration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class DDTestUsingJSON {

	private static WebDriver driver;
	private static String jsonFilePath=".//jsonfiles//testdata.json";
	
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(dataProvider = "DP")
	public void login(String data)
	{
	
		driver.get("https://demo.nopcommerce.com/login");
		
		String usercreds[]=data.split(",");
		
		WebElement usernameTestField=driver.findElement(By.id("Email"));
		usernameTestField.clear();
		usernameTestField.sendKeys(usercreds[0]);
		
		WebElement passwordTestField=driver.findElement(By.id("Password"));
		passwordTestField.clear();
		passwordTestField.sendKeys(usercreds[1]);
		
		WebElement btnLogin=driver.findElement(By.xpath("//button[@type='submit']"));
		btnLogin.submit();
		
		String actualTitle=driver.getTitle();
		String expectedTitle="nopCommerce demo store";
		
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@DataProvider(name="DP")
	public String[] readJSON()throws Exception
	{
		
			JSONParser parser=new JSONParser();
			Object object=parser.parse(new FileReader(jsonFilePath));

			JSONObject jsonObject=(JSONObject)object;
			
			JSONArray array=(JSONArray)jsonObject.get("userlogins");
			
			String arr[]=new String[array.size()];
						
			for(int i=0;i<arr.length;i++)
			{

				JSONObject obj=(JSONObject)array.get(i);
				String name=(String) obj.get("username");
				String pwd=(String) obj.get("password");
				
				arr[i]=name+","+pwd;
			}
			
			return arr;
	}
	
	
	
}
