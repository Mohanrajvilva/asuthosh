package com.crm.genericlib;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random ran = new Random();
		int random =ran.nextInt(2000);
		return random;
	}
	/**
	 * This method will returns the current date
	 * @return
	 */
	public String getCurrentDate()
	{
		Date d=new Date();
		String currentDate = d.toString();
		return currentDate;
		
	}
	
	/**
	 * This method will return date in specified format
	 * @return
	 */
	public String getFinalDate()
	{
		Date date=new Date();
		String dat = date.toString();
		String[] dte = dat.split(" ");
		String YYYY=dte[5];
		String DD = dte[2];
		String MM = dte[1];
		String today = YYYY+"-"+MM+"-"+DD;
		return today;
	}


}
