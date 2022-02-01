package com.crm.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import com.crm.PomPages.Homepage;
import com.crm.PomPages.LoginPage;

public class Baseclass {
	
public WebDriver driver;
	
	public static WebDriver sdriver=null;
	public ExcelUtility elib=new ExcelUtility();
	public FileUtility flib=new FileUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	
	@BeforeSuite(groups= {"smoketest","regressiontest"})
	public void configBS() {
		System.out.println("========connect to DB=============");
                 
	}

	//@Parameters("browser")
	@BeforeClass(groups= {"smoketest","regressiontest"})
	public void configBC() throws Throwable
	{
		String Browser = flib.readDatafromPropertyfile("browser");
		String Url = flib.readDatafromPropertyfile("url");
		if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		wlib.maximizeWindow(driver);
		wlib.waitForpageLoad(driver);
		driver.get(Url);
		sdriver=driver;
		
	}
	@BeforeMethod(groups= {"smoketest","regressiontest"})
	public void configBM() throws Throwable
	{
		
		String Username = flib.readDatafromPropertyfile("username");
		String Password = flib.readDatafromPropertyfile("password");
		
		
		
		LoginPage lp=new LoginPage(driver);
		lp.Login(Username, Password);
	}
	
	@AfterMethod(groups= {"smoketest","regressiontest"})
	public void configAM()
	{
		Homepage hp=new Homepage(driver);
		hp.logout(driver);
	}
	
	@AfterClass(groups= {"smoketest","regressiontest"})
	public void configAC()
	{
		driver.quit();
	}
	
	@AfterSuite(groups= {"smoketest","regressiontest"})
	public void configAS() {
		System.out.println("=========close DB==============");
	}


}
