package com.duanc.mapper.common;

import java.util.List;

import com.duanc.model.dto.BrandDTO;

public interface BrandCommonMapper {
	
	/**
	 * @Title: getBrands 
	 * @Description: 获取所有的品牌 
	 * @return List<BrandPO>
	 */
	List<BrandDTO> getBrands();
}
