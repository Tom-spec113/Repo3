package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UtilityMethods {
	
	XSSFWorkbook wb;
	
	XSSFSheet sh;
	
	@Test(dataProvider="testdata")
	public void test331(String v1, String v2)
	{
		System.out.println("column A value is "+ v1 +" column B value is "+ v2);
	}
	

	
	@DataProvider(name="testdata")
	public Object[][] readDataFromExcel() {
		
		try {
			
			File fl = new File("./TestData/Book1.xlsx");

			FileInputStream fis = new FileInputStream(fl);

			 wb = new XSSFWorkbook(fis);

			 sh = wb.getSheetAt(0);
			}
			catch (IOException e) {
				e.printStackTrace();
			}

			int rowCount = sh.getLastRowNum();

			int colCount = sh.getRow(0).getLastCellNum();
			
		//	System.out.println( colCount);

			Object[][] data = new Object[rowCount + 1][colCount];

			for (int i = 0; i <= rowCount; i++) {

				for (int j = 0; j < colCount; j++) {

					data[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
					
					System.out.println(data[i][j]);
					}
				}
			
			return data;

		}
		
	public static String captureScreenshot(WebDriver driver, String screenName) {
		
		String path;
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		path = System.getProperty("user.dir")+"/Screenshots/"+ screenName +getCurrentDateTime()+".png";
		try {
		File f = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f, new File(path));
		}
		catch(IOException e) {
			e.getStackTrace();
		}
		
		//System.out.println("Taken screenshot");
		return path;
	}
	
	public static String getCurrentDateTime() {
		
		DateFormat cf = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date d = new Date();
		
		return cf.format(d);
	}
	

	}


