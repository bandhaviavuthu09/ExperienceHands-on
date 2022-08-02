//package com.bestbuyapiplayground.utils;
//
//import java.io.FileInputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.junit.Test;
//
//public class ReadExcelData {
//
//	@Test
//	public Map<String,String> getTestData()
//	{
//		try {
//			
//		Map<String,String> TestData=new HashMap<String,String>();
//		FileInputStream fs = new FileInputStream("C:\\Users\\002OER744\\Desktop\\ExperiencedLevelHandsOn\\BestBuyAPIPlayground\\src\\test\\resources\\TestData.xlsx");
//		//Creating a workbook
//		XSSFWorkbook workbook = new XSSFWorkbook(fs);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//		System.out.println(sheet.getRow(0).getCell(0));
//		Row row1 = sheet.getRow(1);
//		Cell cell1 = row1.getCell(1);
//		System.out.println(sheet.getRow(0).getCell(1));
//		Row row2 = sheet.getRow(1);
//		Cell cell2 = row2.getCell(1);
//		System.out.println(sheet.getRow(1).getCell(0));
//		Row row3 = sheet.getRow(1);
//		Cell cell3 = row3.getCell(1);
//		System.out.println(sheet.getRow(1).getCell(1));
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
//		return null;
//		
//	}
//	
//		
//	
//}
