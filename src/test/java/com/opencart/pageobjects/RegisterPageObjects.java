package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageObjects extends BasePage {
	private String firstName = BasePage.randomString(7);
	private String lastName = BasePage.randomString(9);
	private String email = firstName + "." + lastName + "@gmail.com";
	private String password = BasePage.randomString(8);

	public RegisterPageObjects(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement inputFirstName;

	@FindBy(id = "input-lastname")
	private WebElement inputLastName;

	@FindBy(id = "input-email")
	private WebElement inputEmail;

	@FindBy(id = "input-password")
	private WebElement inputPassword;

	@FindBy(id = "input-newsletter")
	private WebElement cbNewsLetter;

	@FindBy(name = "agree")
	private WebElement cbPrivacyPolicy;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	private WebElement btnContinue;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	private WebElement txtAccountCreated;

	public void enterFirstName() {
		inputFirstName.sendKeys(firstName);
	}

	public void enterLastName() {
		inputLastName.sendKeys(lastName);
	}

	public void enterEmail() {
		inputEmail.sendKeys(email);
		fileUtility.setProperty("email", email);
	}

	public void enterPassword() {
		inputPassword.sendKeys(password);
		fileUtility.setProperty("password", password);
	}

	public void clickOnPrivacyPolicy() {
		clickUsingJavascriptExecutor(cbPrivacyPolicy);
	}

	public void clickOnContinue() {
		clickUsingJavascriptExecutor(btnContinue);
	}

	public String getConfirmationMessage() {
		return txtAccountCreated.getText();
	}
}
