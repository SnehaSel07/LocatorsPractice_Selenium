package apachiPOI_xls;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_xls_forLoop {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// Workbook --> Sheet --> Rows --> Cell
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet2 = book.createSheet();

		Object sheetData[][] = { { "Course_id", "Name", "Price" }, { "111", "Java", "4800" },
				{ "112", "React.js", "6700" }, { "113", "FullStack QA", "10200" },
				{ "114", "FullStack Developer", "12000" } };

		int rows = sheetData.length;
		int cols = sheetData[0].length;

		for (int r = 0; r < rows; r++) {
			XSSFRow row = sheet2.createRow(r);

			for (int c = 0; c < cols; c++) {
				XSSFCell cell = row.createCell(c);
				Object value = sheetData[r][c];

				if (value instanceof String)
					cell.setCellValue((String) value);
				else if (value instanceof Double)
					cell.setCellValue((Double) Double.parseDouble((String) value));
				else if (value instanceof Boolean)
					cell.setCellValue((Boolean) value);
			}
		}

		String filePath = ".\\dataFiles\\course.xlsx";
		FileOutputStream output = new FileOutputStream(filePath);
		book.write(output);
		output.close();

		System.out.println("Created");
	}
}
