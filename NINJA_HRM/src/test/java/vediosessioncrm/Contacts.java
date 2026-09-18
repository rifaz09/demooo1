package vediosessioncrm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import buisness.login_page;
import generic.excelutility;
import generic.javautility;
import generic.propertyutility;
import generic.webdriverutility;
import pac.buisness.pom.crm.objectrepositary.Contactspage;
import pac.buisness.pom.crm.objectrepositary.CreateNewOrganizationPage;
import pac.buisness.pom.crm.objectrepositary.Createcontact;

import pac.buisness.pom.crm.objectrepositary.Creatingnewcontact;
import pac.buisness.pom.crm.objectrepositary.HomePage;
import pac.buisness.pom.crm.objectrepositary.Login_Page;
import pac.buisness.pom.crm.objectrepositary.Searchresult;

public class Contacts {
	
	
		
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
		if(actualcontact.contains(contactname))
		{
			System.out.println(contactname  +  "  name is pass");
		}
		else
		{
			System.out.println(contactname+  "  name is fail");
		}
//		
//		hp.getContactlink().click();
//		
//		cnc.createcontact(contactname, "Last Name");
//		
//		driver.findElement(By.xpath("//a[text()='"+contactname+"']/preceding::input[@name='selected_id']")).click();
		
//		Searchresult sr=new Searchresult(driver);
//		sr.delete();
		
     hp.logout();
//		
//		Thread.sleep(3000);
//		driver.quit();
		
	}

}
