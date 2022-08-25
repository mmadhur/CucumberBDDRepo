package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	public WebDriver ldriver;

	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath = "//input[@id='SearchEmail']")
	WebElement txtemail;

	@FindBy(xpath = "//input[@id='SearchFirstName']")
	WebElement f_name;

	@FindBy(xpath = "//input[@id='SearchLastName']")
	WebElement l_name;

	@FindBy(xpath = "//button[@id='search-customers']")
	WebElement srch_btn;

	@FindBy(xpath = "//table[@id='customers-grid']")
	WebElement table;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tablerows;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tablecolumns;

	// ------------------Actions Method------------------

	public void setEmail(String email) {
		txtemail.clear();
		txtemail.sendKeys(email);
	}

	public void setFirstName(String fname) {
		txtemail.clear();
		f_name.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtemail.clear();
		l_name.sendKeys(lname);
	}

	public void clickonsearch() {
		srch_btn.click();
	}

	public int getTableRows() {
		return (tablerows.size());
	}

	public int getTableCols() {
		return (tablecolumns.size());
	}

	public boolean searchCustomerbyEmail(String email) {
		boolean flag = false;

		for (int i = 1; i <= getTableRows(); i++) {
			String emailid = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]"))
					.getText();

			if (emailid.endsWith(email)) {
				flag = true;
			}
		}
		return flag;
	}

	public boolean searchCustomerbyName(String Name) {
		boolean flag = false;

		for (int i = 1; i <= getTableRows(); i++) {

			String name = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[3]"))
					.getText();
			String names[] = name.split(" ");

			if (names[0].equals("James") && names[1].equals("Pan")) {
				flag = true;
			}
		}
		return flag;
	}

}
