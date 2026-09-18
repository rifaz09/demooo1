package baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic.UtilityClassObject;
import generic.databaseutility;
import generic.propertyutility;
import generic.webdriverutility;
import pac.buisness.pom.crm.objectrepositary.HomePage;
import pac.buisness.pom.crm.objectrepositary.Login_Page;

public class BaseClass {

	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public ExtentSparkReporter spark;
	public ExtentReports report;

	@BeforeSuite(groups = { "st", "rt" })
	public void database() throws Exception {
		System.out.println("Execcuting====BS");
//		databaseutility du = new databaseutility();
//		du.getdbconnection(null, null, null);

		
	}

	// @Parameters("BROWSER")
	@BeforeClass(groups = { "st", "rt" })
	public void launchbrowsr() throws Exception {

		webdriverutility wbu = new webdriverutility();
		propertyutility pu = new propertyutility();
		String Browser = pu.readDataProperFromproperty("browser");
		String Url = pu.readDataProperFromproperty("url");
		driver = wbu.launchbrowser(Browser);
		UtilityClassObject.setDriver(driver);
		sdriver = driver;
		driver.get(Url);

	}

	@BeforeMethod(groups = { "st", "rt" })
	public void logintocrm() throws Exception {

		Login_Page lp = new Login_Page(driver);
		lp.logintoapp("admin", "admin");

	}

	@AfterMethod(groups = { "st", "rt" })
	public void configAM() {
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "st", "rt" })
	public void configAC() {
		driver.quit();
	}

	@AfterSuite(groups = { "st", "rt" })
	public void configAS() throws Exception {
		System.out.println("close  database");
		// databaseutility dbu = new databaseutility();
		// dbu.clodeconnection(null);
		
	}

}
