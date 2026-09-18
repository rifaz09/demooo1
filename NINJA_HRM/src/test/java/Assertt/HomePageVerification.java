package Assertt;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageVerification {
	
	@Test
	public void homaeverify()
	{
		String Exptresult="Home-page";
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.29.4:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String actresult=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		
		
		SoftAssert sa=new SoftAssert();
		sa.assertNotEquals(actresult, Exptresult);
		sa.assertAll();
	
		
		System.out.println("end of execution");
	}
	
	@Test
	public void logoverification()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.29.4:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		boolean actresult=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isDisplayed();	
		Assert.assertTrue(actresult);
	}

}
