package com.duanc.web.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.duanc.api.UserService;
import com.duanc.api.web.CartService;
import com.duanc.model.User;
import com.duanc.model.base.BaseCart;
import com.duanc.model.dto.PhoneDTO;
import com.duanc.utils.MD5Util;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping("/login")
	@ResponseBody
	public String webLogin(User user, Boolean rememberMe, HttpServletRequest request) {
		user.setPassword(MD5Util.getMd5(user.getPassword()));
		User u = userService.findUser(user);
		boolean data = false;
		if(u != null) {
			request.getSession().setAttribute("current_user", u);
			
			@SuppressWarnings("unchecked")
			List<PhoneDTO> cartList = (List<PhoneDTO>) request.getSession().getAttribute("cartList");
			List<BaseCart> list = cartService.getCarts(u.getId());
			if(list == null || list.size() == 0) {
				if(cartList != null && cartList.size() > 0) {
					String json = JSON.toJSONString(cartList);
					BaseCart baseCart = new BaseCart();
					baseCart.setCarts(json);
					baseCart.setUserId(u.getId());
					cartService.addToCart(baseCart);
				}
			}else {
				BaseCart baseCart = list.get(0);
				if(cartList != null && cartList.size() > 0) {
					List<PhoneDTO> carts = (List<PhoneDTO>) JSON.parseArray(baseCart.getCarts(), PhoneDTO.class);
					for (PhoneDTO phoneDTO : carts) {
						cartList.add(phoneDTO);
					}
					String json = JSON.toJSONString(cartList);
					baseCart.setCarts(json);
					cartService.updataCarts(baseCart, u.getId());
				}
			}
			
			data = true;
		} 
		return JSON.toJSONString(data);
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public String webLogout(HttpServletRequest request) {
		request.getSession().removeAttribute("current_user");
		request.getSession().removeAttribute("cartList");
		String data = null;
		return JSON.toJSONString(data);
	}
}
