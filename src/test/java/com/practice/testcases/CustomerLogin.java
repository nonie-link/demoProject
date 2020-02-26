package com.practice.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.practice.utilities.TestUtil;

public class CustomerLogin extends TestBase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void customerLogin(Hashtable<String,String> ht) throws InterruptedException {
		
		click("cusBtn");
		select("custDrop", ht.get("Name"));
		click("loginBtn");
		Thread.sleep(5000);
	}

}
