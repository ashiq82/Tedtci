package Mytest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent {
	
	
	
	public static ExtentReports report;
	
	public static ExtentReports reort() {
	
		
		  ExtentSparkReporter reporter = new ExtentSparkReporter(Testngcreate.f1);
		 
		  reporter.config().setReportName("Ashiq");
		  reporter.config().setDocumentTitle("MyReport");
		  reporter.config().enableTimeline(true); 
		  report = new ExtentReports();
		  report.attachReporter(reporter);
		  return report;
	}
		

}
