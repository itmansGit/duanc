package com.duanc.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duanc.controller.BaseController;
import com.duanc.model.User;
import com.duanc.utils.MD5Util;

@Controller
public class LoginController extends BaseController{
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogin(User user, Boolean rememberMe) {
		if(user.getUsername() != null && user.getPassword() != null) {
			UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), MD5Util.getMd5(user.getPassword()));
			Subject currentUser = SecurityUtils. getSubject();
		
			try {
				if (!currentUser.isAuthenticated()){
					if(null !=  rememberMe) {
						token.setRememberMe(rememberMe);
					}
					currentUser.login(token);
				}
				return "redirect:/authc/model-mng";
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				return "login";
			}
		}
		return "login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.removeAttribute("staff");
		Subject currentUser = SecurityUtils. getSubject();
		currentUser.logout();
		return "login";
	}
}
