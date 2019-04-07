package com.git.start.WebWordPress.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class CommonUtil {
	WebDriver driver;
	public CommonUtil(WebDriver driver2) {
		this.driver= driver2;		
	}
	
	public String screenshots(String name)
	{
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");  
		System.out.println(formatter.format(date)); 
		
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") +"\\Screens\\"+name+""+formatter.format(date)+".png";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	public String[] readExcelFile() {
		File f = new File("Resource/dataWordPress.xlsx");
		XSSFWorkbook excel = null;
		FileInputStream fis = null;
		String[] myvalue = null;
		try {
			fis = new FileInputStream(f);

			excel = new XSSFWorkbook(fis);
			XSSFSheet sheet = excel.getSheet("wordpress");

			myvalue=new String[2];
			myvalue[0]=sheet.getRow(1).getCell(0).getStringCellValue();;
			myvalue[1]=sheet.getRow(1).getCell(1).getStringCellValue();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				excel.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return myvalue;
	}
}
