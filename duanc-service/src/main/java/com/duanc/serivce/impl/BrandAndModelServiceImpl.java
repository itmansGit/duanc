package com.duanc.serivce.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.BrandAndModelService;
import com.duanc.mapper.common.BrandMapper;
import com.duanc.mapper.common.ModelMapper;
import com.duanc.model.dto.BrandDTO;
import com.duanc.model.dto.ModelDTO;
import com.duanc.utils.Pagination;

@Service("brandAndModelService")
public class BrandAndModelServiceImpl implements BrandAndModelService{
	@Autowired
	private BrandMapper brandMapper;
	@Autowired
	private ModelMapper modelMapper;
	
	private Map<Integer, String> dataMap;
	private List<Map<String, Object>> dataList;
	
	@Override
	public Map<Integer, String> getBrandsMap() {
		List<BrandDTO> list = brandMapper.getBrands();
		dataMap = new HashMap<Integer, String>();
		for (BrandDTO brandDTO : list) {
			dataMap.put(brandDTO.getId(), brandDTO.getBrandName());
		}
		return dataMap;
	}

	@Override
	public List<Map<String, Object>> getBrandsList() {
		List<BrandDTO> list =  brandMapper.getBrands();
		dataList = new ArrayList<Map<String, Object>>();
		for (BrandDTO brandDTO : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("brandId", brandDTO.getId());
			map.put("brandName", brandDTO.getBrandName());
			dataList.add(map);
		}
		return dataList;
	}

	@Override
	public Map<Integer, String> getModelMapByBrand(Integer brandId) {
		ModelDTO modelDTO = new ModelDTO();
		modelDTO.setBrandId(brandId);
		List<ModelDTO> list =  modelMapper.getModelsByBrandPO(modelDTO);
		dataMap = new HashMap<Integer, String>();
		for (ModelDTO modelDTO2 : list) {
			dataMap.put(modelDTO2.getId(), modelDTO2.getModelName());
		}
		return dataMap;
	}

	@Override
	public List<Map<String, Object>> getModelListByBrand(Integer brandId) {
		ModelDTO modelDTO = new ModelDTO();
		modelDTO.setBrandId(brandId);
		List<ModelDTO> list =  modelMapper.getModelsByBrandPO(modelDTO);
		dataList = new ArrayList<Map<String, Object>>();
		for (ModelDTO modelDTO2 : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("modelId", modelDTO2.getId());
			map.put("modelName", modelDTO2.getModelName());
			dataList.add(map);
		}
		return dataList;
	}

	@Override
	public Pagination getModelDataList(Integer brandId, Pagination pagination) {
		ModelDTO modelDTO = new ModelDTO();
		modelDTO.setBrandId(brandId);
		modelDTO.setPagination(pagination);
		pagination.setTotal(modelMapper.getModelsByBrandPOTotal(modelDTO));
		List<ModelDTO> modelDtoList =  modelMapper.getModelsByBrandPO(modelDTO);
		pagination.setDataList(modelDtoList);
		return pagination;
	}

	@Override
	public boolean addModel(String modelName, Integer brandId) {
		ModelDTO modelDTO = new ModelDTO();
		modelDTO.setModelName(modelName);
		modelDTO.setBrandId(brandId);
		Integer b =  modelMapper.addModel(modelDTO);
		if(b > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteModelById(Integer modelId) {
		ModelDTO modelDTO = new ModelDTO();
		modelDTO.setId(modelId);
		Integer b = modelMapper.deleteModel(modelDTO);
		if(b > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateModel(ModelDTO modelDTO) {
		Integer b = modelMapper.updateModel(modelDTO);
		if(b > 0) {
			return true;
		}
		return false;
	}

}
