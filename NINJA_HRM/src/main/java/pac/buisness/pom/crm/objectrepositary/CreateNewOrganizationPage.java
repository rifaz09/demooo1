package pac.buisness.pom.crm.objectrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	
	
	
	

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;
	
	@FindBy(name="industry")
	private WebElement industrydb;

	public WebElement getIndustrydb() {
		return industrydb;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createorg(String orgname)
	{
		orgNameEdt.sendKeys(orgname);
		savebtn.click();
		
	}
	public void createorg(String orgname,String industry)
	{
		orgNameEdt.sendKeys(orgname);
		Select sel=new Select(industrydb);
		sel.selectByVisibleText(industry);
		savebtn.click();
		
	}

}
