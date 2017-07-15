package com.shadow.mvc.main.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shadow.mvc.domain.model.Page;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.dao.mybatis.RoleDao;
import com.shadow.mvc.main.domain.Group;
import com.shadow.mvc.main.domain.Role;
import com.shadow.mvc.main.service.RoleService;
import com.shadow.mvc.support.service.ServiceSupport;

/**
 * 角色模块实现类
 * 
 * @author shadow
 * 
 */
@Component("roleService")
public class RoleServiceImpl extends ServiceSupport implements RoleService {

	private RoleDao roleDao;

	public RoleDao getRoleDao() {
		return roleDao;
	}

	@Resource(name = "roleDao")
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public Service findByResourceId(Integer id) {
		List<Role> list = this.roleDao.queryByResourceId(id);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

	public Service findByUserId(Integer id) {
		List<Role> list = this.roleDao.queryByUserId(id);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

	public Service findById(Role model) {
		Role o = this.roleDao.queryById(model.getId());
		Service service = getService();
		service.setSuccess(true).setValue(o);
		return service;
	}

	public Service findForAll(Map<String, Object> params) {
		List<Role> list = this.roleDao.queryForAll(params);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

	@Override
	public Service findForPage(Map<String, Object> params) {
		Page<Role> page = new Page<Role>();
		Integer total = this.roleDao.queryForPageTotal(params);
		List<Role> list = this.roleDao.queryForPageList(params);
		page.setTotal(total);
		page.setList(list);
		Service service = getService();
		service.setSuccess(true).setValue(page);
		return service;
	}

	public Service modify(Role model) {
		this.roleDao.update(model);
		Service service = getService();
		service.setSuccess(true).setMessage("修改成功!");
		return service;
	}

	public Service removeById(Role model) {
		this.roleDao.deleteById(model.getId());
		Service service = getService();
		service.setSuccess(true).setMessage("删除成功!");
		return service;
	}

	public Service removeForAll(String list) {
		this.roleDao.deleteForBatch(toArray(list));
		Service service = getService();
		service.setSuccess(true).setMessage("批量删除成功!");
		return service;
	}

	public Service save(Role model) {
		this.roleDao.insert(model);
		Service service = getService();
		service.setSuccess(true).setMessage("保存成功!");
		return service;
	}

	@Override
	public Service findRoleChildren() {
		return null;
	}

	@Override
	public Service findAllotRole(Group group, int mold) {
		Map<String, Object> params = getMap();
		params.put("group", group.getId());
		params.put("mold", mold);
		List<Role> list = this.roleDao.queryAllotRole(params);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

	@Override
	public Service removeRelate(Group group, Role role) {
		Map<String, Object> params = getMap();
		params.put("group", group.getId());
		params.put("role", role.getId());
		this.roleDao.deleteRelate(params);
		Service service = getService();
		service.setSuccess(true).setMessage("为分组删除角色成功!");
		return service;
	}

	@Override
	public Service saveRelate(Group group, Role role) {
		Map<String, Object> params = getMap();
		params.put("group", group.getId());
		params.put("role", role.getId());
		this.roleDao.insertRelate(params);
		Service service = getService();
		service.setSuccess(true).setMessage("为分组设置角色成功!");
		return service;
	}

}
