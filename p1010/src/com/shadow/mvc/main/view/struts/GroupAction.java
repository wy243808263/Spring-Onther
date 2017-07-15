package com.shadow.mvc.main.view.struts;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.shadow.mvc.base.view.IAction;
import com.shadow.mvc.domain.model.Page;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.domain.Brand;
import com.shadow.mvc.main.domain.Group;
import com.shadow.mvc.main.domain.Role;
import com.shadow.mvc.main.domain.User;
import com.shadow.mvc.main.service.GroupService;
import com.shadow.mvc.main.service.RoleService;
import com.shadow.mvc.support.view.ActionSupport;

/**
 * 分组模块控制
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
@Component("groupAction")
@Scope("prototype")
public class GroupAction extends ActionSupport implements IAction {

	private GroupService groupService;
	private RoleService roleService;
	private String array;
	private Group group;

	private User user;

	private List<Role> allotRole;
	private List<Role> notAllotRole;

	private Service service;

	private Page<Group> page;

	public String add() {
		service = this.groupService.save(group);
		flush(toJSON(service));
		return NONE;
	}

	public String edit() {
		service = this.groupService.modify(group);
		flush(toJSON(service));
		return NONE;
	}

	public String findById() {
		group = (Group) this.groupService.findById(group).getValue();
		return "findById";
	}

	@SuppressWarnings("unchecked")
	public String findByIdForAllot() {
		group = (Group) this.groupService.findById(group).getValue();
		allotRole = (List<Role>) this.roleService.findAllotRole(group, 1)
				.getValue();
		notAllotRole = (List<Role>) this.roleService.findAllotRole(group, 2)
				.getValue();
		return "findByIdForAllot";
	}

	@SuppressWarnings("unchecked")
	public String pageTotal() {
		Integer total = ((Page<Brand>) this.groupService.findForPage(
				getParams()).getValue()).getTotal();
		flush(total);
		return NONE;
	}

	@SuppressWarnings("unchecked")
	public String page() {
		page = (Page<Group>) this.groupService.findForPage(getParams())
				.getValue();
		return "page";
	}

	public String removeById() {
		service = this.groupService.removeById(group);
		flush(toJSON(service));
		return NONE;
	}

	public String removeForAll() {
		service = this.groupService.removeForAll(array);
		flush(toJSON(service));
		return NONE;
	}

	/** 添加用户分组关系 */
	public String addRelate() {
		service = this.groupService.saveRelate(group, user);
		flush(toJSON(service));
		return NONE;
	}

	/** 删除用户分关系 */
	public String removeRelate() {
		service = this.groupService.removeRelate(group, user);
		flush(toJSON(service));
		return NONE;
	}

	// ======================SET,GET======================

	public GroupService getGroupService() {
		return groupService;
	}

	@Resource(name = "groupService")
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	@Resource(name = "roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public List<Role> getAllotRole() {
		return allotRole;
	}

	public void setAllotRole(List<Role> allotRole) {
		this.allotRole = allotRole;
	}

	public List<Role> getNotAllotRole() {
		return notAllotRole;
	}

	public void setNotAllotRole(List<Role> notAllotRole) {
		this.notAllotRole = notAllotRole;
	}

	public String getArray() {
		return array;
	}

	public void setArray(String array) {
		this.array = array;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Page<Group> getPage() {
		return page;
	}

	public void setPage(Page<Group> page) {
		this.page = page;
	}

}
