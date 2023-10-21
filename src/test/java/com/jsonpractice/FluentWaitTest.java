package com.jsonpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FluentWaitTest {

	public static void main(String[] args)throws Exception {

		/*
		 * String url = "https://www.apple.com/in/";
		 * 
		 * WebDriver driver = new ChromeDriver(); driver.manage().window().maximize();
		 * driver.manage().deleteAllCookies();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 * 
		 * driver.get(url);
		 * 
		 * Thread.sleep(5000);
		 * 
		 * WebElement webElement=driver.findElement(By.xpath(
		 * "//div[@data-unit-id='macbook-air-15']")); Actions actions=new
		 * Actions(driver); actions.scrollToElement(webElement).perform();
		 */		
		
		WebDriver driver = new ChromeDriver(); driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("https://jqueryui.com/droppable/");
		 Thread.sleep(5000);
		 WebElement iframeWE=driver.findElement(By.xpath("//iframe[@src='/resources/demos/droppable/default.html']"));
		 driver.switchTo().frame(iframeWE);
		 
		 WebElement draggable=driver.findElement(By.id("draggable"));
		 WebElement droppable=driver.findElement(By.id("droppable"));
		
		 Actions actions=new Actions(driver);
		 actions.dragAndDrop(draggable, droppable).perform();
		
	}

}
