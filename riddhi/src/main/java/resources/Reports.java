package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {


	public static ExtentReports generateReoprt() {
		String path=System.getProperty("user.dir")+"//reports/extent.html";
		
			ExtentSparkReporter reporter=new ExtentSparkReporter(path);
			reporter.config().setReportName("RIDDHI AUTOMATION REPORT");
			reporter.config().setDocumentTitle("RESULTS");
			
			ExtentReports reports=new ExtentReports();
			reports.attachReporter(reporter);
			reports.setSystemInfo("tester", "AMIT GAIKWAD");
			reports.setSystemInfo("system", "windows 10");
			reports.setSystemInfo("browser", "chrome");
			return reports;
	}
	
	
	
	
}
