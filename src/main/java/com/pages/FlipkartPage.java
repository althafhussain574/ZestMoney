package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPage {
	
	Logger log = Logger.getLogger(FlipkartPage.class);
	WebDriver driver;
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	WebElement flisearchbox;
	@FindBy(xpath="//button[@class='vh79eN']")
	WebElement flipserachbutton;
	@FindBy(xpath="//*[@class='_3Njdz7']/button")
	WebElement flip_alert;
	@FindBy(xpath="(//*[@class='_3wU53n'])[1]")
	WebElement flip_touchphone;
	@FindBy(xpath="//div[@class='_1vC4OE _3qQ9m1']")
	WebElement flip_iphoneprice;
	
	public FlipkartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		public void enterText(String text)
		{
			flisearchbox.clear();
			flisearchbox.sendKeys(text);
			log.info("Data entered on textfield : "+text);
		}
		
		public void touchsearchbutton()
		{
			flipserachbutton.click();
			log.info("clicked on search button");
		}
		
		public void ClickAlert()
		{
			flip_alert.isDisplayed();
			flip_alert.click();
			log.info("clicked on alert start page");
		}
	

		public void touchPhone() {
			flip_touchphone.click();
			log.info("clicked on iphone ");
			
		}
		
		public String getflipartprice()
		{
			String text = flip_iphoneprice.getText();
			log.info("get flipkart iphone price");
			return text;
		}
}
