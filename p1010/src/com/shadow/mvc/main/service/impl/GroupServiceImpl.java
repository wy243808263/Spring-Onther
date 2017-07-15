package com.shadow.mvc.main.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shadow.mvc.domain.model.Page;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.dao.mybatis.GroupDao;
import com.shadow.mvc.main.domain.Group;
import com.shadow.mvc.main.domain.Role;
import com.shadow.mvc.main.domain.User;
import com.shadow.mvc.main.service.GroupService;
import com.shadow.mvc.support.service.ServiceSupport;

/**
 * 分组模块实现类
 * 
 * @author shadow
 * 
 */
@Component("groupService")
public class GroupServiceImpl extends ServiceSupport implements
		GroupService {

	private GroupDao groupDao;

	public GroupDao getGroupDao() {
		return groupDao;
	}

	@Resource(name = "groupDao")
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	@Override
	public Service findById(Group model) {
		Group o = this.groupDao.queryById(model.getId());
		Service service = getService();
		service.setSuccess(true).setValue(o);
		return service;
	}

	@Override
	public Service findForAll(Map<String, Object> params) {
		List<Group> list = this.groupDao.queryForAll(params);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

	@Override
	public Service findForPage(Map<String, Object> params) {
		Page<Group> page = new Page<Group>();
		Integer total = this.groupDao.queryForPageTotal(params);
		List<Group> list = this.groupDao.queryForPageList(params);
		page.setTotal(total);
		page.setList(list);
		Service service = getService();
		service.setSuccess(true).setValue(page);
		return service;
	}

	@Override
	public Service save(Group model) {
		this.groupDao.insert(model);
		Service service = getService();
		service.setSuccess(true).setMessage("保存成功!");
		return service;
	}

	@Override
	public Service modify(Group model) {
		this.groupDao.update(model);
		Service service = getService();
		service.setSuccess(true).setMessage("修改成功!");
		return service;
	}

	@Override
	public Service removeById(Group model) {
		this.groupDao.deleteById(model.getId());
		Service service = getService();
		service.setSuccess(true).setMessage("删除成功!");
		return service;
	}

	@Override
	public Service removeForAll(String list) {
		this.groupDao.deleteForBatch(toArray(list));
		Service service = getService();
		service.setSuccess(true).setMessage("批量删除成功!");
		return service;

	}

	@Override
	public Service findGroupChidren() {
		int level = ((User) getUserDetails()).getLevel();
		List<Group> list = this.groupDao.queryGroupChildren(level);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

	@Override
	public Service findAllotGroup(User user, int mold) {
		Map<String, Object> params = getMap();
		params.put("user", user.getId());
		params.put("mold", mold);
		List<Role> list = this.groupDao.queryAllotGroup(params);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

	@Override
	public Service removeRelate(Group group, User user) {
		Map<String, Object> params = getMap();
		params.put("group", group.getId());
		params.put("user", user.getId());
		this.groupDao.deleteRelate(params);
		Service service = getService();
		service.setSuccess(true).setMessage("为用户删除分组成功!");
		return service;
	}

	@Override
	public Service saveRelate(Group group, User user) {
		Map<String, Object> params = getMap();
		params.put("group", group.getId());
		params.put("user", user.getId());
		this.groupDao.insertRelate(params);
		Service service = getService();
		service.setSuccess(true).setMessage("为用户设置分组成功!");
		return service;
	}
}
