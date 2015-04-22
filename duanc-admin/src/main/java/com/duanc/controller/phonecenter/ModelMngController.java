package com.duanc.controller.phonecenter;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.duanc.api.BrandAndModelService;
import com.duanc.controller.BaseController;
import com.duanc.model.dto.BrandDTO;
import com.duanc.model.dto.ModelDTO;
import com.duanc.utils.JSONResult;
import com.duanc.utils.Pagination;

@Controller
@RequestMapping(value = "/authc")
public class ModelMngController extends BaseController{
	@Autowired
	private BrandAndModelService brandAndModelService;
	
	@RequestMapping(value = "/model-mng")
	@RequiresPermissions(value = {"manager:model-mng:search"})
	public String showModel(Model model, BrandDTO brandDTO, Pagination pagination) {
		if(brandDTO.getId() != null) {
			pagination = brandAndModelService.getModelDataList(brandDTO.getId(), pagination);
			model.addAttribute("pagination", pagination);
		}
		model.addAttribute("brandDTO", brandDTO);
		initBrand(model);
		return "phone-center/model-mng";
	}
	
	@RequestMapping(value = "/ajax-add-model", method = RequestMethod.POST)
	@ResponseBody
	public String addModel(ModelDTO modelDTO, Integer brandId) {
		if(brandId != null && modelDTO.getModelName() != null && !StringUtils.isEmpty(modelDTO.getModelName())) {
			if(brandAndModelService.addModel(modelDTO.getModelName(), brandId)){
				JSONResult jr = new JSONResult();
				jr.setSuccess(true);
				jr.setMessage("添加成功");
				String json = JSON.toJSONString(jr);
				return json;
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/ajax-del-model", method = RequestMethod.POST)
	@ResponseBody
	public String delModel(ModelDTO modelDTO) {
		if(modelDTO.getId() != null ) {
			if(brandAndModelService.deleteModelById(modelDTO.getId())){
				JSONResult jr = new JSONResult();
				jr.setSuccess(true);
				jr.setMessage("删除成功");
				String json = JSON.toJSONString(jr);
				return json;
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/ajax-update-model", method = RequestMethod.POST)
	@ResponseBody
	public String updateModel(ModelDTO modelDTO) {
		if(modelDTO.getId() != null ) {
			if(brandAndModelService.updateModel(modelDTO)){
				JSONResult jr = new JSONResult();
				jr.setSuccess(true);
				jr.setMessage("修改成功");
				String json = JSON.toJSONString(jr);
				return json;
			}
		}
		return null;
	}
}
