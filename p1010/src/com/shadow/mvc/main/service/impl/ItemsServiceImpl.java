package com.shadow.mvc.main.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shadow.mvc.domain.model.Page;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.dao.mybatis.ItemsDao;
import com.shadow.mvc.main.domain.Items;
import com.shadow.mvc.main.service.ItemsService;
import com.shadow.mvc.support.service.ServiceSupport;

/**
 * 分类信息模块实现类
 * 
 * @author shadow
 * 
 */
@Component("itemsService")
public class ItemsServiceImpl extends ServiceSupport implements
		ItemsService {

	private ItemsDao itemsDao;

	public ItemsDao getItemsDao() {
		return itemsDao;
	}

	@Resource(name = "itemsDao")
	public void setItemsDao(ItemsDao itemsDao) {
		this.itemsDao = itemsDao;
	}

	@Override
	public Service save(Items model) {
		this.itemsDao.insert(model);
		Service service = getService();
		service.setSuccess(true).setMessage("保存成功!");
		return service;
	}

	@Override
	public Service modify(Items model) {
		this.itemsDao.update(model);
		Service service = getService();
		service.setSuccess(true).setMessage("修改成功!");
		return service;
	}

	@Override
	public Service findById(Items model) {
		Items o = this.itemsDao.queryById(model.getId());
		Service service = getService();
		service.setSuccess(true).setValue(o);
		return service;
	}

	@Override
	public Service findForAll(Map<String, Object> params) {
		List<Items> list = this.itemsDao.queryForAll(params);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

	@Override
	public Service findForPage(Map<String, Object> params) {
		Page<Items> page = new Page<Items>();
		Integer total = this.itemsDao.queryForPageTotal(params);
		List<Items> list = this.itemsDao.queryForPageList(params);
		page.setTotal(total);
		page.setList(list);
		Service service = getService();
		service.setSuccess(true).setValue(page);
		return service;
	}

	@Override
	public Service removeById(Items model) {
		this.itemsDao.deleteById(model.getId());
		Service service = getService();
		service.setSuccess(true).setMessage("删除成功!");
		return service;

	}

	@Override
	public Service removeForAll(String list) {
		this.itemsDao.deleteForBatch(toArray(list));
		Service service = getService();
		service.setSuccess(true).setMessage("批量删除成功!");
		return service;
	}

}
