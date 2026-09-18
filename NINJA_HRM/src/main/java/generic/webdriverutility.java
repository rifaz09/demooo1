package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class webdriverutility {
	
		
		public WebDriver driver;
		
		public WebDriver launchbrowser(String browser){
				
		if(browser.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		else
			driver=new ChromeDriver();
		return driver;
		}
		
		public void maximize(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		public void implictwait(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration
					.ofSeconds(10));
		}
		
		public void selectfromdropdown(WebElement ele, String visibletext)
		{
			Select sel=new Select(ele);
			sel.selectByVisibleText(visibletext);
		}
		
		}


