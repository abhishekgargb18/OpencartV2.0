package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass {

	@Test
	public void verify_productsearch() {
		try {
			HomePage hp = new HomePage(driver);
			hp.setsearchbox("mac");
			Thread.sleep(1000);
			hp.clickSearch();

			SearchPage sp = new SearchPage(driver);
			boolean target = sp.ismackbookExists();

			Assert.assertEquals(target, true, "login failed");

		} catch (Exception e) {
			Assert.fail();
		}
	}
}
