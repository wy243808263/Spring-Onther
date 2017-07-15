package com.shadow.mvc.main.service;

import com.shadow.mvc.base.service.IService;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.domain.Group;
import com.shadow.mvc.main.domain.User;

/**
 * 分组模块接口
 * 
 * @author shadow
 * 
 */
public interface GroupService extends IService<Group, Integer> {

	/**
	 * 查询分配分组
	 * 
	 * @param user
	 * @param mold
	 * @return Service
	 */
	public Service findAllotGroup(User user, int mold);

	/**
	 * 保存用户分组关系
	 * 
	 * @param group
	 * @param user
	 * @return Service
	 */
	public Service saveRelate(Group group, User user);

	/**
	 * 删除用户分组关系
	 * 
	 * @param group
	 * @param user
	 * @return Service
	 */
	public Service removeRelate(Group group, User user);

	/**
	 * 查询当前权限下的子集
	 * 
	 * @return List<Group>
	 */
	public Service findGroupChidren();
}
