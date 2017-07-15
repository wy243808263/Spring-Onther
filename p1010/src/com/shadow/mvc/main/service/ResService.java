package com.shadow.mvc.main.service;

import com.shadow.mvc.base.service.IService;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.domain.Res;
import com.shadow.mvc.main.domain.Role;

/**
 * 资源模块接口
 * 
 * @author shadow
 * 
 */
public interface ResService extends IService<Res, Integer> {

	/**
	 * 查询分配资源
	 * 
	 * @param role
	 * @param mold
	 * @return Service
	 */
	public Service findAllotRes(Role role, int mold);

	/**
	 * 保存角色资源关系
	 * 
	 * @param role
	 * @param resource
	 * @return Service
	 */
	public Service saveRelate(Role role, Res resource);

	/**
	 * 删除角色资源关系
	 * 
	 * @param role
	 * @param resource
	 * @return Service
	 */
	public Service removeRelate(Role role, Res resource);

	/**
	 * 检测是否存在重复资源
	 * 
	 * @param model
	 * @param mold
	 * @return Service
	 */
	public Service checkIsExist(Res model, String mold);
}
