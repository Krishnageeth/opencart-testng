package com.opencart.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileutility {
	private FileInputStream fileInputStream = null;
	private HSSFWorkbook hssfWorkbook = null;
	private HSSFSheet hssfSheet = null;
	private HSSFRow hssfRow = null;
	private HSSFCell hssfCell = null;
	private XSSFWorkbook xssfWorkbook = null;
	private XSSFSheet xssfSheet = null;
	private XSSFRow xssfRow = null;
	private XSSFCell xssfCell = null;
	private String fileName;
	private String sheetName;

	public ExcelFileutility(String fileName, String sheetName) {
		this.fileName = System.getProperty("user.dir") + "\\testData\\" + fileName;
		this.sheetName = sheetName;

	}

	public int getRowCount() throws IOException {
		int rowCount = 0;
		if (fileName.substring(fileName.lastIndexOf(".") + 1).equalsIgnoreCase("xls")) {
			fileInputStream = new FileInputStream(fileName);
			hssfWorkbook = new HSSFWorkbook(fileInputStream);
			hssfSheet = hssfWorkbook.getSheet(sheetName);
			rowCount = hssfSheet.getLastRowNum();
			hssfWorkbook.close();

		} else {
			fileInputStream = new FileInputStream(fileName);
			xssfWorkbook = new XSSFWorkbook(fileInputStream);
			xssfSheet = xssfWorkbook.getSheet(sheetName);
			rowCount = xssfSheet.getLastRowNum();
			xssfWorkbook.close();
		}
		fileInputStream.close();
		return rowCount;
	}

	public int getCellCount(int row) throws IOException {
		int cellCount = 0;
		if (fileName.substring(fileName.lastIndexOf(".") + 1).equalsIgnoreCase("xls")) {
			fileInputStream = new FileInputStream(fileName);
			hssfWorkbook = new HSSFWorkbook(fileInputStream);
			hssfSheet = hssfWorkbook.getSheet(sheetName);
			hssfRow = hssfSheet.getRow(row);
			cellCount = hssfRow.getLastCellNum();
			hssfWorkbook.close();
		} else {
			fileInputStream = new FileInputStream(fileName);
			xssfWorkbook = new XSSFWorkbook(fileInputStream);
			xssfSheet = xssfWorkbook.getSheet(sheetName);
			xssfRow = xssfSheet.getRow(row);
			cellCount = xssfRow.getLastCellNum();
			xssfWorkbook.close();
		}
		fileInputStream.close();
		return cellCount;
	}

	public String getCellData(int rowNum, int cellNum) throws IOException {
		String getData = null;
		if (fileName.substring(fileName.lastIndexOf(".") + 1).equalsIgnoreCase("xls")) {
			fileInputStream = new FileInputStream(fileName);
			hssfWorkbook = new HSSFWorkbook(fileInputStream);
			hssfSheet = hssfWorkbook.getSheet(sheetName);
			hssfRow = hssfSheet.getRow(rowNum);
			hssfCell = hssfRow.getCell(cellNum);
			DataFormatter dataFormatter = new DataFormatter();
			try {
				getData = dataFormatter.formatCellValue(hssfCell);
			} catch (Exception e) {
				getData = "";
			}
			hssfWorkbook.close();
		} else {
			fileInputStream = new FileInputStream(fileName);
			xssfWorkbook = new XSSFWorkbook(fileInputStream);
			xssfSheet = xssfWorkbook.getSheet(sheetName);
			xssfRow = xssfSheet.getRow(rowNum);
			xssfCell = xssfRow.getCell(cellNum);
			DataFormatter dataFormatter = new DataFormatter();
			try {
				getData = dataFormatter.formatCellValue(xssfCell);
			} catch (Exception e) {
				getData = "";
			}
			xssfWorkbook.close();
		}
		fileInputStream.close();
		return getData;
	}
}
