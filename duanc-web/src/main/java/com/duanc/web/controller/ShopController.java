package com.duanc.web.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duanc.api.PhoneService;
import com.duanc.api.web.ShopPageService;
import com.duanc.model.base.BaseModel;
import com.duanc.model.dto.PhoneDTO;
import com.duanc.utils.Pagination;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired 
	private ShopPageService shopPageService;
	@Autowired
	private PhoneService phoneService;
	
	@RequestMapping("/page")
	public String getShopPage(Model model, Integer modelId,Pagination pagination){
		List<BaseModel> models = shopPageService.getModels();
		if(models.size() > 10){
			models = models.subList(0, 10);
		}
		pagination = phoneService.getPhoneList(null, modelId, pagination);
		model.addAttribute("models", models);
		model.addAttribute("pagination", pagination);
		model.addAttribute("navbar", 1);
		return "shop";
	}
	
	@RequestMapping(value = "/ajax-more-model")
	@ResponseBody
	public List<BaseModel> getMoreModels() {
		List<BaseModel> models = shopPageService.getModels();
		if(models.size() > 10){
			return models.subList(10, models.size());
		}
		return null;
	}
	
	@RequestMapping(value = "/ajax-load-phone")
	@ResponseBody
	public List<PhoneDTO> loadPhones(String price, Integer modelId) {
		BigDecimal maxPrice = null;
		BigDecimal minPrice = null;
		if(price.contains("~")){
			String [] strs = price.split("~");
			maxPrice = new BigDecimal(Integer.parseInt(strs[1]));
			minPrice = new BigDecimal(Integer.parseInt(strs[0]));
		} else if(price.contains(">")) {
			minPrice = new BigDecimal(Integer.parseInt(price.replace(">", ""))); 
		} else if(price.contains("<")) {
			maxPrice = new BigDecimal(Integer.parseInt(price.replace("<", ""))); 
		} 
		List<PhoneDTO> phones = shopPageService.getPhones(modelId, minPrice, maxPrice);
		return phones;
	}
}
