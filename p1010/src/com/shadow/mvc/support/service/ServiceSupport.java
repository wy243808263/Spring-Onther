package com.shadow.mvc.support.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;

import com.shadow.mvc.domain.model.Service;
import com.shadow.system.dictionary.DateFormatEntry;
import com.shadow.util.base.Utils;

/**
 * SERVICE层SUPPORT类
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public abstract class ServiceSupport implements DateFormatEntry {

	protected final Logger logger = Logger.getLogger(getClass());

	/** 转换主键集合 */
	public List<Integer> toArray(String string) {
		return Utils.PKUtil.toArray(string);
	}

	/** 获取用户 */
	public UserDetails getUserDetails() {
		return Utils.SecurityUtil.getUserDetails();
	}

	/** 转换字符串为Timestamp */
	public Timestamp getTimestamp(String date) {
		Date d = getDate(date);
		if (d == null)
			return null;
		return new Timestamp(getDate(date).getTime());
	}

	/** 转换字符串为Date */
	public Date getDate(String date) {
		if (date == null || "".equals(date))
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(
				DateFormatEntry.DEFAULT_FORMAT_NORMAL);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/** 获取项目绝对路径 */
	public String getPath() {
		return System.getProperty("webapp.root");
	}

	/** 实例化逻辑封装对象 */
	public Service getService() {
		return new Service();
	}

	/** 实例化参数集合 */
	public Map<String, Object> getMap() {
		return new HashMap<String, Object>();
	}
}