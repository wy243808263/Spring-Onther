package com.shadow.mvc.main.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shadow.mvc.domain.model.Page;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.dao.mybatis.BrandDao;
import com.shadow.mvc.main.domain.Brand;
import com.shadow.mvc.main.service.BrandService;
import com.shadow.mvc.support.service.ServiceSupport;

/**
 * 品牌信息模块实现类
 * 
 * @author shadow
 * 
 */
@Component("brandService")
public class BrandServiceImpl extends ServiceSupport implements
		BrandService {

	private BrandDao brandDao;

	public BrandDao getBrandDao() {
		return brandDao;
	}

	@Resource(name = "brandDao")
	public void setBrandDao(BrandDao brandDao) {
		this.brandDao = brandDao;
	}

	@Override
	public Service save(Brand model) {
		this.brandDao.insert(model);
		Service service = getService();
		service.setSuccess(true).setMessage("保存成功!");
		return service;
	}

	@Override
	public Service modify(Brand model) {
		this.brandDao.update(model);
		Service service = getService();
		service.setSuccess(true).setMessage("修改成功!");
		return service;
	}

	@Override
	public Service findById(Brand model) {
		Brand o = this.brandDao.queryById(model.getId());
		Service service = getService();
		service.setSuccess(true).setValue(o);
		return service;
	}

	@Override
	public Service findForAll(Map<String, Object> params) {
		List<Brand> list = this.brandDao.queryForAll(params);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

	@Override
	public Service findForPage(Map<String, Object> params) {
		Page<Brand> page = new Page<Brand>();
		Integer total = this.brandDao.queryForPageTotal(params);
		List<Brand> list = this.brandDao.queryForPageList(params);
		page.setTotal(total);
		page.setList(list);
		Service service = getService();
		service.setSuccess(true).setValue(page);
		return service;
	}

	@Override
	public Service removeById(Brand model) {
		this.brandDao.deleteById(model.getId());
		Service service = getService();
		service.setSuccess(true).setMessage("删除成功!");
		return service;
	}

	@Override
	public Service removeForAll(String list) {
		this.brandDao.deleteForBatch(toArray(list));
		Service service = getService();
		service.setSuccess(true).setMessage("批量删除成功!");
		return service;
	}

}
