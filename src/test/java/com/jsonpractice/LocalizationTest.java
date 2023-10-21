package com.jsonpractice;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class LocalizationTest {
	
	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		
		DevTools devTools=driver.getDevTools();
	    devTools.createSession();
	    
	    Map<String,Object> coordinates=new HashMap<>();
	    coordinates.put("latitude",40);
	    coordinates.put("longitude",3);
	    coordinates.put("accuracy",1);
	    
	    driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
  		
	    driver.get("https://www.google.com");
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    		
		driver.findElement(By.name("q")).sendKeys("Netflix",Keys.ENTER);
		driver.findElements(By.cssSelector("h3.LC20lb.MBeuO.DKV0Md")).get(0).click();
		
		String title=driver.findElement(By.cssSelector("h1[data-uia=nmhp-card-hero-text-title]")).getText();
		System.out.println(title);
		
	}

}
