package com.duanc.api;

import java.util.Map;

import com.duanc.model.dto.StorageDTO;
import com.duanc.utils.Pagination;

public interface StorageService {
	
	/**
	 * @Description: 入库  
	 * @author chao.duan
	 * @throws
	 */
	boolean storeIn(StorageDTO storageDTO);
	
	/**
	 * @Description: 获取 
	 * @author chao.duan
	 */
	Pagination getStoreList(StorageDTO storageDTO, Pagination pagination);
	
	Map<Integer, String> getStorageStatus();
}
