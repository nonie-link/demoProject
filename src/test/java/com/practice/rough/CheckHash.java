package com.practice.rough;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import com.practice.utilities.ExcelManager;

public class CheckHash {
/*
 * 
 * These are some comments that I have added to the class
 * Second Comments
 * 
 * 
 */
	public static void main(String[] args) throws IOException {

			String sheetName = "addCustomerTest";
			ExcelManager em = new ExcelManager(System.getProperty("user.dir") + "\\src\\test\\resources\\excelsheets\\testdata.xlsx");
			em.getSheetName(sheetName);
			int rows = em.getRows();
			int cols = em.getCols();
			
			System.out.println(rows + " " + cols);

			Object [][] data = new Object[rows][1];

			Hashtable<String,String> ht = null;

			for(int i = 1; i <= rows; i++) {
				ht = new Hashtable<String,String>();
				for(int j = 0; j < cols; j++) {
					ht.put(em.readData(0, j), em.readData(i,j));
					data[i-1][0] = ht;
				}
				
			}
			
			System.out.println(data[0][0]);

			


		}
		
		

	}

