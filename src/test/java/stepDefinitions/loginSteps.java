package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.loginPage;
import pageObjects.searchCustomer;
public class loginSteps extends BaseClass{
	

	@Before
	public void setup() throws IOException {
		
		logger=Logger.getLogger("nopCommerce"); // Added logger
		PropertyConfigurator.configure("log4j.properties"); // Added logger
		// Reading properties
		configProp = new Properties();
		FileInputStream configProfile = new FileInputStream("config.properties");
		configProp.load(configProfile);
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "./Drivers/chromedriver.exe");
		
		String br = configProp.getProperty("browser");
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
		driver = new ChromeDriver();
		}else if(br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", configProp.getProperty("edgepath"));
			driver = new EdgeDriver();
		}
		
		logger.info("****Launching Browser*****");
		driver.manage().window().maximize();
	}

	@Given("User launch the browser")
	public void user_launch_the_browser() {
		
	
		lp = new loginPage(driver);
		addCustomer= new AddCustomerPage(driver);
		searchCus = new searchCustomer(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		logger.info("****Opening URL*****");
		driver.get(url);
	}

	@And("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String username, String pwd) {
		logger.info("****Providing login details*****");
		lp.emailSet(username);
		lp.passworsSet(pwd);

	}

	@And("Click on Login button")
	public void click_on_login_button() {
		logger.info("****Started login*****");
		lp.loginB();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
			logger.info("****Login passed*****");
		}else {
			Assert.assertEquals(title, driver.getTitle());
			logger.info("****Login failed*****");
		}

	}

	@When("User click on log out link")
	public void user_click_on_log_out_link() {
		logger.info("****Click on logout button*****");
		lp.logoutB();
	}

	@And("Close the browser")
	public void close_the_browser() {
		logger.info("*****Closing the browser****");
		driver.close();
	}

	// Customer feature step definitions..................................

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		Assert.assertEquals("Dashboard / nopCommerce administration", addCustomer.getTitle());
	}
	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		logger.info("****User click on customers Menu*****");
		addCustomer.customer_MenuSet();
	}
	@And("Click on customers menu item")
	public void click_on_customers_menu_item() {
		logger.info("****User click on customers item*****");
		addCustomer.customer_ItemSet();
	}
	@And("Click on Add new button")
	public void click_on_add_new_button() {
		addCustomer.AddNew_BtnSet();
	}
	@Then("User can view Add new cutomer page")
	public void user_can_view_add_new_cutomer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCustomer.getTitle());
	}
	@When("User enters customer info")
	public void user_enters_customer_info() {
		logger.info("*****Adding new Customer*****");
		logger.info("*****Providing customer data*****");
		addCustomer.emailTxtSet(randomString()+"@gmail.com");
		addCustomer.passwordTxtSet("txt1234");
		addCustomer.FirstNameTxtSet("Fadi");
		addCustomer.LastNameTxtSet("xero");
		addCustomer.genderSet("Male");
		addCustomer.DobSet("06/12/1990");
		addCustomer.compabyName("Telecom");
		addCustomer.taxExemptSet();
//		addCustomer.selectVendorRole("Guests");
		addCustomer.selectVendor("Vendor 2");
		addCustomer.adminContentTxt("This is for Testing .............");

	}
	@And("Click o Save button")
	public void click_o_save_button() throws InterruptedException {
		logger.info("*****Saving customer data*****");
		addCustomer.saveBtnClick();
		Thread.sleep(2000);

	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));
	}
	
	// Steps for searching customer using email 
	@When("Enter customer Email")
	public void enter_customer_email() {
		logger.info("*****Seraching customer by using email*****");
		searchCus.setEmail("brenda_lindgren@nopCommerce.com");
	}
	@When("User click on search button")
	public void user_click_on_search_button() throws InterruptedException {
		searchCus.setSearchBtn();
		Thread.sleep(2000);
	}
	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		boolean status = searchCus.searchCustomerByEmail("brenda_lindgren@nopCommerce.com");
		Assert.assertEquals(true, status);
	}
	
	@When("Enter customer First name")
	public void enter_customer_first_name() {
		searchCus.setFName("Victoria");
	}
	@When("Enter customer Last name")
	public void enter_customer_last_name() {
		searchCus.setLName("Terces");
	}
	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() {
		logger.info("*****Searching customer by name*****");
		boolean status = searchCus.searchCustByFnamAndLname("Victoria Terces");
		Assert.assertEquals(true, status);
	}

}
