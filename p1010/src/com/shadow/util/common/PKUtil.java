package com.shadow.util.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 主键切割实现类
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public class PKUtil {

	/**
	 * 分割字符串为ID
	 * 
	 * @param string
	 * @return List<Integer>
	 */
	public List<Integer> toArray(String string) {
		return handleString2Array(string, ",");
	}

	/**
	 * 分割字符串为ID
	 * 
	 * @param array
	 * @param regex
	 * @return List<Integer>
	 */
	public List<Integer> toArray(String string, String regex) {
		return handleString2Array(string, regex);
	}

	private List<Integer> handleString2Array(String array, String regex) {
		List<Integer> list = new ArrayList<Integer>();
		String[] strings = StringUtils.split(array, regex);
		for (int i = 0, len = strings.length; i < len; i++)
			list.add(Integer.valueOf(strings[i]));
		return list;
	}

}
