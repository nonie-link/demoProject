package com.practice.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
	
	private XSSFWorkbook workbook;
	private File file;
	private FileInputStream fis;
	private FileOutputStream fos;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	
	 public ExcelManager(String file) throws IOException {
		  this.file = new File(file);
		  fis = new FileInputStream(file);
		  workbook = new XSSFWorkbook(fis);
		  
	  }
	   
	  public void getSheetName(String sheetName) {
		   sheet = workbook.getSheet(sheetName);
	   }
	  
	  public int getRows() {
		  return sheet.getLastRowNum();
	  }
	  
	  public int getCols() {
		  return sheet.getRow(0).getPhysicalNumberOfCells();
	  }
	  
	  public String readData(int row, int col) {
		  this.row = sheet.getRow(row);
		  cell = this.row.getCell(col);
		  
		  switch(cell.getCellType()) {
		  
		  case BLANK:
			   break;
		  case STRING:
			  return cell.getStringCellValue();
		  case NUMERIC:
			  return String.valueOf(cell.getNumericCellValue());
		 default:
			 break;
		 }	 
			  
	   return null;	  
	   
	}
		  
	  }

