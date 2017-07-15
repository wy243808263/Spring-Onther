package com.shadow.extras.cxf;

import javax.jws.WebService;

/**
 * CXF实例
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
@WebService
public interface Hello {

	public String hello(String username);
	
	public int getNumber(Integer i);
	// public User getUser();
}