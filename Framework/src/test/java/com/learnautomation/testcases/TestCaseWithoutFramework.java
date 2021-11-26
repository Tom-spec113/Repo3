package com.learnautomation.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCaseWithoutFramework {
	
	@Test
	public void test1() throws InterruptedException
	{
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://freecrm.com/");
		

		
		driver.findElement(By.name("username")).sendKeys("Test");
		driver.findElement(By.name("password")).sendKeys("Test");
		
		driver.findElement(By.id("identifierId")).sendKeys("rkcc1010");
	}
	
	
	
	

}
