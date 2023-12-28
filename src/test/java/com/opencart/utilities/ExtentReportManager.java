package com.opencart.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencart.pageobjects.BasePage;

public class ExtentReportManager implements ITestListener {

	private ExtentSparkReporter extentSparkReporter = null;
	private ExtentReports extentReports = null;
	private ExtentTest extentTest = null;
	private String reportName;

	@Override
	public void onStart(ITestContext iTestContext) {
		String simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		reportName = "open-cart_test_report_" + simpleDateFormat + ".html";
		extentSparkReporter = new ExtentSparkReporter(".\\reports\\" + reportName);
		extentSparkReporter.config().setDocumentTitle("Open-cart test report");
		extentSparkReporter.config().setReportName("Open-cart");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}

	private ExtentTest getTestName(ITestResult iTestResult) {
		extentTest = extentReports.createTest(iTestResult.getName());
		return extentTest;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		getTestName(result);
		extentTest.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(BasePage.getScreenshot()).build());
		extentTest.log(Status.PASS, result.getName() + " test passed!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		getTestName(result);
		extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(BasePage.getScreenshot()).build());
		extentTest.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		getTestName(result);
		extentTest.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		extentReports.flush();
	}
}
