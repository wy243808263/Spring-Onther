package com.shadow.util.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.arabidopsis.ahocorasick.AhoCorasick;
import org.arabidopsis.ahocorasick.SearchResult;

/**
 * AC多模匹配敏感字符工具类实现类
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public class AcUtilImpl implements AcUtil {

	public String contrast(String filters, String word, String regex) {
		AhoCorasick ac = getInstance();
		String[] strings = StringUtils.split(filters, regex);
		String val = null;
		for (int i = 0, len = strings.length; i < len; i++) {
			val = strings[i];
			ac.add(val.getBytes(), val);
		}
		return result(ac, word);
	}

	public String contrast(String[] filters, String word) {
		AhoCorasick ac = getInstance();
		String val = null;
		for (int i = 0, len = filters.length; i < len; i++) {
			val = filters[i];
			ac.add(val.getBytes(), val);
		}
		return result(ac, word);
	}

	public String contrast(List<String> filters, String word) {
		AhoCorasick ac = getInstance();
		String val = null;
		for (int i = 0, len = filters.size(); i < len; i++) {
			val = filters.get(i);
			ac.add(val.getBytes(), val);
		}
		return result(ac, word);
	}

	@Override
	public String contrast(Map<String, Object> filters, String word) {
		AhoCorasick ac = getInstance();
		String val = null;
		for (Map.Entry<String, Object> entry : filters.entrySet()) {
			val = entry.getKey();
			ac.add(val.getBytes(), val);
		}
		return result(ac, word);
	}

	/** 获取匹配结果 */
	private String result(AhoCorasick ac, String word) {
		ac.prepare(); // 预备状态
		Iterator<?> iterator = ac.search(word.getBytes());
		SearchResult result = null;
		StringBuffer buffer = new StringBuffer();
		while (iterator.hasNext()) {
			result = (SearchResult) iterator.next();
			buffer.append(result.getOutputs()).append(",");
		}
		return buffer.length() > 0 ? buffer.substring(0, buffer.length() - 1)
				: "";
	}

	/** 初始化实例对象 */
	private AhoCorasick getInstance() {
		return new AhoCorasick();
	}

	public static void main(String[] args) {

		String[] filters1 = { "情", "毛老大", "开心", "yo", "test" };
		String filters2 = "or,world,33,dd,test";
		String regex = ",";

		Map<String, Object> filters3 = new HashMap<String, Object>();
		filters3.put("搜索", null);
		filters3.put("老大", null);
		filters3.put("test", null);
		filters3.put("毛", null);

		String word = "hello world, how are you, 今天是是情人节,毛老大很开心!";

		String result1 = new AcUtilImpl().contrast(filters1, word);
		String result2 = new AcUtilImpl().contrast(filters2, word, regex);
		String result3 = new AcUtilImpl().contrast(filters3, word);

		System.out.println("测试结果1: " + result1);
		System.out.println("测试结果2: " + result2);
		System.out.println("测试结果3: " + result3);
	}

}
