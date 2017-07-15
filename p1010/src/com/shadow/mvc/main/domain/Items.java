package com.shadow.mvc.main.domain;

import java.io.Serializable;

/**
 * 分类信息实体
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
public class Items implements Serializable {

	private Integer id; // 编号

	private String name; // 名称

	private Brand brand; // 品牌

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

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

}