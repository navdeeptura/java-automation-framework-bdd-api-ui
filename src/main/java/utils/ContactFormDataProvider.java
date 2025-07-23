package utils;

import org.testng.annotations.DataProvider;

public class ContactFormDataProvider {
	
	@DataProvider(name = "ContactData")
	public Object[][] getContactData() {
		String fileName = PropertiesReader.get("contact.data.excel");
		String sheetName = PropertiesReader.get("sheet.name");
		return ExcelReaderUtil.readExcelData(fileName, sheetName);
	}
	
	

}
