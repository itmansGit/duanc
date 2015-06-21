package com.duanc.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.duanc.api.web.RegistService;
import com.duanc.model.base.BaseUser;
import com.duanc.utils.MD5Util;

@Controller
public class RegistController {
	@Autowired
	private RegistService registService;
	
	@RequestMapping("/regist-page")
	public String getRegistPage() {
		return "regist";
	}
	
	@RequestMapping(value = "/checkUser")
	@ResponseBody
	public String checkUser(BaseUser baseUser){
		List<BaseUser> list = registService.selectUser(baseUser);
		if(list != null && list.size() > 0) {
			return JSON.toJSONString(false
					);
		}
		return JSON.toJSONString(true);
	}
	
	@RequestMapping(value = "/regist")
	public String checkAndSendEmail(BaseUser baseUser, Model model, HttpServletRequest request){
		if(baseUser.getEmail() != null && baseUser.getEmail().trim() != "" && baseUser.getUsername() != null && baseUser.getUsername().trim() != "" 
				&& baseUser.getPhoneNo()!=null && baseUser.getPhoneNo().trim() != "" && baseUser.getPassword()!= null && baseUser.getPassword().trim() != ""){
			baseUser.setPassword(MD5Util.getMd5(baseUser.getPassword()));
			if(registService.regist(baseUser) == true) {
				request.getSession().setAttribute("current_user", baseUser);
				return "redirect:/index/index";
			} 
			model.addAttribute("regist_message", "系统繁忙请稍后再试");
		} else {
			model.addAttribute("regist_message", "请写完整信息再试");
		}
		return "regist";
	}
}
