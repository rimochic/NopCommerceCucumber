package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	WebDriver driver;
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By customer_Menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By customer_Item = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By AddNew_Btn = By.cssSelector("a[class='btn btn-primary']");
	By emailTxt = By.xpath("//input[@id='Email']");
	By passwordTxt = By.xpath("//input[@id='Password']");
	By FirstNameTxt = By.xpath("//input[@id='FirstName']");
	By LastNameTxt = By.xpath("//input[@id='LastName']");
	By MaleGender = By.xpath("//input[@id='Gender_Male']");
	By FemaleGender = By.xpath("//input[@id='Gender_Female']");
	By DOB = By.xpath("//input[@id='DateOfBirth']");
	By companyNameTxt = By.xpath("//input[@id='Company']");
	By taxExempt = By.xpath("//input[@id='IsTaxExempt']");
	// Select Box Customer roles
	By CustomerRoleTxt = By.id("//div[@class='input-group-append input-group-required']//div[@role='listbox']");
	By ListAdminitrator = By.xpath("//option[contains(text(), 'Administrators')]");
	By ListModerator = By.xpath("//option[contains(text(), 'Forum Moderators')]");
	By ListGuest = By.xpath("//option[contains(text(), 'Guests')]");
	By ListRegistered = By.xpath("//option[contains(text(), 'Registered')]");
	By ListVendor = By.xpath("//option[contains(text(), 'Vendors')]");
	
	By dropDOfVendor = By.xpath("//select[@id='VendorId']");
	By adminContent = By.xpath("//textarea[@id='AdminComment']");
	By saveBtn = By.xpath("//button[@name='save']");
	
	//ACtions Methods
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void customer_MenuSet() {
		driver.findElement(customer_Menu).click();
	}
	public void customer_ItemSet() {
		driver.findElement(customer_Item).click();
	}
	public void AddNew_BtnSet() {
		driver.findElement(AddNew_Btn).click();
	}
	public void emailTxtSet(String email) {
		driver.findElement(emailTxt).sendKeys(email);
	}
	public void passwordTxtSet(String pwd) {
		driver.findElement(passwordTxt).sendKeys(pwd);
	}
	public void FirstNameTxtSet(String Fname) {
		driver.findElement(FirstNameTxt).sendKeys(Fname);
	}
	public void LastNameTxtSet(String Lname) {
		driver.findElement(LastNameTxt).sendKeys(Lname);
	}
	public void genderSet(String gender){
		if(gender.equals("Male")) {
			driver.findElement(MaleGender).click();
		}else if(gender.equals("Female")){
			driver.findElement(FemaleGender).click();
		}else{
			driver.findElement(MaleGender).click(); // default
		}
	}
	public void DobSet(String dob) {
		driver.findElement(DOB).sendKeys(dob);;
	}
	public void compabyName(String name) {
		driver.findElement(companyNameTxt).sendKeys(name);
	}
	public void taxExemptSet() {
		driver.findElement(taxExempt).click();
		}
	 public void selectVendorRole(String role) {
		 driver.findElement(CustomerRoleTxt).click();
		 Select list = new Select(driver.findElement(CustomerRoleTxt));
		 list.selectByVisibleText(role);
	 }
	 
	 public void selectVendor(String opt) {
		 driver.findElement(dropDOfVendor).click();
		 Select list = new Select(driver.findElement(dropDOfVendor));
		 list.selectByVisibleText(opt);
	 }

	 public void adminContentTxt(String content) {
		 driver.findElement(adminContent).sendKeys(content);
	 }
	 public void saveBtnClick() {
		 driver.findElement(saveBtn).click();
	 }
}
