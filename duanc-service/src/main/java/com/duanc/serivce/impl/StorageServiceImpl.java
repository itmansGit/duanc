package com.duanc.serivce.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.StorageService;
import com.duanc.common.MatchingMap;
import com.duanc.constants.Constants;
import com.duanc.mapper.common.StorageMapper;
import com.duanc.model.dto.StorageDTO;
import com.duanc.utils.IDAutogenerationUtil;
import com.duanc.utils.Pagination;

@Service("storageService")
public class StorageServiceImpl implements StorageService {
	
	@Autowired
	private StorageMapper storageMapper;
	
	@Override
	public boolean storeIn(StorageDTO storageDTO) {
		storageDTO.setStorageId(IDAutogenerationUtil.createIdWithRandom());
		storageDTO.setStatus(Constants.STORAGE_STATUS_IN);
		return storageMapper.addStorage(storageDTO);
	}

	@Override
	public Pagination getStoreList(StorageDTO storageDTO, Pagination pagination) {
		List<StorageDTO> list = storageMapper.getStorages(storageDTO);
		storageDTO.setPagination(pagination);
		List<StorageDTO> dataList = storageMapper.getStorages(storageDTO);
		dataList = initStorageDTO(dataList);
		pagination.setTotal(list.size());
		pagination.setDataList(dataList);
		return pagination;
	}

	@Override
	public Map<Integer, String> getStorageStatus() {
		List<Integer> list = storageMapper.getStatus();
		Map<Integer, String> dataMap = new HashMap<Integer, String>();
		Map<Integer, String> map = new MatchingMap().getStorageStatusMap();
		for (Integer integer : list) {
			if(null != integer) {
				dataMap.put(integer, map.get(integer));
			}
		}
		return dataMap;
	}
	
	private List<StorageDTO> initStorageDTO(List<StorageDTO> dataList) {
		Map<Integer, String> map = new MatchingMap().getStorageStatusMap();
		for (StorageDTO storageDTO : dataList) {
			storageDTO.setStatusName(map.get(storageDTO.getStatus()));
		}
		return dataList;
	}
}
