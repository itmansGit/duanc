package com.duanc.serivce.impl.comm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.comm.OrderDetialService;
import com.duanc.api.comm.OrderService;
import com.duanc.inner.common.OrderStatusMatch;
import com.duanc.mapper.base.BrandMapper;
import com.duanc.mapper.base.ModelMapper;
import com.duanc.mapper.base.OrderMapper;
import com.duanc.mapper.base.PhoneMapper;
import com.duanc.mapper.base.UserAddressMapper;
import com.duanc.model.base.BaseOrder;
import com.duanc.model.base.BaseOrderDetail;
import com.duanc.model.base.BaseOrderExample;
import com.duanc.model.base.BaseOrderExample.Criteria;
import com.duanc.model.base.BasePhone;
import com.duanc.model.base.BaseUserAddress;
import com.duanc.model.dto.OrderDTO;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private UserAddressMapper userAddressMapper;
	@Autowired
	private OrderDetialService orderDetialService;
	@Autowired
	private PhoneMapper phoneMapper;
	@Autowired
	private BrandMapper brandMapper;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<OrderDTO> selectUserOrder(int userId) {
		BaseOrderExample example = new BaseOrderExample();
		Criteria c = example.createCriteria();
		c.andUserIdEqualTo(userId);
		byte b0 = 0;
		byte b8 = 8;
		c.andStatusBetween(b0, b8);
		List<BaseOrder> orders = orderMapper.selectByExample(example);
		List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
		if(orders != null && orders.size() > 0) {
			for (BaseOrder baseOrder : orders) {
				OrderDTO orderDTO = new OrderDTO();
				BaseUserAddress baseUserAddress = userAddressMapper.selectByPrimaryKey(baseOrder.getAddrId());
				BaseOrderDetail baseOrderDetail = orderDetialService.select(baseOrder.getOrderId());
				BasePhone basePhone = phoneMapper.selectByPrimaryKey(baseOrderDetail.getPhoneId());
				orderDTO.setBasePhone(basePhone);
				orderDTO.setBaseOrderDetail(baseOrderDetail);
				orderDTO.setBaseUserAddress(baseUserAddress);
				orderDTO.setBaseOrder(baseOrder);
				//status状态码转意义
				orderDTO.setStatus(new OrderStatusMatch().getOrderStatus(baseOrder.getStatus()));
				//brandName
				orderDTO.setBrandName(brandMapper.selectByPrimaryKey(basePhone.getBrandId()).getBrandName());
				orderDTO.setModelName(modelMapper.selectByPrimaryKey(basePhone.getModelId()).getModelName());
				orderDTOs.add(orderDTO);
			}
		}
		return orderDTOs;
	}
	
	@Override
	public boolean delOrder(String orderId) {
		BaseOrderExample example = new BaseOrderExample();
		Criteria c = example.createCriteria();
		c.andOrderIdEqualTo(orderId);
		if(orderMapper.deleteByExample(example) > 0 && orderDetialService.delOrderDetail(orderId)){
			return true;
		}
		return false;
	}

	@Override
	public boolean updataOrderStatus(String orderId, byte status) {
		BaseOrderExample example = new BaseOrderExample();
		Criteria c = example.createCriteria();
		c.andOrderIdEqualTo(orderId);
		List<BaseOrder> orders = orderMapper.selectByExample(example);
		if(orders != null && orders.size() > 0) {
			BaseOrder baseOrder = orders.get(0);
			baseOrder.setStatus(status);
			if(orderMapper.updateByPrimaryKey(baseOrder) > 0){
				return true;
			}
		}
		return false;
	}

}
