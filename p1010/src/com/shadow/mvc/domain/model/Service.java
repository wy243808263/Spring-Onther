package com.shadow.mvc.domain.model;

import java.io.Serializable;

import com.shadow.mvc.exception.ServiceException;

/**
 * 
 * 逻辑层数据对象
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
@SuppressWarnings("serial")
public class Service implements Serializable {

	private Boolean success; // 逻辑结果

	private String message; // 返回信息

	private Object value; // 返回值

	private ServiceException exception; // 异常信息

	public Boolean getSuccess() {
		return success;
	}

	public Service setSuccess(Boolean success) {
		this.success = success;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Service setMessage(String message) {
		this.message = message;
		return this;
	}

	public Object getValue() {
		return value;
	}

	public Service setValue(Object value) {
		this.value = value;
		return this;
	}

	public ServiceException getException() {
		return exception;
	}

	public Service setException(ServiceException exception) {
		this.exception = exception;
		return this;
	}

}
