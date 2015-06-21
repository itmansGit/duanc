package com.duanc.inner.common;

import com.duanc.mapper.base.BrandMapper;
import com.duanc.mapper.base.ModelMapper;
import com.duanc.model.base.BasePhone;
import com.duanc.model.dto.PhoneDTO;

public class BasePhoneToDTO {
	
	public PhoneDTO getPhoneDTO(BasePhone bp,ModelMapper modelMapper,BrandMapper brandMapper) {
		PhoneDTO phoneDTO = new PhoneDTO();
		phoneDTO.setBattery(bp.getBatteryCapacity());
		phoneDTO.setBrandId(bp.getBrandId());
		phoneDTO.setBrandName(brandMapper.selectByPrimaryKey(bp.getBrandId()).getBrandName());
		phoneDTO.setCpu(bp.getCpu());
		phoneDTO.setCpuCores(bp.getCpuCores());
		phoneDTO.setCpuhz(bp.getCpuHz());
		phoneDTO.setId(bp.getId());
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
		phoneDTO.setVersion(bp.getVersion());
		return phoneDTO;
	}
}
