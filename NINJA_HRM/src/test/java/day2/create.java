package day2;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class create {
	public static void main(String[] args) throws Exception {

		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");

		Properties p = new Properties();
		p.load(fis);

		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("userName");
		String password = p.getProperty("password");

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

		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Employees']")).click();
		driver.findElement(By.xpath("//span[text()='Add New Employee']")).click();

		fis = new FileInputStream("./src/test/resources/project 2.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		Random r = new Random();
		int num = r.nextInt();

		String name = wb.getSheet("Sheet1").getRow(1).getCell(0).toString() + num;
		String email = wb.getSheet("Sheet1").getRow(1).getCell(1).toString();
		String phone = wb.getSheet("Sheet1").getRow(1).getCell(2).toString();
		String username = wb.getSheet("Sheet1").getRow(1).getCell(3).toString() + num;
		String designation = wb.getSheet("Sheet1").getRow(1).getCell(4).toString();
		String experience = wb.getSheet("Sheet1").getRow(1).getCell(5).toString();
		String project = wb.getSheet("Sheet1").getRow(1).getCell(6).toString();

		driver.findElement(By.xpath("//label[text()='Name*']/following-sibling::input")).sendKeys(name);
		driver.findElement(By.xpath("//label[text()='Email*']/following-sibling::input")).sendKeys(email);
		driver.findElement(By.xpath("//label[text()='Phone*']/following-sibling::input")).sendKeys(phone);
		driver.findElement(By.xpath("//label[text()='Username*']/following-sibling::input")).sendKeys(username);
		driver.findElement(By.xpath("//label[text()='Designation*']/following-sibling::input")).sendKeys(designation);
		driver.findElement(By.xpath("//label[text()='Experience*']/following-sibling::input")).sendKeys(experience);

		Select sl = new Select(driver.findElement(By.xpath("//label[text()=' Project*']/following-sibling::select")));
		sl.selectByVisibleText(project);
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@value='Add']")));
		
//		Actions act = new Actions(driver);
//		act.moveToElement(driver.findElement(By.xpath("//input[@value='Add']"))).perform();
//		act.click(driver.findElement(By.xpath("//input[@value='Add']"))).perform();

	}  

}
