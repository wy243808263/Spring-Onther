package com.shadow.security.handler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.shadow.mvc.main.domain.User;
import com.shadow.mvc.main.service.UserService;
import com.shadow.util.base.Utils;

/**
 * spring security登录成功处理
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	private final static Logger logger = Logger
			.getLogger(LoginSuccessHandler.class);

	private UserService userService;

	private String indexUrl; // 登陆成功跳转路径

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getIndexUrl() {
		return indexUrl;
	}

	public void setIndexUrl(String indexUrl) {
		this.indexUrl = indexUrl;
	}

	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		User user = (User) Utils.SecurityUtil.getUserDetails();
		if (logger.isDebugEnabled())
			logger.debug("信息: ["
					+ user.getUsername()
					+ "] "
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.format(new Date()) + " 登录成功");
		response.setContentType("text/plain");
		response.getWriter().print("success");
	}

}
