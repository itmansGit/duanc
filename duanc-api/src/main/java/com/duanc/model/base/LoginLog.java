package com.duanc.model.base;

import java.io.Serializable;

/**
 * <p>登录日志</p> 
 * <p>class type : javabean </p> 
 * 
 * <pre>
 * 含成员类:CreatedAndModify cam
 * 已实现序列化
 * </pre> 
 * 
 * @author duanchao
 */
public class LoginLog implements Serializable{

	private static final long serialVersionUID = 4695350419124053891L;
	
	private Integer id;
	private Integer userId;
	private String ip;
	private CreatedAndModify cam;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public CreatedAndModify getCam() {
		return cam;
	}
	public void setCam(CreatedAndModify cam) {
		this.cam = cam;
	}
	
}
