package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage {
	WebDriver driver;

	// Constructor
	public AccountRegistrationPage(WebDriver driver) {
//		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locator
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtfirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtlastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txttelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtconfirmpassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkdpolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btncontinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	// ActionMethods
	public void setfirstname(String fname) {
		txtfirstname.sendKeys(fname);
	}

	public void setlastname(String lname) {
		txtlastname.sendKeys(lname);
	}

	public void setemail(String email) {
		txtemail.sendKeys(email);
	}

	public void settelephone(String tele) {
		txttelephone.sendKeys(tele);
	}

	public void setpassword(String pass) {
		txtpassword.sendKeys(pass);
	}

	public void setconfirmpassword(String pass) {
		txtconfirmpassword.sendKeys(pass);
	}

	public void setprivatepolicy() {
		chkdpolicy.click();
	}

	public void clickcontinue() {
		// sol 1
		btncontinue.click();

		// sol 2
//			btncontinue.submit();

//			sol 3
//			Actions act = new Actions(driver);
//			act.moveToElement(btncontinue).click().perform();

//			sol 4
//			JavascriptExecutor js = (JavascriptExecutor)driver;
//			js.executeScript("argument[0].click();", btncontinue);

//			sol 5
//			btncontinue.sendKeys(Keys.RETURN);

//			sol 6
//			WebDriverWait mywait = new WebDriverWait(driver , Duration.ofSeconds(10));
//			mywait.until(ExpectedConditions.elementToBeClickable(btncontinue)).click();

	}

	public String getconfirmationmsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}
}
