package com.shadow.security.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.shadow.mvc.main.domain.Group;
import com.shadow.mvc.main.domain.Res;
import com.shadow.mvc.main.domain.Role;
import com.shadow.mvc.main.domain.User;
import com.shadow.mvc.main.service.RoleService;
import com.shadow.mvc.main.service.UserService;
import com.shadow.security.model.GrantedResource;
import com.shadow.security.model.SimpleGrantedResource;

/**
 * SPRING SECURITY3用户登录处理
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserService userService;
	private RoleService roleService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@SuppressWarnings("unchecked")
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		// 使用User服务类查询数据用户是否存在,如不存在或密码错误则抛出对应的异常
		List<User> users = (List<User>) this.userService.findByUserName(
				username).getValue();

		// 判断用户是否存在
		if (users == null || users.isEmpty())
			throw new UsernameNotFoundException("用户/密码错误,请重新输入!");

		// 获取首个用户名
		User user = users.get(0);
		return init(user);
	}

	/** 初始化 */
	private User init(User user) {

		List<Group> groups = user.getGroups();

		if (groups == null || groups.isEmpty())
			throw new UsernameNotFoundException("尚未分配权限组!");

		// 分组权限集合
		Set<Role> roles = new HashSet<Role>();
		for (Group group : groups) {
			roles.addAll(group.getRoles());
		}

		// 角色权限集合
		Collection<GrantedAuthority> gaRoles = new HashSet<GrantedAuthority>();
		Collection<GrantedResource> gaRess = new HashSet<GrantedResource>();

		for (Role role : roles) {
			gaRoles.add(new SimpleGrantedAuthority(role.getName()));
			role = (Role) this.roleService.findById(role).getValue();
			if (role.getRess() != null && !role.getRess().isEmpty())
				for (Res res : role.getRess()) { // 取出角色所拥有的资源
					gaRess.add(new SimpleGrantedResource(res.getUri()));
				}
		}

		if (gaRoles == null || gaRoles.isEmpty())
			throw new UsernameNotFoundException("权限不足!");

		user.setAuthorities(gaRoles);
		user.setResources(gaRess);

		return user;
	}
}