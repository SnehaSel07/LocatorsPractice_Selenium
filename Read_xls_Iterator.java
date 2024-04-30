package apachiPOI_xls;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_xls_Iterator {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String excelFilePath = ".\\dataFiles\\seleniumData.xlsx";
		FileInputStream fileInput = new FileInputStream(excelFilePath);

		// Workbook --> Sheet --> Rows --> Cell
		XSSFWorkbook newWorkBook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet1 = newWorkBook.getSheetAt(0);

		Iterator iter = sheet1.iterator();
		while (iter.hasNext()) {

			XSSFRow rows = (XSSFRow) iter.next();
			Iterator cellIter = rows.cellIterator();

			while (cellIter.hasNext()) {
				XSSFCell cell = (XSSFCell) cellIter.next();
				switch (cell.getCellType()) {
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;

				}
				System.out.print("  | ");
			}
			System.out.println();
		}

	}
}
