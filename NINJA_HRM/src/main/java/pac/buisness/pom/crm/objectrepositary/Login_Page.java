package pac.buisness.pom.crm.objectrepositary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	WebDriver driver;
		public Login_Page(WebDriver driver) {
			this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement user;
	
	@FindBy(name="user_password")
	private WebElement pwd;
	
	@FindBy(id="submitButton")
	private WebElement submitbtn;

	public WebElement getUser() {
		return user;
	}

	

	public WebElement getPwd() {
		return pwd;
	}

	

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	

	
	
	
	public void logintoapp(String username,String password)
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		user.sendKeys(username);
		pwd.sendKeys(password);
		submitbtn.click();
	}
	
}
