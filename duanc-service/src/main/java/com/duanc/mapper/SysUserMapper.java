package com.duanc.mapper;

import java.util.Set;

import com.duanc.model.User;

public interface SysUserMapper {
	
	/**
	 * @Description: 查找匹配的用户 
	 * @param user
	 * @return User
	 */
	User getUser(User user);
	
	/**
	 * @Description: 获得用户的所有角色 
	 * @param user
	 * @return Set<String>
	 */
	Set<String> getUsersRoles(User user);
	
	/**
	 * @Description: 获得用户的所有权限
	 * @param user
	 * @return Set<String>
	 */
	Set<String> getUsersPremissions(User user);
}
