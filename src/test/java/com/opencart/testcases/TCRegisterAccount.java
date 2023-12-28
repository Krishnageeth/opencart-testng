package com.opencart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.baseclass.BaseClass;
import com.opencart.pageobjects.HomePageObjects;
import com.opencart.pageobjects.RegisterPageObjects;

public class TCRegisterAccount extends BaseClass {

	@Test()
	public void tcRegisterAccount() {
		logger.info("***** TC Register Account Begins *****");
		HomePageObjects homePageObjects = new HomePageObjects(driver);
		homePageObjects.clickOnMyAccountDropdown();
		logger.info("Clicked on my account dropdown");
		homePageObjects.clickOnRegisterLink();
		logger.info(" Clicked on register link");
		RegisterPageObjects registerPageObjects = new RegisterPageObjects(driver);
		registerPageObjects.enterFirstName();
		logger.info("Entered first name");
		registerPageObjects.enterLastName();
		logger.info("Entered last name");
		registerPageObjects.enterEmail();
		logger.info("Entered email");
		registerPageObjects.enterPassword();
		logger.info("Entered password");
		registerPageObjects.clickOnPrivacyPolicy();
		logger.info("Accepted privacy policy");
		registerPageObjects.clickOnContinue();
		logger.info("Clicked on continue button");
		String confirmMessage = registerPageObjects.getConfirmationMessage();
		Assert.assertEquals(confirmMessage, "Your Account Has Been Created!");
		logger.info("***** TC Login Ends *****");
	}
}
