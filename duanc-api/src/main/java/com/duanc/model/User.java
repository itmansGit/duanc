package com.duanc.model;

import java.util.Set;

public class User extends MyBaseUser{
	
	private static final long serialVersionUID = -5556460615688866192L;
	/**
	 * 用户id
	 */
	private Integer id;
	
	/**
	 * 用户名
	 */
	private String username;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 手机号码
	 */
	private String phoneNo;
	
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 角色列表
	 */
	private Set<String> roleNames;
	/**
	 * 权限列表
	 */
	private Set<String> permissions;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<String> getRoleNames() {
		return roleNames;
	}
	public void setRoleNames(Set<String> roleNames) {
		this.roleNames = roleNames;
	}
	public Set<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
