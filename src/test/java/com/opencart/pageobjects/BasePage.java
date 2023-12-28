package com.opencart.pageobjects;

import java.io.File;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.opencart.baseclass.BaseClass;

public class BasePage extends BaseClass {
	private static Random random = null;
	private static JavascriptExecutor javascriptExecutor = null;
	private static TakesScreenshot takesScreenshot = null;

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static String randomString(int count) {
		random = new Random();
		String alphaNum = "abcdefghijklmnopqrstuvwxyz0123456789";
		StringBuffer randomString = new StringBuffer();
		while (randomString.length() != count) {
			int randomNumber = (int) Math.abs(Math.round(random.nextDouble() * 100));
			if (randomNumber < 36) {
				char character = alphaNum.charAt(randomNumber);
				randomString.append(character);
			}
		}
		return randomString.toString();

	}

	public static String getScreenshot() {
		takesScreenshot = (TakesScreenshot) driver;
		File sourcePath = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir") + "\\screenshots\\" + sourcePath.getName();
		try {
			FileUtils.copyFile(sourcePath, new File(destPath));
		} catch (Exception e) {
			e.getMessage();
		}
		return destPath;
	}

	public static void clickUsingJavascriptExecutor(WebElement webElement) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", webElement);
	}

}
