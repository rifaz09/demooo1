package pac2;

import org.testng.annotations.Test;

public class OrgTest {
	
	@Test
	public void createorgTest() {
		

		String URL=System.getProperty("url");
		String BROWSER=System.getProperty("browser");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		System.out.println("execute createorgTest");
	}
	
	@Test
	public void modifyorgTest() {
		System.out.println("execute modifyorgTest");
	}
	
	@Test
	public void industryorgTest() {
		System.out.println("execute industryorgTest");
	}

}
