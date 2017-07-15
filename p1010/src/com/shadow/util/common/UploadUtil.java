package com.shadow.util.common;

import java.io.File;

/**
 * 上传工具接口
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public interface UploadUtil {

	/** 字符编码 */
	public final static String ENCODING = "UTF-8";

	/**
	 * 上传文件
	 * 
	 * @param fileData
	 * @param fileDataFileName
	 * @param savePath
	 * @return String
	 */
	public String execute(File fileData, String fileDataFileName,
			String savePath);

	/**
	 * 按比例缩略
	 * 
	 * @param filePath
	 * @param per
	 * @return String
	 */
	public String skeletonize(String filePath, float per);

	/**
	 * 按指定长宽比例缩略
	 * 
	 * @param filePath
	 * @param width
	 * @param height
	 * @param per
	 * @return String
	 */
	public String skeletonize(String filePath, int width, int height, float per);
}
