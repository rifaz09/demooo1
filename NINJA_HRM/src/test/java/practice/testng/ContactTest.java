package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {

	@Test//(priority = 2)
	public void createcontacttest() {
		System.out.println("Create contact in db");
		System.out.println("execute createcontacttest");
	}

	@Test//(priority = 1)
	public void createcontactwithmobileest() {
		System.out.println("create contact in Db");
		System.out.println("execute createcontactwithmobileest");
	}

}
