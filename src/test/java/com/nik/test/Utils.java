package com.nik.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {

	String excelPath = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx";
	XSSFWorkbook workbook;


	public  String getScreenshot(WebDriver driver, String screenshotName) throws Exception {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/TestsScreenshots/" + screenshotName + dateName + ".jpg";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;

	}

public  String getValeFromExcel(int row, int col) throws IOException {
	workbook=new XSSFWorkbook(excelPath);
	XSSFSheet sheet= workbook.getSheetAt(0);
	XSSFRow setrow=sheet.getRow(row);
	XSSFCell setcell=setrow.getCell(col);
	String value=setcell.getStringCellValue();
	return value;	
}

}