package com.learnautomation.testcases;

import org.testng.annotations.Test;

public class TestInvocationCount {
	
@Test(invocationCount=10)
protected void testInvocationCount() {
	
	System.out.println("Execute this test 10 times");
	
}
	
	

}
