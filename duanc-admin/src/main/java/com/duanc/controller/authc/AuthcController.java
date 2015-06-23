package com.duanc.controller.authc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duanc.api.admin.AuthcService;
import com.duanc.model.base.BaseResources;
import com.duanc.model.base.BaseRole;

@Controller
@RequestMapping("/authc")
public class AuthcController {
	
	@Autowired
	private AuthcService authcService;
	
	@RequestMapping(value = "/role-page")
	public String getRolePage(Model model){
		List<BaseRole> roles = authcService.getRoles();
		model.addAttribute("roles", roles);
		return "authc/role";
	}
	
	@RequestMapping(value = "/resources-page")
	public String getResourcesPage(Model model){
		List<BaseResources> resources = authcService.getResources();
		model.addAttribute("resources", resources);
		return "authc/resources";
	}
}
