package Mytest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.xml.XmlClass;

import com.aventstack.extentreports.ExtentReports;

import mypack.testtt;

public class TestS5{
	
	
		
		//DriverHandlers d= new DriverHandlers(driver);
		
		@Test
		public void Testef()  {
		
			Base.initialize();
			DriverHandlers driver = new DriverHandlers();
			driver.get("https://google.com");
			driver.screenshot("name");
			
		
		 

	}

}
