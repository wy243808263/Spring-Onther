package com.shadow.security.encrypt.impl;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.shadow.security.encrypt.Encoder;

/**
 * MD5加密工具实现类(不支持逆转算法)
 * 
 * @author shadow
 * @email 124010356@qq.com
 * @create 2012.04.28
 */
public class MD5Encoder implements Encoder {

	public String decrypt(String password, String key) {
		// 不支持该方法抛出UnsupportedOperationException异常
		throw new UnsupportedOperationException("Not supported the mehtod");
	}

	public String encrypt(String password) {
		// 使用SPRING SECURITY3里的MD5实现类
		return new Md5PasswordEncoder().encodePassword(password, null);
	}

	public String encrypt(String password, String salt) {
		// 使用SPRING SECURITY3里的MD5实现类
		return new Md5PasswordEncoder().encodePassword(password, salt);
	}

	public static void main(String[] args) {
		System.out.println(new MD5Encoder().encrypt("root", "root"));
	}
}
