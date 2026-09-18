package practice.testng;

import org.testng.annotations.Test;

public class OrderTest {
	
	@Test
	public void CreateOrderTest()
	{
		System.out.println("Execute CreateOrderTest==>123");
		String str=null;
		System.out.println(str.equals("123"));
	}
	
	@Test(dependsOnMethods = "CreateOrderTest")
	public void billimgOrderTest() {
		System.out.println("Execute cillingOrderTest");
	}

}
