package com.crm.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement Header;
	
	@FindBy(xpath="(//a[text()='Contacts'])[1]")
	private WebElement contactlink;
	
	public CreateOrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getHeader() {
		return Header;
	}

	public WebElement getContactlink() {
		return contactlink;
	}
	
	

}
