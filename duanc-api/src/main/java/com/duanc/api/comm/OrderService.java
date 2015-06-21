package com.duanc.api.comm;

import java.util.List;

import com.duanc.model.dto.OrderDTO;

public interface OrderService {
	List<OrderDTO> selectUserOrder(int userId);
	
	boolean delOrder(String orderId);
	
	boolean updataOrderStatus(String orderId, byte status);
}
