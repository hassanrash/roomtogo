package com.room2go;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;

public class BaseTest {
	
	@SuppressWarnings("rawtypes")
	private static  IOSDriver driver;
	
	@SuppressWarnings("rawtypes")
	@BeforeMethod
	
	public void setUp() throws MalformedURLException {
	
		
		DesiredCapabilities caps = DesiredCapabilities.iphone();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "9.3"); //Replace this with your iOS version
		caps.setCapability("deviceName", "iPhone 6"); //Replace this with your simulator/device version 
		caps.setCapability("browserName", "Safari"); 
		caps.setCapability("app", " "); // if using an app mention app path in your system
		driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
	}
	@Test
	public void launchBrowser() throws InterruptedException
	{
		driver.get("https://www.roomstogo.com");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.roomstogo.com", "URL Mismatch");
		Assert.assertEquals(driver.getTitle(), "Furniture Store: Affordable Home Furniture Online", "Title Mismatch");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
