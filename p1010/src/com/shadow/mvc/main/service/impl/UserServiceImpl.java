package com.shadow.mvc.main.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.shadow.mvc.domain.model.Page;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.dao.mybatis.UserDao;
import com.shadow.mvc.main.domain.User;
import com.shadow.mvc.main.service.UserService;
import com.shadow.mvc.support.service.ServiceSupport;
import com.shadow.util.base.Utils;

/**
 * 用户模块实现类
 * 
 * @author shadow
 * 
 */
@Component("userService")
public class UserServiceImpl extends ServiceSupport implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public Service LoginForUpdate(User user) {
		this.userDao.update(user);
		Service service = getService();
		service.setSuccess(true).setMessage("修改成功!");
		return service;
	}

	public Service checkUser(String username) {
		int count = this.userDao.checkUser(username);
		Service service = getService();
		if (count <= 0)
			service.setSuccess(true).setMessage("账号尚未被注册!");
		else
			service.setSuccess(false).setMessage("账号已被注册,请重新填写!");
		return service;
	}

	public Service findByUserName(String username) {
		List<User> list = this.userDao.queryByUserName(username);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

	public Service logout() {
		return null;
	}

	public Service findForPage(Map<String, Object> params) {
		Page<User> page = new Page<User>();
		int level = ((User) getUserDetails()).getLevel();
		params.put("level", level);
		Integer total = this.userDao.queryForPageTotal(params);
		List<User> list = this.userDao.queryForPageList(params);
		page.setTotal(total);
		page.setList(list);
		Service service = getService();
		service.setSuccess(true).setValue(page);
		return service;
	}

	public Service findById(User model) {
		User o = this.userDao.queryById(model.getId());
		Service service = getService();
		service.setSuccess(true).setValue(o);
		return service;
	}

	public Service findForAll(Map<String, Object> params) {
		List<User> list = this.userDao.queryForAll(params);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

	public Service modify(User model) {
		String pwd = model.getPassword();
		if (pwd != null && !"".equals(pwd)) {
			String newpwd = Utils.Encoder.encrypt(pwd, model
					.getUsername());
			model.setPassword(newpwd);
		} else {
			User user = this.userDao.queryById(model.getId());
			model.setPassword(user.getPassword());
		}
		this.userDao.update(model);
		Service service = getService();
		service.setSuccess(true).setMessage("修改成功!");
		return service;
	}

	public Service removeById(User model) {
		this.userDao.deleteById(model.getId());
		Service service = getService();
		service.setSuccess(true).setMessage("删除成功!");
		return service;
	}

	public Service removeForAll(String list) {
		this.userDao.deleteForBatch(toArray(list));
		Service service = getService();
		service.setSuccess(true).setMessage("批量删除成功!");
		return service;
	}

	public Service save(User model) {
		model.setStatus(1);
		String newpassword = Utils.Encoder.encrypt(model
				.getPassword(), model.getUsername());
		model.setPassword(newpassword);
		model.setLevel(99);
		this.userDao.insert(model);
		// this.userDao.insertGroupRelation(model);
		// this.userDao.insertRelation(model);
		Service service = getService();
		service.setSuccess(true).setMessage("保存成功!");
		return service;
	}

	public Service findForPageTotalSearch(Map<String, Object> params) {
		Integer total = this.userDao.queryForPageTotalSearch(params);
		Service service = getService();
		service.setSuccess(true).setValue(total);
		return service;
	}

	public Service findForPageListSearch(Map<String, Object> params) {
		List<User> list = this.userDao.queryForPageListSearch(params);
		Service service = getService();
		service.setSuccess(true).setValue(list);
		return service;
	}

}
