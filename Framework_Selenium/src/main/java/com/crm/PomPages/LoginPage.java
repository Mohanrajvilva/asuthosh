package com.crm.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		
		@FindBy(name="user_name")
		private WebElement userName;
		
		@FindBy(name="user_password")
		private WebElement passWord;
		
		@FindBy(id="submitButton")
		private WebElement loginbtn;
		
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}

		
		public void Login(String username,String password)
		{
			userName.sendKeys(username);
			passWord.sendKeys(password);
			loginbtn.click();
		}

}
