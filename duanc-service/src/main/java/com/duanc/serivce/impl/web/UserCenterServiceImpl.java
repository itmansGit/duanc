package com.duanc.serivce.impl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.web.UserCenterService;
import com.duanc.mapper.base.UserAddressMapper;
import com.duanc.mapper.base.UserDataMapper;
import com.duanc.mapper.base.UserMapper;
import com.duanc.model.base.BaseUser;
import com.duanc.model.base.BaseUserAddress;
import com.duanc.model.base.BaseUserData;
import com.duanc.model.base.BaseUserDataExample;
import com.duanc.model.base.BaseUserDataExample.Criteria;

@Service("userCenterService")
public class UserCenterServiceImpl implements UserCenterService{
	@Autowired
	private UserDataMapper userDataMapper;
	@Autowired
	private UserAddressMapper userAddressMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public boolean updataUserData(BaseUserData baseUserData) {
		BaseUserDataExample example = new BaseUserDataExample();
		Criteria c = example.createCriteria();
		c.andUserIdEqualTo(baseUserData.getUserId());
		List<BaseUserData> list = userDataMapper.selectByExample(example);
		Integer key = list.get(0).getId();
		baseUserData.setId(key);
		if(userDataMapper.updateByPrimaryKey(baseUserData) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updataPassword(BaseUser user) {
		if(userMapper.updateByPrimaryKey(user) > 0){
			return true;
		}
		return false;
	}


	@Override
	public boolean updataUserAddress(BaseUserAddress baseUserAddress) {
		if(userAddressMapper.updateByPrimaryKey(baseUserAddress) > 0){
			return true;
		}
		return false;
	}
}
