package com.shadow.security.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.shadow.security.model.UserDetails;
import com.shadow.util.base.Utils;

/**
 * SPRING SECURITY3工具类实现类
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public class SecurityUtil {

	public final static String SPRING_SECURITY_CONTEXT = "SPRING_SECURITY_CONTEXT";

	public SecurityContext getSecurityContext() {
		return (SecurityContext) Utils.ContextUtil.getSession()
				.getAttribute(SPRING_SECURITY_CONTEXT);
	}

	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * 获取SECURITY3的认证对象
	 * 
	 * @return UserDetails
	 */
	public UserDetails getUserDetails() {
		return (UserDetails) getAuthentication().getPrincipal();
	}

}