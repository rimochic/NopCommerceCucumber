package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class searchCustomer {
	
	WebDriver driver;
	WaitHelper wait;
	public searchCustomer(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
	}
	
	@FindBy(xpath="//input[@id='SearchEmail']")
	WebElement txtEmail;
	@FindBy(id="SearchFirstName")
	WebElement txtFirstName;
	@FindBy(id="SearchLastName")
	WebElement txtLastName;
	@FindBy(id="search-customers")
	WebElement serachBtn;
	@FindBy(xpath="//table[@role='grid']")
	WebElement searchTable;
	@FindBy(xpath="//table[@id='customers-grid']")
	WebElement tableData;
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;
	
	
	
	public void setEmail(String email) {
		wait.waitForElement(txtEmail, 5);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFName(String fname) {
		wait.waitForElement(txtFirstName, 5);
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}
	
	public void setLName(String lname) {
		wait.waitForElement(txtLastName, 5);
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	
	public void setSearchBtn() {
		serachBtn.click();
	}
	
	public int getNoRows() {
		return tableRows.size();
	}
	
	public int getNoColumns() {
		return tableColumns.size();
	}
	// searching customer by email
	public boolean searchCustomerByEmail(String email) {
		boolean flag = false;
		for(int i=1;i<=getNoRows();i++) {
			String emailId = tableData.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailId);
			if(emailId.equals(email)) {
				flag=true;
			}
		}
		return flag;
	}
	
	// searching customer by email
		public boolean searchCustByFnamAndLname(String Name) {
			boolean flag = false;
			for(int i=1;i<=getNoRows();i++) {
				String name = tableData.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
				String names[]=name.split(" ");
				if(names[0].equals("Victoria") && names[1].equals("Terces")) {
					flag=true;
				}
			}
			return flag;
		}
	
	
	
	

}
