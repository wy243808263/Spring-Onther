package com.shadow.mvc.main.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.shadow.mvc.base.dao.IDao;
import com.shadow.mvc.main.domain.Res;

/**
 * 资源接口
 * 
 * @author shadow
 * 
 */
public interface ResDao extends IDao<Res, Integer> {

	/**
	 * 查询分配资源
	 * 
	 * @param params
	 * @return List<Resource>
	 */
	public List<Res> queryAllotRes(Map<String, Object> params);

	/**
	 * 保存角色跟资源的关系
	 * 
	 * @param params
	 */
	public void insertRelate(Map<String, Object> params);

	/**
	 * 删除角色跟资源的关系
	 * 
	 * @param params
	 */
	public void deleteRelate(Map<String, Object> params);

	/**
	 * 权限集合有关的资源
	 * 
	 * @param list
	 * @return List<Res>
	 */
	public List<Res> queryByRoles(List<Integer> list);

	/**
	 * 检测当前资源是否重复
	 * 
	 * @param model
	 * @return Integer
	 */
	public Integer checkIsExist(Res model);
}