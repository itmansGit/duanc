package com.duanc.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duanc.api.web.PayService;
import com.duanc.api.web.ShowService;
import com.duanc.model.User;
import com.duanc.model.base.BaseOrder;
import com.duanc.model.base.BaseOrderDetail;
import com.duanc.model.base.BaseUserAddress;
import com.duanc.model.dto.PhoneDTO;
import com.duanc.utils.IDAutogenerationUtil;

@Controller
@RequestMapping(value = "/booking")
public class BookingController {
	@Autowired
	private ShowService showService;
	@Autowired
	private PayService payService;
	
	@RequestMapping(value = "")
	public String getPayPage(Integer phoneId, Model model, HttpServletRequest request){
		User u = (User) request.getSession().getAttribute("current_user");
		if(u == null) {
			return "redirect:/index/index";
		}
		String orderId = IDAutogenerationUtil.createIdWithRandom();
		model.addAttribute("orderId", orderId);
		
		BaseUserAddress userAddress = payService.getUserAddresses(u.getId()).get(0);
		model.addAttribute("userAddress", userAddress);
		
		PhoneDTO phone = showService.getPhoneDTO(phoneId);
		model.addAttribute("phone", phone);
		
		BaseOrder order = new BaseOrder();
		order.setAddrId(userAddress.getId());
		order.setOrderId(orderId);
		order.setOrderPrice(phone.getPrice());
		order.setUserId(u.getId());
		request.getSession().setAttribute("order", order);
		
		BaseOrderDetail baseOrderDetail = new BaseOrderDetail();
		baseOrderDetail.setNumber(1);
		baseOrderDetail.setPhoneId(phone.getId());
		baseOrderDetail.setOrderId(orderId);
		baseOrderDetail.setPrice(phone.getPrice());
		baseOrderDetail.setCreatedUser(u.getId());
		request.getSession().setAttribute("orderDetial", baseOrderDetail);
		
		return "booking";
	}
	
	@RequestMapping(value = "/submit")
	public String pay(Model model, HttpServletRequest request){
		BaseOrder order = (BaseOrder) request.getSession().getAttribute("order");
		BaseOrderDetail baseOrderDetail = (BaseOrderDetail) request.getSession().getAttribute("orderDetial");
		if(order == null || baseOrderDetail == null) {
			return "redirect:/index/index";
		}
		payService.submitOrder(order, baseOrderDetail);
		return "redirect:/shop/page";
	}
}
