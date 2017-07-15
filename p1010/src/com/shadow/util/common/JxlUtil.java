package com.shadow.util.common;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public interface JxlUtil {

	/**
	 * 获取文件
	 * @param filePath
	 * @return Workbook
	 */
	public Workbook getWorkbook(String filePath);

	/**
	 * 获取工作表
	 * @param index
	 * @return Sheet
	 */
	public Sheet getSheet(Workbook workbook, int index);

	/**
	 * 获取单元格
	 * @param sheet
	 * @param i
	 * @param j
	 * @return Cell
	 */
	public Cell getCell(Sheet sheet, int i, int j);
}
