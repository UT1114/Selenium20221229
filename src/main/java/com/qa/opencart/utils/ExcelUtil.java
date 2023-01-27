package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	private static final String EXCEL_TEST_DATA_SHEET_PATH = ".\\src\\test\\resources\\ExcelTestData\\OpenCartTestData.xlsx";
	private static FileInputStream fis;
	private static Workbook book;
	private static Sheet sheet;

	public static Object[][] readExcelData(String sheetName) {
		Object[][] data;
		try {
			fis = new FileInputStream(EXCEL_TEST_DATA_SHEET_PATH);
			book = WorkbookFactory.create(fis);
			sheet = book.getSheet(sheetName);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;

	}
	
	
	
	public static Object[][] readRowData(String sheetName, int Row_No) {
		Object[][] data;
		try {
			fis = new FileInputStream(EXCEL_TEST_DATA_SHEET_PATH);
			book = WorkbookFactory.create(fis);
			sheet = book.getSheet(sheetName);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(Row_No).getCell(j).toString();
			}
		}
		return data;

	}
	
	
	
	
	
	
	
	
	
	

}
