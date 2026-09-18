package com.crm.createorg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import generic.excelutility;
import generic.javautility;

import pac.buisness.pom.crm.objectrepositary.Contactspage;
import pac.buisness.pom.crm.objectrepositary.Createcontact;
import pac.buisness.pom.crm.objectrepositary.Creatingnewcontact;
import pac.buisness.pom.crm.objectrepositary.HomePage;


public class createcontact extends BaseClass {
	
	
		
		
		
		@Test(groups = "st")
		public void CreateContact() throws Exception {
		
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
		System.out.println(actualcontact);
		
		}
		
		@Test(groups = "rt")
		public void CreateContactWithMobilenumber() throws Exception {
			
				
				
				
				HomePage hp=new HomePage(driver);
				hp.getContactlink().click();
				
				Createcontact co=new Createcontact(driver);
				co.getCreatenewcontact().click();
				
				javautility ju=new javautility();
				int num = ju.generaterandomnumber();
				
				
				excelutility eu=new excelutility();
				String contactname=eu.readDataFromExcel("org", 1, 0)+num;
				String contactmobileno=eu.readDataFromExcel("org", 1, 2);
				
				
				Creatingnewcontact cnc=new Creatingnewcontact(driver);
				cnc.createcontactwithmobile(contactname, contactmobileno);
				
				Contactspage cp=new Contactspage(driver);
				String actualcontact=cp.getContactinfo().getText();
				System.out.println(actualcontact);
			
		}

	}



