package com.shadow.util.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.shadow.system.dictionary.DateFormatEntry;

import ognl.DefaultTypeConverter;

/**
 * 日期转换器
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public class DateConverterUtil extends DefaultTypeConverter implements
		DateFormatEntry {

	private static final DateFormat[] ACCEPT_DATE_FORMATS = {
			new SimpleDateFormat(DEFAULT_FORMAT_NORMAL),
			new SimpleDateFormat(DEFAULT_FORMAT_EXT),
			new SimpleDateFormat(DD_MM_YYYY_HH_MM_SS_NORMAL),
			new SimpleDateFormat(DD_MM_YYYY_HH_MM_SS_EXT),
			new SimpleDateFormat(YYYY_MM_DD_NORMAL),
			new SimpleDateFormat(YYYY_MM_DD_EXT),
			new SimpleDateFormat(DD_MM_YYYY_NORMAL),
			new SimpleDateFormat(DD_MM_YYYY_EXT), }; // 支持转换的日期格式

	@SuppressWarnings("unchecked")
	@Override
	public Object convertValue(Map context, Object value, Class toType) {
		if (toType == Date.class) { // 浏览器向服务器提交时，进行String to Date的转换
			String dateString = null;
			String[] params = (String[]) value;
			dateString = params[0];// 获取日期的字符串
			for (DateFormat format : ACCEPT_DATE_FORMATS) {
				try {
					return format.parse(dateString);// 遍历日期支持格式，进行转换
				} catch (ParseException e) {
					e.printStackTrace();
					return null;
				}
			}
			return null;
		} else if (toType == Timestamp.class) { // 浏览器向服务器提交时，进行String to
			String dateString = null;
			String[] params = (String[]) value;
			dateString = params[0];// 获取日期的字符串
			try {
				return Timestamp.valueOf(dateString);// 遍历日期支持格式，进行转换
			} catch (IllegalArgumentException e) {
				return null;
			}
		} else if (toType == String.class) { // 服务器向浏览器输出时，进行Date to
			// String的类型转换
			Date date = (Date) value;
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);// 输出的格式是yyyy-MM-dd
		}
		return null;
	}

}
