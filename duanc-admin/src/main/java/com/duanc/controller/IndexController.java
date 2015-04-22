package com.duanc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String index() {
		return "login";
	}
	
	@RequestMapping("/example")
	public String test() {
		return "phone-data/example";
	}
	
	@RequestMapping("/authc/400")
	public String test400() {
		return "400";
	}
	@RequestMapping("/blank")
	public String blank() {
		return "test/blank";
	}
}
