package com.shadow.mvc.main.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shadow.mvc.domain.model.Page;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.dao.mybatis.GoodsDao;
import com.shadow.mvc.main.domain.Goods;
import com.shadow.mvc.main.service.GoodsService;
import com.shadow.mvc.support.service.ServiceSupport;

/**
 * 商品信息模块实现类
 * 
 * @author shadow
 * 
 */
@Component("goodsService")
public class GoodsServiceImpl extends ServiceSupport implements
		GoodsService {

	private GoodsDao goodsDao;

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	@Resource(name = "goodsDao")
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Override
	public Service save(Goods model) {
		this.goodsDao.insert(model);
		Service service = getService();
		service.setSuccess(true).setMessage("保存成功!");
		return service;
	}

	@Override
	public Service modify(Goods model) {
		this.goodsDao.update(model);
		Service service = getService();
		service.setSuccess(true).setMessage("修改成功!");
		return service;
	}

	@Override
	public Service findById(Goods model) {
		Goods o = this.goodsDao.queryById(model.getId());
		Service service = getService();
		service.setSuccess(true).setValue(o);
		return service;
	}

	@Override
	public Service findForAll(Map<String, Object> params) {
		List<Goods> list = this.goodsDao.queryForAll(params);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

	@Override
	public Service findForPage(Map<String, Object> params) {
		Page<Goods> page = new Page<Goods>();
		Integer total = this.goodsDao.queryForPageTotal(params);
		List<Goods> list = this.goodsDao.queryForPageList(params);
		page.setTotal(total);
		page.setList(list);
		Service service = getService();
		service.setSuccess(true).setValue(page);
		return service;
	}

	@Override
	public Service removeById(Goods model) {
		this.goodsDao.deleteById(model.getId());
		Service service = getService();
		service.setSuccess(true).setMessage("删除成功!");
		return service;
	}

	@Override
	public Service removeForAll(String list) {
		this.goodsDao.deleteForBatch(toArray(list));
		Service service = getService();
		service.setSuccess(true).setMessage("批量删除成功!");
		return service;
	}

}
