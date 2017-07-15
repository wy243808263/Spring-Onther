package com.shadow.util.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.shadow.util.base.Utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * FREEMARKER生成静态文件工具
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public class FreemarkerUtil {

	// 日志对象
	private final static Logger logger = Logger.getLogger(FreemarkerUtil.class);

	private final static String DEFAULT_ENCODING = "UTF-8"; // 默认编码

	private static FreemarkerUtil freemarkerUtil = new FreemarkerUtil();

	private String encoding;

	private FreemarkerUtil() {
	}

	public String getEncoding() {
		if (null == encoding || "".equals(encoding))
			encoding = DEFAULT_ENCODING;
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public static FreemarkerUtil getInstance() {
		return freemarkerUtil;
	}

	// 配置实例
	private Configuration configuration = null;

	private String ROOT_PATH = Utils.ContextUtil.getRealPath("/");

	// 获取freemarker的配置类. freemarker本身支持classpath,目录和从ServletContext获取.
	protected Configuration getFreeMarkerConfiguration() {
		if (null == configuration) {

			// 初始化freemarker实例
			configuration = new Configuration();

			// 设置实例的编码格式
			configuration.setDefaultEncoding(getEncoding());

			// 读取模版路径
			configuration.setServletContextForTemplateLoading(
					ServletActionContext.getServletContext(), "");
		}
		return configuration;
	}

	/**
	 * 
	 * @param ftlPath
	 *            模板文件名,相对项目路径,例如 "template/test.ftl"
	 * @param params
	 *            用于处理模板的属性Object映射
	 * @param dirs
	 *            要生成的静态文件的路径,相对设置中的根路径,例如 "template/test/test2"
	 * @param htmlName
	 *            静态文件名
	 * @return String 返回静态文件的路径,格式"/xx/xx.html"
	 */
	public String creat(String ftlPath, String dirPath, String htmlName,
			Map<String, Object> params) {
		return produce(ROOT_PATH, ftlPath, dirPath, htmlName, params);
	}

	/**
	 * 
	 * @param root
	 *            自定义绝对路径
	 * @param ftlPath
	 *            模板文件名,相对项目路径,例如 "template/test.ftl"
	 * @param params
	 *            用于处理模板的属性Object映射
	 * @param dirPath
	 *            要生成的静态文件的路径,相对设置中的根路径,例如 "template/test/test2"
	 * @param htmlName
	 *            静态文件名
	 * @return String 返回静态文件的路径,格式"/xx/xx.html"
	 */
	public String creat(String root, String ftlPath, String dirPath,
			String htmlName, Map<String, Object> params) {
		return produce(root, ftlPath, dirPath, htmlName, params);
	}

	private String produce(String root, String ftlPath, String dirPath,
			String htmlName, Map<String, Object> params) {
		try {
			// 加载模版
			Template template = getFreeMarkerConfiguration().getTemplate(
					"/" + ftlPath);

			// 设置模版的编码
			template.setEncoding(getEncoding());

			// 判断目录是否存在,不存在则自动创建
			String dirsPath = creatDirs(root, dirPath);

			// 创建文件流
			File file = new File(root + dirsPath + htmlName);

			// 输出文件流
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file), getEncoding()));

			// 将属性设置到模版里
			template.process(params, out);
			out.flush();
			out.close();

			// 返回生成文件的路径
			return "/" + dirsPath + htmlName;
		} catch (TemplateException e) {
			logger.error(ftlPath, e);
			return null;
		} catch (IOException e) {
			logger.error(ftlPath, e);
			return null;
		}
	}

	/**
	 * 文件目录检测
	 * 
	 * @param root
	 *            当前所在路径
	 * @param dirs
	 *            文件目录
	 * @return String 返回目录结构
	 */
	private String creatDirs(String root, String dirPath) {
		StringBuffer buffer = new StringBuffer("");
		if (StringUtils.isNotEmpty(dirPath)) {
			String[] dirs = StringUtils.split(dirPath, "/|\\$");
			for (String dir : dirs) {
				buffer.append(dir).append("/");
			}
			File file = null;
			if (!"".equals(buffer.toString())) {
				file = new File(root + buffer.toString());
				if (!file.exists())
					file.mkdirs();
			}
		}
		return buffer.toString();
	}

}
