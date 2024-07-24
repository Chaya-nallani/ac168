package com.log4j;

import java.io.File;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class testExcel {

	public static void main(String[] args) throws Exception {
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("testSheet");
		sheet.createRow(0);
		sheet.getRow(0).createCell(0).setCellValue("Chaya");
		sheet.getRow(0).createCell(1).setCellValue("MS");
		
		sheet.createRow(1);
		sheet.getRow(1).createCell(0).setCellValue("Chaya");
		sheet.getRow(1).createCell(1).setCellValue("MS");
		
		File file = new File("C:\\Users\\Chaya\\eclipse-workspace_Chaya\\com.testNew\\src\\test\\resources\\excelTest.xls");
		
		workbook.write(file);
		workbook.close();							
		
	}
}
