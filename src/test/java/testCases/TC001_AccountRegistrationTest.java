package testCases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"regression","master"})
	public void verify_account_registration() throws InterruptedException {
//		try {
		
		logger.trace("***************Starting TC001_AccountRegistration**********************");
			HomePage hp = new HomePage(driver);
			
			logger.info("click on my account");
			hp.clickMyAccount();
			Thread.sleep(3000);
			hp.clickRegister();

			AccountRegistrationPage arp = new AccountRegistrationPage(driver);
			arp.setfirstname("john");
			arp.setlastname("mark");
			arp.setemail(RandomString() + "@gmail.com"); // random email
			arp.settelephone(Randomnumber());

			String password = RandomAlpha();
			arp.setpassword(password);
			arp.setconfirmpassword(password);

			arp.setprivatepolicy();
			Thread.sleep(2000);
			arp.clickcontinue();
//		System.out.println(arp.getconfirmationmsg());
			String msg = arp.getconfirmationmsg();
			AssertJUnit.assertEquals(msg, "Your Account Has Been Created!");
//		System.out.println(RandomString());
			System.out.println(RandomAlpha());
//		} catch (
//
//		Exception e) {
//			e.getMessage();
//		}
	}
}
