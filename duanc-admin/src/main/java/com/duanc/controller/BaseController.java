package com.duanc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.duanc.api.BrandAndModelService;

public abstract class BaseController {
	protected Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	protected String parsePattern = "yyyy-MM-dd";
	
	@Autowired
	private BrandAndModelService brandAndModelService;
	
	@InitBinder
	private void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		LOGGER.debug(">>>>>>>>>>>>>>>SpringMVC 日期格式化<<<<<<<<<<<<<<<<");
		DateFormat df = new SimpleDateFormat(parsePattern);
		CustomDateEditor editor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	/**
	 * @Title: initBrand 
	 * @Description: 初始化页面，显示品牌。
	 * @param model
	 */
	protected void initBrand(Model model) {
		Map<Integer, String> brandMap = brandAndModelService.getBrandsMap();
		model.addAttribute("brands", brandMap);
	}
	
}
