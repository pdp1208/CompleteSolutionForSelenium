package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestDataFromExcel {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static String ProjectPath;

	@DataProvider(name = "TestData")
	public static Object[][] ExcelFetchData(String fileName, String sheetname, String TestCase) {
		ProjectPath = System.getProperty("user.dir");
		String ExcelPath = ProjectPath + "\\src\\test\\java\\TestDataFromExcel\\" + fileName + ".xlsx";

		try {
			FileInputStream is = new FileInputStream(ExcelPath);
			workbook = new XSSFWorkbook(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int testCaselineNo = 0;
		
		for (int i = 0; i < rowCount; i++) {
			String cellValue = sheet.getRow(i).getCell(0).getStringCellValue();
			if (TestCase.equals(cellValue)) {
				testCaselineNo++;
				System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
			}
		}
		System.out.println(testCaselineNo);
		int columnCount = sheet.getRow(testCaselineNo).getLastCellNum();
		Object[][] data = new Object[testCaselineNo][columnCount - 1];
		for (int j = 1; j < columnCount; j++) {
			Cell cell = sheet.getRow(testCaselineNo).getCell(j);
			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				data[testCaselineNo - 1][j - 1] = String.valueOf(cell.getNumericCellValue());
			} else {
				data[testCaselineNo - 1][j - 1] = cell.getStringCellValue();
			}
		}
		return data;
	}
}