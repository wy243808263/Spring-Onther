package com.shadow.mvc.main.domain;

import java.io.Serializable;

/**
 * 品牌信息实体
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
public class Brand implements Serializable {

	private Integer id; // 编号
	
	private String name; // 名称

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