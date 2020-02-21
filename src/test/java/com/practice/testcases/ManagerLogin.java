package com.practice.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.practice.base.TestBase;

public class ManagerLogin extends TestBase{

	@Test
	public void ManagerLogin() throws IOException {
		click("bankBtn");
		verifyEquals("asdf", "vbcal");
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))), "Login Not Successful");
	}

}
