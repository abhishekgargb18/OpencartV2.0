package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	// Constructor
	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Locator

	@FindBy(xpath = "//div[@class=\"caption\"]//a[.='MacBook']")
	WebElement mackbook;
	
	@FindBy(xpath ="(//span[contains(text(),'Add to Cart')])[2]")
	WebElement Addtocart;
	
	@FindBy(xpath="//span[normalize-space()='Shopping Cart']")
	WebElement lnkShoppingcart;
	
	
	// Action Methods

	public boolean ismackbookExists() {
		try {
			return(mackbook.isDisplayed());
		}catch(Exception e) {
			return(false);
		}
	}
	
	public void ClickAddtocart() {
		Addtocart.click();
	}
	
	public void ClickShoppingCart() {
		lnkShoppingcart .click();
	}
	
	
	
	
	
}
