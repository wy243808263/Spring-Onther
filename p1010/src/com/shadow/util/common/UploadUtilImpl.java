package com.shadow.util.common;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 
 * 文件管理工具
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public class UploadUtilImpl implements UploadUtil {

	public String execute(File fileData, String fileDataFileName,
			String savePath) {

		String extName = "";// 扩展名
		String newName = "";// 新文件名
		String nowTime = "";// 当前时间

		// 防止文件名重复
		synchronized (this) {
			nowTime = new SimpleDateFormat("yyyymmddHHmmss").format(new Date());
		}

		File file = new File(savePath);
		if (!file.exists())
			file.mkdirs();

		// 获取扩展名
		if (fileDataFileName.lastIndexOf(".") >= 0)
			extName = fileDataFileName.substring(fileDataFileName
					.lastIndexOf("."));

		newName = nowTime + extName;

		// 创建文件夹
		File saveDir = new File(savePath);
		if (!saveDir.exists())
			saveDir.mkdirs();

		// 把源文件拷贝到保存目录下
		fileData.renameTo(new File(savePath + "\\" + newName));

		return newName;
	}

	public String skeletonize(String filePath, float per) {

		File file = new File(filePath); // 读入刚才上传的文件
		String newName = "thum_" + file.getName();
		Image src;
		try {
			src = javax.imageio.ImageIO.read(file);
			// 构造Image对象
			int old_w = src.getWidth(null); // 得到源图宽
			int old_h = src.getHeight(null);
			int new_w = 0;
			int new_h = 0; // 得到源图长

			new_w = Math.round(old_w / per);
			new_h = Math.round(old_h / per);// 计算新图长宽

			BufferedImage tag = new BufferedImage(new_w, new_h,
					BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(src, 0, 0, new_w, new_h, null); // 绘制缩小后的图
			FileOutputStream newimage = new FileOutputStream(file.getParent()
					+ "\\" + newName); // 输出到文件流
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
			encoder.encode(tag); // 近JPEG编码
			newimage.close();
			return newName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param file
	 *            图片文件
	 * @param w
	 *            目标宽 *
	 * @param h
	 *            目标高 *
	 * @param per
	 *            百分比
	 */
	public String skeletonize(String filePath, int width, int height, float per) {
		Image src;
		try {
			File file = new File(filePath);
			src = javax.imageio.ImageIO.read(file);
			// 构造Image对象
			String newName = "thum_" + file.getName();

			int old_w = src.getWidth(null); // 得到源图宽
			int old_h = src.getHeight(null);
			int new_w = 0;
			int new_h = 0; // 得到源图长
			double w2 = (old_w * 1.00) / (width * 1.00);
			double h2 = (old_h * 1.00) / (height * 1.00);
			// 图片跟据长宽留白，成一个正方形图。
			BufferedImage oldpic;
			if (old_w > old_h) {
				oldpic = new BufferedImage(old_w, old_w,
						BufferedImage.TYPE_INT_RGB);
			} else {
				if (old_w < old_h)
					oldpic = new BufferedImage(old_h, old_h,
							BufferedImage.TYPE_INT_RGB);
				else
					oldpic = new BufferedImage(old_w, old_h,
							BufferedImage.TYPE_INT_RGB);
			}
			Graphics2D g = oldpic.createGraphics();
			g.setColor(Color.white);
			if (old_w > old_h) {
				g.fillRect(0, 0, old_w, old_w);
				g.drawImage(src, 0, (old_w - old_h) / 2, old_w, old_h,
						Color.white, null);
			} else {
				if (old_w < old_h) {
					g.fillRect(0, 0, old_h, old_h);
					g.drawImage(src, (old_h - old_w) / 2, 0, old_w, old_h,
							Color.white, null);
				} else {
					// g.fillRect(0,0,old_h,old_h);
					g.drawImage(src.getScaledInstance(old_w, old_h,
							Image.SCALE_SMOOTH), 0, 0, null);
				}
			}
			g.dispose();
			src = oldpic;
			// 图片调整为方形结束
			if (old_w > width)
				new_w = (int) Math.round(old_w / w2);
			else
				new_w = old_w;
			if (old_h > height)
				new_h = (int) Math.round(old_h / h2);// 计算新图长宽
			else
				new_h = old_h;
			BufferedImage tag = new BufferedImage(new_w, new_h,
					BufferedImage.TYPE_INT_RGB);
			// tag.getGraphics().drawImage(src,0,0,new_w,new_h,null);
			// 绘制缩小后的图
			tag.getGraphics().drawImage(
					src.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0,
					0, null);
			FileOutputStream newimage = new FileOutputStream(file.getParent()
					+ "\\" + newName); // 输出到文件流
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
			/* 压缩质量 */
			jep.setQuality(per, true);
			encoder.encode(tag, jep);
			// encoder.encode(tag);
			// 近JPEG编码
			newimage.close();
			return newName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		// 文件的重定向测试
		File file = new File("E:\\111.JPG");
		UploadUtil uploadUtil = new UploadUtilImpl();
		String savePath = "D:\\";
		uploadUtil.execute(file, "", savePath);
		/*
		 * UploadUtil uploadUtil = new UploadUtilImpl();
		 * uploadUtil.skeletonize("E:\\111.jpg", 300, 400, 1f);
		 */

		// uploadUtil.skeletonize("E:\\111.jpg", 1.5f);
	}
}
