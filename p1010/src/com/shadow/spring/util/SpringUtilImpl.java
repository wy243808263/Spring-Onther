package com.shadow.spring.util;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.shadow.util.base.Utils;

/**
 * SPRING工具实现类
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 * 
 */
public class SpringUtilImpl implements SpringUtil {

	public ApplicationContext getApplicationContext(
			ServletContext servletContext) {
		return WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
	}

	public Object getBean(ServletContext servletContext, String name) {
		return getApplicationContext(servletContext).getBean(name);
	}

	public Object getBean(String name) {
		return getApplicationContext(Utils.ContextUtil.getContext())
				.getBean(name);
	}

}
