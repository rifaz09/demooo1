package ExtentReport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentScreenshot {
	
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
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.29.4:8888/");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filepath=ts.getScreenshotAs(OutputType.BASE64);

		ExtentTest test = report.createTest("createcontactTest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HFDC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.addScreenCaptureFromBase64String(filepath,"Errorfile");
		}
		driver.close();

	}


}
