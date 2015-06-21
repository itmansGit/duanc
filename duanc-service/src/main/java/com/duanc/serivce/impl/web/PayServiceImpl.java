package com.duanc.serivce.impl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.web.PayService;
import com.duanc.mapper.base.OrderDetailMapper;
import com.duanc.mapper.base.OrderMapper;
import com.duanc.mapper.base.UserAddressMapper;
import com.duanc.model.base.BaseOrder;
import com.duanc.model.base.BaseOrderDetail;
import com.duanc.model.base.BaseUserAddress;
import com.duanc.model.base.BaseUserAddressExample;
import com.duanc.model.base.BaseUserAddressExample.Criteria;

@Service("payService")
public class PayServiceImpl implements PayService{

	@Autowired
	private UserAddressMapper userAddressMapper;
	
	@Override
	public List<BaseUserAddress> getUserAddresses(Integer userId) {
		BaseUserAddressExample example = new BaseUserAddressExample();
		Criteria c = example.createCriteria();
		c.andUserIdEqualTo(userId);
		return userAddressMapper.selectByExample(example);
	}
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	@Override
	public boolean submitOrder(BaseOrder baseOrder,BaseOrderDetail baseOrderDetail) {
		byte b = 0;
		baseOrder.setStatus(b);
		baseOrder.setType(b);
		int i = orderMapper.insert(baseOrder);
		if(i > 0) {
			if(orderDetailMapper.insert(baseOrderDetail) > 0){
				return true;
			}
		}
		return false;
	}

}
