package com.shadow.mvc.domain.model;

import java.io.Serializable;

/**
 * 
 * 文件数据存储对象
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
@SuppressWarnings("serial")
public class File implements Serializable {
	private java.io.File fileData;
	private String fileDataFileName;
	private String fileDataContentType;
	private String filePath;
	private String fileDataFileFakeName;
	private String fileDataFileThumName;
	private String sitePath;
	private String savePath;
	private Serializable id;

	public java.io.File getFileData() {
		return fileData;
	}

	public void setFileData(java.io.File fileData) {
		this.fileData = fileData;
	}

	public String getFileDataFileName() {
		return fileDataFileName;
	}

	public void setFileDataFileName(String fileDataFileName) {
		this.fileDataFileName = fileDataFileName;
	}

	public String getFileDataContentType() {
		return fileDataContentType;
	}

	public void setFileDataContentType(String fileDataContentType) {
		this.fileDataContentType = fileDataContentType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileDataFileFakeName() {
		return fileDataFileFakeName;
	}

	public void setFileDataFileFakeName(String fileDataFileFakeName) {
		this.fileDataFileFakeName = fileDataFileFakeName;
	}

	public String getFileDataFileThumName() {
		return fileDataFileThumName;
	}

	public void setFileDataFileThumName(String fileDataFileThumName) {
		this.fileDataFileThumName = fileDataFileThumName;
	}

	public String getSitePath() {
		return sitePath;
	}

	public void setSitePath(String sitePath) {
		this.sitePath = sitePath;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public Serializable getId() {
		return id;
	}

	public void setId(Serializable id) {
		this.id = id;
	}

}
