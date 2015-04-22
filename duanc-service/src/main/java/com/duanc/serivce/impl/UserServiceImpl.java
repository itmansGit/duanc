package com.duanc.serivce.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.UserService;
import com.duanc.mapper.UserMapper;
import com.duanc.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findUser(User user) {
		user = userMapper.getUser(user);
		return user;
	}

	@Override
	public Set<String> getRolesByUser(User user) {
		return userMapper.getUsersRoles(user);
	}

	@Override
	public Set<String> getPremissionsByUser(User user) {
		return userMapper.getUsersPremissions(user);
	}

}
