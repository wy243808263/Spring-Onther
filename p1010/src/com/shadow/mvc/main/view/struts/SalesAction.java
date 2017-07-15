package com.shadow.mvc.main.view.struts;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.shadow.mvc.base.view.IAction;
import com.shadow.mvc.domain.model.Page;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.domain.Brand;
import com.shadow.mvc.main.domain.Sales;
import com.shadow.mvc.main.service.SalesService;
import com.shadow.mvc.support.view.ActionSupport;

/**
 * 存销模板控制实现
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
@Component("salesAction")
@Scope("prototype")
public class SalesAction extends ActionSupport implements IAction {

	private SalesService salesService;
	private String array;
	private Sales sales;

	private Service service;

	private Page<Sales> page;

	@Override
	public String add() {
		service = this.salesService.save(sales);
		flush(toJSON(service));
		return NONE;
	}

	public void show() {
		service = this.salesService.findForAll(getParams());
		flush(toJSON(service));
	}

	@Override
	public String edit() {
		service = this.salesService.modify(sales);
		flush(toJSON(service));
		return NONE;
	}

	@Override
	public String findById() {
		sales = (Sales) this.salesService.findById(sales).getValue();
		return "findById";
	}

	@SuppressWarnings("unchecked")
	public String pageTotal() {
		Integer total = ((Page<Brand>) this.salesService.findForPage(
				getParams()).getValue()).getTotal();
		flush(total);
		return NONE;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String page() {
		page = (Page<Sales>) this.salesService.findForPage(getParams())
				.getValue();
		return "page";
	}

	@Override
	public String removeById() {
		service = this.salesService.removeById(sales);
		flush(toJSON(service));
		return NONE;
	}

	@Override
	public String removeForAll() {
		service = this.salesService.removeForAll(array);
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

	public SalesService getSalesService() {
		return salesService;
	}

	@Resource(name = "salesService")
	public void setSalesService(SalesService salesService) {
		this.salesService = salesService;
	}

	public Sales getSales() {
		return sales;
	}

	public void setSales(Sales sales) {
		this.sales = sales;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Page<Sales> getPage() {
		return page;
	}

	public void setPage(Page<Sales> page) {
		this.page = page;
	}

}
