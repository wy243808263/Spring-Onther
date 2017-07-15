package com.shadow.mvc.main.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shadow.mvc.domain.model.Page;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.dao.mybatis.GoodsDao;
import com.shadow.mvc.main.dao.mybatis.SalesDao;
import com.shadow.mvc.main.domain.Goods;
import com.shadow.mvc.main.domain.Sales;
import com.shadow.mvc.main.domain.User;
import com.shadow.mvc.main.service.SalesService;
import com.shadow.mvc.support.service.ServiceSupport;

/**
 * 存销信息模块实现类
 * 
 * @author shadow
 * 
 */
@Component("salesService")
public class SalesServiceImpl extends ServiceSupport implements
		SalesService {

	private SalesDao salesDao;
	private GoodsDao goodsDao;

	public SalesDao getSalesDao() {
		return salesDao;
	}

	@Resource(name = "salesDao")
	public void setSalesDao(SalesDao salesDao) {
		this.salesDao = salesDao;
	}

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	@Resource(name = "goodsDao")
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Override
	public Service save(Sales model) {
		model.setUser((User) getUserDetails());
		Goods goods = this.goodsDao.queryById(model.getGoods().getId());
		int curr_amount = model.getAmount(); // 操作数量
		int db_amount = goods.getAmount(); // 当前库存
		if (model.getMold() == 1) {
			goods.setAmount(curr_amount + db_amount); // 进货
			this.salesDao.insert(model);
			this.goodsDao.update(goods);
		} else if (model.getMold() == 2) {
			if (db_amount > 0 && (db_amount - curr_amount >= 0)) {
				goods.setAmount(db_amount - curr_amount); // 出货
				this.salesDao.insert(model);
				this.goodsDao.update(goods);
			}
		}
		Service service = getService();
		service.setSuccess(true).setMessage("保存成功!");
		return service;
	}

	@Override
	public Service modify(Sales model) {
		this.salesDao.update(model);
		Service service = getService();
		service.setSuccess(true).setMessage("修改成功!");
		return service;
	}

	@Override
	public Service findById(Sales model) {
		Sales o = this.salesDao.queryById(model.getId());
		Service service = getService();
		service.setSuccess(true).setValue(o);
		return service;
	}

	@Override
	public Service findForAll(Map<String, Object> params) {
		List<Sales> list = this.salesDao.queryForAll(params);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

	@Override
	public Service findForPage(Map<String, Object> params) {
		Page<Sales> page = new Page<Sales>();
		if (params.get("start") != null) {
			params.put("start", getTimestamp(params.get("start").toString()));
		}
		if (params.get("ends") != null) {
			params.put("ends", getTimestamp(params.get("ends").toString()));
		}
		Integer total = this.salesDao.queryForPageTotal(params);
		List<Sales> list = this.salesDao.queryForPageList(params);
		
		page.setTotal(total);
		page.setList(list);
		Service service = getService();
		service.setSuccess(true).setValue(page);
		return service;
	}

	@Override
	public Service removeById(Sales model) {
		this.salesDao.deleteById(model.getId());
		Service service = getService();
		service.setSuccess(true).setMessage("删除成功!");
		return service;
	}

	@Override
	public Service removeForAll(String list) {
		this.salesDao.deleteForBatch(toArray(list));
		Service service = getService();
		service.setSuccess(true).setMessage("批量删除成功!");
		return service;
	}

}
