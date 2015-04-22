package com.duanc.utils;

public class OptionResult {
	/**
	 * 成功状态
	 */
	private boolean success;
	/**
	 * 传回信息
	 */
	private String message;
	
	public OptionResult() {
		super();
	}
	public OptionResult(boolean success) {
		super();
		this.success = success;
	}
	public OptionResult(String message) {
		super();
		this.message = message;
	}
	public OptionResult(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
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
	
}
