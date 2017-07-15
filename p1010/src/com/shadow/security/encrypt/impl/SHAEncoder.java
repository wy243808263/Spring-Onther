package com.shadow.security.encrypt.impl;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import com.shadow.security.encrypt.Encoder;


/**
 * SHA加密工具实现类(不支持逆转算法)
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public class SHAEncoder implements Encoder {

	public String decrypt(String password, String key) {
		//不支持该方法抛出UnsupportedOperationException异常
		throw new UnsupportedOperationException("Not supported the mehtod");
	}

	/**
	 * 不添加盐值加密
	 */
	public String encrypt(String password) {
		//使用SPRING SECURITY3里的SHA实现类
		return new ShaPasswordEncoder().encodePassword(password, null);
	}

	/**
	 * 添加盐值加密
	 */
	public String encrypt(String password, String salt) {
		//使用SPRING SECURITY3里的SHA实现类
		return new ShaPasswordEncoder().encodePassword(password, salt);
	}

}
