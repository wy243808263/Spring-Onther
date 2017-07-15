package com.shadow.util.common;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinUtilImpl implements PinYinUtil {

	public String getAbbreviate(String word, boolean bool) {
		StringBuffer sb = new StringBuffer();
		String tempPinyin = null;
		for (int i = 0, len = word.length(); i < len; ++i) {
			tempPinyin = getCharacterPinYin(word.charAt(i));
			if (tempPinyin == null)
				sb.append(word.charAt(i));// 如果charAt(i)非汉字，则保持原样
			else {
				if (bool)
					tempPinyin = String.valueOf(tempPinyin.charAt(0))
							.toUpperCase().concat(tempPinyin.substring(1));
				sb.append(tempPinyin);
			}
		}
		return sb.toString();

	}

	public String getPinYin(String str, boolean bool) {
		String convert = "";
		for (int i = 0, len = str.length(); i < len; i++) {
			char word = str.charAt(i);
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if (pinyinArray != null)
				convert += pinyinArray[0].charAt(0);
			else
				convert += word;
		}
		if (bool)
			convert = convert.toUpperCase();
		return convert;
	}

	// 转换单个字符
	private String getCharacterPinYin(char c) {
		HanyuPinyinOutputFormat format = null;
		String[] pinyin;

		format = new HanyuPinyinOutputFormat();
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		pinyin = null;
		try {
			pinyin = PinyinHelper.toHanyuPinyinStringArray(c, format);
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
		// 如果c不是汉字，toHanyuPinyinStringArray会返回null
		if (pinyin == null)
			return null;
		// 只取一个发音，如果是多音字，仅取第一个发音
		return pinyin[0];
	}

}