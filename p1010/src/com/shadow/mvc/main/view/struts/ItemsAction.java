package com.shadow.mvc.main.view.struts;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.shadow.mvc.base.view.IAction;
import com.shadow.mvc.domain.model.Page;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.domain.Brand;
import com.shadow.mvc.main.domain.Items;
import com.shadow.mvc.main.service.ItemsService;
import com.shadow.mvc.support.view.ActionSupport;

/**
 * 分类模板控制实现
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
@Component("itemsAction")
@Scope("prototype")
public class ItemsAction extends ActionSupport implements IAction {

	private ItemsService itemsService;
	private String array;
	private Items items;

	private Service service;

	private Page<Items> page;

	@Override
	public String add() {
		service = this.itemsService.save(items);
		flush(toJSON(service));
		return NONE;
	}

	public void show() {
		service = this.itemsService.findForAll(getParams());
		flush(toJSON(service));
	}

	@Override
	public String edit() {
		service = this.itemsService.modify(items);
		flush(toJSON(service));
		return NONE;
	}

	@Override
	public String findById() {
		items = (Items) this.itemsService.findById(items).getValue();
		return "findById";
	}

	@SuppressWarnings("unchecked")
	public String pageTotal() {
		Integer total = ((Page<Brand>) this.itemsService.findForPage(
				getParams()).getValue()).getTotal();
		flush(total);
		return NONE;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String page() {
		page = (Page<Items>) this.itemsService.findForPage(getParams())
				.getValue();
		return "page";
	}

	@Override
	public String removeById() {
		service = this.itemsService.removeById(items);
		flush(toJSON(service));
		return NONE;
	}

	@Override
	public String removeForAll() {
		service = this.itemsService.removeForAll(array);
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

	public ItemsService getItemsService() {
		return itemsService;
	}

	@Resource(name = "itemsService")
	public void setItemsService(ItemsService itemsService) {
		this.itemsService = itemsService;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Page<Items> getPage() {
		return page;
	}

	public void setPage(Page<Items> page) {
		this.page = page;
	}

}
