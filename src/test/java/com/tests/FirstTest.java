package com.tests;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.framework.BaseTestCase;
import com.pages.AmazonPage;
import com.pages.FlipkartPage;

public class FirstTest extends BaseTestCase
{
	AmazonPage amazon_page;
	FlipkartPage flip_page;
	
	@Test
	public void test1() throws Exception
	{
		try
		{
			driver.get("http://www.amazon.in");
			Thread.sleep(1500);
			amazon_page = new AmazonPage(driver);
			amazon_page.enterText("iphone 11 64gb white");
			amazon_page.touchsearchbutton();
			Thread.sleep(2000);
			amazon_page.touchPhone();
			Thread.sleep(2000);
			 //Get handles of the windows
	        String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();
	        String a_price = null;
	        int p = 0;
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                a_price = amazon_page.getAmazonPrice();
	                a_price = a_price.substring(1, a_price.length());
	               //String aaa_price = a_price.split(".")[0];
	               String aaprice= a_price.replaceAll("[-+^:,]","");
	               String substr = aaprice.substring(0,aaprice.indexOf("."));
	               substr= substr.trim();
	               p = Integer.parseInt(substr.trim());
	    			System.out.println(p);
	    			driver.close();
	            }
	        }
	        driver.switchTo().window(mainWindowHandle);
	        driver.get("http://www.flipkart.com");
	        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	        Thread.sleep(3000);
	        flip_page = new FlipkartPage(driver);
	        flip_page.ClickAlert();
	        flip_page.enterText("iphone 11 64gb white");
	        Thread.sleep(2000);
	        flip_page.touchsearchbutton();
	        Thread.sleep(1500);
	        
	        flip_page.touchPhone();
	        Thread.sleep(3000);
	        String f_price = null;
	        String mainWindowHandle1 = driver.getWindowHandle();
	        Set<String> allWindowHandles1 = driver.getWindowHandles();
	        Iterator<String> iterator1 = allWindowHandles1.iterator();
	        int f = 0;
	        while (iterator1.hasNext()) {
	            String ChildWindow = iterator1.next();
	                if (!mainWindowHandle1.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                f_price = flip_page.getflipartprice();
	                f_price = f_price.substring(1,f_price.length());
	                String aaprice= f_price.replaceAll("[-+^:,]","");
	                f = Integer.parseInt(aaprice);
	    			System.out.println(f);
	    			driver.close();
	            }
	        }
	        driver.switchTo().window(mainWindowHandle1);
			
	        if(p>f)
	        {
	        	System.out.println("Amazon has higher price than flipkart");
	        }
	        else
	        {
	        	System.out.println("Flipkart has more price compared to amazon");
	        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
	}
	

}
