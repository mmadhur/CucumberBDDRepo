package StepDefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddcustomerPage;
import pageObjects.Login_pge1;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {

	@Before
	public void setup() throws IOException {

		// ------Adding logs---------------
		logger = Logger.getLogger("Cucumber_demo");
		PropertyConfigurator.configure("log4j.properties");

		// ----Reading Properties file
		configprop = new Properties();
		// --------Opening file in input mode
		FileInputStream fis = new FileInputStream("config.properties");
		configprop.load(fis);

		String br = configprop.getProperty("browser");
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
			driver = new ChromeDriver();

		}
		logger.info("*********** LAUNCHING BROWSER**********");

	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {

		// ------Adding logs---------------
//		logger = Logger.getLogger("Cucumber_demo");
//		PropertyConfigurator.configure("log4j.properties");
//		
//		
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
//		driver = new ChromeDriver();
//		logger.info("*********** LAUNCHING BROWSER**********");
		
		lp1 = new Login_pge1(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		logger.info("*********** OPENING URL**********");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		logger.info("*********** PROVIDING LOGIN DETAILS **********");
		lp1.setusername(email);
		lp1.setPassword(password);

	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		logger.info("*********** STARTED LOGIN**********");
		lp1.clicklogin();
		Thread.sleep(3000);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {

		if (driver.getPageSource().contains("Login was unsuccessful")) {

			System.out.println("-------Login Unsuccessful----------");
			driver.close();
			Assert.assertTrue(false);

		} else {
			logger.info("*********** LOGIN SUCCESSFUL**********");
			Assert.assertEquals(driver.getTitle(), title);
		}
	}

	@When("User click on Log out")
	public void user_click_on_log_out() throws InterruptedException {

		Thread.sleep(3000);
		logger.info("*********** CLICKING LOGOUT**********");
		lp1.clicklogout();

	}

	@And("Close the browser")
	public void close_the_browser() throws InterruptedException {
		logger.info("*********** CLOSING BROWSER**********");
		Thread.sleep(3000);
		driver.quit();

	}
	// -------------------ADD NEW CUSTOMER STEPS
	// DEFINITIONS--------------------------------------

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {

		addcust = new AddcustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getTitle());
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		logger.info("*********** CLICK ON CUSTOMERS MENU**********");
		Thread.sleep(3000);
		addcust.click_customer_menu();
	}

	@When("click on customers menu item")
	public void click_on_customers_menu_item() throws InterruptedException {
		logger.info("*********** CLICK ON CUSTOMERS MENU ITEM**********");
		Thread.sleep(3000);
		addcust.click_customer_menu_item();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {

		logger.info("************CLICK ON ADD NEW BUTTON**********");
		Thread.sleep(3000);
		addcust.click_addnew_btn();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		logger.info("*********** OPENING CUSTOMERS DETAILS PAGE**********");
		Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {

		logger.info("*********** ENTERING CUSTOMER DETAILS**********");
		String email = Randomstring() + "@gmail.com";
		addcust.setEmail(email);
		addcust.setpassword("test1234");
		addcust.setFirstName("Mayank");
		addcust.setLastName("Madhur");
		addcust.setGender("male");
		addcust.setDob("09/01/1990");
		addcust.isTaxExempt(true);
		addcust.setAdminContent("This is for QA automation testing");
		Thread.sleep(2000);
		addcust.setManagerVendor();
		// addcust.setCustomerRoles("Vendors");

	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		Thread.sleep(3000);
		addcust.clicksave();

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {

		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));

	}

	// -----Find customer by Email Id--------------------------------------------

	@When("Enter customer email")
	public void enter_customer_email() throws InterruptedException {

		searchcust = new SearchCustomerPage(driver);
		Thread.sleep(3000);
		searchcust.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		Thread.sleep(3000);
		searchcust.clickonsearch();

	}

	@Then("user should find email in search table")
	public void user_should_find_email_in_search_table() throws InterruptedException {

		Thread.sleep(3000);
		boolean status = searchcust.searchCustomerbyEmail("victoria_victoria@nopCommerce.com");
		Thread.sleep(2000);
		Assert.assertEquals(true, status);
	}

	// ---------Find customer by name----------------------->

	@When("Enter customer first name")
	public void enter_customer_first_name() {

		searchcust = new SearchCustomerPage(driver);
		searchcust.setFirstName("James");

	}

	@When("Enter customer last name")
	public void enter_customer_last_name() {

		searchcust.setLastName("Pan");

	}

	@Then("user should find name in search table")
	public void user_should_find_name_in_search_table() throws InterruptedException {

		Thread.sleep(3000);
		boolean status = searchcust.searchCustomerbyName("James Pan");
		Thread.sleep(2000);
		Assert.assertEquals(true, status);
	}

}
