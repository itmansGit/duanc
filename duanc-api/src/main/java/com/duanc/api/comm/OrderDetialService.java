package com.duanc.api.comm;

import com.duanc.model.base.BaseOrderDetail;

public interface OrderDetialService {
	
	BaseOrderDetail select(String orderId);
	
	boolean delOrderDetail(String orderId);
}
