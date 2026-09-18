package practiceTest;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.excelutility;

public class GetProductInfoTest {
	
	@Test(dataProvider = "getdata")
	public void getproductinfitest(String brandname,String productname)throws Exception {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com/");
		
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
		
		
		//capture product info
		String x="//span[text()='"+productname+"']/following::div[@class='puisg-row'][1]/div[1]/div/div[1]/div/div/a/span/span/span[2]";
		String price= driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
		}
	
	@DataProvider
	public Object[][] getdata() throws Exception{
		
		
		excelutility eu=new excelutility();
		int rowcount=eu.getrowcount("product");
		
		Object[][] objArr=new Object[rowcount][2];
		
		for(int i=0;i<rowcount;i++)
		{
		objArr[i][0]=eu.readDataFromExcel("product", i+1, 0);
		objArr[i][1]=eu.readDataFromExcel("product", i+1, 1);
		
		}
		
		return objArr;
	}

}
