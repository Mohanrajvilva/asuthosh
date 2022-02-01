package com.crm.orgtest;



import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.genericlib.Baseclass;

import com.crm.PomPages.CreateOrganizationInfoPage;
import com.crm.PomPages.CreateOrganizationPage;
import com.crm.PomPages.Homepage;

import com.crm.PomPages.OrganisationPage;

public class OrganizationTest extends Baseclass {
	
	@Test(groups="smoketest")
	public void createOrgTest() throws Throwable
	{
		/**
		 * Get random number
		 */
		int random = jlib.getRandomNumber();
		/**
		 * Get data from excel sheet
		 */
		
		String Orgname = elib.getDataFromExcel("Sheet1",1,0)+random;
		/**
		 * Homepage
		 */
		Homepage hp=new Homepage(driver);
		hp.getOrglink().click();
		
		
		/**
		 * Organisationpage
		 */
		OrganisationPage op=new OrganisationPage(driver);
		op.getPlusbtn().click();
		/**
		 * CreateOrganisationpage
		 */
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrg(Orgname);
		/**
		 * CreateOrganisationInfo Page verification
		 */
		
		CreateOrganizationInfoPage coif=new CreateOrganizationInfoPage(driver);
		wlib.waitForElementToBeClickable(driver,coif.getHeader());
		
		String header = coif.getHeader().getText();
		
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(header.contains(Orgname));
		soft.assertAll();
		
		
	}
	
	//==============================================================================//
	
	@Test(groups="regressiontest")
	public void createOrgwithindustryTest() throws Throwable
	{
		/**
		 * get Random number
		 */
		
		int random = jlib.getRandomNumber();
		
		/**
		 * Get data from the excel sheet
		 *
		 */
		
		String Orgname = elib.getDataFromExcel("Sheet1",1,0)+random;
		
		String Industry = elib.getDataFromExcel("Sheet1",1,2);
		String Type = elib.getDataFromExcel("Sheet1",2,3);
		
		/**
		 * Navigating to homepage
		 */
		
		Homepage hp=new Homepage(driver);
		hp.getOrglink().click();
		
		/**
		 * Navigating to Organisation page
		 */
		OrganisationPage cp=new OrganisationPage(driver);
		cp.getPlusbtn().click();
		/**
		 * Organisation info page for verification
		 */
		
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrg(Orgname);
		WebElement ele = cop.getIndusTry();
		wlib.select(Industry, ele);
		
		
		wlib.waitForpageLoad(driver);
		WebElement ele1 = cop.getType();
		wlib.select(Type, ele1);
		
		CreateOrganizationInfoPage coif=new CreateOrganizationInfoPage(driver);
		wlib.waitForElementToBeClickable(driver, coif.getHeader());
		String Cont = coif.getHeader().getText();
		
		Assert.assertTrue(Cont.contains(Orgname));
		
}
}
