package com.duanc.model.mybase;

import java.io.Serializable;

/**
 * 
 * <p>角色资源对应表</p> 
 * <p>class type :  javabean</p>
 * 
 * <pre>
 * 已实现序列化
 * </pre>
 *
 * @author duanchao
 */
public class RoleResources implements Serializable{

	private static final long serialVersionUID = 5523923964333526573L;
	
	private Integer roleId;
	private Integer resourcesId;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getResourcesId() {
		return resourcesId;
	}
	public void setResourcesId(Integer resourcesId) {
		this.resourcesId = resourcesId;
	}
	
}
