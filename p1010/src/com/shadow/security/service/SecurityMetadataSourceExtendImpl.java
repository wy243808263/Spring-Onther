package com.shadow.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RegexRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

import com.shadow.mvc.main.domain.Res;
import com.shadow.mvc.main.domain.Role;
import com.shadow.mvc.main.service.ResService;
import com.shadow.mvc.main.service.RoleService;

/**
 * 初始化时加载角色资源关联数据
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public class SecurityMetadataSourceExtendImpl implements
		SecurityMetadataSourceExtend {

	protected Logger logger = Logger.getLogger(getClass());

	private RoleService roleService; // 角色服务类

	private ResService resService; // 资源服务类

	private RequestMatcher requestMatcher; // 匹配规则

	private String matcher; // 规则标识

	private SessionRegistry sessionRegistry; // session库存

	private static Map<String, Collection<ConfigAttribute>> kv = new ConcurrentHashMap<String, Collection<ConfigAttribute>>(); // 资源集合

	public RoleService getRoleService() {
		return roleService;
	}

	@Resource(name = "roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public ResService getResService() {
		return resService;
	}

	@Resource(name = "resService")
	public void setResService(ResService resService) {
		this.resService = resService;
	}

	public SessionRegistry getSessionRegistry() {
		return sessionRegistry;
	}

	@Resource(name = "sessionRegistry")
	public void setSessionRegistry(SessionRegistry sessionRegistry) {
		this.sessionRegistry = sessionRegistry;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	// 初始化方法时候从数据库中读取资源
	@PostConstruct
	public void init() {
		load();
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> attributes = new HashSet<ConfigAttribute>();
		for (Map.Entry<String, Collection<ConfigAttribute>> entry : kv
				.entrySet()) {
			attributes.addAll(entry.getValue());
		}
		return attributes;
	}

	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		HttpServletRequest request = ((FilterInvocation) object).getRequest();

		// DEBUG模式显示请求资源路径
		if (logger.isDebugEnabled())
			logger.debug("当前请求URL: " + request.getRequestURI());

		// 检测请求与当前资源匹配的正确性
		Iterator<String> iterator = kv.keySet().iterator();
		while (iterator.hasNext()) {
			String uri = iterator.next();
			if (matcher.toLowerCase().equals("ant")) {
				requestMatcher = new AntPathRequestMatcher(uri);
			}
			if (matcher.toLowerCase().equals("regex")) {
				requestMatcher = new RegexRequestMatcher(uri, request
						.getMethod(), true);
			}
			if (requestMatcher.matches(request))
				return kv.get(uri);
		}
		return null;
	}

	/**
	 * 加载所有资源与权限的关系
	 */
	@SuppressWarnings("unchecked")
	public void load() {
		List<Res> ress = (List<Res>) this.resService.findForAll(null)
				.getValue();
		for (Res res : ress) {
			if (res.getMold().equals("1"))
				kv.put(res.getUri(), list2Collection(res.getRoles()));
		}
	}

	/**
	 * 将List<Role>集合转换为框架需要的Collection<ConfigAttribute>集合
	 * 
	 * @param roles
	 * @return Collection<ConfigAttribute>
	 */
	private Collection<ConfigAttribute> list2Collection(List<Role> roles) {
		List<ConfigAttribute> list = new ArrayList<ConfigAttribute>();
		for (Role role : roles)
			list.add(new SecurityConfig(role.getName()));
		return list;
	}

	public void setMatcher(String matcher) {
		this.matcher = matcher;
	}

	public void expireNow() {
		kv.clear();
		load();
		shotOff();
	}

	/** 把全部用户踢出系统,必须重新登录 */
	private void shotOff() {
		List<Object> users = sessionRegistry.getAllPrincipals();
		if (logger.isDebugEnabled())
			logger.debug("当前用户数: " + users.size());
		// 遍历所有用户
		for (Object o : users) {
			if (logger.isDebugEnabled()) {
				UserDetails user = (UserDetails) o;
				logger.debug("当前用户名: " + user.getUsername());
			}
			for (SessionInformation information : sessionRegistry
					.getAllSessions(o, false)) {
				information.expireNow();
				sessionRegistry.removeSessionInformation(information
						.getSessionId());
			}
		}
	}
}