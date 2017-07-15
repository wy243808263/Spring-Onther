package com.shadow.util.common;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class JxlUtilImpl implements JxlUtil {

	public Sheet getSheet(Workbook workbook, int index) {
		return workbook.getSheet(index);
	}

	public Workbook getWorkbook(String filePath) {
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(filePath));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}

	public Cell getCell(Sheet sheet, int i, int j) {
		return sheet.getCell(i, j);
	}

}
