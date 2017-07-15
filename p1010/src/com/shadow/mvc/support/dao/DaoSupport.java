package com.shadow.mvc.support.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 抽象JDBC基层类
 * 
 * @author Administrator
 * 
 */
public abstract class DaoSupport {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Resource(name = "jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
