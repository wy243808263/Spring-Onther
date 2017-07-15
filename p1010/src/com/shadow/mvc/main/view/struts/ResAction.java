package com.shadow.mvc.main.view.struts;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.shadow.mvc.base.view.IAction;
import com.shadow.mvc.domain.model.Page;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.domain.Brand;
import com.shadow.mvc.main.domain.Res;
import com.shadow.mvc.main.domain.Role;
import com.shadow.mvc.main.service.ResService;
import com.shadow.mvc.support.view.ActionSupport;

/**
 * 资源模块控制实现
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
@Component("resAction")
@Scope("prototype")
public class ResAction extends ActionSupport implements IAction {

	private ResService resService;
	private String array;
	private Res res;
	private Role role;

	private Service service;

	private Page<Res> page;

	public String add() {
		service = this.resService.save(res);
		flush(toJSON(service));
		return NONE;
	}

	public String edit() {
		service = this.resService.modify(res);
		flush(toJSON(service));
		return NONE;
	}

	public String findById() {
		res = (Res) this.resService.findById(res).getValue();
		return "findById";
	}

	@SuppressWarnings("unchecked")
	public String pageTotal() {
		Integer total = ((Page<Brand>) this.resService.findForPage(getParams())
				.getValue()).getTotal();
		flush(total);
		return NONE;
	}

	@SuppressWarnings("unchecked")
	public String page() {
		page = (Page<Res>) this.resService.findForPage(getParams()).getValue();
		return "page";
	}

	public String removeById() {
		service = this.resService.removeById(res);
		flush(toJSON(service));
		return NONE;
	}

	public String removeForAll() {
		service = this.resService.removeForAll(array);
		flush(toJSON(service));
		return NONE;
	}

	/** 查询当前角色未拥有的资源 */
	public String showNotAllotRes() {
		service = this.resService.findAllotRes(role, 1);
		flush(toJSON(service));
		return NONE;
	}

	/** 查询当前角色未拥有的资源 */
	public String showAllotRes() {
		service = this.resService.findAllotRes(role, 2);
		flush(toJSON(service));
		return NONE;
	}

	/** 添加资源角色关系 */
	public String addRelate() {
		service = this.resService.saveRelate(role, res);
		flush(toJSON(service));
		return NONE;
	}

	/** 删除资源角色关系 */
	public String removeRelate() {
		service = this.resService.removeRelate(role, res);
		flush(toJSON(service));
		return NONE;
	}

	/** 检测资源是否重复 */
	public String checkIsExist() {
		service = this.resService.checkIsExist(res, array);
		flush(toJSON(service));
		return NONE;
	}

	// ======================SET,GET======================

	public ResService getResService() {
		return resService;
	}

	@Resource(name = "resService")
	public void setResService(ResService resService) {
		this.resService = resService;
	}

	public Res getRes() {
		return res;
	}

	public void setRes(Res res) {
		this.res = res;
	}

	public String getArray() {
		return array;
	}

	public void setArray(String array) {
		this.array = array;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Page<Res> getPage() {
		return page;
	}

	public void setPage(Page<Res> page) {
		this.page = page;
	}

}
