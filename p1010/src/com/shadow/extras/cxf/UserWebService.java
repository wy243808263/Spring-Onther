package com.shadow.extras.cxf;

import javax.jws.WebService;

@WebService
public interface UserWebService {

	public User queryUser(User user, Integer id);

	public Integer queryCount(Integer count);
}
