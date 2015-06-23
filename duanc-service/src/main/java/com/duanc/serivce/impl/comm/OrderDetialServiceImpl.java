package com.duanc.serivce.impl.comm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.comm.OrderDetialService;
import com.duanc.mapper.base.OrderDetailMapper;
import com.duanc.model.base.BaseOrderDetail;
import com.duanc.model.base.BaseOrderDetailExample;
import com.duanc.model.base.BaseOrderDetailExample.Criteria;

@Service("orderDetialService")
public class OrderDetialServiceImpl implements OrderDetialService{
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	@Override
	public BaseOrderDetail select(String orderId) {
		BaseOrderDetailExample example = new BaseOrderDetailExample();
		Criteria c = example.createCriteria();
		c.andOrderIdEqualTo(orderId);
		List<BaseOrderDetail> list = orderDetailMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public boolean delOrderDetail(String orderId) {
		BaseOrderDetailExample example = new BaseOrderDetailExample();
		Criteria c = example.createCriteria();
		c.andOrderIdEqualTo(orderId);
		if(orderDetailMapper.deleteByExample(example) > 0){
			return true;
		}
		return false;
	}

	@Override
	public List<String> getOrderIds(List<Integer> phoneIds) {
		BaseOrderDetailExample example = new BaseOrderDetailExample();
		Criteria c = example.createCriteria();
		c.andPhoneIdIn(phoneIds);
		List<BaseOrderDetail> list = orderDetailMapper.selectByExample(example);
		List<String> orderIds = new ArrayList<>();
		if (list != null && list.size() >0) {
			for (BaseOrderDetail baseOrderDetail : list) {
				orderIds.add(baseOrderDetail.getOrderId());
			}
		}
		return orderIds;
	}

}
