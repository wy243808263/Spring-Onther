package com.shadow.mvc.main.view.struts;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.shadow.mvc.base.view.IAction;
import com.shadow.mvc.domain.model.Page;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.domain.Brand;
import com.shadow.mvc.main.service.BrandService;
import com.shadow.mvc.support.view.ActionSupport;

/**
 * 品牌模板控制实现
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
@Component("brandAction")
@Scope("prototype")
public class BrandAction extends ActionSupport implements IAction {

	private BrandService brandService;
	private String array;
	private Brand brand;
	private Service service;
	private Page<Brand> page;
	private List<Brand> list;

	@Override
	public String add() {
		service = this.brandService.save(brand);
		flush(toJSON(service));
		return NONE;
	}

	public void show() {
		service = this.brandService.findForAll(getParams());
		flush(toJSON(service));
	}

	@Override
	public String edit() {
		service = this.brandService.modify(brand);
		flush(toJSON(service));
		return NONE;
	}

	@Override
	public String findById() {
		brand = (Brand) this.brandService.findById(brand).getValue();
		return "findById";
	}

	@SuppressWarnings("unchecked")
	public String pageTotal() {
		Integer total = ((Page<Brand>) this.brandService.findForPage(
				getParams()).getValue()).getTotal();
		flush(total);
		return NONE;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String page() {
		page = (Page<Brand>) this.brandService.findForPage(getParams())
				.getValue();
		return "page";
	}

	@Override
	public String removeById() {
		service = this.brandService.removeById(brand);
		flush(toJSON(service));
		return NONE;
	}

	@Override
	public String removeForAll() {
		service = this.brandService.removeForAll(array);
		flush(toJSON(service));
		return NONE;
	}

	// ======================SET,GET======================

	public String getArray() {
		return array;
	}

	public void setArray(String array) {
		this.array = array;
	}

	public BrandService getBrandService() {
		return brandService;
	}

	@Resource(name = "brandService")
	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Page<Brand> getPage() {
		return page;
	}

	public void setPage(Page<Brand> page) {
		this.page = page;
	}

	public List<Brand> getList() {
		return list;
	}

	public void setList(List<Brand> list) {
		this.list = list;
	}

}
