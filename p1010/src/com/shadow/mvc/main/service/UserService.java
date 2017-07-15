package com.shadow.mvc.main.service;

import java.util.Map;

import com.shadow.mvc.base.service.IService;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.domain.User;

/**
 * 用户模块接口
 * 
 * @author shadow
 * 
 */
public interface UserService extends IService<User, Integer> {

	/**
	 * 更新登录信息
	 * 
	 * @param user
	 * @return Service
	 */
	public Service LoginForUpdate(User user);

	/**
	 * 安全退出功能
	 * 
	 * @return Service
	 */
	public Service logout();

	/**
	 * 检测用户是否存在
	 * 
	 * @param username
	 * @return Service
	 */
	public Service checkUser(String username);

	/**
	 * 通过用户名获取账号
	 * 
	 * @param username
	 * @return Service
	 */
	public Service findByUserName(String username);

	/**
	 * 通过类型、账号、用户名搜索
	 * 
	 * @param params
	 * @return Service
	 */
	public Service findForPageTotalSearch(Map<String, Object> params);

	/**
	 * 通过类型、账号、用户名搜索
	 * 
	 * @param params
	 * @return Service
	 */
	public Service findForPageListSearch(Map<String, Object> params);

}
