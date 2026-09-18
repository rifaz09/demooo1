package day3;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import buisness.login_page;

public class loginn {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://49.249.29.4:8091/");
		
		login_page lp=new login_page(driver);
		lp.userlogin("rmgyantra", "rmgy@9999");
	}

}
