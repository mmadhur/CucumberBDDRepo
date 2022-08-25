package StepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddcustomerPage;
import pageObjects.Login_pge1;
import pageObjects.SearchCustomerPage;

public class BaseClass {

	public WebDriver driver;
	public Login_pge1 lp1;
	public AddcustomerPage addcust;
	public SearchCustomerPage searchcust;
//	public Properties configprop;
	
	
	public static String Randomstring()
	{
		 String randomStr = RandomStringUtils.randomAlphabetic(5);
		 return (randomStr);
	}
	
	
	
}
