package com.shadow.util.common;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 数据源工具类(SPRING)
 * 
 * @author shadow
 * 
 */
public class DataSourceUtil {

	/**
	 * 获取数据源
	 * 
	 * @param driver
	 * @param url
	 * @param username
	 * @param password
	 * @return DataSource
	 */
	public DataSource get(String driver, String url, String username,
			String password) {
		return set(driver, url, username, password);
	}

	/**
	 * 获取数据源
	 * 
	 * @param driver
	 * @param url
	 * @return DataSource
	 */
	public DataSource get(String driver, String url) {
		return set(driver, url, null, null);
	}

	/**
	 * 注册数据源
	 * 
	 * @param driver
	 * @param url
	 * @param username
	 * @param password
	 * @return DataSource
	 */
	private DataSource set(String driver, String url, String username,
			String password) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

}
