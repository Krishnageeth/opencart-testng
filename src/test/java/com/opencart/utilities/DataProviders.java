package com.opencart.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	ExcelFileutility excelFileutility = null;

	@DataProvider(name = "getExcelData")
	public String[][] getExcelData() throws IOException {
		excelFileutility = new ExcelFileutility("excel.xlsx", "Sheet1");
		int totalRows = excelFileutility.getRowCount();
		int totalColumns = excelFileutility.getCellCount(totalRows);
		String getData[][] = new String[totalRows][totalColumns];
		for (int rowCount = 1; rowCount <= totalRows; rowCount++) {
			for (int cellCount = 0; cellCount < totalColumns; cellCount++) {
				getData[rowCount - 1][cellCount] = excelFileutility.getCellData(rowCount, cellCount);
			}
		}
		return getData;
	}
}
