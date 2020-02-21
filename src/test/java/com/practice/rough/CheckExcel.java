package com.practice.rough;

import java.io.IOException;

import com.practice.utilities.ExcelManager;

public class CheckExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        Object [][] data = new Object[1][3];
		ExcelManager em = new ExcelManager(System.getProperty("user.dir") + "\\src\\test\\resources\\excelsheets\\testdata.xlsx");
		em.getSheetName("addCustomerTest");
		System.out.println(em.getRows());
		System.out.println(em.getCols());
		for(int i = 1; i <=em.getRows(); i++) {
		   for(int j = 0; j < 3; j++) {
			   data [i-1][j] = em.readData(i,j);
	}
}
	}
}
