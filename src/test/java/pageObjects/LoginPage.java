package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	//constructor
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	
	// Action methods
	
	public void setEmail(String email	) {
		txtEmail.sendKeys(email);
		
	}
	
	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	
	

}
