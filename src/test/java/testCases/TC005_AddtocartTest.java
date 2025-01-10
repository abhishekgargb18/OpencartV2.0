package testCases;

import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_AddtocartTest extends BaseClass{
	
	@Test
	public void TestCart() throws InterruptedException {
		
		SearchPage sp = new SearchPage(driver);
		sp.ClickAddtocart();
		Thread.sleep(3000);
		sp.ClickShoppingCart();
	}

}
