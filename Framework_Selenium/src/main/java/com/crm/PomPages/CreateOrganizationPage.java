package com.crm.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	WebDriver driver;
	
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(name="industry")
	private WebElement IndusTry;
	
	@FindBy(name="accounttype")
	private WebElement Type;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void createOrg(String Orgname)
	{
		orgName.sendKeys(Orgname);
		SaveBtn.click();
	}

	public WebElement getIndusTry() {
		return IndusTry;
	}

	public WebElement getType() {
		return Type;
	}
	
	
	

}
