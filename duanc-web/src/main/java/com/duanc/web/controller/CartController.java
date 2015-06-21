package com.duanc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.duanc.api.web.CartService;
import com.duanc.api.web.ShowService;
import com.duanc.model.User;
import com.duanc.model.base.BaseCart;
import com.duanc.model.dto.PhoneDTO;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
	@Autowired
	private ShowService showService;
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "")
	public String getCartPage(HttpServletRequest request) {
		User u = (User) request.getSession().getAttribute("current_user");
		if(u != null) {
			List<BaseCart> list = cartService.getCarts(u.getId());
			if(list != null && list.size() != 0) {
				BaseCart baseCart = list.get(0);
				List<PhoneDTO> carts = (List<PhoneDTO>) JSON.parseArray(baseCart.getCarts(), PhoneDTO.class);
				request.getSession().setAttribute("cartList", carts);
			} 
		}
		return "/user/cart";
	}
	
	@RequestMapping(value = "/ajax-addToCart")
	@ResponseBody
	public String addToCart(Integer phoneId, HttpServletRequest request){
		if(phoneId != null ) {
			PhoneDTO phone = showService.getPhoneDTO(phoneId);
			if(phone != null) {
				User u = (User) request.getSession().getAttribute("current_user");
				if(u != null) {
					List<BaseCart> list = cartService.getCarts(u.getId());
					if(list == null || list.size() == 0) {
						BaseCart baseCart = new BaseCart();
						baseCart.setCarts(JSON.toJSONString(phone));
						baseCart.setUserId(u.getId());
						cartService.addToCart(baseCart);
					} else {
						BaseCart baseCart = list.get(0);
						List<PhoneDTO> carts = (List<PhoneDTO>) JSON.parseArray(baseCart.getCarts(), PhoneDTO.class);
						carts.add(phone);
						String json = JSON.toJSONString(carts);
						baseCart.setCarts(json);
						cartService.updataCarts(baseCart, u.getId());
					}
					return JSON.toJSONString(true);
				} else {
					@SuppressWarnings("unchecked")
					List<PhoneDTO> cartList = (List<PhoneDTO>) request.getSession().getAttribute("cartList");
					if(cartList == null) {
						cartList = new ArrayList<PhoneDTO>();
					}
					cartList.add(phone);
					request.getSession().setAttribute("cartList", cartList);
					return JSON.toJSONString(true);
				}
			}
		}
		return JSON.toJSONString(false);
	}
	
	@RequestMapping(value = "/ajax-removeFromCart")
	@ResponseBody
	public String removeFromCart(Integer phoneId, HttpServletRequest request){
		if(phoneId != null ) {
			PhoneDTO phone = showService.getPhoneDTO(phoneId);
			if(phone != null) {
				
				User u = (User) request.getSession().getAttribute("current_user");
				if(u != null) {
					List<BaseCart> list = cartService.getCarts(u.getId());
					if(list != null && list.size() != 0) {
						BaseCart baseCart = list.get(0);
						List<PhoneDTO> cartList = (List<PhoneDTO>) JSON.parseArray(baseCart.getCarts(), PhoneDTO.class);
						for (int i = 0; i < cartList.size(); i++) {
							if(cartList.get(i).getId() == phone.getId()) {
								cartList.remove(i);
							}
						}
						baseCart.setCarts(JSON.toJSONString(cartList));
						cartService.updataCarts(baseCart, u.getId());
						return JSON.toJSONString(true);
					} 
				} else {
					@SuppressWarnings("unchecked")
					List<PhoneDTO> cartList = (List<PhoneDTO>) request.getSession().getAttribute("cartList");
					for (int i = 0; i < cartList.size(); i++) {
						if(cartList.get(i).getId() == phone.getId()) {
							cartList.remove(i);
						}
					}
					request.getSession().setAttribute("cartList", cartList);
					return JSON.toJSONString(true);
				}
			}
		}
		return JSON.toJSONString(false);
	}
	
	@RequestMapping(value = "/ajax-removeListFromCart")
	@ResponseBody
	public String removeListFromCart(@RequestParam("arr[]") Integer[] arr, HttpServletRequest request){
		if(arr != null && arr.length != 0) {
			@SuppressWarnings("unchecked")
			List<PhoneDTO> cartList = (List<PhoneDTO>) request.getSession().getAttribute("cartList");
			for (Integer integer : arr) {
				PhoneDTO phone = showService.getPhoneDTO(integer);
				if(phone != null) {
					
					User u = (User) request.getSession().getAttribute("current_user");
					if(u != null) {
						List<BaseCart> list = cartService.getCarts(u.getId());
						if(list != null && list.size() != 0) {
							BaseCart baseCart = list.get(0);
							List<PhoneDTO> carts = (List<PhoneDTO>) JSON.parseArray(baseCart.getCarts(), PhoneDTO.class);
							for (int i = 0; i < carts.size(); i++) {
								if(carts.get(i).getId() == phone.getId()) {
									carts.remove(i);
								}
							}
							baseCart.setCarts(JSON.toJSONString(carts));
							cartService.updataCarts(baseCart, u.getId());
							return JSON.toJSONString(true);
						} 
					} else {
						for (int i = 0; i < cartList.size(); i++) {
							if(cartList.get(i).getId() == phone.getId()) {
								cartList.remove(i);
							}
						}
					}
				}
			}
			request.getSession().setAttribute("cartList", cartList);
			return JSON.toJSONString(true);
		}
		return JSON.toJSONString(false);
	}
}
