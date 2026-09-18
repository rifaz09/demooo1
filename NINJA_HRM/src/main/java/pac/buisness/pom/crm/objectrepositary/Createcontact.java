package pac.buisness.pom.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createcontact {
	
	WebDriver driver;
	public Createcontact(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement Createnewcontact;

	public WebElement getCreatenewcontact() {
		return Createnewcontact;
	}
	
	

}
