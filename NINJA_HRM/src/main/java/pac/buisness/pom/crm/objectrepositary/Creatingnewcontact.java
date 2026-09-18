package pac.buisness.pom.crm.objectrepositary;

import java.sql.Date;
import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Creatingnewcontact {
	
	WebDriver driver;
	public Creatingnewcontact(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(name="button")
	private WebElement savebtn;
	
	@FindBy(name="search_text")
	private WebElement search;
	
	@FindBy(id="bas_searchfield")
	private WebElement inn;
	
	@FindBy(name="submit")
	private WebElement searchbtn;
	
	@FindBy(id="mobile")
	private WebElement mobile;
	
	@FindBy(xpath = "//a[text()='Edit']")
	private WebElement link;
	
	@FindBy(name = "button_Mobile")
	private WebElement savemob;
	
	@FindBy(id = "jscal_field_support_end_date")
	private WebElement insertdate;

	public WebElement getInsertdate() {
		return insertdate;
	}

	public WebElement getSavemob() {
		return savemob;
	}

	public WebElement getLink() {
		return link;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getInn() {
		return inn;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createcontact(String lstname)
	{
		lastname.sendKeys(lstname);
		
		savebtn.click();
	}
	
	
	public void createcontact(String searchname, String in)
	{
		search.sendKeys(searchname);
		Select sel=new Select(inn);
		sel.selectByVisibleText(in);
		searchbtn.click();
		
		}
	
	public void createcontactwithmobile(String lstname,String mob)
	{
		lastname.sendKeys(lstname);
//		Actions act=new Actions(driver);
//		act.moveToElement(link);
//		link.click();
		mobile.sendKeys(mob);
		
		savebtn.click();
	}

}
