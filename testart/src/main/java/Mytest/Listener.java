package Mytest;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import mypack.testtt;

public class Listener implements ITestListener{
	
	ExtentReports extent = Extent.reort();
	DriverHandlers driver = new DriverHandlers();
	static ExtentTest test;
	int y=0;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String name =result.getMethod().getMethodName();
		test =extent.createTest(name);
	
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Passed");
		y++;
		if(y==testtt.cnt)
		{
			
		driver.close();
		System.out.println(y+" Test PASSED");
        String zipDirName = "E:\\Result\\TestResult.zip";
        
        //zipSingleFile(file, zipFileName);
        
        Zipresult zipFiles = new Zipresult();
        zipFiles.zipDirectory(Testngcreate.f1, zipDirName);
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String name =result.getMethod().getMethodName();
		test.log(Status.FAIL, "Failed");
		driver.screenshot("Failed");
		extent.flush();
		
		System.out.println("Test Case "+name+ " FAILED");
        String zipDirName = Location.TestResult+"TestResult.zip";
        
        //zipSingleFile(file, zipFileName);
        
        Zipresult zipFiles = new Zipresult();
        zipFiles.zipDirectory(Testngcreate.f1, zipDirName);
        driver.close();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush();
		
		
	}
	
	

}
