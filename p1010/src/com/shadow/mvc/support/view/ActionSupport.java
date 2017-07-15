package com.shadow.mvc.support.view;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.shadow.mvc.domain.model.Page;
import com.shadow.util.base.Utils;

/**
 * 基层ACTION
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
public abstract class ActionSupport extends com.opensymphony.xwork2.ActionSupport {

	/** 日志 */
	protected final Logger logger = Logger.getLogger(getClass());

	/** 发送数据到页面 */
	public void flush(Object object) {
		Utils.ContextUtil.flush(object, null);
	}

	/** 序列JSON字符 */
	public String toJSON(Object object) {
		return Utils.ContextUtil.toJSON(object);
	}

	/** 获取REQUEST对象 */
	public HttpServletRequest getRequest() {
		return Utils.ContextUtil.getRequest();
	}

	/** 获取表单参数 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> action = getRequest().getParameterMap(); // 获取MAP数组键值
		for (Map.Entry<String, Object> entry : action.entrySet()) { // 获取具体值
			Object[] objects = (Object[]) entry.getValue();
			if (objects[0] != null && !"".equals(objects[0]))
				params.put(entry.getKey(), objects[0]);
		}
		return pageControl(params);
	}

	/** 分页逻辑控制 */
	private Map<String, Object> pageControl(Map<String, Object> params) {
		if (params.get("action") != null && params.get("action").equals("list")) {
			params = getConverParams(params);
		}
		return params;
	}

	/** 计算当前分页起始值 */
	private Map<String, Object> getConverParams(Map<String, Object> params) {
		int total = 0;
		int offset = 0;
		int limit = 10;
		try {
			total = Integer.valueOf(params.get("total").toString());
			offset = Integer.valueOf(params.get("offset").toString());
			limit = Integer.valueOf(params.get("limit").toString());
		} catch (NumberFormatException e) {
			logger.error("提示: 分页参数类型转换错误异常...");
		}
		Page<Object> page = new Page<Object>();
		page.setCurrent(offset);
		page.setLimit(limit);
		page.setTotal(total);
		params.put("offset", page.getOffset());
		params.put("limit", limit);
		return params;
	}

	/** 填充语言参数值 */
	public void fillTextParams() {
		Map<String, Object> params = Utils.LanguageUtil
				.getParamValues(Utils.TextParams);
		getRequest().getSession().setAttribute("lang", params);
	}

	/** 主键字符串转成集合 */
	protected List<Integer> toArray(String array) {
		return Utils.PKUtil.toArray(array);
	}

	/** 获取项目绝对路径 */
	public String getPath() {
		return System.getProperty("webapp.root");
	}

	protected InputStream inputStream; // 下载流

	protected String fileName; // 下载文件名

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
