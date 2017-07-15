package com.shadow.mvc.main.dao.jdbc.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.shadow.extras.cxf.User;
import com.shadow.mvc.main.dao.jdbc.EUserDao;
import com.shadow.mvc.support.dao.DaoSupport;

@Component("eUserDao")
public class EUserDaoImpl extends DaoSupport implements EUserDao {

	@Override
	public void insertForAllot(List<User> users) {
		// TODO 批量授权处理
	}

}
