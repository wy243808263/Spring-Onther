package com.shadow.mvc.domain.model;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据存储对象
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
@SuppressWarnings("serial")
public class Page<T> implements Serializable {

	private int limit = 10; // 显示数
	private int result = 0; // 页数
	private int total = 0; // 记录数
	private int current = 0; // 当前页
	private int offset = 1; // 索引值

	private List<T> list;

	public int getOffset() {
		int index = this.getResult();
		if (index > 0) {
			if (current < 1)
				current = 1;
			if (current > result)
				current = result;
		}
		if (index <= 0)
			current = 1;
		offset = (current - 1) * limit;
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getResult() {
		if (total % limit == 0)
			result = total / limit;
		else
			result = total / limit + 1;
		return result;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotal() {
		return total;
	}

	public int getCurrent() {
		return current;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

}