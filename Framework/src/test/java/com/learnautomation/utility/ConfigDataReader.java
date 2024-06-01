package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataReader {
	
	Properties p;
	
	public ConfigDataReader() {
		try
		{
		File f = new File("./Config/Config.properties");
		FileInputStream fis = new FileInputStream(f);
		p = new Properties();
		p.load(fis);
		System.out.println("Properties have been loaded");
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	public String getConfigParam(String pname) {
		
		return p.getProperty(pname);
	}

}
