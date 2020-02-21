package com.practice.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.practice.base.TestBase;


public class TestUtil extends TestBase{

	public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = d.toString().replace(" ", "_").replace(":", "_") + ".jpg";
		FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
	}

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) throws IOException {

		String sheetName = m.getName().toString();
		ExcelManager em = new ExcelManager(System.getProperty("user.dir") + "\\src\\test\\resources\\excelsheets\\testdata.xlsx");
		em.getSheetName(sheetName);
		int rows = em.getRows();
		int cols = em.getCols();

		Object [][] data = new Object[rows][1];

		Hashtable<String,String> ht = null;

		for(int i = 1; i <= rows; i++) {
			ht = new Hashtable<String,String>();
			for(int j = 0; j < cols; j++) {
				ht.put(em.readData(0, j), em.readData(i,j));
				data[i-1][0] = ht;
			}
			
		}

		return data;


	}

}
