package com.shadow.extras.cxf;

import javax.jws.WebService;

import com.shadow.mvc.main.domain.User;

/**
 * CXF实例
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
@WebService(endpointInterface = "com.shadow.extras.cxf.Hello")
public class HelloImpl implements Hello {

	public String hello(String username) {
		System.out.println("server is called!");
		return "sayHello: " + username;
	}

	public User getUser() {
		User user = new User();
		user.setUsername("321321");
		user.setId(1);
		return user;
	}

	public int getNumber(Integer i) {
		return i;
	}

}