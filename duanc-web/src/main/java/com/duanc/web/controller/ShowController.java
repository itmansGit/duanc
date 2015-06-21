package com.duanc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duanc.api.web.ShowService;
import com.duanc.model.dto.PhoneDTO;

@Controller
@RequestMapping("/show")
public class ShowController {
	
	@Autowired
	private ShowService showService;
	
	@RequestMapping(value = "/getPage")
	public String getShowPage(Model model, Integer phoneId){
		if(phoneId == null ) {
			return "redirect:/index/index";
		}
		PhoneDTO phoneDTO = showService.getPhoneDTO(phoneId);
		model.addAttribute("showPhone", phoneDTO);
		return "show";
	}
}
