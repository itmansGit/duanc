package com.duanc.api;

import java.util.List;
import java.util.Map;

import com.duanc.model.dto.ModelDTO;
import com.duanc.utils.Pagination;

public interface BrandAndModelService {
	
	/**
	 * @Description: 获取机型详情列表 
	 * @param brandId
	 * @return List<ModelDTO>
	 */
	Pagination getModelDataList(Integer brandId, Pagination pagination);
	
	/**
	 * @Title: deleteModelById 
	 * @Description: 删除机型 
	 * @return boolean
	 */
	boolean deleteModelById(Integer modelId);
	
	/**
	 * @Description: 添加机型 
	 * @param modelDTO
	 * @param brandId
	 * @return boolean
	 */
	boolean addModel(String modelName, Integer brandId);
	
	/**
	 * @Description: 修改机型内容 
	 * @param modelDTO
	 * @return boolean
	 */
	boolean updateModel(ModelDTO modelDTO);
	
	/**
	 * @Description: 获取所有品牌,返回Map
	 * 			key ---- brandId
	 * 			value ---- brandName
	 * @return Map<Integer,String>
	 */
	Map<Integer, String> getBrandsMap();
	
	/**
	 * @Description: 获取所有品牌,返回List 
	 * 			brandId 品牌ID  brandName 品牌名称
	 * @return List<Map<String,Object>>
	 */
	List<Map<String, Object>> getBrandsList();
	
	/**
	 * @Description: 获取品牌下的所有机型，返回Map
	 * 				key --- modelId   value --- modelName
	 * @param brandId
	 * @return Map<Integer,String>
	 */
	Map<Integer, String> getModelMapByBrand(Integer brandId);
	
	/**
	 * @Description: 获取品牌下的所有机型，返回List
	 * 				 modelId  modelName
	 * @param brandId
	 * @return List<Map<String,Object>>
	 */
	List<Map<String, Object>> getModelListByBrand(Integer brandId);
}
