package com.duanc.api;

import java.util.List;
import java.util.Map;

import com.duanc.model.dto.PhoneDTO;
import com.duanc.utils.Pagination;

public interface PhoneService {
	
	/**
	 * @Description: 添加手机 
	 * @param phoneDTO
	 * @param brandId
	 * @param modelId
	 * @return boolean
	 */
	boolean addPhone(PhoneDTO phoneDTO);
	
	/**
	 * @Description: 通过品牌id,机型id获取版本手机详情列表 
	 * @param brandId
	 * @param modelId
	 * @return Pagination
	 */
	Pagination getPhoneList(Integer brandId, Integer modelId, Pagination pagination);
	
	/**
	 * @Description: 通过id获取phone详情 
	 * @param phoneId
	 * @return PhoneDTO
	 */
	PhoneDTO getPhoneById(Integer phoneId);
	
	/**
	 * @Description: 删除版本手机信息 
	 * @param phoneId
	 * @return boolean
	 */
	boolean delPhone(Integer phoneId);
	
	/**
	 * @Description: 更新版本手机信息 
	 * @param phone
	 * @return boolean
	 */
	boolean updatePhone(PhoneDTO phone);
	
	/**
	 * 			key ---- phoneId
	 * 			value ---- phoneName
	 */
	Map<Integer, String> getPhonesMap(Integer modelId);
	
	/**
	 * 			phoneId   phoneName 
	 */
	List<Map<String, Object>> getPhonesList(Integer modelId);
}
