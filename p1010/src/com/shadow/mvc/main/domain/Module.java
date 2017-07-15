package com.shadow.mvc.main.domain;

import java.io.Serializable;

/**
 * 资源模块分类
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
public class Module implements Serializable {

	private Integer id;

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
