package com.shadow.spring.db.dynamic;

import javax.annotation.Resource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 获取数据源(依赖SPRING框架)
 * 
 * @author shadow
 * @create 2013.04.03
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	private DataSourceEntry dataSourceEntry;

	@Override
	protected Object determineCurrentLookupKey() {
		return this.dataSourceEntry.get();
	}

	@Resource
	public void setDataSourceEntry(DataSourceEntry dataSourceEntry) {
		this.dataSourceEntry = dataSourceEntry;
	}

}
