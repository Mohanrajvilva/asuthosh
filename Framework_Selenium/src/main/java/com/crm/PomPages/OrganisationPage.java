package com.crm.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement Plusbtn;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement Searchbar;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchbtn;
	
	@FindBy(id="1")
	private WebElement Createdorg;
	
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getSearchbar() {
		return Searchbar;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getCreatedorg() {
		return Createdorg;
	}

	

	public WebElement getPlusbtn() {
		return Plusbtn;
	}
	

}
