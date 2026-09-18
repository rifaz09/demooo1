package advanceday1;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class propertyfile {
	public static void main(String[] args) throws Exception {

		// 1.open the file in read mode
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");

		// 2.create object of properties class to read data based on key
		Properties p = new Properties();

		p.load(fis);

		System.out.println("url :" + p.getProperty("url"));
		System.out.println("userName: " + p.getProperty("userName"));
		System.out.println("password: " + p.getProperty("password"));

		WebDriver driver;

		if (p.getProperty("browser").equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (p.getProperty("browser").equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (p.getProperty("browser").equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("url"));

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(p.getProperty("userName"));
		Thread.sleep(5000);

		driver.findElement(By.id("inputPassword")).clear();
		driver.findElement(By.id("inputPassword")).sendKeys(p.getProperty("password"));
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
    
	}

}
