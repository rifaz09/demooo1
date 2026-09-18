package practiceTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class beforeAfter {
	
	@BeforeSuite
	public void configBS() {
		System.out.println("Execcuting====BS");
	}
	@BeforeClass
	public void configBC() {
		System.out.println("Executing=====BC");
	}
	@BeforeMethod
	public void configBM() {
		System.out.println("Executing======BM");
	}
	@Test
	public void createcontact() {
		System.out.println("Executing======createcontact");
	}
	@Test
	public void Ccd() {
		System.out.println("Executing========ccd");
	}
	@AfterClass
	public void configAC() {
		System.out.println("Executing========AC");
	}
	@AfterMethod
	public void configAM() {
		System.out.println("Executing=========AM");
	}
	@AfterSuite
	public void configAS() {
		System.out.println("Executing========AS");
	}

}
