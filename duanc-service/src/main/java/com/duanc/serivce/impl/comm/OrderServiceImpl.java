package com.duanc.serivce.impl.comm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.UserService;
import com.duanc.api.comm.OrderDetialService;
import com.duanc.api.comm.OrderService;
import com.duanc.inner.common.OrderStatusMatch;
import com.duanc.mapper.base.BrandMapper;
import com.duanc.mapper.base.ModelMapper;
import com.duanc.mapper.base.OrderMapper;
import com.duanc.mapper.base.PhoneMapper;
import com.duanc.mapper.base.UserAddressMapper;
import com.duanc.mapper.base.UserMapper;
import com.duanc.mapper.common.OrderCommonMapper;
import com.duanc.mapper.common.PhoneCommonMapper;
import com.duanc.model.User;
import com.duanc.model.QO.OrderQO;
import com.duanc.model.base.BaseOrder;
import com.duanc.model.base.BaseOrderDetail;
import com.duanc.model.base.BaseOrderExample;
import com.duanc.model.base.BaseOrderExample.Criteria;
import com.duanc.model.base.BasePhone;
import com.duanc.model.base.BaseUser;
import com.duanc.model.base.BaseUserAddress;
import com.duanc.model.dto.OrderDTO;
import com.duanc.model.dto.PhoneDTO;
import com.duanc.utils.Pagination;

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
	
	@Autowired
	private OrderCommonMapper orderCommonMapper;
	
	@Override
	public Map<Byte, String> getOrderStatusMap() {
		List<Byte> list = orderCommonMapper.getOrderStatus();
		Map<Byte, String> map = new HashMap<Byte, String>();
		if(list != null && list.size() >0){
			for (Byte byte1 : list) {
				if(byte1 == 0) {
					map.put(byte1, "待付款");
				} else if(byte1 == 1){
					map.put(byte1, "待发货");
				} else if(byte1 == 2){
					map.put(byte1, "已发货");
				} else if(byte1 == 3){
					map.put(byte1, "已到货");
				} else if(byte1 == 4){
					map.put(byte1, "已签收");
				} else if(byte1 == 5){
					map.put(byte1, "已确认收货");
				} else if(byte1 == 6){
					map.put(byte1, "待退货审核");
				} else if(byte1 == 7){
					map.put(byte1, "退货审核通过");
				} else if(byte1 == 8){
					map.put(byte1, "已退货");
				} else if(byte1 == 9){
					map.put(byte1, "已取消");
				} 
			}
		}
		return map;
	}
	
	@Autowired
	private PhoneCommonMapper phoneCommonMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;
	@Override
	public Pagination selectOrderByOrderQO(OrderQO or, Pagination pagination) {
		/*List<String> orderIds = null;
		if(or.getBrandId() != null) {
			List<Integer> phoneIds = phoneCommonMapper.getPhoneIdByBrandAndModel(or.getBrandId(), or.getModelId());
			orderIds = orderDetialService.getOrderIds(phoneIds);
		}*/
		/*User u = new User();
		if(or.getUsername() != null && or.getUsername().trim() != "") {
			u.setUsername(or.getUsername());
			u = userService.findUser(u);
		}*/
		BaseOrderExample example = new BaseOrderExample();
		Criteria c = example.createCriteria();
		if(or.getOrderId() != null && !"".equals(or.getOrderId().trim())) {
			c.andOrderIdEqualTo(or.getOrderId());
		} else {
			List<String> orderIds = null;
			if(or.getBrandId() != null) {
				PhoneDTO phoneDTO = new PhoneDTO();
				phoneDTO.setBrandId(or.getBrandId());
				phoneDTO.setModelId(or.getModelId());
				List<Integer> phoneIds = phoneCommonMapper.getPhoneIdByBrandAndModel(phoneDTO);
				orderIds = orderDetialService.getOrderIds(phoneIds);
			}
			if(orderIds != null && orderIds.size() > 0) {
				c.andOrderIdIn(orderIds);
			}
		}
		if(or.getUsername() != null && !"".equals(or.getUsername().trim())) {
			User u = new User();
			u.setUsername(or.getUsername());
			u = userService.findUser(u);
			if( u.getId() != null ) {
				c.andUserIdEqualTo(u.getId());
			}
		}
		if(or.getStatus() != null) {
			c.andStatusEqualTo(or.getStatus());
		}
		pagination.setTotal(orderMapper.selectByExample(example).size());
		if(pagination != null) {
			example.setPagination(pagination);
		}
		List<BaseOrder> orders = orderMapper.selectByExample(example);
		List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
		if(orders != null && orders.size() > 0) {
			for (BaseOrder baseOrder : orders) {
				OrderDTO orderDTO = new OrderDTO();
				BaseUserAddress baseUserAddress = userAddressMapper.selectByPrimaryKey(baseOrder.getAddrId());
				BaseOrderDetail baseOrderDetail = orderDetialService.select(baseOrder.getOrderId());
				BasePhone basePhone = phoneMapper.selectByPrimaryKey(baseOrderDetail.getPhoneId());
				BaseUser baseUser = userMapper.selectByPrimaryKey(baseOrder.getUserId());
				
				orderDTO.setBaseUser(baseUser);
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
		pagination.setDataList(orderDTOs);
		return pagination;
	}
	
}
