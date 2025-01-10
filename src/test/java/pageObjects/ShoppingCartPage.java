package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

	//Constructor
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locator
	@FindBy(xpath="//span[normalize-space()='Checkout']")
	WebElement btnCheckout;
	
	//ActionMethods

	public void ClickbtnCheckout() {
		btnCheckout.click();
	}
}
