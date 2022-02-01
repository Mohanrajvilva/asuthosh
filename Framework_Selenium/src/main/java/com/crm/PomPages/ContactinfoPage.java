package com.crm.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactinfoPage {
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement Contactheader;
	
	public ContactinfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getContactheader() {
		return Contactheader;
	}
	
	

}
