package com.duanc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duanc.api.BrandAndModelService;
import com.duanc.api.PhoneService;

@Controller
@RequestMapping(value = "/authc")
public class CommonController extends BaseController {
	
	@Autowired
	private BrandAndModelService brandAndModelService;
	@Autowired
	private PhoneService phoneService;
	
	@RequestMapping(value = "/ajax-init-model")
	@ResponseBody
	public List<Map<String, Object>> initModel(Integer brandId) {
		List<Map<String, Object>> models = brandAndModelService.getModelListByBrand(brandId);
		return models;
	}
	
	@RequestMapping(value = "/ajax-init-phone")
	@ResponseBody
	public List<Map<String, Object>> initPhone(Integer modelId) {
		List<Map<String, Object>> phones = phoneService.getPhonesList(modelId);
		return phones;
	}
}
