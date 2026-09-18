package vediosessioncrm;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import generic.excelutility;
import generic.javautility;
import generic.propertyutility;
import generic.webdriverutility;
import pac.buisness.pom.crm.objectrepositary.CreateNewOrganizationPage;
import pac.buisness.pom.crm.objectrepositary.HomePage;
import pac.buisness.pom.crm.objectrepositary.Login_Page;
import pac.buisness.pom.crm.objectrepositary.OrganizationInfo;
import pac.buisness.pom.crm.objectrepositary.OrganizationPage;

public class Crm {

	//public static void main(String[] args) throws Throwable {

		WebDriver driver;
		// read common data
		@Test
		public void createorg() throws Exception {
			//WebDriver driver;
		propertyutility pu = new propertyutility();
		String browser = pu.readDataProperFromproperty("browser");
		String url = pu.readDataProperFromproperty("url");
		String username = pu.readDataProperFromproperty("userName");
		String password = pu.readDataProperFromproperty("password");
		
		javautility ju=new javautility();
	int num=	ju.generaterandomnumber();
		
		excelutility eu=new excelutility();
		String orgName=eu.readDataFromExcel("org", 1, 0)+num;

		webdriverutility wdu = new webdriverutility();
		driver = wdu.launchbrowser("chrome");

		driver.get(url);

		Login_Page lp = new Login_Page(driver);
		lp.logintoapp(username, password);

		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateorg().click();
		
		CreateNewOrganizationPage cp=new CreateNewOrganizationPage(driver);
		cp.createorg(orgName);
		
		OrganizationInfo oi=new OrganizationInfo(driver);
		String actualorname=oi.getOrginfo().getText();
		if(actualorname.contains(orgName))
		{
			System.out.println(orgName +"name is verified==pass");
		}
		else
		{
			System.out.println(orgName+ "name is not verifeid==fail");
		}
		
		hp.logout();
		
		
		driver.quit();
		}
		
		@Test
		public void CreateOrgWithIndustry() throws Exception {
			
				//WebDriver driver;
			propertyutility pu = new propertyutility();
			String browser = pu.readDataProperFromproperty("browser");
			String url = pu.readDataProperFromproperty("url");
			String username = pu.readDataProperFromproperty("userName");
			String password = pu.readDataProperFromproperty("password");
			
			javautility ju=new javautility();
		int num=	ju.generaterandomnumber();
			
			excelutility eu=new excelutility();
			String orgName=eu.readDataFromExcel("org", 1, 0)+num;
			String industryname=eu.readDataFromExcel("org", 1, 1);

			webdriverutility wdu = new webdriverutility();
			driver = wdu.launchbrowser("chrome");

			driver.get(url);

			Login_Page lp = new Login_Page(driver);
			lp.logintoapp(username, password);

			HomePage hp=new HomePage(driver);
			hp.getOrglink().click();
			
			OrganizationPage op=new OrganizationPage(driver);
			op.getCreateorg().click();
			
			CreateNewOrganizationPage cp=new CreateNewOrganizationPage(driver);
			cp.createorg(orgName, industryname);
			
			OrganizationInfo oi=new OrganizationInfo(driver);
			String actualorname=oi.getOrginfo().getText();
			if(actualorname.contains(orgName))
			{
				System.out.println(orgName +"name is verified==pass");
			}
			else
			{
				System.out.println(orgName+ "name is not verifeid==fail");
			}
			
			hp.logout();
			
			
			driver.quit();
			}
			
			
		}

	


