package com.jsonpractice;

import java.time.Duration;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WinHandlesTest {
	
	public static void main(String[] args)throws InterruptedException 
	{
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.google.com/");
		
		WebElement textArea=driver.findElement(By.name("q"));
				
		textArea.sendKeys("Hello iPhone 15");
		
		String currentWindowHandle=driver.getWindowHandle();
		
		System.out.println(currentWindowHandle);
		
		Thread.sleep(5000);
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(5000);

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Amazon.in']")));
		
		
		
		Wait<WebDriver> fwait=new FluentWait<WebDriver>(driver)
				   .pollingEvery(Duration.ofSeconds(5))
				   .withTimeout(Duration.ofSeconds(20))
				   .ignoring(NoSuchElementException.class);
		
	   
		WebElement mobileTabInAmazonSite=fwait.until(new Function<WebDriver,WebElement>()
				{

					@Override
					public WebElement apply(WebDriver t) {

						return driver.findElement(By.xpath("//a[contains(.,'Today')]/following-sibling::a[contains(.,'Mobiles')]"));
						
					}
				
				}
				
				);
				
				
		
		mobileTabInAmazonSite.click();
		
		
		Set<String> windowHandles=driver.getWindowHandles();
		
		System.out.println(windowHandles.size());
		
        for(String handle:windowHandles)
        {
        	 if(handle.equalsIgnoreCase(currentWindowHandle))
        		 driver.switchTo().window(handle);
        }
		
       System.out.println(driver.getCurrentUrl()+" : "+driver.getTitle());
       
       Thread.sleep(5000);
       
       driver.close();
       
       Set<String> currHandles=driver.getWindowHandles();
       
       System.out.println(currHandles.size());
       
       System.out.println(currHandles);
       
       String winhandle=currHandles.stream().findFirst().get();
       
       driver.switchTo().window(winhandle);
       
       System.out.println(driver.getCurrentUrl());
       System.out.println(driver.getTitle());
       
       driver.close();
	}

}
