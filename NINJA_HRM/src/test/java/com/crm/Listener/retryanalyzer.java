package com.crm.Listener;

import org.testng.Assert;
import org.testng.annotations.Test;

public class retryanalyzer {
	
	@Test(retryAnalyzer = Listener_utility.retrylistener.class)
	public void activatesim( ) {
		System.out.println("executing activatesim");
		Assert.assertEquals("", "login");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");
	}

}
