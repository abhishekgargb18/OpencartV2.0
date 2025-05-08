package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
 * Data is valid  -- login success - test pass --- logout
 * Data is valid --  login failed -- test failed 
 * 
 * Data is invalid --- login success -- test failed -- logout
 * Data is invalid ---- login failed ---- test pass 
 */
public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class , groups="datadriven") // getting data provider from different
																				// class
	public void verify_loginDDT(String email, String pwd, String exp) {
		logger.info("*********starting TC003_LoginDDT********************");
		try {
			// home page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clicklogin();

			// login page
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			// AyAccountPage
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetpage = map.isMyAccountPageExists();

//		Assert.assertEquals(targetpage, true , "login failed");
//		
//		Thread.sleep(2000);
//		
//		map.ClickLogout();

			if (exp.equalsIgnoreCase("valid")) {
				if (targetpage == true) {
					map.ClickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("invalid")) {
				if (targetpage == true) {
					map.ClickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
            logger.error("Exception occurred: " + e.getMessage());
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }

		logger.info("*********finishing TC003_LoginDDT********************");

	}

}
