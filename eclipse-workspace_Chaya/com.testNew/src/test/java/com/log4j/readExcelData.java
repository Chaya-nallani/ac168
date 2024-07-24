package com.log4j;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcelData {
	
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\Chaya\\eclipse-workspace_Chaya\\com.testNew\\src\\test\\resources\\testExcel.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String value = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(value);
		workbook.close();
		fis.close();
	}

}
