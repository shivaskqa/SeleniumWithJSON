package com.jsonpractice;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitExample {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url="https://www.amazon.in/";
		
		driver.get(url);
		
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				                  .withTimeout(Duration.ofSeconds(20))
				                  .pollingEvery(Duration.ofSeconds(5))
				                  .ignoring(Exception.class);
		
		WebElement element=wait.until(new Function<WebDriver,WebElement>()
				{

					@Override
					public WebElement apply(WebDriver t) {

					 return driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
					
					}
			
				}
				
				);
		
          element.sendKeys("iPhone 15",Keys.ENTER);
          
         WebElement apple_iPhone15= wait.until(new Function<WebDriver,WebElement>()
        		  
        		 {
        	 
        	         public WebElement apply(WebDriver driver)
        	         {
        	        	 
        	        	 return driver.findElement(By.xpath("//a/span[contains(.,'Apple iPhone 15')]"));
        	        	 
        	         }
        	 
        		 }
        		  
      		  );
		  
           apple_iPhone15.click();	
           
           Thread.sleep(5000);
		
           driver.quit();
		
	}

}
