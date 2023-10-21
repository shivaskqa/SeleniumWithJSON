package com.jsonpractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestBrokenLinks {

	@Test
	public void testBrokenLinks() {

		ResourceBundle resourceBundle = ResourceBundle.getBundle("application-config");

		String url = resourceBundle.getString("url");

		WebDriver driver = GetDriver.getDriver();

		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("a")));

		List<WebElement> webElements = driver.findElements(By.tagName("a"));

		for (WebElement w : webElements) {

			String hitURL = w.getAttribute("href");
			validateURL(hitURL);

		}

	}

	private void validateURL(String hitURL) {
		// TODO Auto-generated method stub

		try {

			URL url = new URL(hitURL);
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			huc.setConnectTimeout(5000);
			huc.connect();

			if (huc.getResponseCode() == 200)
				System.out.println("This is a valid link :" + hitURL);
			else
				System.out.println("This " + hitURL + " is not working..");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
