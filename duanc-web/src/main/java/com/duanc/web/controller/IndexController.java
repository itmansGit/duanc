package com.duanc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duanc.api.web.IndexService;
import com.duanc.model.base.BasePhone;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired 
	private IndexService indexService;
	
	@RequestMapping(value = "/index")
	public String getIndexPage(Model model) {
		List<BasePhone> list = indexService.getRotationFigure();
		model.addAttribute("phones", list);
		model.addAttribute("navbar", 0);
		return "index";
	}
}
