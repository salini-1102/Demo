package demo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenerclass implements ITestListener {

	ExtentReports er;
	
	
	//it will monitor the listener class ex= when it is starting and ending
	
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		String name = result.getName();
		
		//particular test monitor
		
		test= er.createTest(name);
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String name = result.getName();
		
		test.log(Status.PASS, name+"------->pass");
	}

	public void onTestFailure(ITestResult result) {
		
		
        String name = result.getName();
		
		test.log(Status.FAIL, name+"------->Fail");
	}

	public void onTestSkipped(ITestResult result) {
		
		
       String name = result.getName();
		
		test.log(Status.SKIP, name+"------->Skipped");
	}

	public void onStart(ITestContext context) {
		
		//to provide path of the report
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\Extent Report\\"+1+".html");
		
		//to provide title to the report
		
		esr.config().setDocumentTitle("Final Vtiger report");
		
		//to provide the theme or colour
		
		esr.config().setTheme(Theme.STANDARD);
		
		//to provide reporter name
		
		esr.config().setReportName("Salini");
		
		er = new ExtentReports();
		
		//mapping the ExtentSparkReporter and ExtentReports
		er.attachReporter(esr);
		
		er.setSystemInfo("Operating System", "Windows");
		
		er.setSystemInfo("Language", "java");
		
	}

	public void onFinish(ITestContext context) {
		//to make consolidate report
		er.flush();
	}
	
	
}
