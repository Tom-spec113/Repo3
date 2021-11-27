package com.learnautomation.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test failed. Test name is "+ result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped. Test name is "+ result.getName());

	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test started. Test name is "+ result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed. Test name is "+ result.getName());

	}
}
