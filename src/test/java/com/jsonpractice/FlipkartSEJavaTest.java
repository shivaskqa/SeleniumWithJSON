package com.jsonpractice;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartSEJavaTest {

	public static void main(String[] args)throws Exception 
	{
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//implicitwait applies to all elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String url="https://www.flipkart.com/mobile-phones-store?fm=neo%2Fmerchandising&iid=M_7476d54c-73fb-46a9-8b19-d465fdb11430_1_372UD5BXDFYS_MC.ZRQ4DKH28K8J&otracker=hp_rich_navigation_2_1.navigationCard.RICH_NAVIGATION_Mobiles_ZRQ4DKH28K8J&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L0_view-all&cid=ZRQ4DKH28K8J";
		
		driver.get(url);
		
		//WebElement element=driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement menuelement=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Electronics')]")));
		
		menuelement.click();
		
		Thread.sleep(5000);

		
		//By using ExplicitWait
		WebElement menuItemElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Mi')]")));
		
		/*
		 * //FluentWait Wait<WebDriver> fwait=new FluentWait<WebDriver>(driver)
		 * .withTimeout(Duration.ofSeconds(30)) .pollingEvery(Duration.ofSeconds(5))
		 * .ignoring(NoSuchElementException.class);
		 */
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File("C:\\Users\\Shiva\\eclipse-workspace\\seleniumwithjson\\test-output\\flipkartImage.png"));
		
		menuItemElement.click();
		
		
	}

}
