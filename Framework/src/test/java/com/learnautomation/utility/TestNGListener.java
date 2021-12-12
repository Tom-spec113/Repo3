package com.learnautomation.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

	public void onTestFailure(ITestResult result) {

		System.out.println("Test is failed. This Test name is " + result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is skipped. This Test name is " + result.getName());

	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test is now started. Test name is " + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test got passed. Test name is " + result.getName());

	}
}
