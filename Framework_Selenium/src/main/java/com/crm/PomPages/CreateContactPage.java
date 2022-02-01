package com.crm.PomPages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericlib.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	WebDriver driver;
	
	@FindBy(name="lastname")
	private WebElement Contactname;
	
	@FindBy(xpath="//select[@name='leadsource']")
	private WebElement Leadsrc;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement Orgplusbtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement Savebutton;
	
	public CreateContactPage(WebDriver driver)
	{	this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getContactname() {
		return Contactname;
	}

	public WebElement getLeadsrc() {
		return Leadsrc;
	}

	public WebElement getSavebutton() {
		return Savebutton;
	}
	
	
	public WebElement getOrgplusbtn() {
		return Orgplusbtn;
	}

	public void Createcontact(String contactname,String Orgname) throws Throwable
	{
		Contactname.sendKeys(contactname);
		Orgplusbtn.click();
		//Thread.sleep(7000);
		switchToWindow(driver, "Accounts&action");
		OrganisationPage op=new OrganisationPage(driver);
		//Thread.sleep(7000);
		op.getSearchbar().sendKeys(Orgname);
		//Thread.sleep(7000);
		op.getSearchbtn().click();
		driver.findElement(By.xpath("//a[text()='"+Orgname+"']")).click();
		switchToWindow(driver,"Contacts&action");
		Savebutton.click();
	}
	
	public void Createcontact(String contactname)
	{
		Contactname.sendKeys(contactname);
		Savebutton.click();
	}
}
		

