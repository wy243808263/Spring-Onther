package com.shadow.spring.util;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;

/**
 * SPRING工具类接口
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 * 
 */
public interface SpringUtil {

	/**
	 * 获取 Spring ApplicationContext
	 * 
	 * @param servletContext
	 * @return ApplicationContext
	 */
	public ApplicationContext getApplicationContext(ServletContext context);

	/**
	 * 获取spring管理的Bean
	 * 
	 * @param context
	 * @param name
	 * @return Object
	 */
	public Object getBean(ServletContext context, String name);

	/**
	 * 获取spring管理的Bean
	 * 
	 * @param servletContext
	 * @param name
	 * @return Object
	 */
	public Object getBean(String name);

}
