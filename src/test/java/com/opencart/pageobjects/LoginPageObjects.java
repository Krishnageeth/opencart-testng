package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects extends BasePage {

	public LoginPageObjects(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-email")
	private WebElement inputEmail;

	@FindBy(id = "input-password")
	private WebElement inputPassword;

	@FindBy(xpath = "//a[normalize-space()='Forgotten Password']")
	private WebElement linkForgotPassword;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement btnLogin;

	public void enterEmailAddress(String email) {
		inputEmail.sendKeys(email);
	}

	public void enterPassword(String password) {
		inputPassword.sendKeys(password);
	}

	public void clickOnLoginButton() {
		btnLogin.click();
	}
}
