package com.shadow.mvc.main.domain;

import java.io.Serializable;

/**
 * 商品实体
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
public class Goods implements Serializable {

	private Integer id; // 编号

	private String name; // 名称

	private String expound; // 备注信息
	
	private Integer amount; // 库存量

	private Brand brand; // 品牌

	private Items items; // 分类

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

	public String getExpound() {
		return expound;
	}

	public void setExpound(String expound) {
		this.expound = expound;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}