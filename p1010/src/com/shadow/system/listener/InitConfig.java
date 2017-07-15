package com.shadow.system.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.shadow.util.base.Utils;
import com.shadow.util.common.LanguageUtil;

/**
 * 系统初始化操作
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
@Component
public class InitConfig implements ServletContextListener {

	private final static Logger logger = Logger.getLogger(InitConfig.class);

	public void contextDestroyed(ServletContextEvent event) {
		// TODO 系统停止时记录必要数据
	}

	/** 初始化入口 */
	public void contextInitialized(ServletContextEvent event) {
		initDefaultLanguage();
	}

	private void initDefaultLanguage() {
		logger.info("开始初始化默认国际化语言...");
		// 必须存在国际化语言配置文件才能初始化成功
		Utils.TextParams = LanguageUtil
				.getTextParams("/language/global_zh_CN.properties");
	}

}
