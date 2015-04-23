package com.duanc.serivce.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.PhoneService;
import com.duanc.mapper.common.PhoneCommonMapper;
import com.duanc.model.dto.PhoneDTO;
import com.duanc.utils.Pagination;

@Service("phoneService")
public class PhoneServiceImpl implements PhoneService{
	
	@Autowired
	private PhoneCommonMapper phoneMapper;
	
	@Override
	public boolean addPhone(PhoneDTO phoneDTO) {
		PhoneDTO phone = new PhoneDTO();
		phone.setBrandId(phoneDTO.getBrandId());
		phone.setModelId(phoneDTO.getModelId());
		phone.setVersion(phoneDTO.getVersion());
		if(!(phoneMapper.queryPhoneIsExists(phoneDTO) > 0)) {
			if(phoneMapper.addPhone(phoneDTO)) {
				return true;
			}
			return false;
		} else if(phoneMapper.updatePhone(phoneDTO)) {
			return true;
		}
		return false;
	}

	@Override
	public Pagination getPhoneList(Integer brandId, Integer modelId, Pagination pagination) {
		PhoneDTO phoneDTO = new PhoneDTO();
		phoneDTO.setBrandId(brandId);
		phoneDTO.setModelId(modelId);
		phoneDTO.setPagination(pagination);
		pagination.setTotal(phoneMapper.getPhoneListTotal(phoneDTO));
		List<PhoneDTO> dataList = phoneMapper.getPhoneList(phoneDTO);
		pagination.setDataList(dataList);
		return pagination;
	}

	@Override
	public boolean delPhone(Integer phoneId) {
		PhoneDTO phoneDTO = new PhoneDTO();
		phoneDTO.setId(phoneId);
		return phoneMapper.delPhone(phoneDTO);
	}

	@Override
	public boolean updatePhone(PhoneDTO phone) {
		
		return false;
	}

	@Override
	public PhoneDTO getPhoneById(Integer phoneId) {
		PhoneDTO phoneDTO = new PhoneDTO();
		phoneDTO.setId(phoneId);
		List<PhoneDTO> list = phoneMapper.getPhoneList(phoneDTO);
		if(null != list) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Map<Integer, String> getPhonesMap(Integer modelId) {
		PhoneDTO phoneDTO = new PhoneDTO();
		phoneDTO.setModelId(modelId);
		List<PhoneDTO> list = phoneMapper.getPhoneList(phoneDTO);
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (PhoneDTO phoneDTO2 : list) {
			map.put(phoneDTO2.getId(), phoneDTO2.getVersion());
		}
		return map;
	}

	@Override
	public List<Map<String, Object>> getPhonesList(Integer modelId) {
		PhoneDTO phoneDTO = new PhoneDTO();
		phoneDTO.setModelId(modelId);
		List<PhoneDTO> list = phoneMapper.getPhoneList(phoneDTO);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		for (PhoneDTO phoneDTO2 : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("phoneId", phoneDTO2.getId());
			map.put("phoneName", phoneDTO2.getVersion());
			dataList.add(map);
		}
		return dataList;
	}

}
