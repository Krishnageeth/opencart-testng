package com.opencart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.baseclass.BaseClass;
import com.opencart.pageobjects.LoginPageObjects;
import com.opencart.pageobjects.MyAccountPageObjects;
import com.opencart.utilities.DataProviders;

public class TCLogin extends BaseClass {

	@Test(dataProvider = "getExcelData", dataProviderClass = DataProviders.class)
	public void tcLogin(String email, String password) {
		try {
			logger.info("***** TC Login Begins *****");
			MyAccountPageObjects myAccountPageObjects = new MyAccountPageObjects(driver);
			myAccountPageObjects.clickOnMyAccountDropdown();
			logger.info("***** Clicked on My Account dropdown *****");
			myAccountPageObjects.loginLink();
			logger.info("***** Clicked on login link *****");
			LoginPageObjects loginPageObjects = new LoginPageObjects(driver);
			loginPageObjects.enterEmailAddress(email);
			logger.info("***** Entered email address *****");
			loginPageObjects.enterPassword(password);
			logger.info("***** Entered password *****");
			loginPageObjects.clickOnLoginButton();
			logger.info("***** Clicked on login button *****");
			Assert.assertEquals(myAccountPageObjects.getTxtMyAccount(), "My Account");
			logger.info("***** Verifying the My account page is displayed or not *****");
			myAccountPageObjects.clickOnMyAccountDropdown();
			myAccountPageObjects.logoutLink();
			Assert.assertEquals(myAccountPageObjects.getTxtAccountLogout(), "Account Logout");
			logger.info("***** Clicked on logout button *****");
			logger.info("***** TC Login Ends *****");
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
