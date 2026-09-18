package practiceTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import baseclass.BaseClass;

public class CreateContactTest extends BaseClass {
	
	
	@Test
	public void createcontact() {
		System.out.println("Executing======createcontact");
	}
	@Test
	public void createcontactwithdate() {
		System.out.println("Execute======createcontacteithdate");
	

	}


}
