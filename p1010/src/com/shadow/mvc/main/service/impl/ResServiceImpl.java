package com.shadow.mvc.main.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shadow.mvc.domain.model.Page;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.dao.mybatis.ResDao;
import com.shadow.mvc.main.domain.Res;
import com.shadow.mvc.main.domain.Role;
import com.shadow.mvc.main.service.ResService;
import com.shadow.mvc.support.service.ServiceSupport;

/**
 * 资源模块实现类
 * 
 * @author shadow
 * 
 */
@Component("resService")
public class ResServiceImpl extends ServiceSupport implements ResService {

	private ResDao resDao;

	public ResDao getResDao() {
		return resDao;
	}

	@Resource(name = "resDao")
	public void setResDao(ResDao resDao) {
		this.resDao = resDao;
	}

	public Service findById(Res model) {
		Res o = this.resDao.queryById(model.getId());
		Service service = getService();
		service.setSuccess(true).setValue(o);
		return service;
	}

	public Service findForAll(Map<String, Object> params) {
		List<Res> list = this.resDao.queryForAll(params);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

	public Service findForPage(Map<String, Object> params) {
		Page<Res> page = new Page<Res>();
		Integer total = this.resDao.queryForPageTotal(params);
		List<Res> list = this.resDao.queryForPageList(params);
		page.setTotal(total);
		page.setList(list);
		Service service = getService();
		service.setSuccess(true).setValue(page);
		return service;
	}

	public Service modify(Res model) {
		this.resDao.update(model);
		Service service = getService();
		service.setSuccess(true).setMessage("修改成功!");
		return service;
	}

	public Service removeById(Res model) {
		this.resDao.deleteById(model.getId());
		Service service = getService();
		service.setSuccess(true).setMessage("删除成功!");
		return service;
	}

	public Service removeForAll(String list) {
		this.resDao.deleteForBatch(toArray(list));
		Service service = getService();
		service.setSuccess(true).setMessage("批量删除成功!");
		return service;
	}

	public Service save(Res model) {
		this.resDao.insert(model);
		Service service = getService();
		service.setSuccess(true).setMessage("保存成功!");
		return service;
	}

	public Service findAllotRes(Role role, int mold) {
		Map<String, Object> params = getMap();
		params.put("mold", mold);
		params.put("role", role.getId());
		List<Res> list = this.resDao.queryAllotRes(params);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

	public Service removeRelate(Role role, Res res) {
		Map<String, Object> params = getMap();
		params.put("role", role.getId());
		params.put("res", res.getId());
		this.resDao.deleteRelate(params);
		Service service = getService();
		service.setSuccess(true).setMessage("为角色删除资源成功!");
		return service;
	}

	public Service saveRelate(Role role, Res res) {
		Map<String, Object> params = getMap();
		params.put("role", role.getId());
		params.put("res", res.getId());
		this.resDao.insertRelate(params);
		Service service = getService();
		service.setSuccess(true).setMessage("为角色设置资源成功!");
		return service;
	}

	public Service checkIsExist(Res model, String mold) {
		Integer count = this.resDao.checkIsExist(model);
		Service service = getService();
		if (mold.equals("add")) {
			if (count > 0)
				service.setSuccess(false).setMessage("该资源内容已经存在");
			else
				service.setSuccess(true).setMessage("该资源尚可添加");
		}
		if (mold.equals("edit")) {
			Res res = this.resDao.queryById(model.getId());
			if (res.getUri().equals(model.getUri())) {
				service.setSuccess(true).setMessage("该资源尚可添加");
			} else {
				if (count > 0)
					service.setSuccess(false).setMessage("该资源内容已经存在");
			}
		}
		return service;
	}

}
