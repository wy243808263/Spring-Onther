package com.shadow.mvc.main.domain;

import java.util.List;

import com.shadow.mvc.domain.base.AbstractRole;

/**
 * 角色实体
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
public class Role extends AbstractRole {

	private List<Res> ress; // 资源自合

	public List<Res> getRess() {
		return ress;
	}

	public void setRess(List<Res> ress) {
		this.ress = ress;
	}

}