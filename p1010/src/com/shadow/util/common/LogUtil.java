package com.shadow.util.common;

import org.aspectj.lang.JoinPoint;

public interface LogUtil {

	/**
	 * 方法操作前
	 * 
	 * @param joinPoint
	 */
	public void writeBefore(JoinPoint joinPoint);

	/**
	 * 方法操作后
	 * 
	 * @param joinPoint
	 */
	public void writeAfter(JoinPoint joinPoint);

	/**
	 * 环绕方法操作
	 * 
	 * @param joinPoint
	 */
	public void writeAround(JoinPoint joinPoint);
}
