package com.duanc.serivce.impl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.web.RegistService;
import com.duanc.mapper.base.UserAddressMapper;
import com.duanc.mapper.base.UserDataMapper;
import com.duanc.mapper.base.UserMapper;
import com.duanc.model.base.BaseUser;
import com.duanc.model.base.BaseUserAddress;
import com.duanc.model.base.BaseUserData;
import com.duanc.model.base.BaseUserExample;
import com.duanc.model.base.BaseUserExample.Criteria;

@Service("registService")
public class RegistServiceImpl implements RegistService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserDataMapper userDataMapper;
	
	@Override
	public List<BaseUser> selectUser(BaseUser baseUser) {
		BaseUserExample example = new BaseUserExample();
		Criteria c = example.createCriteria();
		if(baseUser.getUsername() != null) {
			c.andUsernameEqualTo(baseUser.getUsername());
		} else if(baseUser.getEmail() != null) {
			c.andEmailEqualTo(baseUser.getEmail());
		} else if(baseUser.getPhoneNo() != null) {
			c.andPhoneNoEqualTo(baseUser.getPhoneNo());
		}
		return userMapper.selectByExample(example);
	}
	
	@Autowired
	private UserAddressMapper userAddressMapper;
	
	@Override
	public boolean regist(BaseUser baseUser) {
		if(userMapper.insert(baseUser) > 0) {
			
			BaseUserData record = new BaseUserData();
			BaseUserExample example = new BaseUserExample();
			Criteria c = example.createCriteria();
			c.andUsernameEqualTo(baseUser.getUsername());
			Integer userId = userMapper.selectByExample(example).get(0).getId();
			record.setUserId(userId);
			
			BaseUserAddress userAddress = new BaseUserAddress();
			userAddress.setUserId(userId);
			
			if(userDataMapper.insert(record) > 0 && userAddressMapper.insert(userAddress) > 0) {
				return true;
			} else{
				return false;
			}
		}
		return false;
	}

}
