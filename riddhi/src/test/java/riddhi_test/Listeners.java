package riddhi_test;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Reports;
import utility.Utils;

public class Listeners extends Utils implements ITestListener{

	ExtentTest test;
	ExtentReports report = Reports.generateReoprt();

	
	public void onStart(ITestContext context) {
		System.out.println("test started : "+context.getName());

	}
	public void onTestStart(ITestResult result) {
		System.out.println("testing started on method: "+result.getName());
		 test = report.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
//		System.out.println("test passed successfully: "+result.getName());
		
		test.log(Status.PASS, "test passed :"+result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
//		System.out.println("test failed : "+result.getName());
		
		test.fail(result.getThrowable());
		String path=null;

		try {
			 path=getscreenshot(result.getMethod().getMethodName());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());


	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("test skipped : "+result.getName());

	}

	

	public void onFinish(ITestContext context) {
//		System.out.println("testing ended: "+context.getName());
		report.flush();

	}

}
