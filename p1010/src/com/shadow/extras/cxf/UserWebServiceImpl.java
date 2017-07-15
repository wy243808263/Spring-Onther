package com.shadow.extras.cxf;

import javax.jws.WebService;

@WebService
public class UserWebServiceImpl implements UserWebService {

	@Override
	public User queryUser(User user, Integer id) {
		System.out.println("当前用户名: " + user.getUsername());
		System.out.println("id参数: " + id);
		return user;
	}

	@Override
	public Integer queryCount(Integer count) {
		return count;
	}

}
