package com.duanc.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.duanc.api.comm.OrderService;
import com.duanc.controller.BaseController;
import com.duanc.model.QO.OrderQO;
import com.duanc.utils.JSONResult;
import com.duanc.utils.Pagination;

@Controller
@RequestMapping(value = "/authc")
public class OrderController extends BaseController{
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/order-page")
	public String getOrderPage(OrderQO orderQO, Model model, Pagination pagination){
		
		pagination = orderService.selectOrderByOrderQO(orderQO,pagination);
		model.addAttribute("pagination", pagination);
		initBrand(model);
		initOrderStatus(model);
		return "order/order";
	}
	
	@RequestMapping("/ajax-updata-status")
	@ResponseBody
	public String updataStatus(String orderId, byte status){
		JSONResult jr = new JSONResult();
		if(orderService.updataOrderStatus(orderId, status)) {
			jr.setSuccess(true);
		} else{
			jr.setSuccess(false);
		}
		return JSON.toJSONString(jr);
	}
}
