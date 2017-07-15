package com.shadow.mvc.main.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 存销信息实体
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
public class Sales implements Serializable {

	private Integer id; // 编号

	private Integer mold; // 存销类型,1.存 2.销

	private String expound; // 备注信息

	private Date establish; // 存销商品时间

	private Integer amount; // 数量

	private String price; // 单价

	private User user; // 操作人

	private Goods goods; // 商品

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMold() {
		return mold;
	}

	public void setMold(Integer mold) {
		this.mold = mold;
	}

	public String getExpound() {
		return expound;
	}

	public void setExpound(String expound) {
		this.expound = expound;
	}

	public Date getEstablish() {
		return establish;
	}

	public void setEstablish(Date establish) {
		this.establish = establish;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

}