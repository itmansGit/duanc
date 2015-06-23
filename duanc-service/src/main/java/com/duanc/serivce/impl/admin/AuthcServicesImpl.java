package com.duanc.serivce.impl.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duanc.api.admin.AuthcService;
import com.duanc.mapper.base.ResourcesMapper;
import com.duanc.mapper.base.RoleMapper;
import com.duanc.model.base.BaseResources;
import com.duanc.model.base.BaseResourcesExample;
import com.duanc.model.base.BaseRole;
import com.duanc.model.base.BaseRoleExample;

@Service("authcService")
public class AuthcServicesImpl implements AuthcService{
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<BaseRole> getRoles() {
		BaseRoleExample example = new BaseRoleExample();
		return roleMapper.selectByExample(example);
	}
	
	@Autowired
	private ResourcesMapper resourcesMapper;
	@Override
	public List<BaseResources> getResources() {
		BaseResourcesExample example = new BaseResourcesExample();
		return resourcesMapper.selectByExample(example);
	}

}
