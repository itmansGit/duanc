package com.duanc.serivce.impl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.web.ShowService;
import com.duanc.inner.common.BasePhoneToDTO;
import com.duanc.mapper.base.BrandMapper;
import com.duanc.mapper.base.ModelMapper;
import com.duanc.mapper.base.PhoneMapper;
import com.duanc.model.base.BasePhone;
import com.duanc.model.dto.PhoneDTO;

@Service("showService")
public class ShowServiceImpl implements ShowService{
	
	@Autowired
	private PhoneMapper phoneMapper;
	@Autowired
	private BrandMapper brandMapper;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PhoneDTO getPhoneDTO(Integer id) {
		BasePhone bp = phoneMapper.selectByPrimaryKey(id);
		
		PhoneDTO phoneDTO = new BasePhoneToDTO().getPhoneDTO(bp,modelMapper,brandMapper);
		/*PhoneDTO phoneDTO = new PhoneDTO();
		phoneDTO.setBattery(bp.getBatteryCapacity());
		phoneDTO.setBrandId(bp.getBrandId());
		phoneDTO.setBrandName(brandMapper.selectByPrimaryKey(bp.getBrandId()).getBrandName());
		phoneDTO.setCpu(bp.getCpu());
		phoneDTO.setCpuCores(bp.getCpuCores());
		phoneDTO.setCpuhz(bp.getCpuHz());
		phoneDTO.setId(id);
		phoneDTO.setListingDate(bp.getListingDate());
		phoneDTO.setModelId(bp.getModelId());
		phoneDTO.setModelName(modelMapper.selectByPrimaryKey(bp.getModelId()).getModelName());
		phoneDTO.setNetType(bp.getNetType());
		phoneDTO.setOs(bp.getOs());
		phoneDTO.setPicUrl(bp.getPicUrl());
		phoneDTO.setPrice(bp.getPrice());
		phoneDTO.setRam(bp.getRam());
		phoneDTO.setRom(bp.getRom());
		phoneDTO.setScreensize(bp.getScreenSize());
		phoneDTO.setVersion(bp.getVersion());*/
		
		return phoneDTO;
	}
}
