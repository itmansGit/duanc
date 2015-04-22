package com.duanc.controller.phonecenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.duanc.api.PhoneService;
import com.duanc.controller.BaseController;
import com.duanc.inner.qo.PhoneQO;
import com.duanc.utils.JSONResult;
import com.duanc.utils.Pagination;

@Controller
@RequestMapping(value = "/authc")
public class PhoneController extends BaseController{
	
	@Autowired
	private PhoneService phoneService;
	
	@RequestMapping(value = "/phone-mng")
	public String phoneList(Model model, PhoneQO phoneQO, Pagination pagination) {
		pagination = phoneService.getPhoneList(phoneQO.getBrandId(), phoneQO.getModelId(), pagination);
		model.addAttribute("pagination", pagination);
		initBrand(model);
		return "phone-center/phone-mng";
	}
	
	@RequestMapping(value = "/ajax-del-phone", method = RequestMethod.POST)
	@ResponseBody
	public String delPhone(Integer id) {
		if(id != null ) {
			if(phoneService.delPhone(id)){
				JSONResult jr = new JSONResult();
				jr.setSuccess(true);
				jr.setMessage("删除成功");
				String json = JSON.toJSONString(jr);
				return json;
			}
		}
		return null;
	}
	
 }
