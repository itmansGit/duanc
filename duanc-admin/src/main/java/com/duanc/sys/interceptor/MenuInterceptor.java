package com.duanc.sys.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.duanc.api.MenuService;
import com.duanc.api.UserService;
import com.duanc.model.Menu;
import com.duanc.model.User;

public class MenuInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private UserService userService;
	@Autowired 
	private MenuService menuService;
	
	private static Logger logger = LoggerFactory.getLogger(MenuInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView != null) {
			User user = (User)request.getSession().getAttribute("user");
			if(user == null) {
				Subject currentUser = SecurityUtils. getSubject();
				String username = (String) currentUser.getPrincipal();
				if(username != null) {
					logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>username:" + username);
					user = new User();
					user.setUsername(username);
					user = userService.findUser(user);
					request.getSession().setAttribute("user", user);
				}
			}
			if(user != null) {
				String menu = request.getParameter("menuId");
				String subMenu = request.getParameter("subMenuId");
				Integer menuId = 0;
				Integer subMenuId = 0;
				if(menu != null && !StringUtils.isEmpty(menu)) {
					menuId = Integer.valueOf(request.getParameter("menuId"));
					modelAndView.addObject("menuId", menuId);
				}
				if(subMenu != null && !StringUtils.isEmpty(subMenu)) {
					subMenuId = Integer.valueOf(request.getParameter("subMenuId"));
					modelAndView.addObject("subMenuId", subMenuId);
				}
				List<Menu> menus = menuService.getMenu(user.getId(), menuId, subMenuId);
				modelAndView.addObject("menus", menus);
			}
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
