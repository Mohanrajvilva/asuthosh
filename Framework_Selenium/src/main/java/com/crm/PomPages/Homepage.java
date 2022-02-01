package com.crm.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	public WebDriver driver;
	
	@FindBy(linkText="Organizations")
	private WebElement Orglink;
	
	@FindBy(linkText="Contacts")
	private WebElement Contactlink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Adminicon;
	
	@FindBy(linkText="Sign Out")
	private WebElement Logoutbtn;
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrglink() {
		return Orglink;
	}

	

	public WebElement getContactlink() {
		return Contactlink;
	}

	

	public WebElement getAdminicon() {
		return Adminicon;
	}

	public WebElement getLogoutbtn() {
		return Logoutbtn;
	}

	public void logout(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.moveToElement(Adminicon).perform();
		Logoutbtn.click();
	}
	


}
