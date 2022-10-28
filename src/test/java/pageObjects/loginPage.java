package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver driver;
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using ="Email")
	WebElement email;
	@FindBy(how = How.ID, using="Password")
	WebElement password;
	@FindBy(how = How.CSS, using = ".button-1.login-button")
	WebElement loginBtn;
	@FindBy(how = How.XPATH, using ="//a[text()='Logout']")
	WebElement logoutBtn;


	public void emailSet(String emailTxt) {
		email.clear();
		email.sendKeys(emailTxt);
	}
	public void passworsSet(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	public void loginB() {
		loginBtn.click();
	}
	public void logoutB() {
		logoutBtn.click();
	}

}
