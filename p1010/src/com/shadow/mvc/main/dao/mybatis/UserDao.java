package com.shadow.mvc.main.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.shadow.mvc.base.dao.IDao;
import com.shadow.mvc.main.domain.User;

public interface UserDao extends IDao<User, Integer> {

	/**
	 * 通过用户名查询信息
	 * 
	 * @param username
	 * @return List<User>
	 */
	public List<User> queryByUserName(String username);

	/**
	 * 检测用户名是否存在
	 * 
	 * @param username
	 * @return int
	 */
	public int checkUser(String username);

	/**
	 * 保存用户分组的关系
	 * 
	 * @param user
	 */
	public void insertGroupRelation(User user);

	/**
	 * 通过部门编号查询
	 * 
	 * @param id
	 * @return List<User>
	 */
	public List<User> queryByDept(Integer id);

	/**
	 * 通过支行编号查询
	 * 
	 * @param id
	 * @return List<User>
	 */
	public List<User> queryByBank(Integer id);

	/**
	 * 通过网点编号查询
	 * 
	 * @param id
	 * @return List<User>
	 */
	public List<User> queryBySite(Integer id);

	/**
	 * 通过类型、账号、用户名搜索
	 * 
	 * @param params
	 * @return Integer
	 */
	public Integer queryForPageTotalSearch(Map<String, Object> params);

	/**
	 * 通过类型、账号、用户名搜索
	 * 
	 * @param params
	 * @return List<User>
	 */
	public List<User> queryForPageListSearch(Map<String, Object> params);
}