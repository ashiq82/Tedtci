package Mytest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Location {

	public static String Testdatasheet;
	public static String TestSuite;
	public static String Testscript;
	public static String Testsheet;
	public static String TestResult;

	public static void Configutaion() throws Exception {

		File ff = new File("C:\\Users\\mashi\\eclipse-workspace\\testart\\configuration.properties");
		FileInputStream fi = new FileInputStream(ff);
		Properties prop = new Properties();
		prop.load(fi);
		Iterator<Object> keys =prop.keySet().iterator();
		
		while(keys.hasNext())
		{
			
			String value =keys.next().toString();
			if(prop.getProperty(value).isEmpty())
			{
				throw new Exception(value+" is empty");
			}
		}
		Testdatasheet = prop.getProperty("Testdatasheet_path");
		TestSuite = prop.getProperty("TestSuite_path");
		Testscript = prop.getProperty("Testscript_path");
		Testsheet = prop.getProperty("Testdatasheet");
		TestResult = prop.getProperty("TestResult");
		
		
	
	}
	

}
