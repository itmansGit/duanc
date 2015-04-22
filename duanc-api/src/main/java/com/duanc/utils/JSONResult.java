package com.duanc.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: JSON对象 
 * @author chao.duan
 */
public class JSONResult {
	/**
	 * 成功状态
	 */
	private boolean success;
	/**
	 * 传回信息
	 */
	private String message;
	/**
	 * 传回对象
	 */
	private Object data;
	/**
	 * 传回多个对象
	 */
	private Map<String,Object> map;
	public JSONResult() {
	}
	public JSONResult(boolean success) {
		super();
		this.success = success;
	}
	public JSONResult(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public JSONResult(boolean success, String message, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}
	public JSONResult(boolean success, String message, Map<String, Object> map) {
		super();
		this.success = success;
		this.message = message;
		this.map = map;
	}
	public JSONResult(boolean success, String message, Object data,
			Map<String, Object> map) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
		this.map = map;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Map<String, Object> getMap() {
		map = new HashMap<String, Object>();
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
}
