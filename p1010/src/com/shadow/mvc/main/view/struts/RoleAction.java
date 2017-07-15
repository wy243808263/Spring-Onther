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
import com.shadow.mvc.main.domain.Res;
import com.shadow.mvc.main.domain.Role;
import com.shadow.mvc.main.domain.User;
import com.shadow.mvc.main.service.ResService;
import com.shadow.mvc.main.service.RoleService;
import com.shadow.mvc.support.view.ActionSupport;

/**
 * 角色模块控制实现
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
@Component("roleAction")
@Scope("prototype")
public class RoleAction extends ActionSupport implements IAction {

	private RoleService roleService;
	private ResService resService;
	private String array;
	private Role role;
	private Group group;

	private List<Res> allotRes;
	private List<Res> notAllotRes;

	private User user;

	private Service service;

	private Page<Role> page;

	public String add() {
		service = this.roleService.save(role);
		flush(toJSON(service));
		return NONE;
	}

	public String edit() {
		service = this.roleService.modify(role);
		flush(toJSON(service));
		return NONE;
	}

	public String findById() {
		role = (Role) this.roleService.findById(role).getValue();
		return "findById";
	}

	@SuppressWarnings("unchecked")
	public String findByIdForAllot() {
		role = (Role) this.roleService.findById(role).getValue();
		allotRes = (List<Res>) this.resService.findAllotRes(role, 1).getValue();
		notAllotRes = (List<Res>) this.resService.findAllotRes(role, 2)
				.getValue();
		return "findByIdForAllot";
	}

	@SuppressWarnings("unchecked")
	public String pageTotal() {
		Integer total = ((Page<Brand>) this.roleService
				.findForPage(getParams()).getValue()).getTotal();
		flush(total);
		return NONE;
	}

	@SuppressWarnings("unchecked")
	public String page() {
		page = (Page<Role>) this.roleService.findForPage(getParams())
				.getValue();
		return "page";
	}

	public String removeById() {
		service = this.roleService.removeById(role);
		flush(toJSON(service));
		return NONE;
	}

	public String removeForAll() {
		service = this.roleService.removeForAll(array);
		flush(toJSON(service));
		return NONE;
	}

	/** 添加分组角色关系 */
	public String addRelate() {
		service = this.roleService.saveRelate(group, role);
		flush(toJSON(service));
		return NONE;
	}

	/** 删除分组角色关系 */
	public String removeRelate() {
		service = this.roleService.removeRelate(group, role);
		flush(toJSON(service));
		return NONE;
	}

	// ======================SET,GET======================

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	@Resource(name = "roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public ResService getResService() {
		return resService;
	}

	@Resource(name = "resService")
	public void setResService(ResService resService) {
		this.resService = resService;
	}

	public String getArray() {
		return array;
	}

	public void setArray(String array) {
		this.array = array;
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

	public Page<Role> getPage() {
		return page;
	}

	public void setPage(Page<Role> page) {
		this.page = page;
	}

	public List<Res> getAllotRes() {
		return allotRes;
	}

	public void setAllotRes(List<Res> allotRes) {
		this.allotRes = allotRes;
	}

	public List<Res> getNotAllotRes() {
		return notAllotRes;
	}

	public void setNotAllotRes(List<Res> notAllotRes) {
		this.notAllotRes = notAllotRes;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
