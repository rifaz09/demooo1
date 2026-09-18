package pac.buisness.pom.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(linkText ="Organizations")
	private WebElement orglink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactlink;
	
	@FindBy(linkText = "More")
	private WebElement Morelink;
	
	@FindBy(linkText = "Campigns")
	private WebElement camplink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admin;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signout;
	

	public WebElement getAdmin() {
		return admin;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getMorelink() {
		return Morelink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	
	
	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getCamplink() {
		return camplink;
	}

	public void navigatetocamp()
	{
		Actions act=new Actions(driver);
		act.moveToElement(Morelink).perform();
		camplink.click();
	}
	
	public void logout()
	{
		Actions act=new Actions(driver);
		act.moveToElement(admin).perform();
		signout.click();
	}
	

}
