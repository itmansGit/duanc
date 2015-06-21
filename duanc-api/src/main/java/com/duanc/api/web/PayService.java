package com.duanc.api.web;

import java.util.List;

import com.duanc.model.base.BaseOrder;
import com.duanc.model.base.BaseOrderDetail;
import com.duanc.model.base.BaseUserAddress;

public interface PayService {
	
	List<BaseUserAddress> getUserAddresses(Integer userId);
	
	boolean submitOrder(BaseOrder baseOrder, BaseOrderDetail baseOrderDetail);
}
