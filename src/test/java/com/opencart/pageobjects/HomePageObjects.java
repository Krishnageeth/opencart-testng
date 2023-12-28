package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects extends BasePage {

	public HomePageObjects(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement ddMyAccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	private WebElement linkRegister;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement linkLogin;

	public void clickOnMyAccountDropdown() {
		ddMyAccount.click();
	}

	public void clickOnRegisterLink() {
		linkRegister.click();
	}
}
