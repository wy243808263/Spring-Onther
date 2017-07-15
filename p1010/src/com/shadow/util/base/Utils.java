package com.shadow.util.base;

import java.util.HashMap;
import java.util.Map;

import com.shadow.security.encrypt.Encoder;
import com.shadow.security.encrypt.impl.MD5Encoder;
import com.shadow.security.util.SecurityUtil;
import com.shadow.security.validate.Validator;
import com.shadow.security.validate.ValidatorImpl;
import com.shadow.spring.util.SpringUtil;
import com.shadow.spring.util.SpringUtilImpl;
import com.shadow.system.dictionary.Language;
import com.shadow.util.common.AcUtil;
import com.shadow.util.common.AcUtilImpl;
import com.shadow.util.common.CommonUtil;
import com.shadow.util.common.CommonUtilImpl;
import com.shadow.util.common.ContextUtil;
import com.shadow.util.common.ContextUtilImpl;
import com.shadow.util.common.DataSourceUtil;
import com.shadow.util.common.FileUtil;
import com.shadow.util.common.FileUtilImpl;
import com.shadow.util.common.ImageUtil;
import com.shadow.util.common.LanguageUtil;
import com.shadow.util.common.PKUtil;
import com.shadow.util.common.PinYinUtil;
import com.shadow.util.common.PinYinUtilImpl;
import com.shadow.util.common.UploadUtil;
import com.shadow.util.common.UploadUtilImpl;

/**
 * 工具集合支持类
 * 
 * @author shadow
 * @create 2013.04.03
 */
public abstract class Utils {

	/** CONTEXT工具类 */
	public static ContextUtil ContextUtil = new ContextUtilImpl();

	/** 基本工具类 */
	public static CommonUtil CommonUtil = new CommonUtilImpl();

	/** 主键分割工具 */
	public static PKUtil PKUtil = new PKUtil();

	/** SPRING工具类 */
	public static SpringUtil SpringUtil = new SpringUtilImpl();

	/** SECURITY工具类 */
	public static SecurityUtil SecurityUtil = new SecurityUtil();

	/** 上传工具类 */
	public static UploadUtil UploadUtil = new UploadUtilImpl();

	/** 文件工具类 */
	public static FileUtil FileUtil = new FileUtilImpl();

	/** 加密工具类(默认使用SECURITY的MD5加密) */
	public static Encoder Encoder = new MD5Encoder();

	/** 校验工具类 */
	public static Validator Validator = new ValidatorImpl();

	/** 敏感字符匹配工具 */
	public static AcUtil AcUtil = new AcUtilImpl();

	/** 拼音转换工具 */
	public static PinYinUtil PinYinUtil = new PinYinUtilImpl();

	/** 语言工具 */
	public static Language LanguageUtil = new LanguageUtil();

	/** 多语言参数值 */
	public static Map<String, Object> TextParams = new HashMap<String, Object>();

	/** 数据源工具类 */
	public static DataSourceUtil DataSourceUtil = new DataSourceUtil();

	/** 图片工具类 */
	public static ImageUtil ImageUtil = new ImageUtil();
}
