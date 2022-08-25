package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_pge1 {

public WebDriver ldriver;
	
	public Login_pge1(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(id ="Email")
	WebElement txtemail;
	
	@FindBy(id ="Password")
	WebElement txtPassword;
	
	@FindBy(xpath ="//button[normalize-space()='Log in']")
	WebElement btnlogin;
			
	@FindBy(xpath ="//a[normalize-space()='Logout']")
	WebElement btnlogout;
	
	public void setusername(String uname)
	{
		txtemail.clear();
		txtemail.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{ 
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
		
	}
	
	public void clicklogin()
	{ 
		btnlogin.click();
	}
	
	public void clicklogout()
	{ 
		btnlogout.click();
	}
	
	
}
