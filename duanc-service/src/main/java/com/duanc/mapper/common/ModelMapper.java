package com.duanc.mapper.common;

import java.util.List;

import com.duanc.model.dto.ModelDTO;

public interface ModelMapper {
	
	/**
	 * @Description: 根据品牌获取机型 
	 * @return List<ModelPO>
	 */
	List<ModelDTO> getModelsByBrandPO(ModelDTO modelDTO);
	
	/**
	 * @Description: 获取查询总数 
	 * @param modelPO
	 * @return Integer
	 */
	Integer getModelsByBrandPOTotal(ModelDTO modelDTO);
	
	/**
	 * @Description: 添加机型 
	 * @param modelPO 
	 */
	Integer addModel(ModelDTO modelDTO);
	
	/**
	 * @Description: 删除机型 
	 * @param modelPO void
	 */
	Integer deleteModel(ModelDTO modelDTO);
	
	/**
	 * @Description: 更新机型 
	 * @param modelPO void
	 */
	Integer updateModel(ModelDTO modelDTO);
}
