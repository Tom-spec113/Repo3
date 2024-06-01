package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider(){

		try {
		File f = new File("./TestData/Book1.xlsx");
		FileInputStream fs = new FileInputStream(f);
		wb = new XSSFWorkbook(fs);
		System.out.println("Excel workbook object initialized");
		}
		catch(IOException e) {

			e.printStackTrace();

		}

	}
	

	public String getStringData(int sn, int row, int col) {

		return wb.getSheetAt(sn).getRow(row).getCell(col).getStringCellValue();

	}

	public double getNumericData(int sn, int row, int col) {
		
		return wb.getSheetAt(sn).getRow(row).getCell(col).getNumericCellValue();
	}
	

}
