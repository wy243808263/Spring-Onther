package com.shadow.util.common;

import java.util.Properties;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * 文件操作工具类接口
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public interface FileUtil {

	/**
	 * 读取property文件
	 * 
	 * @param filePath
	 * @return Properties
	 */
	public Properties readProperties(String file);

	/**
	 * 读取XML文件返回Document对象
	 * 
	 * @param filePath
	 *            文件路径
	 * @return Document
	 */
	public Document readXML(String filePath);

	/**
	 * 读取跟元素下的节点
	 * 
	 * @param document
	 *            文档
	 * @param tagName
	 *            标签
	 * @return NodeList
	 */
	public NodeList getRootNode(Document document, String tagName);

	/**
	 * 获取指定节点的内容
	 * 
	 * @param fatherName
	 *            父节点标签
	 * @param childName
	 *            子节点标签
	 * @return String
	 */
	public String getContent(NodeList nodes, String fatherName, String childName);
}
