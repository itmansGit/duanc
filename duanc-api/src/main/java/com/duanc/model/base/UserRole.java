package com.duanc.model.base;

import java.io.Serializable;

/**
 * 
 * <p>用户角色对应表</p> 
 * <p>class type :  javabean</p>
 * 
 * <pre>
 * 已实现序列化
 * </pre>  
 *
 * @author duanchao
 */
public class UserRole implements Serializable{
	
	private static final long serialVersionUID = -393447944272991398L;
	
	private Integer userId;
	private Integer roleId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
