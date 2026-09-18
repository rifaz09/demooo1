package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTest2 {
	
	@Test(dataProvider = "getdata")
	public void createcontact(String firstname,String lastname,long phoneno) {
		System.out.println("firstname: " +firstname+ "lastname "+lastname+ "phonenumber "+phoneno);
	}
	
	@DataProvider
	public Object[][] getdata(){
		Object[][] objArr=new Object[3][3];
		objArr[0][0] ="deepak";
		objArr[0][1] ="hr";
		objArr[0][2] =8976567842l;
		
		objArr[1][0] ="sam";
		objArr[1][1] ="sh";
		objArr[1][2] =8976567843l;
		
		objArr[2][0] ="jhon";
		objArr[2][1] ="smith";
		objArr[2][2] =8976567840l;
		
		return objArr;
		
		
	}

}
