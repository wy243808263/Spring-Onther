package com.shadow.spring.db.template;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * DAO层扩展模块,由于MyBatis在批处理方法不好操控,特意加入此扩展层来满足开发需求,主要使用SPRING JDBCTEMPLATE的接口
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 * 
 * @param T
 */
public abstract class JdbcDao<T extends Serializable> {

	protected final Logger logger = Logger.getLogger(getClass());

	// SPRING JDBC模板接口
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Resource(name = "jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
