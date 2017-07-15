package com.shadow.mvc.main.view.struts;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.shadow.mvc.base.view.IAction;
import com.shadow.mvc.domain.model.Page;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.domain.Brand;
import com.shadow.mvc.main.domain.Goods;
import com.shadow.mvc.main.service.GoodsService;
import com.shadow.mvc.support.view.ActionSupport;

/**
 * 商品模板控制实现
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
@Component("goodsAction")
@Scope("prototype")
public class GoodsAction extends ActionSupport implements IAction {

	private GoodsService goodsService;
	private String array;
	private Goods goods;
	private List<Goods> goodss;
	private Service service;
	private Page<Goods> page;

	@Override
	public String add() {
		service = this.goodsService.save(goods);
		flush(toJSON(service));
		return NONE;
	}

	public void show() {
		service = this.goodsService.findForAll(getParams());
		flush(toJSON(service));
	}

	@Override
	public String edit() {
		service = this.goodsService.modify(goods);
		flush(toJSON(service));
		return NONE;
	}

	@Override
	public String findById() {
		goods = (Goods) this.goodsService.findById(goods).getValue();
		return "findById";
	}

	@SuppressWarnings("unchecked")
	public String pageTotal() {
		Integer total = ((Page<Brand>) this.goodsService.findForPage(
				getParams()).getValue()).getTotal();
		flush(total);
		return NONE;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String page() {
		page = (Page<Goods>) this.goodsService.findForPage(getParams())
				.getValue();
		return "page";
	}

	@Override
	public String removeById() {
		service = this.goodsService.removeById(goods);
		flush(toJSON(service));
		return NONE;
	}

	@Override
	public String removeForAll() {
		service = this.goodsService.removeForAll(array);
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

	public GoodsService getGoodsService() {
		return goodsService;
	}

	@Resource(name = "goodsService")
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<Goods> getGoodss() {
		return goodss;
	}

	public void setGoodss(List<Goods> goodss) {
		this.goodss = goodss;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Page<Goods> getPage() {
		return page;
	}

	public void setPage(Page<Goods> page) {
		this.page = page;
	}

}
