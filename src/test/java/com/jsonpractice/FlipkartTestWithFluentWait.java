package com.jsonpractice;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FlipkartTestWithFluentWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//implicit wait applies to all elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String url="https://www.flipkart.com/mobile-phones-store?fm=neo%2Fmerchandising&iid=M_7476d54c-73fb-46a9-8b19-d465fdb11430_1_372UD5BXDFYS_MC.ZRQ4DKH28K8J&otracker=hp_rich_navigation_2_1.navigationCard.RICH_NAVIGATION_Mobiles_ZRQ4DKH28K8J&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L0_view-all&cid=ZRQ4DKH28K8J";
		
		driver.get(url);
		
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
		                         .withTimeout(Duration.ofSeconds(30))
		                         .pollingEvery(Duration.ofSeconds(5))
		                         .ignoring(NoSuchElementException.class);
		
		WebElement menuElectronics=wait.until(new Function<WebDriver,WebElement>(){

			@Override
			public WebElement apply(WebDriver t) {
				// TODO Auto-generated method stub
				return driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
			}
		});
		
		menuElectronics.click();
		
		WebElement element=wait.until(new Function<WebDriver,WebElement>(){
			
			public WebElement apply(WebDriver driver)
			{
				return driver.findElement(By.xpath("//a[contains(text(),'Mi')]"));
			}
			
		});
		
      element.click();		
	
      
      WebElement clickonBecomeASellerMenu=wait.until(new Function<WebDriver,WebElement>()
    		  {
    	  
				@Override
				public WebElement apply(WebDriver t) {
					// TODO Auto-generated method stub

					return driver.findElement(By.xpath("//div//a[contains(.,'Cart')]/../../../..//div/a[contains(.,'Become a Seller')]"));
				}
    	  
    		  }
    		  
    		  );

         clickonBecomeASellerMenu.click();
      
	}
	
}