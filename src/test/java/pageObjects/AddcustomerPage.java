package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {

	
public WebDriver ldriver;
	
	public AddcustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
//	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
//	WebElement Customers;
	
	By lnkcustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkcustomersmenu_item = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	
	By btnadd_new = By.xpath("//a[normalize-space()='Add new']");
	By txt_email = By.xpath("//input[@id='Email']");
	By txt_password = By.xpath("//input[@id='Password']");
	By txtfirst_name = By.xpath("//input[@id='FirstName']");
	By txtlast_name = By.xpath("//input[@id='LastName']");
	By txtcb_male = By.xpath("//label[normalize-space()='Male']");
	By txtcb_female = By.xpath("//label[normalize-space()='Female']");
	By txtdob = By.xpath("//input[@id='DateOfBirth']");
	By txtcompany_name = By.xpath("//input[@id='Company']");
	By txt_taxexempt = By.xpath("//input[@id='IsTaxExempt']");
	By txt_newsltr = By.xpath("//div[@class='input-group-append']//div[@role='listbox']");
	By txtcustomer_roles = By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']");
	By txtmanager_vendor = By.xpath("//select[@id='VendorId']");
	By txt_active = By.xpath("//input[@id='Active']");
	
	By listitemguests = By.xpath("//li[normalize-space()='Guests']");
	By listitemAdmin = By.xpath("");
	By listitemregister = By.xpath("//li[normalize-space()='Registered']");
	By listitemvendors = By.xpath("//li[contains(text(),'Vendors')]");
	By listitemForumModerators = By.xpath("//li[normalize-space()='Forum Moderators']");
	
	By txt_admincontent = By.xpath("//textarea[@id='AdminComment']");
	By txtbtn_save = By.xpath("//button[@name='save']");
	
	// Actions Method
	
	public String getTitle()
	{
		return ldriver.getTitle();
	}
	public void click_customer_menu()
	{
		ldriver.findElement(lnkcustomers_menu).click();
	}
	
	public void click_customer_menu_item()
	{
		ldriver.findElement(lnkcustomersmenu_item).click();
	}
	
	public void click_addnew_btn()
	{
		ldriver.findElement(btnadd_new).click();
	}
	public void setEmail(String email)
	{
		ldriver.findElement(txt_email).sendKeys(email);
	}
	public void setpassword(String password)
	{
		ldriver.findElement(txt_password).sendKeys(password);
	}
	public void setFirstName(String fname)
	{
		ldriver.findElement(txtfirst_name).sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		ldriver.findElement(txtlast_name).sendKeys(lname);
	}
	public void setGender(String gender)
	{
		if(gender.equals("male"))
		{
			ldriver.findElement(txtcb_male).click();
		}
		else if(gender.equals("female"))
		{
			ldriver.findElement(txtcb_female).click();
		}
		else
		{
			ldriver.findElement(txtcb_male).click(); // by default
		}
	}
	
	public void setDob(String dob)
	{
		ldriver.findElement(txtdob).sendKeys(dob);
	}
	
	public void setCompanyName(String c_name)
	{
		ldriver.findElement(txtcompany_name).sendKeys(c_name);
	}
	public void isTaxExempt(boolean s)
	{
		if(s == true)
		{
			ldriver.findElement(txt_taxexempt).click();
		}
		
	}
	public void setAdminContent(String text)
	{
		ldriver.findElement(txt_admincontent).sendKeys(text);
	}
	
	public void setManagerVendor()
	{
		Select drp = new Select(ldriver.findElement(txtmanager_vendor));
		//drp.selectByVisibleText(value);
		drp.selectByIndex(1);
	}
	public void setCustomerRoles(String role)
	{
		if(role.equals("Vendors"))
		{
			//ldriver.findElement(txtcustomer_roles).click();
			ldriver.findElement(listitemvendors).click();
		}
					
	}
	
	public void clicksave() throws InterruptedException
	{
		Thread.sleep(3000);
		ldriver.findElement(txtbtn_save).click();
	}
	
	
}
