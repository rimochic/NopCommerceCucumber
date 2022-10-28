package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.loginPage;
import pageObjects.searchCustomer;

public class BaseClass {
	WebDriver driver;
	loginPage lp;
	AddCustomerPage addCustomer;
	searchCustomer searchCus;
	public static Logger logger;
	Properties configProp;
	
	// Generating random string for unique email
	public static String randomString() {
		String genrateString1 = RandomStringUtils.randomAlphabetic(5);
		return genrateString1;
	}
	

}
