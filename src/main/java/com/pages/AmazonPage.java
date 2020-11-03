package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

	WebDriver driver;
	Logger log = Logger.getLogger(AmazonPage.class);
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchbox;
	@FindBy(xpath="//*[@id='nav-search-submit-text']/input")
	WebElement searchbutton;
	@FindBy(xpath="(//*[@class='a-link-normal a-text-normal'])[1]")
	WebElement touchphone;
	@FindBy(xpath="//table[@class='a-lineitem']/tbody/tr[2]/td[2]//*[@id='priceblock_ourprice']")
	WebElement getamazonprice;
	
	
	public AmazonPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterText(String text)
	{
		searchbox.clear();
		searchbox.sendKeys(text);
		log.info("Data entered on textfield : "+text);
	}
	
	public void touchsearchbutton()
	{
		searchbutton.click();
		log.info("clicked on search button");
	}
	
	public void touchPhone()
	{
		touchphone.click();
		log.info("clicked on phone");
	}
	
	public String getAmazonPrice()
	{
		String text= getamazonprice.getText();
		log.info("Get Text for element is successful");
		return text;
	}
	
}

