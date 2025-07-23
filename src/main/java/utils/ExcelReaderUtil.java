package utils;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtil {
	
	public static Object[][] readExcelData(String fileName, String sheetName){
				
		try (
				FileInputStream fis = new FileInputStream(fileName);
				Workbook workbook = new XSSFWorkbook(fis);
				) 
		{	
			Sheet sheet = workbook.getSheet(sheetName);
			int rows = sheet.getPhysicalNumberOfRows();
			int columns = sheet.getRow(0).getPhysicalNumberOfCells();
			
			Object[][] data = new Object[rows - 1][columns];
			
			for (int i = 1; i < rows; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < columns; j ++) {
					Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					data[i-1][j] = getCellValue(cell);
				}
			}
			
			return data;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Fail to laod excel file " + e.getMessage());
		}
	}
	
	private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue();
            case BOOLEAN: return cell.getBooleanCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getLocalDateTimeCellValue().toLocalDate();
                }
                return cell.getNumericCellValue();
            case FORMULA: return cell.getCellFormula();
            case BLANK: return "";
            default: return "";
        }
	}
}
