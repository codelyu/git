package com.sxt.sys.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Utils {

	public static void main(String[] args) {
		String password1=new Md5Hash("123456").toString();
		System.out.println("MD5默认加密码后:"+password1);
		//在password1的基础再加密  散列2次
		String password2=new Md5Hash(password1).toString();
		System.out.println("MD5两次加密码后:"+password2);
		//在password2的基础再加密  散列3次
		String password3=new Md5Hash(password2).toString();
		System.out.println("MD5三次加密码后:"+password3);
		
		String pwd="123456";
		//默认散列一次  一次盐
		String password4=new Md5Hash(pwd, "张三武汉").toString();
		System.out.println("MD5散列一次 加盐:"+password4);
		//散列二次  加盐
		String password5=new Md5Hash(pwd, "李四武汉", 2).toString();
		System.out.println("MD5散列二次 加盐:"+password5);
	}
	
	/**
	 * 生成加密码后的密码
	 * @param source 密码明文
	 * @param salt  盐
	 * @param hashIterations  散列次数
	 * @return
	 */
	public static String encodePasswordUseMd5(Object source, Object salt, int hashIterations) {
		return new Md5Hash(source, salt, hashIterations).toString();
	}
}
