package com.duanc.api.admin;

import java.util.List;

import com.duanc.model.base.BaseResources;
import com.duanc.model.base.BaseRole;

public interface AuthcService {
	
	List<BaseRole> getRoles();
	
	List<BaseResources> getResources();
	
} 
