package com.duanc.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.duanc.api.UserService;
import com.duanc.api.comm.OrderService;
import com.duanc.api.web.PayService;
import com.duanc.api.web.UserCenterService;
import com.duanc.model.User;
import com.duanc.model.base.BaseUser;
import com.duanc.model.base.BaseUserAddress;
import com.duanc.model.base.BaseUserData;
import com.duanc.model.dto.OrderDTO;
import com.duanc.utils.FileUploadUtil;
import com.duanc.utils.IDAutogenerationUtil;
import com.duanc.utils.MD5Util;

@Controller
@RequestMapping(value = "/user-center")
public class UserCenterController {
	@Autowired
	private UserService userService;
	@Autowired
	private PayService payService;
	@Autowired
	private UserCenterService userCenterService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/index")
	public String getIndexPage(HttpServletRequest request) {
		User u = (User) request.getSession().getAttribute("current_user");
		if(u == null) {
			return "redirect:/index/index";
		}
		return "user/center-index";
	}
	
	@RequestMapping(value = "/data")
	public String getDataPage(HttpServletRequest request) {
		User u = (User) request.getSession().getAttribute("current_user");
		if(u == null) {
			return "redirect:/index/index";
		}
		return "user/center-data";
	}
	
	@RequestMapping(value = "/addr")
	public String getAddrPage(HttpServletRequest request, Model model) {
		User u = (User) request.getSession().getAttribute("current_user");
		if(u == null) {
			return "redirect:/index/index";
		}
		List<BaseUserAddress> addrs = payService.getUserAddresses(u.getId());
		if(addrs != null && addrs.size() > 0){
			model.addAttribute("addr", addrs.get(0));
		} else{
			model.addAttribute("addr", new BaseUserAddress());
		}
		return "user/center-addr";
	}
	
	@RequestMapping(value = "/order")
	public String getOrderPage(HttpServletRequest request,Model model) {
		User u = (User) request.getSession().getAttribute("current_user");
		if(u == null) {
			return "redirect:/index/index";
		}
		List<OrderDTO> list = orderService.selectUserOrder(u.getId());
		model.addAttribute("orders", list);
		return "user/center-order";
	}
	
	@RequestMapping(value = "/pwd")
	public String getPwdPage(HttpServletRequest request) {
		User u = (User) request.getSession().getAttribute("current_user");
		if(u == null) {
			return "redirect:/index/index";
		}
		return "user/center-pwd";
	}
	
	
	@RequestMapping(value = "/data/change")
	public String dataChange(MultipartFile file, BaseUserData baseUserData, HttpServletRequest request,Model model) {
		User u = (User) request.getSession().getAttribute("current_user");
		if(u == null) {
			return "redirect:/index/index";
		}
		if(!"".equals(file.getOriginalFilename()) ) {
			String root = request.getSession().getServletContext().getRealPath(""); //通过REQUEST来得到相对地址
			root = root.substring(0, root.lastIndexOf('\\'));
			root = root.substring(0, root.lastIndexOf('\\')) + "\\webapps\\fileupload\\img\\head";
			String fileName = getFileName(file);
			try {
				FileUploadUtil.fileUpload(fileName, root, file.getBytes());
			} catch (IOException e) {
				model.addAttribute("error", "图片上传异常！请稍后再试！");
				e.printStackTrace();
				return "user/center-data";
			}
			baseUserData.setHeadUrl("img/head/" + fileName);
		}else{
			baseUserData.setHeadUrl(u.getHeadUrl());
		}
			baseUserData.setUserId(u.getId());
			if(!userCenterService.updataUserData(baseUserData)){
				model.addAttribute("error", "服务异常！请稍后再试！");
			} else {
				u = userService.findUser(u);
				request.getSession().setAttribute("current_user", u);
			}
		return "user/center-data";
	}
		
	private String getFileName(MultipartFile file) {
		String fileName = file.getOriginalFilename().trim();//获取文件名
		fileName = "head" + IDAutogenerationUtil.createId() + fileName.substring(fileName.lastIndexOf("."));
		return fileName;
	}
	
	@RequestMapping(value = "/addr/change")
	public String addrChange(BaseUserAddress baseUserAddress, HttpServletRequest request, Model model){
		User u = (User) request.getSession().getAttribute("current_user");
		if(u == null) {
			return "redirect:/index/index";
		}
		baseUserAddress.setUserId(u.getId());
		if(!userCenterService.updataUserAddress(baseUserAddress)) {
			model.addAttribute("error", "服务异常！请稍后再试！");
		}else {
			List<BaseUserAddress> addrs = payService.getUserAddresses(u.getId());
			if(addrs != null && addrs.size() > 0){
				model.addAttribute("addr", addrs.get(0));
			} else{
				model.addAttribute("addr", new BaseUserAddress());
			}
		}
		return "user/center-addr";
	}
	
	@RequestMapping(value = "/pwd/change")
	public String pwdChange(String oldPwd, String newPwd , HttpServletRequest request, Model model){
		User u = (User) request.getSession().getAttribute("current_user");
		if(u == null) {
			return "redirect:/index/index";
		}
		if(MD5Util.getMd5(oldPwd).equals(u.getPassword())){
			BaseUser baseUser = new BaseUser();
			baseUser.setEmail(u.getEmail());
			baseUser.setId(u.getId());
			baseUser.setPassword(MD5Util.getMd5(newPwd));
			baseUser.setUsername(u.getUsername());
			baseUser.setPhoneNo(u.getPhoneNo());
			if(userCenterService.updataPassword(baseUser)){
				u.setPassword(MD5Util.getMd5(newPwd));
				u = userService.findUser(u);
				request.getSession().setAttribute("current_user", u);
				model.addAttribute("pwd_massage", "修改成功！");
			}
		} else {
			model.addAttribute("pwd_massage", "密码错误！请重新输入！");
		}
		return "user/center-pwd";
	}
}
