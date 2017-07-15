package com.shadow.system.listener;

import java.io.IOException;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 定时器作业
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
@SuppressWarnings("serial")
public class InitTimer extends HttpServlet implements ServletContextListener {

	protected Logger logger = Logger.getLogger(getClass());

	public InitTimer() {
		// do something
	}

	private Timer timer = null; // 时间器

	// private final long INTERVAL_TIME = 600000; // 执行间隔(毫秒)

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel();
		event.getServletContext().log("定时器销毁");
	}

	public void contextInitialized(ServletContextEvent event) {
		timer = new Timer(true);
		event.getServletContext().log("定时器启动");
		// timer.schedule(new OrderTask(event.getServletContext()), 0,
		// INTERVAL_TIME);
		event.getServletContext().log("添加到任务调度表");
	}

}