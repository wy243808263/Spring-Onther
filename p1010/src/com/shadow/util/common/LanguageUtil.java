package com.shadow.util.common;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.shadow.system.dictionary.Language;
import com.shadow.util.base.Utils;

@SuppressWarnings("serial")
public class LanguageUtil extends ActionSupport implements Language {

	protected static final Logger logger = Logger.getLogger(LanguageUtil.class);

	@Override
	public Locale getLocale(String language) {
		if (language.equals(ENGLISH)) {
			return Locale.ENGLISH;
		}
		if (language.equals(FRENCH)) {
			return Locale.FRENCH;
		}
		if (language.equals(GERMAN)) {
			return Locale.GERMAN;
		}
		if (language.equals(ITALIAN)) {
			return Locale.ITALIAN;
		}
		if (language.equals(JAPANESE)) {
			return Locale.JAPANESE;
		}
		if (language.equals(KOREAN)) {
			return Locale.KOREAN;
		}
		if (language.equals(CHINESE)) {
			return Locale.CHINESE;
		}
		if (language.equals(SIMPLIFIED_CHINESE)) {
			return Locale.SIMPLIFIED_CHINESE;
		}
		if (language.equals(TRADITIONAL_CHINESE)) {
			return Locale.TRADITIONAL_CHINESE;
		}
		if (language.equals(FRANCE)) {
			return Locale.FRANCE;
		}
		if (language.equals(GERMANY)) {
			return Locale.GERMANY;
		}
		if (language.equals(ITALY)) {
			return Locale.ITALY;
		}
		if (language.equals(JAPAN)) {
			return Locale.JAPAN;
		}
		if (language.equals(KOREA)) {
			return Locale.KOREA;
		}
		if (language.equals(CHINA)) {
			return Locale.CHINA;
		}
		if (language.equals(PRC)) {
			return Locale.PRC;
		}
		if (language.equals(TAIWAN)) {
			return Locale.TAIWAN;
		}
		if (language.equals(UK)) {
			return Locale.UK;
		}
		if (language.equals(US)) {
			return Locale.US;
		}
		if (language.equals(CANADA)) {
			return Locale.CANADA;
		}
		if (language.equals(CANADA_FRENCH)) {
			return Locale.CANADA_FRENCH;
		}
		// 默认返回
		return Locale.CHINESE;
	}

	/**
	 * 获取全局多语言参数
	 * 
	 * @param path
	 * @return Map<String, Object>
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getTextParams(String path) {
		Properties pop = Utils.FileUtil.readProperties(path);
		Map<String, Object> params = new HashMap<String, Object>();
		if (pop != null) {
			params = new HashMap<String, Object>((Map) pop);
		}
		if (params.isEmpty())
			logger.info("初始化默认国际化语言失败,请检查配置文件是否正确...");
		else
			logger.info("初始化默认国际化语言成功...");
		return params;
	}

	@Override
	public Map<String, Object> getParamValues(Map<String, Object> params) {
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			params.put(key, getValue(key));
		}
		return params;
	}

	@Override
	public String getValue(String key) {
		return getText(key);
	}

}
