package vediosessioncrm;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Deallocate;

import generic.excelutility;
import generic.javautility;
import generic.propertyutility;
import generic.webdriverutility;
import pac.buisness.pom.crm.objectrepositary.Contactspage;
import pac.buisness.pom.crm.objectrepositary.Createcontact;
import pac.buisness.pom.crm.objectrepositary.Creatingnewcontact;
import pac.buisness.pom.crm.objectrepositary.HomePage;
import pac.buisness.pom.crm.objectrepositary.Login_Page;

public class CreateContactTest {
	
	WebDriver driver;
	
	@Test
	public void CreateContact() throws Exception {
	propertyutility pu=new propertyutility();
	String browser=pu.readDataProperFromproperty("browser");
	String url=pu.readDataProperFromproperty("url");
	String username=pu.readDataProperFromproperty("userName");
	String password=pu.readDataProperFromproperty("password");
	
	webdriverutility wu=new webdriverutility();
	driver=wu.launchbrowser(browser);
	driver.get(url);
	
	Login_Page lp=new Login_Page(driver);
	lp.logintoapp(username,password);
	
	HomePage hp=new HomePage(driver);
	hp.getContactlink().click();
	
	Createcontact co=new Createcontact(driver);
	co.getCreatenewcontact().click();
	
	javautility ju=new javautility();
	int num = ju.generaterandomnumber();
	
	
	excelutility eu=new excelutility();
	String contactname=eu.readDataFromExcel("org", 1, 0)+num;
	
	Creatingnewcontact cnc=new Creatingnewcontact(driver);
	cnc.createcontact(contactname);
	
	Contactspage cp=new Contactspage(driver);
	String actualcontact=cp.getContactinfo().getText();
	
	}
	
	@Test
	public void CreateContactWithMobilenumber() throws Exception {
		
			propertyutility pu=new propertyutility();
			String browser=pu.readDataProperFromproperty("browser");
			String url=pu.readDataProperFromproperty("url");
			String username=pu.readDataProperFromproperty("userName");
			String password=pu.readDataProperFromproperty("password");
			
			webdriverutility wu=new webdriverutility();
			driver=wu.launchbrowser(browser);
			driver.get(url);
			
			Login_Page lp=new Login_Page(driver);
			lp.logintoapp(username,password);
			
			HomePage hp=new HomePage(driver);
			hp.getContactlink().click();
			
			Createcontact co=new Createcontact(driver);
			co.getCreatenewcontact().click();
			
			javautility ju=new javautility();
			int num = ju.generaterandomnumber();
			
			
			excelutility eu=new excelutility();
			String contactname=eu.readDataFromExcel("org", 1, 0)+num;
			
			
			Creatingnewcontact cnc=new Creatingnewcontact(driver);
			cnc.createcontact(contactname);
			
			Contactspage cp=new Contactspage(driver);
			String actualcontact=cp.getContactinfo().getText();
		
	}
	@Test
	public void CreateContactWithMobilenumber1() throws Exception {
		
			propertyutility pu=new propertyutility();
			String browser=pu.readDataProperFromproperty("browser");
			String url=pu.readDataProperFromproperty("url");
			String username=pu.readDataProperFromproperty("userName");
			String password=pu.readDataProperFromproperty("password");
			
			webdriverutility wu=new webdriverutility();
			driver=wu.launchbrowser(browser);
			driver.get(url);
			
			Login_Page lp=new Login_Page(driver);
			lp.logintoapp(username,password);
			
			HomePage hp=new HomePage(driver);
			hp.getContactlink().click();
			
			Createcontact co=new Createcontact(driver);
			co.getCreatenewcontact().click();
			
			javautility ju=new javautility();
			int num = ju.generaterandomnumber();
			
			
			excelutility eu=new excelutility();
			String contactname=eu.readDataFromExcel("org", 1, 0)+num;
			
			
			Creatingnewcontact cnc=new Creatingnewcontact(driver);
			cnc.createcontact(contactname);
			
			LocalDate currdate=LocalDate.now();
			System.out.println(currdate);
			
			Contactspage cp=new Contactspage(driver);
			String actualcontact=cp.getContactinfo().getText();
		
	}



}
