package com.shadow.util.common;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * 图片缩略处理工具类
 * 
 * @author shadow
 */
public class ImageUtil {

	/**
	 * 指定大小进行缩放(自动比例)
	 * 
	 * @param srcFile
	 *            源文件(绝对路径)
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @param destFile
	 *            目标文件(绝对路径)
	 * @throws IOException
	 */
	public void getImg4_width_height_y(String srcFile, int width, int height,
			String destFile) throws IOException {
		/**
		 * size(width,height) 若图片横比200小，高比300小，不变
		 * 若图片横比200小，高比300大，高缩小到300，图片比例不变 / 若图片横比200大，高比300小，横缩小到200，图片比例不变
		 * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
		 */
		// Thumbnails.of("images/test.jpg").size(200,300).toFile("C:/image_200x300.jpg");
		// e.g.
		Thumbnails.of(srcFile).size(width, height).toFile(destFile);
	}

	/**
	 * 指定大小进行缩放(非自动比例)
	 * 
	 * @param srcFile
	 *            源文件(绝对路径)
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @param destFile
	 *            目标文件(绝对路径)
	 * @throws IOException
	 */
	public void getImg4_width_height_n(String srcFile, int width, int height,
			String destFile) throws IOException {
		/**
		 * keepAspectRatio(false) 默认是按照比例缩放的
		 */
		// Thumbnails.of("images/test.jpg").size(120,120).keepAspectRatio(false).toFile("C:/image_120x120.jpg");
		// e.g.
		Thumbnails.of(srcFile).size(width, height).keepAspectRatio(false)
				.toFile(destFile);
	}

	/**
	 * 按照比例进行缩放
	 * 
	 * @param srcFile
	 *            源文件(绝对路径)
	 * @param scale
	 *            比例
	 * @param destFile
	 *            目标文件(绝对路径)
	 * @throws IOException
	 */
	public void getImg4_scale(String srcFile, float scale, String destFile)
			throws IOException {
		/**
		 * scale(比例)
		 */
		// Thumbnails.of("images/test.jpg").scale(0.25f).toFile("C:/image_25%.jpg");
		// e.g.
		Thumbnails.of(srcFile).scale(scale).toFile(destFile);
	}

	/**
	 * 旋转
	 * 
	 * @param srcFile
	 *            源文件(绝对路径)
	 * @param rotate
	 *            角度 正数=顺时针 / 负数=逆时针
	 * @param destFile
	 *            目标文件(绝对路径)
	 * @throws IOException
	 */
	public void getImg4_retate(String srcFile, int rotate, String destFile)
			throws IOException {
		/**
		 * rotate(角度) 正数：顺时针 / 负数：逆时针
		 */
		// Thumbnails.of("images/test.jpg")rotate(90).toFile("C:/image+90.jpg");
		// e.g.
		Thumbnails.of(srcFile).rotate(rotate).toFile(destFile);
	}

	/**
	 * 加水印
	 * 
	 * @param srcFile
	 *            源文件(绝对路径)
	 * @param position
	 *            位置
	 * @param watermarkImg
	 *            水印图
	 * @param transparency
	 *            透明度
	 * @param destFile
	 *            目标文件(绝对路径)
	 * @throws IOException
	 */
	public void getImg4_water(String srcFile, Positions position,
			String watermarkImg, float transparency, String destFile)
			throws IOException {
		/**
		 * watermark(位置，水印图，透明度)
		 */
		// Thumbnails.of("images/test.jpg").watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new
		// File("images/watermark.png")), 0.5f)
		// .outputQuality(0.8f).toFile("C:/image_watermark_bottom_right.jpg");
		// e.g.
		Thumbnails.of(srcFile).watermark(position,
				ImageIO.read(new File(watermarkImg)), transparency).toFile(
				destFile);
	}

	/**
	 * 裁剪
	 * 
	 * @param srcFile
	 *            源文件(绝对路径)
	 * @param position
	 *            位置(不按位置按照具体坐标裁剪时设为null)
	 * @param x
	 *            X轴坐标
	 * @param y
	 *            Y轴坐标
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @param destFile
	 *            目标文件(绝对路径)
	 * @throws IOException
	 */
	public void getImg4_cut(String srcFile, Positions position, int x, int y,
			int width, int height, String destFile) throws IOException {
		/**
		 * 图片中心400*400的区域
		 */
		// Thumbnails.of("images/test.jpg").sourceRegion(Positions.CENTER, 400,
		// 400).keepAspectRatio(false)
		// .toFile("C:/image_region_center.jpg"); e.g.
		/**
		 * 指定坐标
		 */
		// Thumbnails.of("images/test.jpg").sourceRegion(600, 500, 400,
		// 400).keepAspectRatio(false)
		// .toFile("C:/image_region_coord.jpg"); e.g.

		if (position != null) {
			Thumbnails.of(srcFile).sourceRegion(position, width, height)
					.keepAspectRatio(false).toFile(destFile);
		} else {
			Thumbnails.of(srcFile).sourceRegion(x, y, width, height)
					.keepAspectRatio(false).toFile(destFile);
		}
	}

	/**
	 * 转化图像格式
	 * 
	 * @param srcFile
	 *            源文件(绝对路径)
	 * @param fileType
	 *            需转化的文件类型
	 * @param destFile
	 *            目标文件(绝对路径)
	 * @throws IOException
	 */
	public void getImg4_mold(String srcFile, String fileType, String destFile)
			throws IOException {
		/**
		 * outputFormat(图像格式)
		 */
		// Thumbnails.of("images/test.jpg")outputFormat("png").toFile("C:/image_1280x1024.png");
		// e.g.
		Thumbnails.of(srcFile).outputFormat(fileType).toFile(destFile);
	}

}