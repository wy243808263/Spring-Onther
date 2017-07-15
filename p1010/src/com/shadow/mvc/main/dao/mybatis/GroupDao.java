package com.shadow.mvc.main.dao.mybatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.shadow.mvc.base.dao.IDao;
import com.shadow.mvc.main.domain.Group;
import com.shadow.mvc.main.domain.Role;

/**
 * 分组接口
 * 
 * @author shadow
 * 
 */
public interface GroupDao extends IDao<Group, Integer> {

	public List<Group> queryByRoleId(Serializable id);

	public List<Group> queryByUserId(Serializable id);

	/**
	 * 查询小于当前权限的子集
	 * 
	 * @param level
	 * @return List<Group>
	 */
	public List<Group> queryGroupChildren(Serializable level);

	/**
	 * 查询用户分组
	 * 
	 * @param params
	 * @return List<Role>
	 */
	public List<Role> queryAllotGroup(Map<String, Object> params);

	/**
	 * 保存用户分组的关系
	 * 
	 * @param params
	 */
	public void insertRelate(Map<String, Object> params);

	/**
	 * 删除用户分组的关系
	 * 
	 * @param params
	 */
	public void deleteRelate(Map<String, Object> params);
}