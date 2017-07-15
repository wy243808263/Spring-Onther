package com.shadow.util.common;

public interface PinYinUtil {

	/**
	 * 获取所有词语首字母缩写(可控制大小写)
	 * @param word
	 * @param bool
	 * @return String
	 */
	public String getAbbreviate(String word, boolean bool);

	/**
	 * 中文转换成拼音(可控制首字母大小写)
	 * @param word
	 * @param bool
	 * @return String
	 */
	public String getPinYin(String word, boolean bool);
}
