package com.duanc.api.comm;

import java.util.List;
import java.util.Map;

import com.duanc.model.QO.OrderQO;
import com.duanc.model.dto.OrderDTO;
import com.duanc.utils.Pagination;

public interface OrderService {
	List<OrderDTO> selectUserOrder(int userId);
	
	boolean delOrder(String orderId);
	
	boolean updataOrderStatus(String orderId, byte status);
	
	Map<Byte,String> getOrderStatusMap();
	
	Pagination selectOrderByOrderQO(OrderQO or, Pagination pagination);
}
