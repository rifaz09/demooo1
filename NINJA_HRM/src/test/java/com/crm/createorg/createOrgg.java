package com.crm.createorg;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listener_utility.ListenerImpClass;
import baseclass.BaseClass;
import generic.UtilityClassObject;
import generic.excelutility;
import generic.javautility;
import pac.buisness.pom.crm.objectrepositary.CreateNewOrganizationPage;
import pac.buisness.pom.crm.objectrepositary.HomePage;
import pac.buisness.pom.crm.objectrepositary.OrganizationInfo;
import pac.buisness.pom.crm.objectrepositary.OrganizationPage;

public class createOrgg extends BaseClass {
	
		

		@Test(groups = "st")
		public void createorg() throws Exception {
			// WebDriver driver;

			UtilityClassObject.getTest().log(Status.INFO,"navigating to home");
			
		   
			HomePage hp = new HomePage(driver);
			hp.getOrglink().click();

			UtilityClassObject.getTest().log(Status.INFO,"navigating organization");
			OrganizationPage op = new OrganizationPage(driver);
			op.getCreateorg().click();
			
			javautility ju = new javautility();
			int num = ju.generaterandomnumber();

			excelutility eu = new excelutility();
			String orgName = eu.readDataFromExcel("org", 1, 0) + num;

			CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
			cp.createorg(orgName);

			OrganizationInfo oi = new OrganizationInfo(driver);
			String actualorname = oi.getOrginfo().getText();
			System.out.println(actualorname+"actual");

		}

		@Test(groups = "rt")
		public void CreateOrgWithIndustry() throws Exception {

			// WebDriver driver;

			javautility ju = new javautility();
			int num = ju.generaterandomnumber();

			excelutility eu = new excelutility();
			String orgName = eu.readDataFromExcel("org", 1, 0) + num;
			String industryname = eu.readDataFromExcel("org", 1, 1);

			HomePage hp = new HomePage(driver);
			hp.getOrglink().click();

			OrganizationPage op = new OrganizationPage(driver);
			op.getCreateorg().click();

			CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
			cp.createorg(orgName, industryname);

			OrganizationInfo oi = new OrganizationInfo(driver);
			String actualorname = oi.getOrginfo().getText();
			System.out.println(actualorname+"actual");
			

		}

	}



