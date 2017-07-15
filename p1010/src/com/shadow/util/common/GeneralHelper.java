package com.shadow.util.common;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public class GeneralHelper {
	/** 简单数据类型集合 */
	public static final Set<Class<?>> SMIPLE_CLASS_SET = new HashSet<Class<?>>(
			18);

	static {
		SMIPLE_CLASS_SET.add(int.class);
		SMIPLE_CLASS_SET.add(long.class);
		SMIPLE_CLASS_SET.add(float.class);
		SMIPLE_CLASS_SET.add(double.class);
		SMIPLE_CLASS_SET.add(byte.class);
		SMIPLE_CLASS_SET.add(char.class);
		SMIPLE_CLASS_SET.add(short.class);
		SMIPLE_CLASS_SET.add(boolean.class);
		SMIPLE_CLASS_SET.add(Integer.class);
		SMIPLE_CLASS_SET.add(Long.class);
		SMIPLE_CLASS_SET.add(Float.class);
		SMIPLE_CLASS_SET.add(Double.class);
		SMIPLE_CLASS_SET.add(Byte.class);
		SMIPLE_CLASS_SET.add(Character.class);
		SMIPLE_CLASS_SET.add(Short.class);
		SMIPLE_CLASS_SET.add(Boolean.class);
		SMIPLE_CLASS_SET.add(String.class);
		SMIPLE_CLASS_SET.add(Date.class);
	}

	/** 检查 clazz 是否为简单数据类型 */
	public final static boolean isSimpleType(Class<?> clazz) {
		return SMIPLE_CLASS_SET.contains(clazz);
	}

	/**
	 * String -> Any，如果 handler 为 null 则把字符串转换为 8 种基础数据类型、及其包装类、 {@link Date} 或
	 * {@link String}， 如果 handler 不为 null 则由 handler 执行转换
	 * 
	 * @param type
	 *            : 目标类型的 {@link Class} 对象
	 * @param v
	 *            : 要转换的字符串
	 * @param handler
	 *            : 类型转换处理器
	 * @return : 转换结果，如果转换不成功返回 null
	 * @throws : 如果目标类型不支持抛出 {@link IllegalArgumentException}
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static final <T> T str2Object(Class<T> type, String v,
			TypeHandler handler) {
		Object param = null;

		if (handler != null)
			return (T) handler.handle(v);

		if (type == String.class)
			param = safeTrimString(v);
		else if (type == int.class)
			param = str2Int_0(v);
		else if (type == long.class)
			param = str2Long_0(v);
		else if (type == byte.class)
			param = str2Byte_0(v);
		else if (type == char.class)
			param = str2Char_0(v);
		else if (type == float.class)
			param = str2Float_0(v);
		else if (type == double.class)
			param = str2Double_0(v);
		else if (type == short.class)
			param = str2Short_0(v);
		else if (type == boolean.class)
			param = str2Boolean_False(v);
		else if (type == Integer.class)
			param = str2Int(v);
		else if (type == Long.class)
			param = str2Long(v);
		else if (type == Byte.class)
			param = str2Byte(v);
		else if (type == Character.class)
			param = str2Char(v);
		else if (type == Float.class)
			param = str2Float(v);
		else if (type == Double.class)
			param = str2Double(v);
		else if (type == Short.class)
			param = str2Short(v);
		else if (type == Boolean.class)
			param = str2Boolean(v);
		else if (Date.class.isAssignableFrom(type))
			param = str2Date(v);
		else
			throw new IllegalArgumentException(String.format(
					"object type '%s' not valid", type));

		return (T) param;
	}

	private static Object str2Float_0(String v) {
		return Float.valueOf(v);
	}

	@SuppressWarnings("deprecation")
	private static Object str2Date(String v) {
		return Date.parse(v);
	}

	private static Object str2Boolean(String v) {
		if (v.equals("true"))
			return true;
		return false;
	}

	private static Object str2Short(String v) {
		return Short.valueOf(v);
	}

	private static Object str2Double(String v) {
		return Double.valueOf(v);
	}

	private static Object str2Float(String v) {
		return Float.valueOf(v);
	}

	private static Object str2Char(String v) {
		return v.toCharArray();
	}

	private static Object str2Byte(String v) {
		return v.getBytes();
	}

	private static Object str2Long(String v) {
		return Long.valueOf(v);
	}

	private static Object str2Int(String v) {
		return Integer.valueOf(v);
	}

	private static Object str2Boolean_False(String v) {
		if (v.equals("true"))
			return true;
		return false;
	}

	private static Object str2Short_0(String v) {
		return Short.valueOf(v);
	}

	private static Object str2Double_0(String v) {
		return Double.valueOf(v);
	}

	private static Object str2Char_0(String v) {
		return v.toCharArray();
	}

	private static Object str2Byte_0(String v) {
		return v.getBytes();
	}

	private static Object str2Long_0(String v) {
		return Long.valueOf(v);
	}

	private static Object str2Int_0(String v) {
		return Integer.valueOf(v);
	}

	private static Object safeTrimString(String v) {
		return v.trim();
	}

	public static final <T> T str2Object(Class<T> type, String v) {
		return str2Object(type, v, null);
	}

	class TypeHandler {
		Object handle(String v) {
			return v;
		}
	}

}