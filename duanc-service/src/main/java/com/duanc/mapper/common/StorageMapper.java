package com.duanc.mapper.common;

import java.util.List;

import com.duanc.model.dto.StorageDTO;

public interface StorageMapper {
	/**
	 * @Description: 添加入库记录 
	 * @author chao.duan
	 */
	boolean addStorage(StorageDTO storageDTO);
	
	List<StorageDTO> getStorages(StorageDTO storageDTO);
	
	List<Integer> getStatus();
}
