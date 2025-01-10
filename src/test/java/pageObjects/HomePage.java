package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
//WebDriver driver;
	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
	}

	// locator
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement Searchtxtbox;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;
	
	// ActionMethod

	public void clickMyAccount() {
		lnkMyAccount.click();
	}

	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clicklogin() {
		lnkLogin.click();
		}
	
	public void  setsearchbox(String search) {
		Searchtxtbox.sendKeys(search);
	}
	
	public void clickSearch() {
		btnSearch.click();
	}
}
