package com.shadow.mvc.base.service;

import java.io.Serializable;
import java.util.Map;

import com.shadow.mvc.domain.model.Service;

/**
 * /** SERVICE层基本接口方法
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 * 
 * @param <T>
 *            实体
 * @param <PK>
 *            主键
 */
public interface IService<T extends Serializable, PK extends Serializable> {

	/**
	 * 保存
	 * 
	 * @param model
	 * @return Service
	 */
	public Service save(T model);

	/**
	 * 修改
	 * 
	 * @param model
	 * @return Service
	 */
	public Service modify(T model);

	/**
	 * 查询单个实体
	 * 
	 * @param model
	 * @return Service
	 */
	public Service findById(T model);

	/**
	 * 查询全部
	 * 
	 * @param params
	 * @return Service
	 */
	public Service findForAll(Map<String, Object> params);

	/**
	 * 分页查询记录条数
	 * 
	 * @param params
	 * @return Service
	 */
	public Service findForPage(Map<String, Object> params);

	/**
	 * 删除
	 * 
	 * @param model
	 * @return Service
	 */
	public Service removeById(T model);

	/**
	 * 批量删除
	 * 
	 * @param list
	 * @return Service
	 */
	public Service removeForAll(String list);
}