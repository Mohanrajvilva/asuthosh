package com.crm.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement Createcontactplusbtn;
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreatecontactplusbtn() {
		return Createcontactplusbtn;
	}
	

}
