package com.duanc.api.web;

import com.duanc.model.base.BaseUser;
import com.duanc.model.base.BaseUserAddress;
import com.duanc.model.base.BaseUserData;

public interface UserCenterService {
	boolean updataUserData(BaseUserData baseUserData);
	
	boolean updataUserAddress(BaseUserAddress baseUserAddress);
	
	boolean updataPassword(BaseUser user);
	
	/*List<OrderDTO> selectUserOrder(int userId);*/
}
