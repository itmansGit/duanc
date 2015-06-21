package com.duanc.api.web;

import java.util.List;

import com.duanc.model.base.BaseUser;

public interface RegistService {
	
	public List<BaseUser> selectUser(BaseUser baseUser);
	
	public boolean regist(BaseUser baseUser);
	
}
