package com.duanc.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName: IDAutogenerationUtil 
 * @Description: ID自动生成 
 * @author duanchao 
 */
public class IDAutogenerationUtil {
	/**
	 * @Description: 2015041316363902 
	 * @author chao.duan
	 */
	public static String createIdWithRandom() {
		Random random = new Random();
		int i = random.nextInt(10);
		String iStr = "";
		if(i < 10) {
			iStr = "0" + i;
		} else {
			iStr = "" + i;
		}
		return createId() + iStr;
	}
	
	/**
	 * @Description: 20150413163715 
	 * @author chao.duan
	 */
	public static String createId() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hh = calendar.get(Calendar.HOUR_OF_DAY);
		String hStr = "";
		if(hh < 10) {
			hStr = "0" + hh;
		} else {
			hStr += hh;
		}
		
		int mm = calendar.get(Calendar.MINUTE);
		String mStr = ""; 
		if(mm < 10) {
			mStr = "0" + mm;
		} else {
			mStr += mm;
		}
		
		int ss = calendar.get(Calendar.SECOND);
		String sStr = ""; 
		if(ss < 10) {
			sStr = "0" + ss;
		} else {
			sStr += ss;
		}
		return createIdByDate() + hStr + mStr + sStr ;
	}
	
	/**
	 * @Description: 20150413 
	 * @author chao.duan
	 */
	public static String createIdByDate() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int yy = calendar.get(Calendar.YEAR);
		
		int MM = calendar.get(Calendar.MONTH) + 1;
		String Mstr = "";
		if(MM < 10) {
			Mstr = "0" + MM;
		} else {
			Mstr += MM;
		}
		
		int dd = calendar.get(Calendar.DATE);
		String dStr = "";
		if(dd < 10) {
			dStr = "0" + dd; 
		} else {
			dStr += dd;
		}
		return yy + Mstr + dStr ;
	}
	
	public static void main(String[] args) {
		System.out.println(createIdWithRandom());
	}
}
