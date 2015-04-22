package com.duanc.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	/**
	 * 创建cookie
	 * @param key
	 * @param value
	 * @param response
	 * @param time
	 * @author chao.duan
	 */
	public static void addCookie(String key, String value, HttpServletResponse response, int time) {
		Cookie cooki; 
		cooki=new Cookie(key,value);
		cooki.setMaxAge(time);//cookie时间 
		response.addCookie(cooki); 
	}
}
