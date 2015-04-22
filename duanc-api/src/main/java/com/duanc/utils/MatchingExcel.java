package com.duanc.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("matchingExcel")
public class MatchingExcel {
	private HashMap<Integer, String> map;
	private List<String> modelList;
	
	private HashMap<Integer, String> getMap() {
		map = new HashMap<Integer, String>();
		map.put(1, "department#部门");
		map.put(2, "subDept#子部门");
		map.put(3, "staffName#姓名");
		
		map.put(4, "officeTime#上班时间");
		map.put(5, "closingTime#下班时间");
		map.put(6, "workTime#工作时长");
		map.put(7, "overTime#加班时长");
		map.put(8, "clickTimes#打卡次数");
		map.put(9, "firstTime#最早打卡时间");
		map.put(10, "lastTime#最晚打卡时间");
		map.put(11, "isWeekend#周末");
		map.put(12, "isHoliday#节假日");
		
		map.put(13, "clickTime#打卡时间");
		
		map.put(14, "month#时间");
		map.put(15, "overTimeSumInMonth#总加班时长");
		map.put(16, "workDateSumInMonth#上班天数");
		return map;
	}
	
	/**
	 * 获取导出excel的成员变量名
	 * @param list
	 * @return
	 * @author chao.duan
	 * @date 2015-1-8 13:52:26
	 * @version 1.0
	 */
	public List<String> getModelMember(List<?> list) {
		map = getMap();
		modelList = new ArrayList<String>();
		for(int i = 0; i < list.size(); i ++) {
			String[] str = map.get(list.get(i)).split("#");
			modelList.add(str[0]);
		}
		return modelList;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 * @author chao.duan
	 * @date 2015-1-8 18:29:08
	 * @version 1.0
	 */
	public List<String> getHeader(List<?> list) {
		map = getMap();
		modelList = new ArrayList<String>();
		for(int i = 0; i < list.size(); i ++) {
			String[] str = map.get(list.get(i)).split("#");
			modelList.add(str[1]);
		}
		return modelList;
	}
}
