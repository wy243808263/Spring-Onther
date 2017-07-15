package com.shadow.mvc.main.dao.jdbc;

import java.util.List;

import com.shadow.extras.cxf.User;

/**
 * 
 * 用户模块扩展Dao
 * 
 * @author shadow
 */
public interface EUserDao {

	/**
	 * 批量处理授权
	 * 
	 * @param users
	 */
	public void insertForAllot(List<User> users);
}
