package com.shadow.mvc.domain.base;

import java.io.Serializable;

/**
 * 资源信息实体
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
public abstract class AbstractRes implements Serializable {

	private Integer id; // 编号

	private String mold; // 类型

	private String uri; // 路径

	private String expound; // 描述信息

	private Integer status; // 状态 1.正常 2.冻结 3.删除 4.异常

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMold() {
		return mold;
	}

	public void setMold(String mold) {
		this.mold = mold;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getExpound() {
		return expound;
	}

	public void setExpound(String expound) {
		this.expound = expound;
	}

}