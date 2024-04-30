package apachiPOI_xls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_xls_forLoop {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String excelFilePath = ".\\dataFiles\\seleniumData.xlsx";
		FileInputStream fileInput = new FileInputStream(excelFilePath);
		// Workbook --> Sheet --> Rows --> Cell
		XSSFWorkbook newWorkBook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet1 = newWorkBook.getSheetAt(0);

		// using for loop
		int rows = sheet1.getLastRowNum();
		int columns = sheet1.getRow(1).getLastCellNum();

		for (int r = 0; r <= rows; r++) {
			XSSFRow rw = sheet1.getRow(r);

			for (int c = 0; c < columns; c++) {

				XSSFCell cell = rw.getCell(c);

				switch (cell.getCellType()) {
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;

				/*
				 * case BOOLEAN: System.out.println(cell.getBooleanCellValue());
				 */

				}
				
				System.out.print("  |  ");

			}
			System.out.println();
		}
	}

}
