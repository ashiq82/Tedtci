package Mytest;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DriverHandlers{
	
	
	public  void get(String url) {
		Base.driver.get(url);
		Listener.test.info("Navigated to "+url);

	}
	
	public  void click(String css) throws Exception {
		
		
		try {
		WebElement element =Base.driver.findElement(By.xpath(css));
		Actions a = new Actions(Base.driver);
		a.moveToElement(element).click().perform();
		}
		catch(Exception e)
		{
			Listener.test.fail(e);
			throw new Exception(e);
		}
		
		
			
		
	}
	
	public  void close() {
		Base.driver.close();
	}
	
	public  void screenshot(String name) 
	{
		
	File src = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.FILE);
	String name1 = Testngcreate.f1+"\\Screenshots\\"+name+".jpg";
	File dest = new File(name1);
	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		Listener.test.addScreenCaptureFromPath(name1, name);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
