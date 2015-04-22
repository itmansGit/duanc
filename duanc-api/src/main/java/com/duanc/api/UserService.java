package com.duanc.api;

import java.util.Set;

import com.duanc.model.User;

public interface UserService {
	
	/**
	 * @Description: 用户登录验证 
	 * @param user
	 * @return User
	 */
	User findUser(User user);
	
	/**
	 * @Description: 通过用户信息获取用户的所有角色 
	 * @param user
	 * @return List<String>
	 */
	Set<String> getRolesByUser(User user);
	
	/**
	 * @Description: 通过用户信息获取用户的所有的权限
	 * @param user
	 * @return Set<String>
	 */
	Set<String> getPremissionsByUser(User user);
}
