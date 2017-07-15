package com.shadow.mvc.main.dao.mybatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.shadow.mvc.base.dao.IDao;
import com.shadow.mvc.main.domain.Role;

/**
 * 角色接口
 * 
 * @author shadow
 * 
 */
public interface RoleDao extends IDao<Role, Integer> {

	public List<Role> queryByResourceId(Serializable id);

	public List<Role> queryByUserId(Serializable id);

	/**
	 * 查询分配角色
	 * 
	 * @param params
	 * @return List<Role>
	 */
	public List<Role> queryAllotRole(Map<String, Object> params);

	/**
	 * 保存分组角色的关系
	 * 
	 * @param params
	 */
	public void insertRelate(Map<String, Object> params);

	/**
	 * 删除分组角色的关系
	 * 
	 * @param params
	 */
	public void deleteRelate(Map<String, Object> params);

	/**
	 * 查询小于当前权限的子集
	 * 
	 * @param level
	 * @return List<Role>
	 */
	public List<Role> queryRoleChildren(Serializable level);

}