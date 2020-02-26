package com.practice.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.practice.utilities.TestUtil;

public class CustomListeners implements ITestListener{
	

	@Override
	public void onTestSuccess(ITestResult result) {
		
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("This test has successfully run");
		Reporter.log("<a href = " + System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + TestUtil.screenshotName + ">Click Here</a>");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

}
