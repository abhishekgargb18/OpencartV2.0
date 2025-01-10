package testCases;

import org.testng.annotations.Test;

import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC006_ShoppingCartTest extends BaseClass {
	
	@Test
	public void Checkout() throws InterruptedException {
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		scp.ClickbtnCheckout();
		Thread.sleep(2000);
	}

}
