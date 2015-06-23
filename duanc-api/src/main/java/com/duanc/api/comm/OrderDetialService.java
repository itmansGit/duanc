package com.duanc.api.comm;

import java.util.List;

import com.duanc.model.base.BaseOrderDetail;

public interface OrderDetialService {
	
	BaseOrderDetail select(String orderId);
	
	boolean delOrderDetail(String orderId);
	
	List<String> getOrderIds(List<Integer> phoneIds);
}
