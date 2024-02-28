package com.utilities

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration


public class readcell {
	@Keyword
	public getcellvalue (int row_position, int cell_position) throws IOException {
		String path = RunConfiguration.getProjectDir()
		FileInputStream fis = new FileInputStream(path + '\\External Test Data\\demo_test_data.xlsx')
		XSSFWorkbook workbook = new XSSFWorkbook(fis)
		XSSFSheet sheet = workbook.getSheet('credentials')
		String cellvalue = sheet.getRow(row_position).getCell(cell_position).getStringCellValue()
		return cellvalue
	}
}
