package pac.buisness.pom.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.utility.nullability.NeverNull.ByDefault;

public class OrganizationInfo {
	
	WebDriver driver;
	public OrganizationInfo(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orginfo;

	public WebElement getOrginfo() {
		return orginfo;
	}

}
