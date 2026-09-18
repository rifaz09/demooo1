package Listener_utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseclass.BaseClass;
import generic.UtilityClassObject;

public class ListenerImpClass implements ITestListener, ISuiteListener {
    
	
	public ExtentSparkReporter spark;
	public  ExtentReports report;
	public static ExtentTest test;
	
	
	
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		String time=new Date().toString().replace(" ","_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("crm test suit result");
		spark.config().setReportName("crm report");
		spark.config().setTheme(Theme.DARK);

		// add envoironment info and create test
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows-11");
		report.setSystemInfo("browser", "chrome-100");

		
//		String time=new Date().toString().replace(" ","_").replace(":", "_");
//		spark = new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
//		spark.config().setDocumentTitle("crm test suit result");
//		spark.config().setReportName("crm report");
//		spark.config().setTheme(Theme.DARK);
//
//		report = new ExtentReports();
//		report.attachReporter(spark);
//		report.setSystemInfo("os", "windows-11");
//		report.setSystemInfo("browser", "chrome-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("report backuo");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=======" + result.getMethod().getMethodName() + "=====start=====");
		 test = report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+">========end=====" );
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=======" + result.getMethod().getMethodName() + "======end=====");
		 test.log(Status.PASS, result.getMethod().getMethodName()+">========completed=====" );
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testname = result.getMethod().getMethodName();
		
		
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ","_").replace(":", "_");
		
		test.addScreenCaptureFromBase64String(filepath,testname+ "_"+time);
		 test.log(Status.FAIL, result.getMethod().getMethodName()+">========failed=====" );
		 
		 
//		File per = new File("./screenshot/"+testname+ "+"+time+".png");
//		try {
//			FileHandler.copy(temp, per);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		 
		
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	

}
