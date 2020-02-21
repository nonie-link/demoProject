package com.practice.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.practice.utilities.TestUtil;

public class AddCustomerTest extends TestBase {
	
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void addCustomerTest(Hashtable<String,String> data) {
		click("addCustBtn");
		type("fName", data.get("firstname"));
		type("lName", data.get("lastname"));
		type("pCode", data.get("postcode"));
		driver.findElement(By.cssSelector(OR.getProperty("addBtn"))).submit();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
		alert.accept();
		
		
		
		
		
	}
	
	

}
