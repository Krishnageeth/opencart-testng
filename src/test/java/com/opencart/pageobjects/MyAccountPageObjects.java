package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageObjects extends BasePage {

	public MyAccountPageObjects(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement ddMyAccount;

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement linkLogin;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement linkLogout;

	@FindBy(xpath = "//h2[text()='My Account']")
	private WebElement txtMyAccount;

	@FindBy(xpath = "//h1[text()='Account Logout']")
	private WebElement txtAccountLogout;

	public String getTxtMyAccount() {
		return txtMyAccount.getText();
	}

	public void clickOnMyAccountDropdown() {
		ddMyAccount.click();
	}

	public void logoutLink() {
		linkLogout.click();
	}

	public void loginLink() {
		linkLogin.click();
	}

	public String getTxtAccountLogout() {
		return txtAccountLogout.getText();
	}
}
