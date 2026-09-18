package com.crm.Listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseclass.BaseClass;
//@Listeners(Listener_utility.ListenerImpClass.class)
public class Listener extends BaseClass {
	
	
	@Test
	public void createinvoiceTest( ) {
		System.out.println("execute createinvoice");
		String actresult=driver.getTitle();
		Assert.assertEquals(actresult, "login");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");
	}
	
	@Test
	public void createinvoicewithcontactTest( ) {
		System.out.println("executing createinvoicewithcontactTest");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");
	}

}
