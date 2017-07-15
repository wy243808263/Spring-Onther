package com.shadow.mvc.main.service;

import com.shadow.mvc.base.service.IService;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.domain.Group;
import com.shadow.mvc.main.domain.Role;

/**
 * 权限模块接口
 * 
 * @author shadow
 * 
 */
public interface RoleService extends IService<Role, Integer> {

	/**
	 * 查询分配资源
	 * 
	 * @param group
	 * @param mold
	 * @return Service
	 */
	public Service findAllotRole(Group group, int mold);

	/**
	 * 保存分组角色关系
	 * 
	 * @param group
	 * @param role
	 * @return Service
	 */
	public Service saveRelate(Group group, Role role);

	/**
	 * 删除分组角色关系
	 * 
	 * @param group
	 * @param role
	 * @return Service
	 */
	public Service removeRelate(Group group, Role role);

	/**
	 * 查询当前权限下子集
	 * 
	 * @return Service
	 */
	public Service findRoleChildren();
	
}
