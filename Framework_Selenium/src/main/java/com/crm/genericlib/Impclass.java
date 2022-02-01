package com.crm.genericlib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Impclass implements ITestListener {
	public void onTestFailure(ITestResult result)
	{
		String testname = result.getMethod().getMethodName();
		System.out.println(testname+"Executing======");
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(Baseclass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./Screenshot/"+testname+".png");
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
