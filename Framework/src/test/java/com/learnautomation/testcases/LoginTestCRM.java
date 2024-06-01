package com.learnautomation.testcases;

import java.io.IOException;
import org.testng.Assert;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;

import com.learnautomation.pages.LoginPage;

//@Listeners(com.learnautomation.utility.TestNGListener.class)
//@Test(singleThreaded = true)
public class LoginTestCRM extends BaseClass {

	protected LoginPage lp;

	/* Test 1 */
	@Test
	public void loginApp1() throws IOException {

		logger = er.createTest("loginApp1").assignCategory("Regression").assignAuthor("Mayuresh")
				.assignDevice("Windows");

		lp = new LoginPage(driver);
		logger.info("Application is started");
		String pt = lp.loginToCRM(edp.getStringData(0, 0, 0), edp.getStringData(0, 0, 1));
		Assert.assertEquals(pt, "OrangeHRM");

	}

	/* Test 2 */
	@Test
	public void chckPageTitle() {

		logger = er.createTest("chckPageTitle").assignCategory("Regression").assignAuthor("Mayuresh")
				.assignDevice("Windows");

		lp = new LoginPage(driver);
		lp.getInnerHtmlForUname();

	}

}
