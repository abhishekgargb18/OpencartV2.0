package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups ={"sanity","master"})
	public void verify_login() {
		logger.info("*********Starting*********");
		
		try {
		//home page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clicklogin();
		
		//loginpage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		Thread.sleep(5000);
		
		//AyAccountPage
		MyAccountPage map = new MyAccountPage(driver);
		boolean targetpage = map.isMyAccountPageExists();
		
		Assert.assertEquals(targetpage, true , "login failed");
		
		Thread.sleep(5000);
		
		map.ClickLogout();
		
		}catch(Exception e) {
			Assert.fail();
		}
		
	
		logger.info("*********Finish test******************");
	}
	
	
	

}
