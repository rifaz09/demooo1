package ExtentReport;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	ExtentReports report;

	@BeforeSuite
	public void bs() {
		// spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("crm test suit result");
		spark.config().setReportName("crm report");
		spark.config().setTheme(Theme.DARK);

		// add envoironment info and create test
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows-11");
		report.setSystemInfo("browser", "chrome-100");

	}

	@AfterSuite
	public void as() {
		report.flush();

	}

	@Test
	public void createcontactTest1() {

		ExtentTest test = report.createTest("createcontactTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HFDC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}

	}

	@Test
	public void createcontactwithorg() {

		ExtentTest test = report.createTest("createcontactTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HFDC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}

	}

	@Test
	public void createcontacwithphone() {

		ExtentTest test = report.createTest("createcontactTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HFDC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}

	}

}
