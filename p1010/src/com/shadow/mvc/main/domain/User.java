package com.shadow.mvc.main.domain;

import java.util.List;

import com.shadow.mvc.domain.base.AbstractUser;

/**
 * 用户实体
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
public class User extends AbstractUser {

	private Integer id; // 编号

	private String name; // 姓名

	private Integer level; // 优先级 1.最高

	private Integer status; // 状态 1.正常 2.冻结 3.删除 4.异常

	private String phone; // 联系电话

	private String email; // 邮箱

	private List<Group> groups; // 所属分组

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}