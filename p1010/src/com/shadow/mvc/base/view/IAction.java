package com.shadow.mvc.base.view;

/**
 * ACTION层基本接口方法
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public interface IAction {

	/**
	 * 添加
	 * 
	 * @return String
	 */
	public String add();

	/**
	 * 修改
	 * 
	 * @return String
	 */
	public String edit();

	/**
	 * 查询
	 * 
	 * @return String
	 */
	public String findById();

	/**
	 * 分页
	 * 
	 * @return String
	 */
	public String page();

	/**
	 * 删除
	 * 
	 * @return String
	 */
	public String removeById();

	/**
	 * 批量删除
	 * 
	 * @return String
	 */
	public String removeForAll();
}
