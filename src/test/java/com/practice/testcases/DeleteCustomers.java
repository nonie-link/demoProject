package com.practice.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.practice.base.TestBase;
import com.practice.utilities.TestUtil;

public class DeleteCustomers extends TestBase{
	
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void deleteCustomers(Hashtable<String, String> searchName) throws InterruptedException {
		
		click("custTab");
		type("searchInput", searchName.get("Name"));
		click("deleteBtn");
		click("homeBtn");
		
		Thread.sleep(4000);
		
		
		
	}

}
