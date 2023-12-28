package com.opencart.baseclass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.opencart.utilities.FileUtility;

public class BaseClass {
	protected static WebDriver driver = null;
	protected Logger logger = null;
	protected static FileUtility fileUtility = null;

	@Parameters("browserName")
	@BeforeClass
	public void setUp(String browserName) throws FileNotFoundException, IOException {
		fileUtility = new FileUtility();
		logger = (Logger) LogManager.getLogger(this.getClass());
		logger.info("***** Driver Initiation *****");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.get(fileUtility.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		logger.info("***** Driver Closure *****");
	}
}
