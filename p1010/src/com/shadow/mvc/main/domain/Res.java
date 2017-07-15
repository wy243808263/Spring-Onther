package com.shadow.mvc.main.domain;

import java.util.List;

import com.shadow.mvc.domain.base.AbstractRes;

/**
 * 资源信息实体
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
public class Res extends AbstractRes {

	private Module module; // 所属模块

	private List<Role> roles; // 权限集合

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}