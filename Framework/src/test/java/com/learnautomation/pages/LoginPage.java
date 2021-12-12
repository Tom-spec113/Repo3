package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver ldriver) {

		driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtUsername")
	WebElement emailadress;
	@FindBy(id = "btnLogin")
	WebElement unamenextButton;
	@FindBy(id = "txtPassword")
	WebElement pwd;
	// @FindBy(id="passwordNext") WebElement pwdnxtbtn;

	// @FindBy(how=How.ID, using="txtUsername") WebElement emadd;
	// @FindBy(how=How.ID, using="btnLogin") WebElement unmnxtbtn;
	// @FindBy(how=How.ID, using="txtPassword") WebElement pswd;
	// @FindBy(how=How.ID, using="passwordNext") WebElement pswdnxtbtn;

	public String loginToCRM(String uname, String password) {

		emailadress.sendKeys(uname);
		pwd.sendKeys(password);

		unamenextButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return driver.getTitle();
	}

	public void getInnerHtmlForUname() {

		System.out.println(emailadress.getAttribute("innerHTML"));
	}
}
