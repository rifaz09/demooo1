package practice.testng;

import org.testng.annotations.Test;

public class InvocationTesst {
	
	@Test(invocationCount = 10)
	public void CreateOrderTest()
	{
		System.out.println("Execute CreateOrderTest");
	}
	
	@Test(enabled = false)
	public void billingAnOrderTest()
	{
		System.out.println("Execute billingAnOrderTest");
	}

}
