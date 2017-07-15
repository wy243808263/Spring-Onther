package com.shadow.mvc.exception;

/**
 * 框架服务层异常
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
@SuppressWarnings("serial")
public class ServiceException extends Exception {

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(String msg, Throwable t) {
		super(msg, t);
	}

}
