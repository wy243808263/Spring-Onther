package com.shadow.mvc.main.view.struts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Component;

import com.danga.MemCached.MemCachedClient;
import com.shadow.mvc.base.view.IAction;
import com.shadow.mvc.domain.model.Page;
import com.shadow.mvc.domain.model.Service;
import com.shadow.mvc.main.domain.Brand;
import com.shadow.mvc.main.domain.Group;
import com.shadow.mvc.main.domain.User;
import com.shadow.mvc.main.service.GroupService;
import com.shadow.mvc.main.service.UserService;
import com.shadow.mvc.support.view.ActionSupport;
import com.shadow.util.base.Utils;
import com.shadow.util.common.FreemarkerUtil;

/**
 * 用户模块控制实现
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements IAction {

	private UserService userService;
	private GroupService groupService;
	private SessionRegistry sessionRegistry;

	private User user;
	private String array;

	private List<Group> allotGroup;
	private List<Group> notAllotGroup;

	private String language;

	private Service service;

	private Page<User> page;

	private MemCachedClient memCachedClient;

	// 检测用户名是否存在
	public String checkUser() {
		service = this.userService.checkUser(user.getUsername());
		flush(toJSON(service));
		return NONE;
	}

	public String add() {
		service = this.userService.save(user);
		flush(toJSON(service));
		return NONE;
	}

	@Override
	public String edit() {
		service = this.userService.modify(user);
		flush(toJSON(service));
		return NONE;
	}

	public String findById() {
		user = (User) this.userService.findById(user).getValue();
		return "findById";
	}

	@SuppressWarnings("unchecked")
	public String findByIdForAllot() {
		user = (User) this.userService.findById(user).getValue();
		allotGroup = (List<Group>) this.groupService.findAllotGroup(user, 1)
				.getValue();
		notAllotGroup = (List<Group>) this.groupService.findAllotGroup(user, 2)
				.getValue();
		return "findByIdForAllot";
	}

	@SuppressWarnings("unchecked")
	public String pageTotal() {
		Integer total = ((Page<Brand>) this.userService
				.findForPage(getParams()).getValue()).getTotal();
		flush(total);
		return NONE;
	}

	@SuppressWarnings("unchecked")
	public String page() {
		page = (Page<User>) this.userService.findForPage(getParams())
				.getValue();
		return "page";
	}

	public String removeById() {
		service = this.userService.removeById(user);
		flush(toJSON(service));
		return NONE;
	}

	public String removeForAll() {
		service = this.userService.removeForAll(array);
		flush(toJSON(service));
		return NONE;
	}

	/** 测试MemCachedClient */
	public void testMemCachedClient() {
		memCachedClient.set("key", "我是存放起来的值");
		System.out.println("通过memcached获取的值: " + memCachedClient.get("key"));
	}

	/** 统计在线人数 */
	public void onlineUsers() {
		System.out
				.println("当前用户数:" + sessionRegistry.getAllPrincipals().size());
	}

	/** 把当前用户踢出系统 */
	public void shotOff() {
		System.out.println(sessionRegistry.getAllPrincipals().size()
				+ "___________");
		// 遍历所有用户
		for (Object o : sessionRegistry.getAllPrincipals()) {
			User user = (User) o;
			System.out.println(user.getId() + "__" + user.getUsername());
			for (SessionInformation information : sessionRegistry
					.getAllSessions(o, false)) {
				information.expireNow();
				sessionRegistry.removeSessionInformation(information
						.getSessionId());
			}
		}
	}

	public void test() {

	}

	/** 多语言测试 */
	public String language() {
		Utils.ContextUtil.setLocale(Utils.LanguageUtil.getLocale(language));
		fillTextParams();
		return "language";
	}

	public void test2() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("message", "这是由FREEMARKER生成的HTML!");
		String url = FreemarkerUtil.getInstance().creat(
				"WEB-INF/ftl/index.html", "sss/sss", "aabs.html", params);
		System.out.println(url);
	}

	public String welcome() {
		return "welcome";
	}

	public String info_login() {
		user = (User) Utils.SecurityUtil.getUserDetails();
		return "info_login";
	}

	public String info_own() {
		user = (User) Utils.SecurityUtil.getUserDetails();
		return "info_own";
	}

	public String logout() {
		return "logout";
	}

	// ======================SET,GET======================

	public String getArray() {
		return array;
	}

	public void setArray(String array) {
		this.array = array;
	}

	public SessionRegistry getSessionRegistry() {
		return sessionRegistry;
	}

	@Resource(name = "sessionRegistry")
	public void setSessionRegistry(SessionRegistry sessionRegistry) {
		this.sessionRegistry = sessionRegistry;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public GroupService getGroupService() {
		return groupService;
	}

	@Resource(name = "groupService")
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public List<Group> getAllotGroup() {
		return allotGroup;
	}

	public void setAllotGroup(List<Group> allotGroup) {
		this.allotGroup = allotGroup;
	}

	public List<Group> getNotAllotGroup() {
		return notAllotGroup;
	}

	public void setNotAllotGroup(List<Group> notAllotGroup) {
		this.notAllotGroup = notAllotGroup;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Page<User> getPage() {
		return page;
	}

	public void setPage(Page<User> page) {
		this.page = page;
	}

	public MemCachedClient getMemCachedClient() {
		return memCachedClient;
	}

	@Resource(name = "memCachedClient")
	public void setMemCachedClient(MemCachedClient memCachedClient) {
		this.memCachedClient = memCachedClient;
	}

}
