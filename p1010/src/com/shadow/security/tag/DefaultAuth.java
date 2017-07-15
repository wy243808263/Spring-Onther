package com.shadow.security.tag;

import java.io.*;
import java.util.Collection;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

import org.apache.log4j.Logger;

import com.shadow.security.model.GrantedResource;
import com.shadow.security.model.UserDetails;
import com.shadow.util.base.Utils;

/**
 * 
 * @author shadow
 * 
 */
public class DefaultAuth extends SimpleTagSupport {

	protected Logger logger = Logger.getLogger(getClass());

	private String val;

	@SuppressWarnings("unchecked")
	public void doTag() throws JspException, IOException {
		UserDetails details = null;
		try {
			details = (UserDetails) Utils.SecurityUtil.getUserDetails();
		} catch (Exception e) {
			logger.error("获取用户信息错误: " + e.getMessage());
			String scirpt = "<script type='text/javascript'>window.onload=function(){alert('登录状态无效,请重新登录!');return false;}</script>";
			getJspContext().getOut().print(scirpt);
			return;
		}
		// 用户不存在
		if (details == null)
			return;
		// 用户资源集合为空
		if (details.getResources() == null || details.getResources().isEmpty())
			return;
		// 匹配资源库
		Collection<GrantedResource> collection = details.getResources();
		for (GrantedResource resource : collection) {
			System.out.println(resource.getResource());
			if (resource.getResource().equals(getVal())) {
				getJspBody().invoke(null);
				return;
			}
		}
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

}