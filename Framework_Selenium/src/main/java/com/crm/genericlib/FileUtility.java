package com.crm.genericlib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class FileUtility {

	public String readDatafromPropertyfile(String key) throws IOException
	{
		FileInputStream fs=new FileInputStream(AutoConstant.propertyfilepath);
		Properties p=new Properties();
		p.load(fs);
		return p.getProperty(key);
	}
}
