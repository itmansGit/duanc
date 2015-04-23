package com.duanc.controller.storage;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duanc.api.StorageService;
import com.duanc.controller.BaseController;
import com.duanc.model.User;
import com.duanc.model.dto.StorageDTO;
import com.duanc.utils.OptionResult;
import com.duanc.utils.Pagination;

@Controller
@RequestMapping(value = "/authc")
public class StoreController extends BaseController{
	
	@Autowired
	private StorageService storageService;
	
	@RequestMapping(value = "/store-in")
	public String storeIn(StorageDTO storageDTO, Model model, HttpServletRequest request) {
		if(null != storageDTO.getPhone() && null != storageDTO.getPhone().getBrandId() && 
				null != storageDTO.getPhone().getModelId() && null != storageDTO.getPhoneId()) {
			User user = (User)request.getSession().getAttribute("user");
			storageDTO.setCreatedTime(new Date());
			storageDTO.setCreateUser(user);
			OptionResult or = new OptionResult();
			if(storageService.storeIn(storageDTO)) {
				or.setMessage("入库成功");
			} else {
				or.setMessage("入库失败!请刷新重试!");
			}
			model.addAttribute("OptionResult", or);
		}
		initBrand(model);
		return "storage/store-in";
	}
	
	@RequestMapping("/get-stores")
	public String getStores(Model model, StorageDTO storageDTO, Pagination pagination) {
		pagination = storageService.getStoreList(storageDTO, pagination);
		model.addAttribute("pagination", pagination);
		initBrand(model);
		initStatus(model);
		return "storage/store-mng";
	}
	
	private void initStatus(Model model) {
		Map<Integer, String> map = storageService.getStorageStatus();
		model.addAttribute("status", map);
	}
}
