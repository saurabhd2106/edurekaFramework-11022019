package demo;

import commonLibs.utils.ExcelDriver;

public class DemoExcelDriver {

	public static void main(String[] args) throws Exception {
		ExcelDriver excelDriver = new ExcelDriver();

		String filename = System.getProperty("user.dir") + "/testOutputFile/testData.xlsx";
		
		String sheetname = "TestDataSheet";
		excelDriver.createWorkBook(filename);
		
		excelDriver.openWorkbook(filename);
		
		excelDriver.createSheet(sheetname);

		excelDriver.setCellData(sheetname, 0, 0, "Saurabh");
		excelDriver.setCellData(sheetname, 0, 1, "Dhingra");
		excelDriver.setCellData(sheetname, 1, 0, "Rahul");
		excelDriver.setCellData(sheetname, 1, 1, "Yadav");
		
		excelDriver.saveFile();
		
		excelDriver.closeWorkbook();
	}

}
