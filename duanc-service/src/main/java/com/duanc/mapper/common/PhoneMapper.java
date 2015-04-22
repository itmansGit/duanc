package com.duanc.mapper.common;

import java.util.List;

import com.duanc.model.dto.PhoneDTO;

public interface PhoneMapper {
	/**
	 * @Description: 添加手机 
	 * @param phoneDTO
	 * @param brandId
	 * @param modelId
	 * @return boolean
	 */
	boolean addPhone(PhoneDTO phoneDTO);
	
	/**
	 * @Description: 检查phone是否已存在 
	 * @param phonePO
	 * @return Integer
	 */
	Integer queryPhoneIsExists(PhoneDTO phoneDTO);
	
	/**
	 * @Description: 通过品牌id,机型id获取版本手机详情列表 
	 * @param brandId
	 * @param modelId
	 * @return List<PhoneDTO>
	 */
	List<PhoneDTO> getPhoneList(PhoneDTO phoneDTO);
	
	/**
	 * @Description: 查询总数 
	 * @param phonePO
	 * @return Integer
	 */
	Integer getPhoneListTotal(PhoneDTO phoneDTO);
	
	/**
	 * @Description: 删除版本手机信息 
	 * @param phoneId
	 * @return boolean
	 */
	boolean delPhone(PhoneDTO phoneDTO);
	
	/**
	 * @Description: 更新版本手机信息 
	 * @param phone
	 * @return boolean
	 */
	boolean updatePhone(PhoneDTO phoneDTO);
}
