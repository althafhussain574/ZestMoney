package com.framework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestCase {
	
	public static WebDriver driver = null;
	public static Logger log = Logger.getLogger(BaseTestCase.class);
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Driver Initialization done");
	}
	
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
		log.info("Driver Instance is closed successfully");
	}
}
