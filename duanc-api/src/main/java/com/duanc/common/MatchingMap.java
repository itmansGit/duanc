package com.duanc.common;

import java.util.HashMap;
import java.util.Map;

import com.duanc.constants.Constants;

public class MatchingMap {
	private Map<Integer, String> map;
	
	/**
	 * @Description: 获取入库状态map 
	 * @author chao.duan
	 */
	public Map<Integer, String> getStorageStatusMap() {
		map = new HashMap<Integer, String>();
		map.put(null, "");
		map.put(Constants.STORAGE_STATUS_IN, Constants.STORAGE_STATUS_IN_NAME);
		map.put(Constants.STORAGE_STATUS_OUT, Constants.STORAGE_STATUS_OUT_NAME);
		return map;
	}
}
