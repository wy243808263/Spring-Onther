package com.shadow.mvc.main.domain;

import java.util.List;

import com.shadow.mvc.domain.base.AbstractGroup;

/**
 * 分组实体
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
public class Group extends AbstractGroup {

	private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}