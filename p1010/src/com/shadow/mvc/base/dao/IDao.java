package com.shadow.mvc.base.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * DAO层基本接口方法
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
public interface IDao<T extends Serializable, PK extends Serializable> {

	/**
	 * 保存
	 * 
	 * @param model
	 */
	public void insert(T model);

	/**
	 * 批量保存
	 * 
	 * @param models
	 */
	public void insertForBatch(List<T> models);

	/**
	 * 更新
	 * 
	 * @param model
	 */
	public void update(T model);

	/**
	 * 删除
	 * 
	 * @param PK
	 */
	public void deleteById(PK pk);

	/**
	 * 批量删除
	 * 
	 * @param list
	 */
	public void deleteForBatch(List<PK> list);

	/**
	 * 获取全部记录
	 * 
	 * @param params
	 * @return List<T>
	 */
	public List<T> queryForAll(Map<String, Object> params);

	/**
	 * 获取单个记录通过PK
	 * 
	 * @param pk
	 * @return T
	 */
	public T queryById(PK pk);

	/**
	 * 获取分页条数
	 * 
	 * @param params
	 * @return PK
	 */
	public PK queryForPageTotal(Map<String, Object> params);

	/**
	 * 获取分页记录
	 * 
	 * @param params
	 * @return List<T>
	 */
	public List<T> queryForPageList(Map<String, Object> params);

}