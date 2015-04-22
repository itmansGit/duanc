package com.duanc.controller.phonecenter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.duanc.api.PhoneService;
import com.duanc.controller.BaseController;
import com.duanc.model.dto.PhoneDTO;
import com.duanc.utils.FileUploadUtil;
import com.duanc.utils.IDAutogenerationUtil;

@Controller
@RequestMapping(value = "/authc")
public class PhoneEntryController extends BaseController{
	@Autowired
	private PhoneService phoneService;
	
	@RequestMapping(value = "/phone-entry")
	public String phoneDateEntry(Model model, PhoneDTO phoneDTO) {
		initBrand(model);
		return "phone-center/phone-entry";
	}
	
	@RequestMapping(value = "/phone-entry-submit")
	public String phoneDateSubmit(Model model, PhoneDTO phoneDTO, @RequestParam MultipartFile file, HttpServletRequest request) {
		if(null != phoneDTO && null != phoneDTO.getBrandId() && null != phoneDTO.getModelId()) {
			if(!"".equals(file.getOriginalFilename()) ) {
				String root = request.getSession().getServletContext().getRealPath(""); //通过REQUEST来得到相对地址，并在后面加上/bookpicture
				root = root.substring(0, root.lastIndexOf('\\')) + "\\fileupload\\img\\phone";
				String fileName = getFileName(phoneDTO, file);
				try {
					FileUploadUtil.fileUpload(fileName, root, file.getBytes());
				} catch (IOException e) {
					model.addAttribute("error", "图片上传异常！请稍后再试！");
					e.printStackTrace();
					return "phone-center/phone-entry";
				}
				phoneDTO.setPicUrl("img/phone/" + fileName);
			}
			if(phoneService.addPhone(phoneDTO)){
				return "redirect:/authc/phone-mng";
			} else {
				model.addAttribute("error", "保存失败！请稍后再试！");
			}
		}
		initBrand(model);
		return "phone-center/phone-entry";
	}
	
	@RequestMapping(value = "/phone-update")
	public String phoneDateUpdate(Model model, PhoneDTO phoneDTO) {
		phoneDTO = phoneService.getPhoneById(phoneDTO.getId());
		model.addAttribute("phoneDTO", phoneDTO);
		initBrand(model);
		return "phone-center/phone-entry";
	}
	
	private String getFileName(PhoneDTO phoneDTO, MultipartFile file) {
		String fileName = file.getOriginalFilename().trim();//获取文件名
		fileName = IDAutogenerationUtil.createId() + fileName.substring(fileName.lastIndexOf("."));
		if(phoneDTO.getModelId() > 9) {
			fileName = phoneDTO.getModelId() + "_" + fileName;
		} else {
			fileName = "0" + phoneDTO.getModelId() + "_" + fileName;
		}
		if(phoneDTO.getBrandId() > 9) {
			fileName = phoneDTO.getBrandId() + fileName;
		} else {
			fileName = "0" + phoneDTO.getBrandId() + fileName;
		}
		return fileName;
	}
}
